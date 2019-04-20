package com.example.thinkpad.gaodemaps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapView mapView=(MapView)findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        AMap aMap=mapView.getMap();
        aMap.setMapType(AMap.MAP_TYPE_NORMAL);
    }
}
