package com.example.godcode_en.ui.fragment.newui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.godcode_en.R;
import com.example.godcode_en.databinding.FragmentFriendBinding;
import com.example.godcode_en.databinding.ItemHeadBinding;
import com.example.godcode_en.databinding.LayoutMainPopupBinding;
import com.example.godcode_en.greendao.entity.Friend;
import com.example.godcode_en.greendao.option.FriendOption;
import com.example.godcode_en.ui.fragment.newui.adapter.ContactAdapter;
import com.example.godcode_en.ui.base.BaseFragment;
import com.example.godcode_en.constant.Constant;
import com.example.godcode_en.ui.fragment.newui.friend.SearchFragment;
import com.example.godcode_en.ui.view.customview.LetterView;
import com.example.godcode_en.ui.view.widget.MenuWindow;
import com.example.godcode_en.utils.ToastUtil;
import java.util.List;

public class FriendFragment extends BaseFragment {
    private View view;
    private int type;
    private FragmentFriendBinding binding;
    private ContactAdapter adapter;
    private MenuWindow menuWindow;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        type = getArguments().getInt("type");
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_friend, container, false);
            view = binding.getRoot();
            initData();
            initView();
            initListener();
        }
        return view;
    }

    public void initData() {
        FriendOption.getInstance(activity).querryFriendList(1, true);
        FriendOption.getInstance(activity).friendUpdateListener().subscribe(
                update -> {
                    if (update) {
                        adapter.clear();
                        List<Friend> friendList = FriendOption.getInstance(activity).getAllFriend(Constant.userId);
                        adapter.refreshData(friendList);
                    }
                }
        );
    }



    public void initListener() {
        binding.search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment searchFragment = new SearchFragment();
                presenter.step2Fragment(searchFragment, "search");
            }
        });

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuWindow = new MenuWindow(getContext());
                LayoutMainPopupBinding binding = menuWindow.getBinding1();
                binding.setFragment(FriendFragment.this);
                menuWindow.show(v);
            }
        });

    }

    public void initView() {
        LetterView letterView = (LetterView) view.findViewById(R.id.letter_view);
        adapter = new ContactAdapter(getActivity(), presenter, type);
        binding.friendList.setAdapter(adapter);
        letterView.setCharacterListener(new LetterView.CharacterClickListener() {
            @Override
            public void clickCharacter(String character) {
                ToastUtil.getInstance().showToast(character, 1000, activity);
                int scrollPosition = adapter.getScrollPosition(character);
                if (scrollPosition != -1) {
                    binding.friendList.setSelection(scrollPosition);
                }
            }

            @Override
            public void clickArrow() {
                binding.friendList.setSelection(0);
            }
        });

    }


    public void showNews(int count) {
        View view = adapter.getView(0, null, null);
        ItemHeadBinding binding = DataBindingUtil.findBinding(view);
        binding.setNewsCount(count);
    }


    public void config(View view) {
        switch (view.getId()) {
            case R.id.mainPopup_addFriend:
                presenter.step2Fragment("addFriend");
                break;
            case R.id.mainPopup_sys:
                presenter.sys();
                break;
        }
        menuWindow.dismiss();
    }

}
