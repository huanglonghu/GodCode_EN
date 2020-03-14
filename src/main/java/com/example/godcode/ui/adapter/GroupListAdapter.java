package com.example.godcode.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.godcode.R;
import com.example.godcode.bean.GroupMsg;
import com.example.godcode.catche.Loader.RxImageLoader;
import com.example.godcode.databinding.ItemLvGroupBinding;
import com.example.godcode.constant.Constant;
import com.example.godcode.ui.view.widget.EditNameDialog;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupListAdapter extends BaseAdapter {
    private ArrayList<GroupMsg.ResultBean.bean> groupList;
    private Context context;
    private LayoutInflater layoutInflater;
    private HashMap<Integer, View> viewMap = new HashMap<>();
    private int periodType;
    private final String[] fcArray;
    private final String[] tbArray;
    private final String[] zcArray;

    public GroupListAdapter(Context context, ArrayList<GroupMsg.ResultBean.bean> groupList) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.groupList = groupList;
        fcArray = context.getResources().getStringArray(R.array.fcArray);
        tbArray = context.getResources().getStringArray(R.array.tbArray);
        zcArray = context.getResources().getStringArray(R.array.zcArray);

    }

    @Override
    public int getCount() {
        return groupList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (groupList.size() > 0 && viewMap.get(position) == null) {
            ItemLvGroupBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_lv_group, null, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
            binding.setFcArray(fcArray);
            binding.setTbArray(tbArray);
            binding.setZcArray(zcArray);
            binding.setPeriodType(periodType);
            GroupMsg.ResultBean.bean bean = groupList.get(position);
            String headImgUrl = bean.getHeadImgUrl();
            if (!TextUtils.isEmpty(headImgUrl)) {
                if (!headImgUrl.contains("http")) {
                    headImgUrl = Constant.baseUrl + headImgUrl;
                }
                RxImageLoader.with(context).load(headImgUrl).into(binding.ivPhoto);
            } else {
                binding.ivPhoto.setImageResource(R.drawable.contact_normal);
            }
            binding.setBean(bean);
            binding.editGroupName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditNameDialog editNameDialog = new EditNameDialog(context, bean.getFK_UserID(), binding.groupName);
                    editNameDialog.show();
                }
            });
            viewMap.put(position, convertView);
        }
        return viewMap.get(position);
    }

    public void clearData(int periodType) {
        this.periodType = periodType;
        viewMap.clear();
        groupList.clear();
        notifyDataSetChanged();
    }


    public void refreshDataByGroupId(int groupId, int coin, double paper) {
        for (int i = 0; i < groupList.size(); i++) {
            GroupMsg.ResultBean.bean bean = groupList.get(i);
            if (bean.getFK_UserID() == groupId) {
                View view = getView(i, null, null);
                ItemLvGroupBinding binding = (ItemLvGroupBinding) view.getTag();
                bean.setTodayCoin(bean.getTodayCoin() + coin);
                bean.setTodayBanknote(bean.getTodayBanknote() + paper);
                binding.setBean(bean);
                break;
            }
        }
    }
}
