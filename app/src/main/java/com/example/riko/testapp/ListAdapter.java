package com.example.riko.testapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Riko on 2016-05-23.
 */
public class ListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Person> mPersonList;

    public ListAdapter(Context mContext,List<Person> mPersonList ) {
        this.mPersonList = mPersonList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mPersonList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPersonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext,R.layout.customviewforlist,null);

        TextView name= (TextView) v.findViewById(R.id.textView4);
        TextView num = (TextView) v.findViewById(R.id.textView3);

        name.setText(mPersonList.get(position).name);
        num.setText(Integer.toString(mPersonList.get(position).id));

        v.setTag(mPersonList.get(position).realID);
        return v;
    }
}
