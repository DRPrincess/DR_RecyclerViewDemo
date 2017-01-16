package com.dr_recyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dr_recyclerviewdemo.R;
import com.dr_recyclerviewdemo.model.AuthorInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/1/16.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    Context context;
    ArrayList<AuthorInfo> array;

    OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener)
    {
        this.mOnItemClickListener  = mOnItemClickListener;
    }

    public  RecyclerViewAdapter(Context context,ArrayList<AuthorInfo> array)
    {
        this.context = context;
        this.array = array;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_normal_recycler_view,parent,false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.tv_1.setText(array.get(position).getName());
        holder.tv_2.setText(array.get(position).getMotto());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(holder.itemView,position);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mOnItemClickListener.onItemLongClick(holder.itemView,position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_1 ,tv_2;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_1 = (TextView) itemView.findViewById(R.id.tv_item_1);
            tv_2 = (TextView) itemView.findViewById(R.id.tv_item_2);
        }
    }


    public interface  OnItemClickListener{
        void onItemClick(View itemView,int position);
        void onItemLongClick(View itemView,int position);
    }




}


