package com.mahii.flavoursdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author i_m_mahii, mahi05
 */
class MyAdapter extends BaseAdapter {

    private ArrayList<MyModel> myModels;
    private LayoutInflater inflater;

    MyAdapter(Context context, ArrayList<MyModel> myModels) {
        this.myModels = myModels;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myModels.size();
    }

    @Override
    public Object getItem(int position) {
        return myModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView itemNoTv, itemGainTv;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            vh = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_row, parent, false);
            vh.itemGainTv = (TextView) convertView.findViewById(R.id.itemGainTv);
            vh.itemNoTv = (TextView) convertView.findViewById(R.id.itemNoTv);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.itemGainTv.setText(myModels.get(position).getGain());
        vh.itemNoTv.setText(myModels.get(position).getItemNo());

        return convertView;
    }

}
