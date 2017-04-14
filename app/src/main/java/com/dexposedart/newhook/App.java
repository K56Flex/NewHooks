package com.dexposedart.newhook;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.dexposedart.newhook.TestHook.TestHookMeanager;

/**
 * 作者：zhangzhongping on 17/4/11 01:19
 * 邮箱：android_dy@163.com
 */
public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        CrashHandler.getInstance().init(context);
        Log.e("123", TestHookMeanager.getTestHookMeanager().StartFrameHook(this) + "");
        boolean[] booleen = TestHookMeanager.getTestHookMeanager().StartFrameHook1(this);
        Log.e("123", booleen[0] + "--" + booleen[1]);
    }

    public static Context getContext() {
        return context;
    }
}
