package com.dexposedart.newhook.TestHook;

import android.view.View;
import android.widget.Toast;

import com.dexposedart.newhook.App;
import com.taobao.android.dexposed.XC_MethodReplacement;
import com.taobao.android.dexposed.annotations.Hook;
import com.taobao.android.dexposed.annotations.HookMethod;
import com.taobao.android.dexposed.annotations.OriginalHookMethod;


/**
 * 作者：zhangzhongping on 17/4/3 23:29
 * 邮箱：android_dy@163.com
 * extends XC_MethodReplacement 是用来兼容dalvik虚拟机hook 实现方法是直接替换原方法的
 * extends XC_MethodHook 也是用来兼容dalvik虚拟机hook  两个实现方法是 一个是被hook方法执行前执行  一个是被hook方法执行后执行
 *
 * 如果art虚拟机不想直接替换原方法需要在@HookMethod注解方法里面调用@OriginalHookMethod注解方法
 *
 * 如果art虚拟机想直接替换原方法 @HookMethod注解方法里面不能调用@OriginalHookMethod注解方法
 *
 */
@Hook(Class = "com.dexposedart.newhook.MainActivity", Name = "Toasts",
        Type = {Boolean[].class, String.class, View[].class})
public class TestProxy1 extends XC_MethodReplacement {

    @HookMethod()
    public static Object HookMethods(Boolean[] booleen, String msg, View[] view) {
        Toast.makeText(App.getContext(), msg + "->Hook", 0).show();
        return OriginalHookMethods(booleen, msg, view) + "Hook";
    }

    @OriginalHookMethod()
    public static Object OriginalHookMethods(Boolean[] booleen, String msg, View[] view) {
        return new Object();
    }


    @Override
    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
        return HookMethods((Boolean[]) param.args[0], (String) param.args[1], (View[]) param.args[2]);
    }

}
