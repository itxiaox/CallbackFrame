package com.xiao.base.callbackframe;


import java.util.HashMap;

/**
 * 作者：wb on 2017-08-24 10:32
 * 邮箱：493204277@qq.com
 * 功能：总的manager管理, 接口管理类，将接口变成对象，然后存储到集合中，当需要使用的时候就从map中取到当前的方法，并进行调用
 */

public class FunctionManager {

    private static FunctionManager functionManager;

    public FunctionManager() {
        mFunctionNoParamNoResult = new HashMap<>();
        mFunctionWithParamWithResult = new HashMap<>();
        mFunctionWithParamNoResult = new HashMap<>();
        mFunctionNoParamWithResult = new HashMap<>();
    }

    public static FunctionManager getInstance() {
        if (functionManager == null) {
            functionManager = new FunctionManager();
        }
        return functionManager;
    }


    private static HashMap<String, FunctionNoParamNoResult> mFunctionNoParamNoResult;
    private static HashMap<String, FunctionWithParamWithResult> mFunctionWithParamWithResult;
    private static HashMap<String, FunctionWithParamNoResult> mFunctionWithParamNoResult;
    private static HashMap<String, FunctionNoParamWithResult> mFunctionNoParamWithResult;

    /**
     * 添加无参数无返回值
     *
     * @param function
     * @return
     */
    public FunctionManager addFunction(FunctionNoParamNoResult function) {
        if (mFunctionNoParamNoResult != null) {
            mFunctionNoParamNoResult.put(function.functionName, function);
        }
        return this;
    }

    /**
     * 添加有参数有返回值
     *
     * @param function
     * @return
     */
    public FunctionManager addFunction(FunctionWithParamWithResult function) {
        if (mFunctionWithParamWithResult != null) {
            mFunctionWithParamWithResult.put(function.functionName, function);
        }
        return this;
    }

    /**
     * 添加有参数无返回值
     *
     * @param function
     * @return
     */
    public FunctionManager addFunction(FunctionWithParamNoResult function) {
        if (mFunctionWithParamNoResult != null) {
            mFunctionWithParamNoResult.put(function.functionName, function);
        }
        return this;
    }

    /**
     * 添加吴参数有返回值
     *
     * @param function
     * @return
     */
    public FunctionManager addFunction(FunctionNoParamWithResult function) {
        if (mFunctionNoParamWithResult != null) {
            mFunctionNoParamWithResult.put(function.functionName, function);
        }
        return this;
    }

    /**
     * 执行没参数没返回值的
     *
     * @param key
     */
    public void invokeFunction(String key) {
        if (key == null || key.equals("")) {
            return;
        }
        if (mFunctionNoParamNoResult != null) {
            FunctionNoParamNoResult functionNoParamNoResult = mFunctionNoParamNoResult.get(key);
            if (functionNoParamNoResult != null) {
                functionNoParamNoResult.function();
            } else {
                try {
                    throw new FunctionException("function not found");
                } catch (com.xiao.base.callbackframe.FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 有参数有返回值
     *
     * @param key
     * @param param
     * @param <Result>
     * @param <Param>
     * @return
     */
    public <Result, Param> Result invokeFunction(String key, Param param) {
        if (key == null || key.equals("")) {
            return null;
        }
        if (mFunctionWithParamWithResult != null) {
            FunctionWithParamWithResult<Result,Param> f = mFunctionWithParamWithResult.get(key);
            if (f != null) {
                    return f.function(param);
            } else {
                try {
                    throw new FunctionException("function not found");
                } catch (com.xiao.base.callbackframe.FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 从缓存中移除添加的接口对象，通常在Activity/Fragment 销毁的时候调用
     * @param functionName
     */
    public void removeFunction(String functionName){
        if(mFunctionNoParamNoResult!=null&&!mFunctionNoParamNoResult.isEmpty()&&mFunctionNoParamNoResult.containsKey(functionName)){
            mFunctionNoParamNoResult.remove(functionName);
        }
        if(mFunctionWithParamWithResult!=null&&!mFunctionWithParamWithResult.isEmpty()&&mFunctionWithParamWithResult.containsKey(functionName)){
            mFunctionWithParamWithResult.remove(functionName);
        }
        if(mFunctionWithParamNoResult!=null&&!mFunctionWithParamNoResult.isEmpty()&&mFunctionWithParamNoResult.containsKey(functionName)){
            mFunctionWithParamNoResult.remove(functionName);
        }
        if(mFunctionNoParamWithResult!=null&&!mFunctionNoParamWithResult.isEmpty()&&mFunctionNoParamWithResult.containsKey(functionName)){
            mFunctionNoParamWithResult.remove(functionName);
        }
    }

}  