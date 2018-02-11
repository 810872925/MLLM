package com.utilslibrary.network;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Author: 马龙
 * E-mail: 178917169@qq.com
 * CreatedTime: 2018/2/11 16:33
 * <p>
 * 网络检测工具类
 */
public class NetworkUtils {

    public NetworkUtils() {
        throw new UnsupportedOperationException("NetworkUtil cannot be instantiated");
    }

    /**
     * 判断网络是否连接
     */
    public static boolean isConnected(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null != connectivity) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (null != info && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是否是wifi连接
     */
    public static boolean isWifi(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null)
            return false;
        return connectivity.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;

    }

    /**
     * 判断当前是否网络连接
     *
     * @param context
     * @return 状态码
     */
    public static Network isConnectedState(Context context) {
        Network network = Network.NET_NO;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni != null && ni.isConnectedOrConnecting()) {
            switch (ni.getType()) {
                case ConnectivityManager.TYPE_WIFI:
                    network = Network.NET_WIFI;
                    break;
                case ConnectivityManager.TYPE_MOBILE:
                    switch (ni.getSubtype()) {
                        case TelephonyManager.NETWORK_TYPE_GPRS: //联通2g
                            break;
                        case TelephonyManager.NETWORK_TYPE_CDMA: //电信2g
                            break;
                        case TelephonyManager.NETWORK_TYPE_EDGE: //移动2g
                            break;
                        case TelephonyManager.NETWORK_TYPE_1xRTT:
                            break;
                        case TelephonyManager.NETWORK_TYPE_IDEN:
                            network = Network.NET_2G;
                            break;
                        case TelephonyManager.NETWORK_TYPE_EVDO_A: //电信3g
                            break;
                        case TelephonyManager.NETWORK_TYPE_UMTS:
                            break;
                        case TelephonyManager.NETWORK_TYPE_EVDO_0:
                            break;
                        case TelephonyManager.NETWORK_TYPE_HSDPA:
                            break;
                        case TelephonyManager.NETWORK_TYPE_HSUPA:
                            break;
                        case TelephonyManager.NETWORK_TYPE_HSPA:
                            break;
                        case TelephonyManager.NETWORK_TYPE_EVDO_B:
                            break;
                        case TelephonyManager.NETWORK_TYPE_EHRPD:
                            break;
                        case TelephonyManager.NETWORK_TYPE_HSPAP:
                            network = Network.NET_3G;
                            break;
                        case TelephonyManager.NETWORK_TYPE_LTE:
                            network = Network.NET_4G;
                            break;
                        default:
                            network = Network.NET_UNKNOWN;
                            break;
                    }
                    break;
                case TelephonyManager.DATA_CONNECTED:

                    break;


                default:
                    break;
            }

        }
        return network;
    }

    /**
     * 打开网络设置界面
     */
    public static void openSetting(Context context) {

        Intent intent = null;
        if (android.os.Build.VERSION.SDK_INT > 10) {
            intent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);

        } else {
            intent = new Intent();
            ComponentName component = new ComponentName("com.android.settings",
                    "com.android.settings.WirelessSettings");
            intent.setComponent(component);
            intent.setAction("android.intent.action.VIEW");
        }
        ((Activity) context).startActivity(intent);
    }

    /**
     * 使用SSL不信任的证书
     */
    public static void useUntrustedCertificate() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
            }
        }};
        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 枚举所有网络状态
     * <p>
     * NET_NO：无网络
     * NET_UNENOWN：未知网络
     * NET_2G：2G网络
     * NET_3G：3G网络
     * NET_4G：4G网络
     */

    public enum Network {
        NET_NO(-1), NET_UNKNOWN(0), NET_WIFI(1), NET_2G(2), NET_3G(3), NET_4G(4);
        public int code;

        Network(int code) {
            this.code = code;
        }
    }

}
