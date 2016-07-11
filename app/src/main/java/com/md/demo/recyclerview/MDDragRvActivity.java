package com.md.demo.recyclerview;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.md.demo.MDBaseActivity;
import com.md.demo.R;
import com.md.demo.recyclerview.adapter.MDDragRvAdapter;
import com.md.demo.recyclerview.mock.MDMockData;

/**
 * Created by wangkegang on 2016/07/11 .
 */
public class MDDragRvActivity extends MDBaseActivity {

    public RecyclerView mRecyclerView;

    private MDDragRvAdapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    private ItemTouchHelper mItemTouchHelper;

    private ItemTouchHelper.Callback mItemTouchCallBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_drag);

        initView();
        initAction();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
    }

    private void initAction() {
        mItemTouchCallBack = new ItemTouchHelper.Callback() {
            /**
             * 设置滑动类型标记
             *
             * @param recyclerView
             * @param viewHolder
             * @return
             */
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                return makeMovementFlags(ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT | ItemTouchHelper.DOWN | ItemTouchHelper.UP, 0);
            }

            /**
             * 移动Item
             *
             * @param recyclerView
             * @param viewHolder
             * @param target
             * @return
             */
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                mAdapter.move(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return true;
            }

            /**
             * 滑动删除Item
             *
             * @param viewHolder
             * @param direction
             */
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            }

            /**
             * Item被选中
             *
             * @param viewHolder
             * @param actionState
             */
            @Override
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                //  item被选中的操作
                if(actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                    viewHolder.itemView.setBackgroundResource(R.color.md_gray);
                }
                super.onSelectedChanged(viewHolder, actionState);
            }

            /**
             * 移动过程中重新绘制Item
             *
             * @param c
             * @param recyclerView
             * @param viewHolder
             * @param dX
             * @param dY
             * @param actionState
             * @param isCurrentlyActive
             */
            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView,
                                    RecyclerView.ViewHolder viewHolder,
                                    float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState,
                        isCurrentlyActive);
            }

            /**
             * 移动过程中重新绘制Item
             *
             * @param c
             * @param recyclerView
             * @param viewHolder
             * @param dX
             * @param dY
             * @param actionState
             * @param isCurrentlyActive
             */
            @Override
            public void onChildDrawOver(Canvas c, RecyclerView recyclerView,
                                        RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState,
                                        boolean isCurrentlyActive) {
                super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState,
                        isCurrentlyActive);
            }

            /**
             * Item是否支持长按拖动
             *
             * @return
             */
            @Override
            public boolean isLongPressDragEnabled() {
                return true;
            }

            /**
             * Item是否支持滑动
             *
             * @return
             */
            @Override
            public boolean isItemViewSwipeEnabled() {
                return false;
            }

            /**
             * 用户操作完毕或者动画完毕后调用
             *
             * @param recyclerView
             * @param viewHolder
             */
            @Override
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                // 操作完毕后恢复颜色
                viewHolder.itemView.setBackgroundResource(R.drawable.md_common_bg);
                super.clearView(recyclerView, viewHolder);
            }
        };

        mItemTouchHelper = new ItemTouchHelper(mItemTouchCallBack);

        mAdapter = new MDDragRvAdapter(MDMockData.getRvData());

        mLayoutManager = new GridLayoutManager(this, 4, OrientationHelper.VERTICAL, false);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }
}
