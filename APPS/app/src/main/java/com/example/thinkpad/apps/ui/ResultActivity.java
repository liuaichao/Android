package com.example.thinkpad.apps.ui;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.thinkpad.apps.R;
import com.example.thinkpad.apps.dao.IUserDao;
import com.example.thinkpad.apps.dao.impl.UserDaoDBImpl;

public class ResultActivity extends Activity {
    private ListView mListRes;
    private ResultAdapter mAdapter;
    private IUserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        userDao= UserDaoDBImpl.getDao(this);
        mListRes=(ListView) findViewById(R.id.list_res);
        mAdapter=new ResultAdapter(this,userDao.showAll());
        mListRes.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        this.getMenuInflater().inflate(R.menu.menu_manager,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if ("管理".equals(item.getTitle())){
            item.setTitle("取消");
            mAdapter.isShow=true;
        }else {
            item.setTitle("管理");
            mAdapter.isShow=false;
        }
        mAdapter.notifyDataSetChanged();
        return super.onOptionsItemSelected(item);
    }
}
