package com.example.thinkpad.apps.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class MyAdapter3 extends BaseAdapter {
    public Activity activity;
    public Object data;

    public MyAdapter3(Activity activity,Object data){
        this.activity=activity;
        this.data=data;

    }
    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
