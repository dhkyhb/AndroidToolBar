package com.example.administrator.androidtoolbar.module;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.administrator.androidtoolbar.adapter.chatAdapter;
import com.example.administrator.androidtoolbar.bean.UserItemMsg;

import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class chatRecyclerItemCallback extends ItemTouchHelper.Callback {

    private List<UserItemMsg> userItemMsgList;
    private chatAdapter mAdapter;

    public chatRecyclerItemCallback(List<UserItemMsg> userItemMsgList, chatAdapter mAdapter) {
        this.userItemMsgList = userItemMsgList;
        this.mAdapter = mAdapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipFlags = ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlags, swipFlags);
    }


    /**
     * @param recyclerView
     * @param viewHolder    拖动的viewholder
     * @param target    目标位置的Viewholder
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int fromPosition = viewHolder.getAdapterPosition();//得到拖动Viewholder的position
        int toPosition = target.getAdapterPosition();//得到目标ViewHolder的position
//        if (fromPosition < toPosition){
//            //分别将中间所有的item位置重新交换
//            for (int i = fromPosition; i < toPosition; i ++){
//                Collections.swap(userItemMsgList, i, i + 1);
//            }
//        } else{
//            for (int i  = fromPosition; i > toPosition; i --){
//                Collections.swap(userItemMsgList, i, i - 1);
//            }
//        }
        Collections.swap(userItemMsgList, fromPosition, toPosition);
        mAdapter.notifyItemMoved(fromPosition, toPosition);
        //返回true表示拖动
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        userItemMsgList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE){
            //滑动时改变item透明度
            float alpha = 1 - Math.abs(dX) / (float)viewHolder.itemView.getWidth();
            viewHolder.itemView.setAlpha(alpha);
            viewHolder.itemView.setTranslationX(dX);
        }
    }
}
