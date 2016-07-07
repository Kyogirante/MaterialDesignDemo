package com.md.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.md.demo.recyclerview.MDRvMainActivity;

/**
 * main page of the app
 *
 * Created by KyoWang on 2016/06/30 .
 */
public class MDMainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView mToRvBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAction();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.to_rv_page_btn) {
            goToRvPage();
        }
    }

    private void initView() {
        mToRvBtn = (CardView) findViewById(R.id.to_rv_page_btn);
    }

    private void initAction() {
        mToRvBtn.setOnClickListener(this);
    }

    private void goToRvPage() {
        Intent intent = new Intent(this, MDRvMainActivity.class);
        startActivity(intent);
    }
}
