package com.xiao.base.calllbackframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.xiao.base.callbackframe.FunctionManager;
import com.xiao.base.callbackframe.ParamInfo;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "log";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = FunctionManager.getInstance().invokeFunction("functionName","Hello World");
                Log.i(TAG, "onClick: "+result);
            }
        });
    }


}
