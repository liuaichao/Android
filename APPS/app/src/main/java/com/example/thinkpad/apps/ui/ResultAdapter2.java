package com.example.thinkpad.apps.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.thinkpad.apps.IUserDao2;
import com.example.thinkpad.apps.R;
import com.example.thinkpad.apps.dao.IUserDao;
import com.example.thinkpad.apps.dao.IUserDao3;
import com.example.thinkpad.apps.dao.entity.User;
import com.example.thinkpad.apps.dao.entity.User2;
import com.example.thinkpad.apps.dao.impl.UserDaoDBImpl;
import com.example.thinkpad.apps.dao.impl.UserDaoDBImpl2;
import com.example.thinkpad.apps.dao.impl.UserDaoDBImpl3;
import com.example.thinkpad.apps.dao.utils.MyOpenHelperCheck;
import com.example.thinkpad.apps.dao.utils.MyOpenHelperPao;

import java.util.List;

public class ResultAdapter2 extends MyAdapter2 implements View.OnClickListener {
    private List<User2> users;
    private LayoutInflater inflater;
    private IUserDao2 userDao;
    private ViewHolder vh;
    private static MyOpenHelperPao myOpenHelperPao;
    private IUserDao3 userDao3;
    public static int color=Color.YELLOW;
    private boolean istrue;
    private MyOpenHelperCheck myOpenHelperCheck;
    private String statenow="已接单";
    public ResultAdapter2(Activity activity, Object data) {
        super(activity, data);
        users=(List<User2>) data;
        inflater=activity.getLayoutInflater();
        userDao=UserDaoDBImpl2.getDao(activity,WelcomeActivity.Noname,null,1);
        userDao3=UserDaoDBImpl3.getDao(activity);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        myOpenHelperCheck=new MyOpenHelperCheck(activity,WelcomeActivity.Noname,null,1);
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.list_item1,parent,false);
            vh=new ViewHolder();
            vh.start=(TextView)convertView.findViewById(R.id.tv_resstart);
            vh.fina=(TextView)convertView.findViewById(R.id.tv_resfinal);
            vh.remark=(TextView)convertView.findViewById(R.id.tv_resbeizhu);
            vh.time=(TextView)convertView.findViewById(R.id.tv_restime);
            vh.state=(TextView)convertView.findViewById(R.id.tv_reszhuangtai);
            vh.del=(Button) convertView.findViewById(R.id.tv_quxiaodingdan);
            vh.map=(Button) convertView.findViewById(R.id.tv_ditu);
            vh.finash=(Button) convertView.findViewById(R.id.tv_queren);
            convertView.setTag(vh);

        }else {
            vh=(ViewHolder) convertView.getTag();
        }

        User2 u=users.get(position);
        vh.start.setText(u.getStart());
        vh.fina.setText(u.getFina());
        vh.remark.setText(u.getRemark());
        vh.time.setText(u.getTime());
        //判断是否已接单
        myOpenHelperPao=new MyOpenHelperPao(activity);
        istrue=userDao3.findUserByName(users.get(position).getTime());


        if (!istrue){
             statenow="已接单";
             vh.state.setText(statenow);

            SQLiteDatabase db=myOpenHelperCheck.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put("state",statenow);
            db.update("user",contentValues,"time=?",new String[]{ResultAdapter3.timers});
            db.close();
        }
        vh.state.setText(u.getState());

        vh.map.setTag(position);
        vh.finash.setTag(position);
        vh.del.setTag(position);

        vh.del.setOnClickListener(this);
        vh.map.setOnClickListener(this);
        vh.finash.setOnClickListener(this);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        int position=(int)v.getTag();
        switch (v.getId()) {
            case R.id.tv_quxiaodingdan:
                //删除数据库的当前条目对应的数据
                userDao.delUser(users.get(position).getNamer());
                users.remove(position);
                break;
            case R.id.tv_ditu:
                break;
            case R.id.tv_queren:
                statenow="已完成";
                users.get(position).setState("已完成");
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
        Button del;
        Button map;
        Button finash;
        ImageButton tel;
    }
}
