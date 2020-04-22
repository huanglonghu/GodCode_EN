package com.example.godcode.ui.fragment.newui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.godcode.bean.EditPresonal;
import com.example.godcode.R;
import com.example.godcode.bean.EditBean;
import com.example.godcode.databinding.FragmentEditpersonalBinding;
import com.example.godcode.greendao.entity.City;
import com.example.godcode.greendao.entity.Province;
import com.example.godcode.greendao.entity.User;
import com.example.godcode.greendao.entity.Zone;
import com.example.godcode.greendao.gen.CityDao;
import com.example.godcode.greendao.gen.ZoneDao;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.constant.Constant;
import com.example.godcode.utils.GreenDaoUtil;
import com.youth.picker.PickerView;
import com.youth.picker.entity.PickerData;
import com.youth.picker.listener.OnPickerClickListener;
import java.util.HashMap;
import java.util.List;

public class EditPresonalFragment extends BaseFragment{
    private FragmentEditpersonalBinding binding;
    private View view;
    private PickerView pickerView;
    private EditBean editBean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_editpersonal, container, false);
            binding.setPresenter(presenter);
            binding.setFragment(this);
            view = binding.getRoot();
            binding.editPresonalToolbar.tvOption.setText("Save");
        }
        initView();
        return view;
    }

    private String[] sexArray = {"Man", "Woman"};


    public void initView() {
        binding.setEditBean(editBean);
        binding.etContent.setText(content);
        switch (editBean.type.get()) {
            case 1:
                binding.editPresonalToolbar.title.setText("Change user name");
                break;
            case 3:
                binding.editPresonalToolbar.title.setText("Modify the area");
                initPickerData();
                pickerView.show(view);
                pickerView.setOnPickerClickListener(new OnPickerClickListener() {
                    @Override
                    public void OnPickerClick(PickerData pickerData) {
                    }

                    @Override
                    public void OnPickerConfirmClick(PickerData pickerData) {
                        String selectText = pickerData.getSelectText();
                        if (!TextUtils.isEmpty(selectText)) {
                            binding.tvContent.setText(selectText);
                        }
                        pickerView.dismiss();
                    }
                });
                break;
        }

        binding.editPresonalToolbar.toolbar3Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.back();
            }
        });

        binding.editPresonalToolbar.option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(editBean.content.get())) {
                    EditPresonal editPresonal = new EditPresonal();
                    editPresonal.setId(Constant.userId);
                    switch (editBean.type.get()) {
                        case 1:
                            editPresonal.setNickName(editBean.content.get());
                            break;
                        case 2:
                            if (editBean.content.get().equals("Woman")) {
                                editPresonal.setSex("2");
                            } else {
                                editPresonal.setSex("1");
                            }
                            break;
                        case 3:
                            editPresonal.setArea(editBean.content.get());
                            break;
                    }
                    HttpUtil.getInstance().editPresonal(editPresonal).subscribe(
                            editSuccess -> {
                                personalUpdate.update(editBean.type.get(), editBean.content.get());
                                presenter.back();
                            }
                    );
                } else {
                    Toast.makeText(activity, "The content cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    private void initPickerData() {
        PickerData data = new PickerData();
        List<Province> provinces = GreenDaoUtil.getSingleton().getDaoSession().getProvinceDao().loadAll();
        String[] mProvinceDatas = new String[provinces.size()];
        HashMap<String, String[]> mCitisDatasMap = new HashMap<>();
        HashMap<String, String[]> mDistrictDatasMap = new HashMap<>();
        for (int i = 0; i < provinces.size(); i++) {
            Province province = provinces.get(i);
            String proName = province.getProName();
            mProvinceDatas[i] = proName;
            int proSort = province.getProSort();
            List<City> cityList = GreenDaoUtil.getSingleton().getDaoSession().getCityDao().queryBuilder().where(CityDao.Properties.ProId.eq(proSort)).list();
            String[] cityArray = new String[cityList.size()];
            for (int j = 0; j < cityList.size(); j++) {
                City city = cityList.get(j);
                String cityName = city.getCityName();
                long citySort = city.getCitySort();
                cityArray[j] = cityName;
                List<Zone> zoneList = GreenDaoUtil.getSingleton().getDaoSession().getZoneDao().queryBuilder().where(ZoneDao.Properties.CityId.eq(citySort)).list();
                String[] zoneArray = new String[zoneList.size()];
                for (int k = 0; k < zoneList.size(); k++) {
                    zoneArray[k] = zoneList.get(k).getZoneName();
                }
                mDistrictDatasMap.put(cityName, zoneArray);
            }
            mCitisDatasMap.put(proName, cityArray);
        }
        //设置数据，有多少层级自己确定
        data.setFirstDatas(mProvinceDatas);
        data.setSecondDatas(mCitisDatasMap);
        data.setThirdDatas(mDistrictDatasMap);
        pickerView = new PickerView(activity, data);
    }


    private String content;

    public void initData(int type, User user) {
        switch (type) {
            case 1:
                content = user.getUserName();
                break;
            case 2:
                content = user.getSex();
                break;
            case 3:
                content = user.getArea();
                break;
        }
        if (editBean == null) {
            editBean = new EditBean();
        }
        editBean.content.set(content);
        editBean.type.set(type);
    }


    public interface PersonalUpdate {
        void update(int type, String content);
    }

    private PersonalUpdate personalUpdate;

    public void setPersonalUpdate(PersonalUpdate personalUpdate) {
        this.personalUpdate = personalUpdate;
    }

    public void edit() {
        switch (editBean.type.get()) {
            case 3:
                pickerView.show(view);
                break;
        }
    }

}
