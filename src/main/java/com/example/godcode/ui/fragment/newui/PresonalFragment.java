package com.example.godcode.ui.fragment.newui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.godcode.bean.EditPresonal;
import com.example.godcode.R;
import com.example.godcode.bean.UploadResponse;
import com.example.godcode.catche.Loader.RxImageLoader;
import com.example.godcode.databinding.FragmentPersonalBinding;
import com.example.godcode.greendao.entity.User;
import com.example.godcode.greendao.option.UserOption;
import com.example.godcode.handler.ActivityResultHandler;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.interface_.HandlerStrategy;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.constant.Constant;
import com.example.godcode.utils.GsonUtil;
import com.example.godcode.utils.ImagUtil;

import okhttp3.MultipartBody;

public class PresonalFragment extends BaseFragment {
    private FragmentPersonalBinding binding;
    private View view;
    private User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            user = UserOption.getInstance().querryUser(Constant.userId);
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_personal, container, false);
            binding.setFragment(this);
            binding.setUser(user);
            binding.setPresenter(presenter);
            view = binding.getRoot();
            initView();
            initData();
            initListener();
        }
        return view;
    }


    public void initListener() {
        binding.ivHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                new ActivityResultHandler.Builder().hadlerStrategy(new HandlerStrategy() {
                    @Override
                    public void onActivityResult(MultipartBody.Part filePart, Bitmap bitmap) {
                        upload(filePart, bitmap);
                    }
                }).requestCode(ActivityResultHandler.REQUEST_SELECT_PHOTO).intent(intent).activity(activity).build().startActivityForResult();
            }
        });


        binding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = binding.etUserName.getText().toString();
                if (TextUtils.isEmpty(userName)) {
                    Toast.makeText(activity, "The userName cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                String email = binding.etEmail.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(activity, "The email cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                String phone = binding.etPhone.getText().toString();
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(activity, "The phone cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                EditPresonal editPresonal = new EditPresonal();
                editPresonal.setId(user.getUserId());
                editPresonal.setEmailAddress(email);
                editPresonal.setNickName(userName);
                HttpUtil.getInstance().editPresonal(editPresonal).subscribe(
                        str -> {
                            user.setEmailAddress(email);
                            user.setUserName(userName);
                            UserOption.getInstance().updateUser(user);
                            Toast.makeText(activity, "Modified success", Toast.LENGTH_SHORT).show();
                        }
                );
            }
        });

    }


    public void initView() {
        String headImageUrl = user.getHeadImageUrl();
        String url = ImagUtil.handleUrl(headImageUrl);
        if (!TextUtils.isEmpty(url)) {
            RxImageLoader.with(activity).getBitmap(headImageUrl).subscribe(
                    imageBean -> {
                        if (imageBean.getBitmap() != null) {
                            Bitmap bitmap = imageBean.getBitmap();
                            RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                            roundedBitmapDrawable.setCircular(true);
                            binding.ivHead.setImageDrawable(roundedBitmapDrawable);
                        }
                    }
            );
        } else {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.contact_normal);
            RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
            roundedBitmapDrawable.setCircular(true);
            binding.ivHead.setImageDrawable(roundedBitmapDrawable);
        }
    }

    @Override
    public void initData() {


    }


    public void upload(MultipartBody.Part filePart, Bitmap bitmap) {
        HttpUtil.getInstance().upload(filePart, 2).subscribe(
                uploadStr -> {
                    UploadResponse uploadResponse = GsonUtil.getInstance().fromJson(uploadStr, UploadResponse.class);
                    String headUrl = uploadResponse.getResult().get(0);
                    EditPresonal editPresonal = new EditPresonal();
                    editPresonal.setId(Constant.userId);
                    editPresonal.setHeadImgUrl(Constant.baseUrl + headUrl);
                    HttpUtil.getInstance().editPresonal(editPresonal).subscribe(
                            editSuccess -> {
                                user.setHeadImageUrl(Constant.baseUrl + headUrl);
                                initView();
                                UserOption.getInstance().updateUser(user);
                            }
                    );
                }
        );
    }
}
