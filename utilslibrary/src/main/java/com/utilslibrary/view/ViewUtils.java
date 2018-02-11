package com.utilslibrary.view;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.utilslibrary.density.DensityUtils;

import java.lang.reflect.Field;

/**
 * Author: 马龙
 * E-mail: 178917169@qq.com
 * CreatedTime: 2018/2/11 16:48
 * <p>
 * ViewUtils
 */
public class ViewUtils {

    private ViewUtils() {
        throw new UnsupportedOperationException("ViewUtil cannot be instantiated");
    }

    /**
     * 设置控件阴影
     *
     * @param view
     * @param elevation
     */
    public static void setElevation(View view, float elevation) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            final int dur = view.getResources().getInteger(android.support.design.R.integer.app_bar_elevation_anim_duration);

            final StateListAnimator sla = new StateListAnimator();

            // Enabled and collapsible, but not collapsed means not elevated
            sla.addState(new int[]{android.R.attr.enabled, android.support.design.R.attr.state_collapsible,
                            -android.support.design.R.attr.state_collapsed},
                    ObjectAnimator.ofFloat(view, "elevation", 0f).setDuration(dur));

            // Default enabled state
            sla.addState(new int[]{android.R.attr.enabled},
                    ObjectAnimator.ofFloat(view, "elevation", elevation).setDuration(dur));

            // Disabled state
            sla.addState(new int[0],
                    ObjectAnimator.ofFloat(view, "elevation", 0).setDuration(0));

            view.setStateListAnimator(sla);
        }
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

}
