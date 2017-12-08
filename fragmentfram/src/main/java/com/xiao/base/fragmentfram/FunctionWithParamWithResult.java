package com.xiao.base.fragmentfram;

/**
 * 有参数有返回值的类型，Result返回值泛型，Param参数泛型
 * Created by xiao on 2017/12/8.
 */

public abstract class FunctionWithParamWithResult<Result,Param> extends Function {
    public FunctionWithParamWithResult(String functionName) {
        super(functionName);
    }
    protected abstract Result function(Param param);
}
