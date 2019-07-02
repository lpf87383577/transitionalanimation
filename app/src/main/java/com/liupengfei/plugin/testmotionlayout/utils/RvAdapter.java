package com.liupengfei.plugin.testmotionlayout.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liupengfei.plugin.testmotionlayout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liupengfei
 * @describe TODO
 * @date on 2019/7/2 17:21
 */
public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvHolder>{

    List<String> mList = new ArrayList<>();

    Context mContext;

    public RvAdapter(Context context){

        mContext = context;

        for (int i=0;i<40;i++){

            mList.add("我是item  "+i);

        }
    }

    @Override
    public RvHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RvHolder rvHolder = new RvHolder(LayoutInflater.from(mContext).inflate(R.layout.item_rv,null));

        return rvHolder;
    }

    @Override
    public void onBindViewHolder(RvHolder holder, int position) {

        holder.tv.setText(mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class RvHolder extends RecyclerView.ViewHolder{

        public TextView tv;

        public RvHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textView);
        }

    }
}
