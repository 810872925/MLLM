package com.utilslibrary.location;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

/**
 * Author: 马龙
 * E-mail: 178917169@qq.com
 * CreatedTime: 2018/2/11 16:24
 * <p>
 * 位置服务工具类
 */
public class LocationUtils {

    private LocationUtils() {
        throw new UnsupportedOperationException("LocationUtils 工具类不能被实例化");
    }

    /**
     * 是否打开系统定位服务
     *
     * @return
     */
    public static boolean isLocationEnabled(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try {
                return Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE) != Settings.Secure.LOCATION_MODE_OFF;
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return !TextUtils.isEmpty(Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED));
        }
    }

    /**
     * 是否开启GPS定位
     *
     * @param context
     * @return
     */
    public static boolean isGpsProvider(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    /**
     * 是否开启网络定位
     *
     * @param context
     * @return
     */
    public static boolean isNetworkProvider(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

}
