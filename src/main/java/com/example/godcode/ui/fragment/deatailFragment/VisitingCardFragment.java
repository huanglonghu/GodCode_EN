package com.example.godcode.ui.fragment.deatailFragment;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godcode.R;
import com.example.godcode.catche.Loader.RxImageLoader;
import com.example.godcode.databinding.FragmentVisitingcardBinding;
import com.example.godcode.greendao.entity.User;
import com.example.godcode.greendao.option.UserOption;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.constant.Constant;
import com.example.godcode.utils.EncryptUtil;
import com.google.zxing.encoding.EncodingHandler;

public class VisitingCardFragment extends BaseFragment {
    private FragmentVisitingcardBinding binding;
    private View view;
    private Bitmap bitmap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_visitingcard, container, false);
            binding.setPresenter(presenter);
            view = binding.getRoot();
            binding.visitingCardToolbar.title.setText("My qr code");
            initView();
        }
        return view;
    }


    public void initView() {
        User user = UserOption.getInstance().querryUser(Constant.userId);
        String headImageUrl = user.getHeadImageUrl();
        initVisitCard();
        if (!TextUtils.isEmpty(headImageUrl)) {
            if (!headImageUrl.contains("http")) {
                headImageUrl = Constant.baseUrl + headImageUrl;
            }
            RxImageLoader.with(activity).load(user.getHeadImageUrl()).into(binding.ivVisitCard);
            RxImageLoader.with(activity).getBitmap(headImageUrl).subscribe(
                    imageBean -> {
                        if (imageBean.getBitmap() != null) {
                            bitmap = imageBean.getBitmap();
                        } else {
                            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.contact_normal);
                        }
                        binding.ivHead.setImageBitmap(bitmap);
                    }
            );
        } else {
            binding.ivHead.setImageResource(R.drawable.contact_normal);
            binding.ivVisitCard.setImageResource(R.drawable.contact_normal);
        }
        binding.tvUserName.setText(Constant.userName);
    }

    private void initVisitCard() {
        String qrStr = getQrStr();
        Bitmap mBitmap = EncodingHandler.createQRCode(qrStr, 2200, 2200, null);
        if (mBitmap != null) {
            binding.visitingcard.setImageBitmap(mBitmap);
        }
    }


    public String getQrStr() {
        String qrStr = null;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(Constant.userName + "|");
            stringBuffer.append(Constant.userId + "|");
            stringBuffer.append(0 + "|");
            stringBuffer.append("3");
            //进行加密
            qrStr = EncryptUtil.aesEncrypt(stringBuffer.toString(), "87a4d115c0956912b495d6bb8b7c0013");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qrStr;
    }

    @Override
    protected void lazyLoad() {
    }

}
