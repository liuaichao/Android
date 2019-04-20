package com.example.thinkpad.shoujitxl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class xiangji extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xiangji);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
                Log.v("TestFile",
                        "SD card is not avaiable/writeable right now.");
                return;
            }
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式
            FileOutputStream b = null;
            File file = new File("/sdcard/myImage/");
            file.mkdirs();// 创建文件夹
            String fileName = "/sdcard/myImage/111.jpg";
            try {
                b = new FileOutputStream(fileName);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    b.flush();
                    b.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ((ImageView) findViewById(R.id.imageView)).setImageBitmap(bitmap);// 将图片显示在ImageView里
        }
    }

}
