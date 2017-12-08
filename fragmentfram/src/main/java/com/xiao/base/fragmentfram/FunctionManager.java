package com.xiao.base.fragmentfram;


import java.util.HashMap;
/**
 * 作者：wb on 2017-08-24 10:32 
 * 邮箱：493204277@qq.com 
 * 功能：总的manager管理 
 */

public class FunctionManager {

    private static FunctionManager functionManager;

    public FunctionManager() {
        mFunctionNoParamNoResult=new HashMap<>();
        mFunctionWithParamWithResult=new HashMap<>();
        mFunctionWithParamNoResult=new HashMap<>();
        mFunctionNoParamWithResult=new HashMap<>();
    }

    public static FunctionManager getInstance(){
        if(functionManager==null){
            functionManager=new FunctionManager();
        }
        return functionManager;
    }


    private static HashMap<String,FunctionNoParamNoResult> mFunctionNoParamNoResult;
    private static HashMap<String,FunctionWithParamWithResult> mFunctionWithParamWithResult;
    private static HashMap<String,FunctionWithParamNoResult> mFunctionWithParamNoResult;
    private static HashMap<String,FunctionNoParamWithResult> mFunctionNoParamWithResult;

    /**
     * 添加无参数无返回值 
     * @param function
     * @return
     */
    public FunctionManager addFunction(FunctionNoParamNoResult function){
        if(mFunctionNoParamNoResult!=null){
            mFunctionNoParamNoResult.put(function.functionName,function);
        }
        return this;
    }

    /**
     * 添加有参数有返回值 
     * @param function
     * @return
     */
    public FunctionManager addFunction(FunctionWithParamWithResult function){
        if(mFunctionWithParamWithResult!=null){
            mFunctionWithParamWithResult.put(function.functionName,function);
        }
        return this;
    }

    /**
     * 添加有参数无返回值 
     * @param function
     * @return
     */
    public FunctionManager addFunction(FunctionWithParamNoResult function){
        if(mFunctionWithParamNoResult!=null){
            mFunctionWithParamNoResult.put(function.functionName,function);
        }
        return this;
    }

    /**
     * 添加吴参数有返回值 
     * @param function
     * @return
     */
    public FunctionManager addFunction(FunctionNoParamWithResult function){
        if(mFunctionNoParamWithResult!=null){
            mFunctionNoParamWithResult.put(function.functionName,function);
        }
        return this;
    }

    /**
     * 执行没参数没返回值的 
     * @param key
     */
    public void invokeFunction(String key){
        if(key==null||key.equals("")){
            return;
        }
        if(mFunctionNoParamNoResult!=null){
            FunctionNoParamNoResult functionNoParamNoResult=mFunctionNoParamNoResult.get(key);
            if(functionNoParamNoResult!=null){
                functionNoParamNoResult.function();
            }else {
                try {
                    throw new FunctionException("function not found");
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 有参数有返回值 
     * @param key
     * @param param
     * @param result
     * @param <Result> 
     * @param <Param> 
     * @return
     */
    public <Result,Param>Result invokeFunction(String key,Param param,Class<Result> result){
        if(key==null||key.equals("")){
            return null;
        }
        if(mFunctionWithParamWithResult!=null){
            FunctionWithParamWithResult f=mFunctionWithParamWithResult.get(key);
            if(f!=null){
                if(result==null){
                    return (Result) f.function(param);
                }else {
                    return result.cast(f.function(param));
                }

            }else {
                try {
                    throw new FunctionException("function not found");
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}  