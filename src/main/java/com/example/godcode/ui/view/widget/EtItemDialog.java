package com.example.godcode.ui.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.example.godcode.R;
import com.example.godcode.databinding.LayoutEditProductpriceBinding;
import com.example.godcode.http.InputFilterMinMax;
import com.example.godcode.interface_.EtStrategy;

public class EtItemDialog extends Dialog{
    private LayoutEditProductpriceBinding binding;
    private Context context;
    private String hint;
    private String title;
    private int type;
    private int position;
    private int max;
    private int min;
    private EtStrategy etStragety;

    private EtItemDialog(@NonNull Builder builder) {
        super(builder.context);
        this.context = builder.context;
        this.hint =builder.hint;
        this.type = builder.type;
        this.title=builder.title;
        this.position=builder.position;
        this.min=builder.min;
        this.max=builder.max;
        this.etStragety=builder.etStragety;
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_edit_productprice, null, false);
        binding.setTitle(title);
        binding.setHint(hint);
        if(max!=0){
            binding.precent.setText(min+"%"+" - "+max+"%");
            binding.etValue.setFilters(new InputFilter[]{new InputFilterMinMax(min+"", max+"")});
        }
        binding.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        binding.commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valueStr = binding.etValue.getText().toString();
                if (!TextUtils.isEmpty(valueStr)) {
                    etStragety.etComplete(valueStr,position);
                    dismiss();
                } else {
                    Toast.makeText(context, "Please enter the " + hint, Toast.LENGTH_SHORT).show();
                }
            }
        });
        if (type == 1) {
            binding.etValue.setInputType(InputType.TYPE_CLASS_NUMBER);
        } else {
            binding.etValue.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
        }
        setContentView(binding.getRoot());
        setCancelable(false);
    }


    @Override
    public void show() {
        super.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.5f;
        getWindow().setWindowAnimations(R.style.popupStyle);
        getWindow().setAttributes(layoutParams);
    }


    public static class Builder {
        private Context context;
        private String title;
        private String hint;
        private int type;
        private int position;
        private int max;
        private int min;
        private EtStrategy etStragety;

        public Builder context(Context context){
            this.context=context;
            return this;
        }
        public Builder title(String title){
            this.title=title;
            return this;
        }
        public Builder hint(String hint){
            this.hint=hint;
            return this;
        }

        public Builder type(int type){
            this.type=type;
            return this;
        }

        public Builder position(int position){
            this.position=position;
            return this;
        }

        public Builder etStragety(EtStrategy etStragety){
            this.etStragety=etStragety;
            return this;
        }

        public Builder max(int max){
            this.max=max;
            return this;
        }

        public Builder min(int min){
            this.min=min;
            return this;
        }

        public EtItemDialog build(){
           return new EtItemDialog(this);
        }
    }

}
