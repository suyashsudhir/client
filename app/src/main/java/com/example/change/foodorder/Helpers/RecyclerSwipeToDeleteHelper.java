package com.example.change.foodorder.Helpers;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.change.foodorder.Interface.RecyclerSwipeToDeleteListener;
import com.example.change.foodorder.ViewHolder.CartViewHolder;
import com.example.change.foodorder.ViewHolder.FavoritesViewHolder;

public class RecyclerSwipeToDeleteHelper extends ItemTouchHelper.SimpleCallback {
    private RecyclerSwipeToDeleteListener listener;

    public RecyclerSwipeToDeleteHelper(int dragDirs, int swipeDirs, RecyclerSwipeToDeleteListener listener) {
        super(dragDirs, swipeDirs);
        this.listener = listener;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        if (listener != null)
            listener.onSwipe(viewHolder,direction,viewHolder.getAdapterPosition());

    }

    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        return super.convertToAbsoluteDirection(flags, layoutDirection);

    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof CartViewHolder) {

            View foregroundView = ((CartViewHolder) viewHolder).foregroundView;
            getDefaultUIUtil().clearView(foregroundView);
        }

        else if (viewHolder instanceof FavoritesViewHolder){
            View foregroundView = ((FavoritesViewHolder) viewHolder).foregroundViewFav;
            getDefaultUIUtil().clearView(foregroundView);

        }




    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        if (viewHolder instanceof CartViewHolder) {
            View foregroundView = ((CartViewHolder) viewHolder).foregroundView;
            getDefaultUIUtil().onDraw(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);
        }
        else if (viewHolder instanceof FavoritesViewHolder){
            View foregroundView = ((FavoritesViewHolder) viewHolder).foregroundViewFav;
            getDefaultUIUtil().onDraw(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);

        }
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (viewHolder != null){
            if (viewHolder instanceof CartViewHolder) {
                View foregroundView = ((CartViewHolder) viewHolder).foregroundView;
                getDefaultUIUtil().onSelected(foregroundView);
            }
            else if (viewHolder instanceof FavoritesViewHolder){
                View foregroundView = ((FavoritesViewHolder) viewHolder).foregroundViewFav;
                getDefaultUIUtil().onSelected(foregroundView);

            }


        }
    }


    @Override
    public void onChildDrawOver(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
       if (viewHolder instanceof CartViewHolder) {

           View foregroundView = ((CartViewHolder) viewHolder).foregroundView;
           getDefaultUIUtil().onDrawOver(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);
       }
       else if (viewHolder instanceof FavoritesViewHolder){
           View foregroundView = ((FavoritesViewHolder) viewHolder).foregroundViewFav;
           getDefaultUIUtil().onDrawOver(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);

       }
    }
}
