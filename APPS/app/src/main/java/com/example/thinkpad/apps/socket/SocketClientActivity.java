package com.example.thinkpad.apps.socket;

import android.os.Bundle;
import android.os.StrictMode;
import java.net.Socket;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.thinkpad.apps.R;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;

public class SocketClientActivity {
   public static void main(String[] args) throws UnknownHostException,IOException{
       Socket socket=new Socket("118.89.246.47",10086);
       System.out.print("客户端去连接");
   }
}
