package com.example.thinkpad.apps.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HeadAdapter extends MyAdapter {
    private int[] imgs_head;

    public HeadAdapter(Activity activity, Object data) {
        super(activity, data);
        imgs_head= (int[]) data;

    }

    @Override
    public int getCount() {
        return imgs_head.length;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        //手动创建一个ImageView对象
        ImageView imgv=new ImageView(activity);
        //创建一个布局参数对象
        ViewGroup.LayoutParams layoutParams=new ViewGroup.LayoutParams(250,250);
        //给imgv设置布局参数
        imgv.setLayoutParams(layoutParams);
        //设置imgv显示哪一张图片
        imgv.setImageResource(imgs_head[position]);
        //设置imgv里面图片到imgv的间距的间距
        imgv.setPadding(8,8,8,8);

        return imgv;
    }
}
