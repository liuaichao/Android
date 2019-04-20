package com.example.thinkpad.apps.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class MyAdapter2 extends BaseAdapter {
    public Activity activity;
    public Object data;


    public MyAdapter2(Activity activity,Object data){
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

}
