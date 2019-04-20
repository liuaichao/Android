package com.example.thinkpad.myapplication;
import android.os.Bundle;
import android.os.StrictMode;
import java.net.Socket;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;

public class MainActivity {
    public static void main(String[] args) throws UnknownHostException,IOException{
        Socket socket=new Socket("118.89.246.47",10086);
        System.out.print("客户端去连接");
    }
}