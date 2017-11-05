package com.example.weijunhao.myapplication.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.weijunhao.myapplication.R;

import butterknife.BindInt;
import butterknife.BindView;

public class Main3Activity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        setSupportActionBar(mToolbar);


        setDefaultFragment();
    }

    private void setDefaultFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content, new BlankFragment(), "BlankFragment")
                .commit();
    }
}
