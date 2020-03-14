package com.example.godcode.ui.fragment.bindproduct;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.godcode.R;
import com.example.godcode.databinding.FragmentBindproductBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.utils.LogUtil;
import com.example.godcode.utils.StringUtil;
import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class BindProductFragment extends BaseFragment {
    private FragmentBindproductBinding binding;
    private View view;
    private String productNumber;
    private int position;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bindproduct, container, false);
            view = binding.getRoot();
            initChild();
            binding.bindproductToolbar.toolbar4Back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    back();
                }
            });
        }
        toggleChild(0);
        return view;
    }

    public void back() {
        switch (position){
            case 0:
                presenter.back();
                setProductNumber(null);
                break;
            case 1:
                setProductNumber("");
                toggleChild(0);
                break;
            case 2:
                setProductNumber("");
                toggleChild(0);
                break;
        }
    }

    private ArrayList<BaseFragment> fragments = new ArrayList<>();

    private void initChild() {
        BindProduct0Fragment fragment0 = new BindProduct0Fragment();
        BindProduct1Fragment fragment1 = new BindProduct1Fragment();
        BindProduct2Fragment fragment2 = new BindProduct2Fragment();
        fragments.add(fragment0);
        fragments.add(fragment1);
        fragments.add(fragment2);
    }


    @Override
    protected void lazyLoad() {
    }


    public void toggleChild(int position) {
        this.position=position;
        BaseFragment fragment = fragments.get(position);
        getChildFragmentManager().beginTransaction().replace(R.id.bindProduct_container, fragment).commit();
    }


    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public void refreshProductNumber(String productNumber){
        this.productNumber=productNumber;
        BindProduct0Fragment fragment0= (BindProduct0Fragment) fragments.get(0);
        fragment0.onResume();
    }

    @Override
    public void onKeyDown() {
        super.onKeyDown();
        back();
    }
}
