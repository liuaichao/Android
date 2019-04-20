package com.example.thinkpad.apps.map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SearchEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.LogoPosition;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.MassTransitRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.example.thinkpad.apps.R;
import com.example.thinkpad.apps.ui.jinru;

import java.util.List;

public class Ditu extends Activity implements View.OnClickListener {
    private MapView mMapView = null;
    private BaiduMap mBaiduMap;
    private TextView check;
    private Button cancel;
    private PoiSearch mPoiSearch;
    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();
    public static String weizhi;
    private LocationClientOption option;
    private RoutePlanSearch mSearch;
    public PlanNode stNode;
    public PlanNode enNode;
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.ditu);//获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        //创建骑行线路规划检索实例
        mSearch = RoutePlanSearch.newInstance();
        //设置百度地图logo的位置
        mMapView.setLogoPosition(LogoPosition.logoPostionRightTop);
        //按钮的实例化和监听
        check=findViewById(R.id.map_check);
        cancel=findViewById(R.id.map_cancel);
        check.setOnClickListener(this);
        cancel.setOnClickListener(this);
        //骑行路线的监听
        OnGetRoutePlanResultListener listener = new OnGetRoutePlanResultListener() {
            @Override
            public void onGetWalkingRouteResult(WalkingRouteResult walkingRouteResult) {

            }

            @Override
            public void onGetTransitRouteResult(TransitRouteResult transitRouteResult) {

            }

            @Override
            public void onGetMassTransitRouteResult(MassTransitRouteResult massTransitRouteResult) {

            }

            @Override
            public void onGetDrivingRouteResult(DrivingRouteResult drivingRouteResult) {

            }

            @Override
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {

            }

            public void onGetBikingRouteResult(BikingRouteResult result) {
                //获取驾车线路规划结果
            }
        };
        mSearch.setOnGetRoutePlanResultListener(listener);
        stNode = PlanNode.withCityNameAndPlaceName("北京", "西二旗地铁站");
        enNode = PlanNode.withCityNameAndPlaceName("北京", "百度科技园");
        //定位注册并监听
        mLocationClient=new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(myListener);

        initLocation();
        //开始定位
        mLocationClient.start();
    }



    private void initLocation(){
        LocationClientOption option=new LocationClientOption();
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，设置定位模式，默认高精度//LocationMode.Hight_Accuracy：高精度；//LocationMode. Battery_Saving：低功耗；//LocationMode. Device_Sensors：仅使用设备；
        option.setCoorType("bd09ll");//可选，设置返回经纬度坐标类型，默认gcj02//gcj02：国测局坐标；//bd09ll：百度经纬度坐标；
        option.setScanSpan(0);//可选，设置发起定位请求的间隔，int类型，单位ms//如果设置为0，则代表单次定位，即仅定位一次，默认为0
        option.setOpenGps(true);//可选，设置是否使用gps，默认false//使用高精度和仅用设备两种定位模式的，参数必须设置为true
        option.setLocationNotify(false);//可选，设置是否当GPS有效时按照1S/1次频率输出GPS结果，默认false
        option.setIgnoreKillProcess(true);//可选，定位SDK内部是一个service，并放到了独立进程。//设置是否在stop的时候杀死这个进程，默认（建议）不杀死，即setIgnoreKillProcess(true)
        option.SetIgnoreCacheException(false);//可选，设置是否收集Crash信息，默认收集，即参数为false
        option.setWifiCacheTimeOut(5*60*1000);//可选，7.2版本新增能力//如果设置了该接口，首次启动定位时，会先判断当前WiFi是否超出有效期，若超出有效期，会先重新扫描WiFi，然后定位
        option.setEnableSimulateGps(false);//可选，设置是否需要过滤GPS仿真结果，默认需要，即参数为false
        mLocationClient.setLocOption(option);
    }
    //Mark
    public void logoshow(double latitude,double longitude){
        //定义Mark坐标
        LatLng point=new LatLng(latitude,longitude);
        //构建mark图标
        BitmapDescriptor bitmap=BitmapDescriptorFactory.fromResource(R.drawable.icon_openmap_mark);
        //构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option=new MarkerOptions().position(point).icon(bitmap);
        //在地图上添加marker，并显示
        mBaiduMap.addOverlay(option);
    }
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
        mPoiSearch.destroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理

        mMapView.onPause();
    }


   //移动地图视角
    private void changeCamera(LatLng latLng) {
        MapStatusUpdate mapStatusUpdate1= MapStatusUpdateFactory.zoomTo(17.0f);
        mBaiduMap.setMapStatus(mapStatusUpdate1);
        //地图移动到当前位置
        MyLocationData.Builder builder=new MyLocationData.Builder();
        builder.accuracy(100).latitude(latLng.latitude).longitude(latLng.longitude);
        mBaiduMap.setMyLocationData(builder.build());

        MapStatusUpdate mapStatusUpdate=MapStatusUpdateFactory.newLatLng(latLng);
        mBaiduMap.animateMapStatus(mapStatusUpdate);

    }

    private void doSearch() {
    }
    //返回键的监听
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.map_check://
                mSearch.bikingSearch((new BikingRoutePlanOption())
                        .from(stNode)
                        .to(enNode));
                break;
            case R.id.map_cancel:
                Intent intent=new Intent(this,jinru.class);
                startActivity(intent);
                this.overridePendingTransition(R.anim.main_in3,R.anim.main_out3);
                mLocationClient.stop();
                break;
        }

    }

    public class MyLocationListener extends BDAbstractLocationListener {

        @Override
             public void onReceiveLocation(BDLocation location) {
                  if (location.getLocType() == 161) {
                    Toast.makeText(Ditu.this, "成功获取您当前的位置" + location.getLocationDescribe(), Toast.LENGTH_SHORT).show();
                    LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                    double latitude=location.getLatitude();
                    double longitude=location.getLongitude();
                    String city = location.getDistrict();
                    check.setText(city);
                    weizhi=location.getDistrict();
                    logoshow(latitude,longitude);
                    changeCamera(latLng);//地图缩放
                    Bundle bundle = new Bundle();
                    bundle.putString("addr", location.getLocationDescribe());
                     } else{
                      Toast.makeText(Ditu.this, "定位失败" + location.getLocationDescribe(), Toast.LENGTH_SHORT).show();
                      weizhi="定位失败";
                  }
        }
    }

}
