package com.xiao.base.callbackframe;

/**
 *
 * 抽象出回调接口的通用模型，总共有四种类型
 * 然后根据参数和返回值组合，有四种：
 1、无参数无返回值
 2、有参数有返回值
 3、有参数无返回值
 4、无参数有返回值
 * Created by xiao on 2017/12/8.
 */

public abstract class Function {
    public String functionName;//方法的名字

    public Function(String functionName){
        this.functionName = functionName;
    }

}
