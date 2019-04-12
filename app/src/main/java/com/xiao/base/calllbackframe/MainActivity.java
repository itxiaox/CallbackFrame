package com.xiao.base.calllbackframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.xiao.base.callbackframe.FunctionManager;
import com.xiao.base.callbackframe.FunctionWithParamWithResult;

public class MainActivity extends AppCompatActivity {
     private static final String TAG = "log";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //将方法添加保存起来
        FunctionManager.getInstance().addFunction(new FunctionWithParamWithResult<String,String>("functionName") {
            @Override
            protected String function(String result) {
                Log.i(TAG, "MainActivity,function: "+result);
                return "function;"+result;
            }
        });

        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FunctionManager.getInstance().removeFunction("functionName");
    }
}
