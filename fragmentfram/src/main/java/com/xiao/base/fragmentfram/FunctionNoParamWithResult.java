package com.xiao.base.fragmentfram;

/**
 * Created by xiao on 2017/12/8.
 */

public abstract class FunctionNoParamWithResult<Result> extends Function{

    public FunctionNoParamWithResult(String functionName) {
        super(functionName);
    }

    protected abstract Result function();
}
