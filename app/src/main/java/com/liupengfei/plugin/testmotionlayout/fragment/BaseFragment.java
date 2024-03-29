package com.liupengfei.plugin.testmotionlayout.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liupengfei.plugin.testmotionlayout.utils.L;

public abstract class BaseFragment extends Fragment {

    protected View mView;

    /**
     * 表示View是否被初始化
     */
    protected boolean isViewInitiated;
    /**
     * 表示对用户是否可见
     */
    protected boolean isVisibleToUser;
    /**
     * 表示数据是否初始化
     */
    protected boolean isDataInitiated;
    protected Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        L.e(getClass().getSimpleName() + ">>>>>>>>>>>　　onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        L.e(getClass().getSimpleName() + ">>>>>>>>>>>　　onCreateView");
        if (mView == null) {
            mContext = getContext();
            mView = View.inflate(mContext, getLayoutId(), null);
            initView(mView);
            L.e(getClass().getSimpleName() + ">>>>>>>>>>>　　initView");
        } else {
            // 缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，
            // 要不然会发生这个rootview已经有parent的错误。
            ViewGroup parent = (ViewGroup) mView.getParent();
            if (parent != null) {
                parent.removeView(mView);
            }
            L.e(getClass().getSimpleName() + ">>>>>>>>>>>　　removeView");
        }
        return mView;
    }

    protected abstract void initView(View view);

    protected abstract int getLayoutId();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        L.e(getClass().getSimpleName() + ">>>>>>>>>>>　　onActivityCreated");
        isViewInitiated = true;
        initListener();
        initData();
        prepareFetchData();
    }

    protected void initListener() {
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        prepareFetchData();
    }

    public abstract void fetchData();

    public boolean prepareFetchData() {
        return prepareFetchData(false);
    }

    /***
     *
     * @param forceUpdate 表示是否在界面可见的时候是否强制刷新数据
     * @return
     */
    public boolean prepareFetchData(boolean forceUpdate) {
        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            //  界面可见的时候再去加载数据
            fetchData();
            isDataInitiated = true;
            return true;
        }
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        L.e(getClass().getSimpleName() + ">>>>>>>>>>>　　onDestroyView");
    }

    protected void initData() {
    }

}