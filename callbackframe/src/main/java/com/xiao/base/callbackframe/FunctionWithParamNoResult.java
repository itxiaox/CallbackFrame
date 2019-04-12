package com.xiao.base.callbackframe;

/**
 * 有参数无返回值类型
 * Created by xiao on 2017/12/8.
 */

public abstract class FunctionWithParamNoResult<Param> extends Function{

    public FunctionWithParamNoResult(String functionName) {
        super(functionName);
    }

    protected abstract void function(Param param);
}
