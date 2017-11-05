package com.example.weijunhao.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.security.Key;
import java.util.List;

/**
 * Created by weijunhao on 2017/8/17.
 */

public class PopupWindowRvAdapter extends RecyclerView.Adapter<PopupWindowRvAdapter.ViewHolder> {
    private Context mContext;
    private List<KeyValueBean> mBeanList;

    public PopupWindowRvAdapter(Context context, List<KeyValueBean> list) {
        mBeanList = list;
        mContext = context;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int pos);
    }

    public OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.text.setText(mBeanList.get(position).getValue());

        if (mBeanList.get(position).isChecked()) {
            holder.text.setTextColor(Color.parseColor("#555555"));
        } else {
            holder.text.setTextColor(Color.parseColor("#000000"));
        }

        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(holder.text, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBeanList == null ? 0 : mBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public ViewHolder(View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.text);
        }
    }
}
