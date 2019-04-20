package com.example.thinkpad.apps.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.thinkpad.apps.R;
import com.example.thinkpad.apps.dao.IUserDao3;
import com.example.thinkpad.apps.dao.entity.User3;
import com.example.thinkpad.apps.dao.impl.UserDaoDBImpl3;

import java.util.List;

public class ResultAdapter3 extends MyAdapter3 implements View.OnClickListener {
    private List<User3> users;
    private LayoutInflater inflater;
    private IUserDao3 userDao;
    private ViewHolder vh;
    private String tel;
    public static String timers;
    public ResultAdapter3(Activity activity, Object data) {
        super(activity, data);
        users=(List<User3>)data;
        inflater=activity.getLayoutInflater();
        userDao= UserDaoDBImpl3.getDao(activity);
    }
    public int getCount(){
        return users.size();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh=null;
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.list_item3,parent,false);
            vh=new ViewHolder();
            vh.start=(TextView)convertView.findViewById(R.id.tv_resstart);
            vh.fina=(TextView)convertView.findViewById(R.id.tv_resfinal);
            vh.remark=(TextView)convertView.findViewById(R.id.tv_resbeizhu);
            vh.time=(TextView)convertView.findViewById(R.id.tv_restime);
            vh.state=(TextView)convertView.findViewById(R.id.tv_reszhuangtai);
            vh.tel=(ImageButton) convertView.findViewById(R.id.dianhua);
            vh.queren=convertView.findViewById(R.id.tv_querenjiedan);
            convertView.setTag(vh);
        }else {
            vh=(ViewHolder) convertView.getTag();
        }

        User3 u=users.get(position);
        vh.start.setText(u.getStart());
        vh.fina.setText(u.getFina());
        vh.remark.setText(u.getRemark());
        vh.time.setText(u.getTime());
        vh.state.setText(u.getState());

        vh.queren.setTag(position);
        vh.tel.setTag(position);
        vh.queren.setOnClickListener(this);
        vh.tel.setOnClickListener(this);

        return convertView;
    }

    @Override
    public void onClick(View v) {
        int position=(int)v.getTag();
        switch (v.getId()){

            case R.id.tv_querenjiedan://确认接单
                userDao.delUser(users.get(position).getTime());
                timers=users.get(position).getTime();
                users.remove(position);

                break;

            case R.id.dianhua://电话
                tel=userDao.select(users.get(position).getTime());
                Uri uri=Uri.parse("tel:"+tel);
                Intent intent=new Intent(Intent.ACTION_DIAL,uri);
                activity.startActivity(intent);
                break;
        }

        //更改数据 刷新适配器 重新拉取数据
        this.notifyDataSetChanged();
    }


    class ViewHolder{
        TextView namer;
        TextView start;
        TextView fina;
        TextView remark;
        TextView time;
        TextView state;
        ImageButton tel;
        Button queren;
    }
}
