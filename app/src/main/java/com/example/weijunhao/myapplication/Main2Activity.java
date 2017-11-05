package com.example.weijunhao.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Main2Activity extends AppCompatActivity {
    private Context mContext = this;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(mContext, 3);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new GridAdapter(mContext));
        int spanCount = 3;//跟布局里面的spanCount属性是一致的
        int spacing = 200;//每一个矩形的间距
        boolean includeEdge = true;//如果设置成false那边缘地带就没有间距
        //设置每个item间距
        mRecyclerView.addItemDecoration(new GridItemDec(spanCount,spacing,includeEdge));

    }


    class GridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        private LayoutInflater mInflater;

        public GridAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rootView = this.mInflater.inflate(R.layout.grid_item,parent,false);
            return new ViewHolder(rootView);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 10;//数据数量，不想搞太复杂
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
