package com.utilslibrary.doubleclick;

/**
 * Author: 马龙
 * E-mail: 178917169@qq.com
 * CreatedTime: 2018/2/11 15:56
 * <p>
 * NoDoubleClickUtils
 */
public class NoDoubleClickUtils {
    private static int SPACE_TIME = 1000;
    private static long lastClickTime;

    private NoDoubleClickUtils() {
        throw new UnsupportedOperationException(
                "NoDoubleClickUtils 工具类不能实例化");
    }

    public static void initLastClickTime(int spaceTime) {
        SPACE_TIME = spaceTime;
        lastClickTime = 0;
    }

    public synchronized static boolean isDoubleClick() {
        long currentTime = System.currentTimeMillis();
        boolean isClick2;
        if (currentTime - lastClickTime > SPACE_TIME) {
            isClick2 = false;
        } else {
            isClick2 = true;
        }
        lastClickTime = currentTime;
        return isClick2;
    }
}
