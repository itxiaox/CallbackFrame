package com.xiao.base.fragmentfram;

/**
 * 返回类型是多个参数，多种类型的封装
 * Created by xiao on 2017/12/8.
 */

public class ParamInfo<K, V> {

    private K key;

    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
