package com.xiao.base.fragmentfram;

/**
 * 无参数无返回值
 * Created by xiao on 2017/12/8.
 */

public abstract class FunctionNoParamNoResult extends Function{
    public FunctionNoParamNoResult(String functionName){
        super(functionName);
    }
    protected abstract void function();

}
