package com.dr_recyclerviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dr_recyclerviewdemo.R;
import com.dr_recyclerviewdemo.model.AuthorInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/1/16.
 */

public class MyAdapter extends BaseAdapter{

    Context context ;


    ArrayList<AuthorInfo> array;


    public MyAdapter(Context context,ArrayList<AuthorInfo> array){

        this.context = context;
        this.array = array;
    }



    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if(convertView == null){

            convertView = LayoutInflater.from(context).inflate(R.layout.item_normal_recycler_view,null);

            holder = new ViewHolder();
            holder.tv_1 = (TextView) convertView.findViewById(R.id.tv_item_1);
            holder.tv_2 = (TextView) convertView.findViewById(R.id.tv_item_2);


            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_1.setText(array.get(position).getName());
        holder.tv_2.setText(array.get(position).getMotto());


        return null;
    }

    public class ViewHolder{

        TextView tv_1,tv_2;


    }
}
