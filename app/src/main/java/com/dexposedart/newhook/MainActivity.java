package com.dexposedart.newhook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.taobao.android.dexposed.DeviceCheck;
import com.taobao.android.dexposed.Hook22_23.utils.HookLog;

public class MainActivity extends AppCompatActivity {
    EditText edit_query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_query = (EditText) findViewById(R.id.edit_query);
        Toast.makeText(App.getContext(), DeviceCheck.LoadCPU(), 0).show();
    }

    public void button(View view) {
        Log.e("123", Toasts(new Boolean[]{true}, edit_query.getText().toString(), new View[]{view}));
    }


    public void button1(View view) {
       test1((Button) view);
    }

    public void button2(View view) {
        Log.e("1234444",nimabi()+"");
        if(nimabi()){
            edit_query.setText("测试3");
        }else{
            edit_query.setText("测试3hook");
        }
    }

    public static String Toasts(Boolean[] booleen, String msg, View[] view) {
        Toast.makeText(App.getContext(), msg, 0).show();
        HookLog.e(msg);
        return msg;
    }

    public boolean nimabi(){
        Log.e("123","nimabo");
        return true;
    }


    public static int test1(Button button){
        Toast.makeText(App.getContext(), button.getText(), 0).show();
        return -1;
    }


    public void button4(View view){
        Log.e("123",test4((Button) view,"测试4")+"");
    }




    public static int test4(Button button,String msg){
        Toast.makeText(App.getContext(), button.getText()+msg, 0).show();
        test41();
        return -1;
    }
    public static void test41(){
        Toast.makeText(App.getContext(), "1123", 0).show();
    }
}
