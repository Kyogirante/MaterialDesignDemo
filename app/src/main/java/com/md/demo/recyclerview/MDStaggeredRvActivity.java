package com.md.demo.recyclerview;

import android.os.Bundle;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.md.demo.MDBaseActivity;
import com.md.demo.R;
import com.md.demo.recyclerview.adapter.MDStaggeredRvAdapter;
import com.md.demo.recyclerview.mock.MDMockData;

/**
 * staggered {@link android.support.v7.widget.RecyclerView} page
 *
 * Created by wangkegang on 2016/07/06 .
 */
public class MDStaggeredRvActivity extends MDBaseActivity {

    private RecyclerView mRecyclerView;

    private MDStaggeredRvAdapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_staggered);

        initData();
        initView();
    }

    private void initData() {
        mAdapter = new MDStaggeredRvAdapter(MDMockData.getRvData());

        mLayoutManager = new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);

    }
}
