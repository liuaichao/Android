package com.example.thinkpad.apps.dao.utils;

public class CheckString {
    public static boolean check(String str){
        String pattern="\\w{6,15}";
        return str.matches(pattern);
    }
}
