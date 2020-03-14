package com.example.godcode.ui.fragment.deatailFragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.godcode.ui.fragment.mainActivity.MineFragment;
import com.example.godcode.utils.GsonUtil;
import okhttp3.MultipartBody;

public class PresonalFragment extends BaseFragment implements EditPresonalFragment.PersonalUpdate{
    private FragmentPersonalBinding binding;
    private View view;
    private User user;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            user = UserOption.getInstance().querryUser(Constant.userId);
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_personal, container, false);
            binding.setFragment(this);
            binding.setUser(user);
            binding.setPresenter(presenter);
            view = binding.getRoot();
            initView();
            initListener();
        }
        return view;
    }

    private void initListener() {
        binding.rlHeadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                new ActivityResultHandler.Builder().hadlerStrategy(new HandlerStrategy() {
                    @Override
                    public void onActivityResult(MultipartBody.Part filePart, Bitmap bitmap) {
                        upload(filePart,bitmap);
                    }
                }).requestCode(ActivityResultHandler.REQUEST_SELECT_PHOTO).intent(intent).activity(activity).build().startActivityForResult();
            }
        });
    }




    private void initView() {
        String headImageUrl = user.getHeadImageUrl();
        if (!TextUtils.isEmpty(headImageUrl)) {
            if (!headImageUrl.contains("http")) {
                headImageUrl = Constant.baseUrl + headImageUrl;
            }
            RxImageLoader.with(activity).load(headImageUrl).into(binding.ivUser);
        } else {
            binding.ivUser.setImageResource(R.drawable.contact_normal);
        }

    }

    @Override
    protected void lazyLoad() {
    }


    private int type;

    public void editPersonal(int type) {
        this.type = type;
        EditPresonalFragment editPresonalFragment = new EditPresonalFragment();
        editPresonalFragment.setPersonalUpdate(PresonalFragment.this);
        editPresonalFragment.initData(type, user);
        presenter.step2Fragment(editPresonalFragment, "editPersonal");
    }

    @Override
    public void update(int type, String content) {
        switch (type) {
            case 1:
                user.setUserName(content);
                break;
            case 2:
                user.setSex(content);
                break;
            case 3:
                user.setArea(content);
                break;
        }
        UserOption.getInstance().updateUser(user);
        binding.setUser(user);
    }


    @Override
    public void onKeyDown() {
        presenter.back();
    }


    public void upload(MultipartBody.Part filePart, Bitmap bitmap) {
        binding.ivUser.setImageBitmap(bitmap);
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
                                UserOption.getInstance().updateUser(user);
                                MineFragment mineFragment= (MineFragment) presenter.getFragments().get(3);
                                mineFragment.refreshData();
                            }
                    );
                }
        );
    }
}
