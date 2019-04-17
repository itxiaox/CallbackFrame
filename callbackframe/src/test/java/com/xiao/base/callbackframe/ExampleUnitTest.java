package com.xiao.base.callbackframe;

import android.util.Log;

import org.junit.Test;

import static org.junit.Assert.*;
public class ExampleUnitTest {

    /**
     * 测试
     */
    @Test
    public void testCallbackFrame(){

        /**
         * 回调处，
         *  将方法添加保存起来
         */

        FunctionManager.getInstance().addFunction(new FunctionWithParamWithResult<String,String>("functionName") {
            @Override
            protected String function(String result) {
                System.out.println("callback-回调处理");
                return "callback:"+result;
            }
        });


        /**
         * 执行调用
         */
        String result = FunctionManager.getInstance().invokeFunction("functionName","Hello World");
        System.out.println("调用处"+result);
    }
}