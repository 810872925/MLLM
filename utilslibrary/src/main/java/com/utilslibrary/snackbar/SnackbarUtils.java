package com.utilslibrary.snackbar;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Author: 马龙
 * E-mail: 178917169@qq.com
 * CreatedTime: 2018/2/11 17:03
 * <p>
 * Snackbar
 */
public class SnackbarUtils {

    private static Snackbar snackbar;

    private SnackbarUtils() {
        throw new UnsupportedOperationException("SnackbarUtils 工具类不能被实例化");
    }

    /**
     * 短时间显示Snackbar
     */
    public static void showShort(View view, CharSequence message) {
        if (null == snackbar) {
            snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        } else {
            snackbar.setText(message);
        }
        snackbar.show();
    }

    /**
     * 短时间显示Snackbar
     */
    public static void showShort(View view, int message) {
        if (null == snackbar) {
            snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        } else {
            snackbar.setText(message);
        }
        snackbar.show();
    }

    /**
     * 长时间显示Snackbar
     */
    public static void showLong(View view, CharSequence message) {
        if (null == snackbar) {
            snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        } else {
            snackbar.setText(message);
        }
        snackbar.show();
    }

    /**
     * 长时间显示Snackbar
     */
    public static void showLong(View view, int message) {
        if (null == snackbar) {
            snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        } else {
            snackbar.setText(message);
        }
        snackbar.show();
    }

    /**
     * 自定义显示Snackbar时间
     */
    public static void show(View view, CharSequence message, int duration) {
        if (null == snackbar) {
            snackbar = Snackbar.make(view, message, duration);
        } else {
            snackbar.setText(message);
        }
        snackbar.show();
    }

    /**
     * 自定义显示Snackbar时间
     */
    public static void show(View view, int message, int duration) {
        if (null == snackbar) {
            snackbar = Snackbar.make(view, message, duration);
        } else {
            snackbar.setText(message);
        }
        snackbar.show();
    }

    /**
     * 关闭Snackbar
     */
    public static void hideToast() {
        if (null != snackbar) {
            snackbar.dismiss();
        }
    }

}
