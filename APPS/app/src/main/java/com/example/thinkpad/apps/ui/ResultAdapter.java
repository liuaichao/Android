package com.example.thinkpad.apps.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thinkpad.apps.R;
import com.example.thinkpad.apps.dao.IUserDao;
import com.example.thinkpad.apps.dao.entity.User;
import com.example.thinkpad.apps.dao.impl.UserDaoDBImpl;

import java.util.List;

public class ResultAdapter extends MyAdapter implements View.OnClickListener {
    private List<User> users;
    private LayoutInflater inflater;
    private IUserDao userDao;
    public boolean isShow=false;

    public ResultAdapter(Activity activity, Object data) {
        super(activity, data);
        users=(List<User>) data;
        inflater=activity.getLayoutInflater();
        userDao= UserDaoDBImpl.getDao(activity);
    }

    @Override
    public int getCount() {
        return users.size();
    }
    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        ViewHolder vh=null;
        if (converView==null){
            converView=inflater.inflate(R.layout.list_item,parent,false);
            vh=new ViewHolder();
            vh.tv_name=converView.findViewById(R.id.tv_resname);
            vh.tv_sex=converView.findViewById(R.id.tv_ressex);
            vh.tv_tel=converView.findViewById(R.id.tv_restel);
            vh.imgv_head=converView.findViewById(R.id.imgv_reshead);
            vh.cb_del=converView.findViewById(R.id.cb_resdel);
            vh.bt_del=converView.findViewById(R.id.bt_itemdel);

            converView.setTag(vh);
        }else {
            vh=(ViewHolder) converView.getTag();
        }
        User u=users.get(position);
        vh.tv_name.setText(u.getName());
        vh.tv_sex.setText(u.getsex());
        vh.tv_tel.setText(u.gettel());
        vh.imgv_head.setImageResource(u.getHeadImg());
        vh.cb_del.setChecked(u.isChecked());
        //每一个条目上面的checkbox对象 自己存储自己的position
        vh.cb_del.setTag(position);
        vh.bt_del.setTag(position);
        //给每个条目上面的CheckBox加监听，点击储存当前CheckBox的选中状态到对应条目的User对象里面去
        vh.cb_del.setOnClickListener(this);
        vh.bt_del.setOnClickListener(this);
        if (isShow){
            vh.bt_del.setVisibility(View.VISIBLE);
        }else{
            vh.bt_del.setVisibility(View.GONE);
        }

        return converView;
    }

    @Override
    public void onClick(View v) {
       int position=(int)v.getTag();
       switch (v.getId()){
           case R.id.cb_resdel:
               CheckBox cb=(CheckBox) v;
               User u=users.get(position);
               u.setChecked(cb.isChecked());
               break;
           case R.id.bt_itemdel:
               //删除数据库的当前条目对应的数据
               userDao.delUser(users.get(position).getName());
               users.remove(position);
               break;
       }
       //更改数据 刷新适配器 重新拉取数据
       this.notifyDataSetChanged();

    }

    class ViewHolder{
        TextView tv_name;
        TextView tv_sex;
        TextView tv_tel;
        ImageView imgv_head;
        CheckBox cb_del;
        Button bt_del;
    }
}
