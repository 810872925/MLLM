package com.utilslibrary.font;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Author: 马龙
 * E-mail: 178917169@qq.com
 * CreatedTime: 2018/2/11 16:58
 * <p>
 * 字体工具类
 */
public class FontUtils {

    private FontUtils() {
        throw new UnsupportedOperationException("TypeFaceUtil cannot be instantiated");
    }

    public static Typeface getRobotoBlack(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Black.ttf");
        return typeface;
    }

    public static Typeface getRobotoBlackItalic(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-BlackItalic.ttf");
        return typeface;
    }

    public static Typeface getRobotoBold(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Bold.ttf");
        return typeface;
    }

    public static Typeface getRobotoBoldItalic(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-BoldItalic.ttf");
        return typeface;
    }

    public static Typeface getRobotoItalic(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Italic");
        return typeface;
    }

    public static Typeface getRobotoLight(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");
        return typeface;
    }

    public static Typeface getRobotoLightItalic(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-LightItalic.ttf");
        return typeface;
    }

    public static Typeface getRobotoMedium(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf");
        return typeface;
    }

    public static Typeface getRobotoMediumItalic(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-MediumItalic.ttf");
        return typeface;
    }

    public static Typeface getRobotoRegular(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
        return typeface;
    }

    public static Typeface getRobotoThin(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Thin.ttf");
        return typeface;
    }

    public static Typeface getRobotoThinItalic(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-ThinItalic.ttf");
        return typeface;
    }

    public static Typeface getRobotoCondensedBold(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-Bold.ttf");
        return typeface;
    }

    public static Typeface getRobotoCondensedBoldItalic(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-BoldItalic.ttf");
        return typeface;
    }

    public static Typeface getRobotoCondensedItalic(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-Italic.ttf");
        return typeface;
    }

    public static Typeface getRobotoCondensedLight(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-Light.ttf");
        return typeface;
    }

    public static Typeface getRobotoCondensedLightItalic(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-LightItalic.ttf");
        return typeface;
    }

    public static Typeface getRobotoCondensedRegular(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-Regular.ttf");
        return typeface;
    }

    public static Typeface getRobotoWeatherNumber(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/WeatherNumber.otf");
        return typeface;
    }

}
