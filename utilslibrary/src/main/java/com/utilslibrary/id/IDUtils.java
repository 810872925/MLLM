package com.utilslibrary.id;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Author: 马龙
 * E-mail: 178917169@qq.com
 * CreatedTime: 2018/2/11 16:42
 * <p>
 * id 生成工具类
 */
public class IDUtils {

    private static long id = 0;
    private static boolean isIDlocked = false;

    /**
     * 生成Long型ID
     *
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static long generateLongID() {
        long tempId = 0;
        while (true) {
            if (!isIDlocked) {
                isIDlocked = true;
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddhhmmssSSS");
                String date = dateFormat.format(new Date());
                tempId = Long.valueOf(date) * 10000;
                if (id < tempId) {
                    id = tempId;
                } else {
                    id = id + 1;
                    tempId = id;
                }
                isIDlocked = false;
                return tempId;
            }
        }
    }

    /**
     * 生成UUID
     *
     * @return
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

}
