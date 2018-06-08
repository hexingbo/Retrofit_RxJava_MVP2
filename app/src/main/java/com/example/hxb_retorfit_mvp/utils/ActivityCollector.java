package com.example.hxb_retorfit_mvp.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *  @作者 ：贺兴波
 *  @时间 ：2018/6/8
 *  @描述 ：ActivityCollector Activity管理类
 */
public class ActivityCollector {


    private static final List<Activity> list = new ArrayList<>();


    public static void addActivity(Activity activity) {
        list.add(activity);
    }

    public static void removeActivity(Activity activity) {
        list.remove(activity);
    }

    public static void removeAllActivity() {

//        list.stream().filter(activity -> !activity.isFinishing()).forEach(Activity::finish);
    }

}
