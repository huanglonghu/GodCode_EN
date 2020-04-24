package com.example.godcode.handler;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.godcode.R;
import com.example.godcode.bean.OrderDetail;
import com.example.godcode.bean.ProductScan;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.interface_.HandlerStrategy;
import com.example.godcode.ui.activity.ClipImageActivity;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.utils.BitmapUtil;
import com.example.godcode.utils.FileUtil;
import com.example.godcode.utils.GsonUtil;
import com.example.godcode.utils.LogUtil;
import com.example.godcode.utils.ToastUtil;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.camera.PlanarYUVLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.decoding.RGBLuminanceSource;
import com.google.zxing.qrcode.QRCodeReader;
import java.io.File;
import java.util.Hashtable;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public class ActivityResultHandler {
    // 处理各种界面跳转的问题
    private FragmentManager fragmentManager;
    public static final int REQUEST_SELECT_CONTACTS = 100;//联系人
    public static final int REQUEST_SELECT_PHOTO = 101;//选择图片
    public static final int REQUEST_CROP_PHOTO = 102; //裁剪图片呢
    public static final int REQUEST_ANALY_PHOTO = 103; //解析图片
    public static final int REQUEST_SCAN = 104;//扫一扫
    public static final int REQUEST_BACK = 105;
    private int RESULT_OK = 0xA1;
    private Intent intent;
    private int requestCode;
    private AppCompatActivity activity;
    private HandlerStrategy handlerStrategy;

    private ActivityResultHandler() {
    }

    private static ActivityResultHandler defaultInstance;

    public static ActivityResultHandler getInstance() {
        ActivityResultHandler activityResultHandler = defaultInstance;
        if (defaultInstance == null) {
            synchronized (BitmapUtil.class) {
                if (defaultInstance == null) {
                    activityResultHandler = new ActivityResultHandler();
                    defaultInstance = activityResultHandler;
                }
            }
        }
        return activityResultHandler;
    }

    private void init(Builder builder) {
        this.activity = builder.activity;
        this.intent = builder.intent;
        this.requestCode = builder.requestCode;
        this.handlerStrategy = builder.handlerStrategy;
        fragmentManager = activity.getSupportFragmentManager();
    }

    private void init(AppCompatActivity activity) {
        this.activity = activity;
        fragmentManager = activity.getSupportFragmentManager();
    }


    public void startActivityForResult() {
        activity.startActivityForResult(intent, requestCode);
    }

    public static class Builder {
        private Intent intent;
        private int requestCode;
        private AppCompatActivity activity;
        private HandlerStrategy handlerStrategy;

        public Builder intent(Intent intent) {
            this.intent = intent;
            return this;
        }

        public Builder requestCode(int requestCode) {
            this.requestCode = requestCode;
            return this;
        }

        public Builder activity(AppCompatActivity activity) {
            this.activity = activity;
            return this;
        }

        public Builder hadlerStrategy(HandlerStrategy handlerStrategy) {
            this.handlerStrategy = handlerStrategy;
            return this;
        }

        public ActivityResultHandler build() {
            getInstance().init(this);
            return defaultInstance;
        }

        public ActivityResultHandler build2(AppCompatActivity activity) {
            getInstance().init(activity);
            return defaultInstance;
        }
    }


    public void handler(int requestCode, int resultCode, Intent data) {
        LogUtil.log(resultCode + "=================WWWWWWWWWWWWWW=============" + requestCode + "======================" + RESULT_OK);
        Uri uri = null;
        if (data != null) {
            uri = data.getData();
        }
        switch (requestCode) {
            case REQUEST_SELECT_CONTACTS:
                String phoneNumber = getPhoneNumber(uri);
                String phoneNum = phoneNumber.replace("-", "");
                handlerStrategy.onActivityResult(phoneNum);
                break;
            case REQUEST_SELECT_PHOTO:
                if (uri == null) {
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(activity, ClipImageActivity.class);
                intent.putExtra("type", 2);//
                intent.setData(uri);
                activity.startActivityForResult(intent, REQUEST_CROP_PHOTO);
                break;
            case REQUEST_CROP_PHOTO:
                if (uri == null) {
                    return;
                }
                String cropImagePath = FileUtil.getRealFilePathFromUri(activity, uri);
                Bitmap bitMap = BitmapFactory.decodeFile(cropImagePath);
                File file = new File(cropImagePath);
                MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
                handlerStrategy.onActivityResult(filePart, bitMap);
                break;
            case REQUEST_ANALY_PHOTO:
                Result result = null;
                try {
                    String[] proj = {MediaStore.Images.Media.DATA};
                    Cursor cursor = activity.getContentResolver().query(data.getData(),
                            proj, null, null, null);
                    String path = null;
                    if (cursor.moveToFirst()) {
                        int column_index = cursor
                                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                        path = cursor.getString(column_index);
                    }
                    cursor.close();
                    result = scanningImage(path);
                    if (result == null) {
                        ToastUtil.getInstance().showToast("Qr code not recognized", 2000, activity);
                    } else {
                        String scanResult = result.getText();
                        Intent resultIntent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putString("qr_scan_result", scanResult);
                        resultIntent.putExtras(bundle);
                        activity.setResult(RESULT_OK, resultIntent);
                        activity.finish();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case REQUEST_SCAN:
                if (resultCode != RESULT_OK) {
                    return;
                }
                Bundle bundle = data.getExtras();
                String scanResult = bundle.getString("qr_scan_result");
                BaseFragment fragment = (BaseFragment) fragmentManager.findFragmentById(R.id.mainActivity_fragmentContainer);
                handlerScan(fragment, scanResult);
                break;
        }

    }

    private void handlerScan(BaseFragment fragment, String scanResult) {

        //如果是收款信息则跳转 付款界面 如果是产品信息 则跳转绑定产品界面 如果是好友信息 则跳转好友详情界面
        if (scanResult.contains("productNumber")) {

        } else if (scanResult.contains("AndroidBoardPay?orderID")) {
            String[] split = scanResult.split("=");
            String orderId = split[split.length - 1];
            if (!TextUtils.isEmpty(orderId)) {
                HttpUtil.getInstance().querryOrderById(Integer.parseInt(orderId)).subscribe(
                        getOrderNumberStr -> {
                            OrderDetail orderResult = GsonUtil.getInstance().fromJson(getOrderNumberStr, OrderDetail.class);
                            OrderDetail.ResultBean result = orderResult.getResult();
                            if (result != null) {
                                HttpUtil.getInstance().querryProduct(result.getFK_ProductID(), null).subscribe(
                                        productStr -> {
                                            if (productStr.contains("\"success\":true")) {
                                                ProductScan productScan = GsonUtil.getInstance().fromJson(productStr, ProductScan.class);
                                                ProductScan.ResultBean productScanResult = productScan.getResult();
                                                if (productScanResult.isIsBind()) {
                                                    if (productScanResult.isIsValid()) {
                                                    } else {
                                                        String errContext = productScanResult.getErrContext();
                                                        Toast.makeText(activity, errContext, Toast.LENGTH_SHORT).show();
                                                    }
                                                } else {
                                                }
                                            }
                                        }
                                );
                            }

                        }
                );
            }

        } else {

        }
    }


    protected Result scanningImage(String path) {
        Bitmap scanBitmap;
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        // DecodeHintType 和EncodeHintType
        Hashtable<DecodeHintType, String> hints = new Hashtable<DecodeHintType, String>();
        hints.put(DecodeHintType.CHARACTER_SET, "utf-8"); // 设置二维码内容的编码
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true; // 先获取原大小
        scanBitmap = BitmapFactory.decodeFile(path, options);
        options.inJustDecodeBounds = false; // 获取新的大小

        int sampleSize = (int) (options.outHeight / (float) 200);

        if (sampleSize <= 0)
            sampleSize = 1;
        options.inSampleSize = sampleSize;
        scanBitmap = BitmapFactory.decodeFile(path, options);
        if (scanBitmap == null) {
            return null;
        }

        LuminanceSource source1 = new PlanarYUVLuminanceSource(
                rgb2YUV(scanBitmap), scanBitmap.getWidth(),
                scanBitmap.getHeight(), 0, 0, scanBitmap.getWidth(),
                scanBitmap.getHeight());
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                source1));
        MultiFormatReader reader1 = new MultiFormatReader();
        Result result1;
        try {
            result1 = reader1.decode(binaryBitmap);
            String content = result1.getText();
            Log.i("123content", content);
        } catch (NotFoundException e1) {
            e1.printStackTrace();
        }
        RGBLuminanceSource source = new RGBLuminanceSource(scanBitmap);
        BinaryBitmap bitmap1 = new BinaryBitmap(new HybridBinarizer(source));
        QRCodeReader reader = new QRCodeReader();
        try {
            return reader.decode(bitmap1, hints);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }


    public byte[] rgb2YUV(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        int len = width * height;
        byte[] yuv = new byte[len * 3 / 2];
        int y, u, v;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int rgb = pixels[i * width + j] & 0x00FFFFFF;
                int r = rgb & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = (rgb >> 16) & 0xFF;
                y = ((66 * r + 129 * g + 25 * b + 128) >> 8) + 16;
                u = ((-38 * r - 74 * g + 112 * b + 128) >> 8) + 128;
                v = ((112 * r - 94 * g - 18 * b + 128) >> 8) + 128;
                y = y < 16 ? 16 : (y > 255 ? 255 : y);
                u = u < 0 ? 0 : (u > 255 ? 255 : u);
                v = v < 0 ? 0 : (v > 255 ? 255 : v);
                yuv[i * width + j] = (byte) y;
                // yuv[len + (i >> 1) * width + (j & ~1) + 0] = (byte) u;
                // yuv[len + (i >> 1) * width + (j & ~1) + 1] = (byte) v;
            }
        }
        return yuv;
    }


    private String getPhoneNumber(Uri uri) {
        String phoneNum = "";
        //得到ContentResolver对象
        ContentResolver cr = activity.getContentResolver();
        //取得电话本中开始一项的光标
        try {
            Cursor cursor = cr.query(uri, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                //取得电话号码
                String ContactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                Cursor phone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + ContactId, null, null);
                if (phone != null) {
                    phone.moveToFirst();
                    String number = ContactsContract.CommonDataKinds.Phone.NUMBER;
                    int columnIndex = phone.getColumnIndex(number);
                    phoneNum = phone.getString(columnIndex);
                }
                phone.close();
                cursor.close();
            } else {
                return null;
            }
        } catch (Exception e) {

        }

        return phoneNum;
    }



    private void stepFragment(BaseFragment fragment, String s) {
        fragmentManager.beginTransaction()
                .replace(R.id.mainActivity_fragmentContainer, fragment)
                .addToBackStack(s)
                .commitAllowingStateLoss();
    }





}
