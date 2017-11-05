package com.example.weijunhao.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context mContext = this;
    private PopupWindow mPopupWindow;
    private List<KeyValueBean> listLeft = getListLeft();
    private List<KeyValueBean> listRight = getListRight();
    private Button mButtonLeft, mButtonRight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonLeft = (Button) findViewById(R.id.button);
        mButtonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow(listLeft);
            }
        });

        mButtonRight = (Button) findViewById(R.id.button2);
        mButtonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow(listRight);
            }
        });
    }

    public void showPopupWindow(final List<KeyValueBean> list) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.popupwindow, null);
        mPopupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setContentView(view);

        RecyclerView recyclerView = view.findViewById(R.id.rv);

        final PopupWindowRvAdapter popupWindowRvAdapter = new PopupWindowRvAdapter(mContext, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(popupWindowRvAdapter);
        popupWindowRvAdapter.setOnItemClickListener(new PopupWindowRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                if (list.get(pos).isChecked()) {
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        if (i == pos) {
                            list.get(i).setChecked(true);
                        } else {
                            list.get(i).setChecked(false);
                        }
                    }
                    popupWindowRvAdapter.notifyDataSetChanged();
                }
                mPopupWindow.dismiss();
            }
        });

        mPopupWindow.showAsDropDown(mButtonLeft);
    }

    public List<KeyValueBean> getListLeft() {
        List<KeyValueBean> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            KeyValueBean bean = new KeyValueBean();
            bean.setKey(i);
            bean.setValue(i + "123");
            list.add(bean);
        }

        return list;
    }

    public List<KeyValueBean> getListRight() {
        List<KeyValueBean> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            KeyValueBean bean = new KeyValueBean();
            bean.setKey(i);
            bean.setValue(i + "哦哦哦");
            list.add(bean);
        }

        return list;
    }
}
