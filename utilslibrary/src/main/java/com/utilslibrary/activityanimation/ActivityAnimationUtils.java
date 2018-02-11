package com.utilslibrary.activityanimation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.utilslibrary.R;
import com.utilslibrary.doubleclick.NoDoubleClickUtils;

/**
 * Author: 马龙
 * E-mail: 178917169@qq.com
 * CreatedTime: 2018/2/11 15:52
 * <p>
 * 界面跳转动画工具类
 */
public class ActivityAnimationUtils {

    private ActivityAnimationUtils() {
        throw new UnsupportedOperationException(
                "ActivityAnimationUtil 工具类不能实例化");
    }

    public static void startActivity(Context context, Intent intent) {
        if (NoDoubleClickUtils.isDoubleClick()) {
            return;
        }
        ((Activity) context).startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.activity_start_in, R.anim.activity_start_out);
    }

    public static void startActivityForFinish(Context context, Intent intent) {
        if (NoDoubleClickUtils.isDoubleClick()) {
            return;
        }
        ((Activity) context).startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.activity_start_in, R.anim.activity_start_out);
        ((Activity) context).finish();
    }

    public static void startActivityForResult(Context context, Intent intent, int requestCode) {
        if (NoDoubleClickUtils.isDoubleClick()) {
            return;
        }
        ((Activity) context).startActivityForResult(intent, requestCode);
        ((Activity) context).overridePendingTransition(R.anim.activity_start_in, R.anim.activity_start_out);
    }

    public static void finishActivity(Context context) {
        if (NoDoubleClickUtils.isDoubleClick()) {
            return;
        }
        ((Activity) context).finish();
        ((Activity) context).overridePendingTransition(R.anim.activity_finish_in, R.anim.activity_finish_out);
    }

    public static void finishActivityForResult(Context context, Intent intent, int resultCode) {
        if (NoDoubleClickUtils.isDoubleClick()) {
            return;
        }
        ((Activity) context).setResult(resultCode, intent);
        ((Activity) context).finish();
        ((Activity) context).overridePendingTransition(R.anim.activity_finish_in, R.anim.activity_finish_out);
    }

}
