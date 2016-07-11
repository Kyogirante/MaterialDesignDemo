package com.md.demo.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.md.demo.MDBaseActivity;
import com.md.demo.R;

/**
 * Created by wangkegang on 2016/07/05 .
 */
public class MDRvMainActivity extends MDBaseActivity implements View.OnClickListener {

    private TextView mToLinearRvPageBtn;

    private TextView mToGridRvPageBtn;

    private TextView mToStaggeredRvPageBtn;

    private TextView mToSwipeToDismissRvPageBtn;

    private TextView mToDragRvBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_main);

        initView();
        initAction();
    }

    private void initView() {
        mToLinearRvPageBtn = (TextView) findViewById(R.id.to_linear_rv_page_btn);
        mToGridRvPageBtn = (TextView) findViewById(R.id.to_grid_rv_page_btn);
        mToStaggeredRvPageBtn = (TextView) findViewById(R.id.to_staggered_rv_page_btn);
        mToSwipeToDismissRvPageBtn = (TextView) findViewById(R.id.to_swipe_rv_page_btn);
        mToDragRvBtn = (TextView) findViewById(R.id.to_drag_rv_page_btn);
    }

    private void initAction() {
        mToLinearRvPageBtn.setOnClickListener(this);
        mToGridRvPageBtn.setOnClickListener(this);
        mToStaggeredRvPageBtn.setOnClickListener(this);
        mToSwipeToDismissRvPageBtn.setOnClickListener(this);
        mToDragRvBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.to_linear_rv_page_btn) {
            Intent intent = new Intent(this, MDLinearRvActivity.class);
            startActivity(intent);
        } else if(id == R.id.to_grid_rv_page_btn) {
            Intent intent = new Intent(this, MDGridRvActivity.class);
            startActivity(intent);
        } else if(id == R.id.to_staggered_rv_page_btn) {
            Intent intent = new Intent(this, MDStaggeredRvActivity.class);
            startActivity(intent);
        } else if(id == R.id.to_swipe_rv_page_btn) {
            Intent intent = new Intent(this, MDSwipeToDismissActivity.class);
            startActivity(intent);
        } else if(id == R.id.to_drag_rv_page_btn) {
            Intent intent = new Intent(this, MDDragRvActivity.class);
            startActivity(intent);
        }
    }
}
