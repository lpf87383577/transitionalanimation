package com.liupengfei.plugin.testmotionlayout.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.liupengfei.plugin.testmotionlayout.R;
import com.liupengfei.plugin.testmotionlayout.utils.RvAdapter;


import java.util.ArrayList;
import java.util.List;


public class ListFragment extends BaseFragment {

    RecyclerView mRecyclerView;
    private static final String KEY = "key";
    private String title = "测试";

    List<String> mDatas = new ArrayList<>();
    private RvAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public static ListFragment newInstance(String title) {
        ListFragment fragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initView(View view) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            title = arguments.getString(KEY);
        }
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setEnabled(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(mContext,
                LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new RvAdapter(mContext);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void tooglePager(boolean isOpen) {
        if (isOpen) {
            setRefreshEnable(false);
            scrollToFirst(false);
        } else {
            setRefreshEnable(true);
        }
    }

    public void scrollToFirst(boolean isSmooth) {
        if (mRecyclerView == null) {
            return;
        }
        if (isSmooth) {
            mRecyclerView.smoothScrollToPosition(0);
        } else {
            mRecyclerView.scrollToPosition(0);
        }
    }

    public void setRefreshEnable(boolean enabled) {
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setEnabled(enabled);
        }

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    public void fetchData() {

    }
}
