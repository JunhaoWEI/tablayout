package com.example.weijunhao.myapplication.fragment;


import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.weijunhao.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment extends Fragment {


    public TabFragment() {
        // Required empty public constructor
    }


    @BindView(R.id.rv_item)
    RecyclerView mRecyclerView;

    @BindView(R.id.linearLayout)
    LinearLayout mLinearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        ButterKnife.bind(this, view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new MyAdapter(getActivity()));

        mRecyclerView.addOnScrollListener(mOnScrollListener);
        return view;
    }

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (dy > 0) {
                ValueAnimator valueAnimator = ValueAnimator.ofInt(mLinearLayout.getHeight(), 0);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        //获取当前的height值
                        int h = (Integer) valueAnimator.getAnimatedValue();
                        //动态更新view的高度
                        mLinearLayout.getLayoutParams().height = h;
                        mLinearLayout.requestLayout();
                    }
                });
                valueAnimator.setDuration(200);
                valueAnimator.start();
            } else {
                ValueAnimator valueAnimator = ValueAnimator.ofInt(0, mLinearLayout.getHeight());
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        //获取当前的height值
                        int h = (Integer) valueAnimator.getAnimatedValue();
                        //动态更新view的高度
                        mLinearLayout.getLayoutParams().height = h;
                        mLinearLayout.requestLayout();
                    }
                });
                valueAnimator.setDuration(200);
                valueAnimator.start();
            }
        }
    };

}
