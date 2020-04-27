package com.example.godcode_en.ui.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;

import com.example.godcode_en.R;
import com.example.godcode_en.databinding.LayoutProducttypeBinding;
import com.example.godcode_en.presenter.Presenter;
import com.example.godcode_en.ui.fragment.newui.adapter.GridViewAdapter;

import java.util.ArrayList;


public class BottomDialog extends Dialog {
    private int selectPosition;
    private String title;
    private ArrayList<String> typeList;

    public BottomDialog(@NonNull Context context, ArrayList<String> typeList, int selectPosition, String title) {
        super(context, R.style.dialog2);
        this.title = title;
        this.typeList = typeList;
        this.selectPosition = selectPosition;
        initView(context);
    }

    private void initView(Context context) {
        LayoutProducttypeBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_producttype, null, false);
        binding.bottomTitle.setText(title);
        binding.cancelProductType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        GridViewAdapter adapter = new GridViewAdapter(typeList, context, selectPosition);
        binding.gridType.setAdapter(adapter);
        binding.gridType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundResource(R.drawable.bg_wxdl);
                adapter.setSelectPosition(position);
                typeSelect.selectType(position);
                cancel();
            }
        });
        getWindow().setWindowAnimations(R.style.popupStyle);
        setContentView(binding.getRoot());
        setCancelable(false);
        setCanceledOnTouchOutside(true);
    }

    @Override
    public void show() {
        super.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = Presenter.getInstance().getWindowWidth();
        layoutParams.height = 1 * (Presenter.getInstance().getWidowHeight()) / 2;
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.5f;
        getWindow().setAttributes(layoutParams);
    }


    public interface TypeSelect {
        void selectType(int type);
    }

    public void setTypeSelect(TypeSelect typeSelect) {
        this.typeSelect = typeSelect;
    }

    private TypeSelect typeSelect;


}
