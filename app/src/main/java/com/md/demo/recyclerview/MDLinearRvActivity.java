package com.md.demo.recyclerview;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.md.demo.MDBaseActivity;
import com.md.demo.R;
import com.md.demo.recyclerview.adapter.MDRvAdapter;
import com.md.demo.recyclerview.decoration.MDLinearRvDividerDecoration;

import java.util.ArrayList;

/**
 * linear {@link RecyclerView} page
 *
 * Created by KyoWang on 2016/06/30 .
 */
public class MDLinearRvActivity extends MDBaseActivity implements View.OnClickListener {

    private TextView mAddItemBtn;

    private TextView mDelItemBtn;

    private RecyclerView mRecyclerView;

    private MDRvAdapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_linear);
        initData();
        initView();
        initAction();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.rv_add_item_btn) {
            mAdapter.addNewItem();
            mLayoutManager.scrollToPosition(0);
        } else if(id == R.id.rv_del_item_btn){
            mAdapter.deleteItem();
            mLayoutManager.scrollToPosition(0);
        }
    }

    private void initData() {
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mAdapter = new MDRvAdapter(getData());

        mAdapter.setOnItemClickListener(new MDRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MDLinearRvActivity.this,"click " + position + " item", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MDLinearRvActivity.this,"long click " + position + " item", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        mAddItemBtn = (TextView) findViewById(R.id.rv_add_item_btn);
        mDelItemBtn = (TextView) findViewById(R.id.rv_del_item_btn);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // 设置布局管理器
        mRecyclerView.setLayoutManager(mLayoutManager);
        // 设置adapter
        mRecyclerView.setAdapter(mAdapter);
        // 设置Item添加和移除的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置Item之间间隔样式
        mRecyclerView.addItemDecoration(new MDLinearRvDividerDecoration(this, LinearLayoutManager.VERTICAL));
    }

    private void initAction() {
        mAddItemBtn.setOnClickListener(this);
        mDelItemBtn.setOnClickListener(this);
    }

    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = " item";
        for(int i = 0; i < 20; i++) {
            data.add(i + temp);
        }

        return data;
    }

}
