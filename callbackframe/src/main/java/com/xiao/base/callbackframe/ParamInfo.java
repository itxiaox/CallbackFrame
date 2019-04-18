package com.xiao.base.callbackframe;

/**
 * 返回类型是多个参数，多种类型的封装,使用泛型
 * Created by xiao on 2017/12/8.
 */

public class ParamInfo<K, V> {

    private K key;

    private V value;

    /**
     * 获取参数的Key
     * @return 返回Key
     */
    public K getKey() {
        return key;
    }
    /**
     * 设置参数的键
     * @param key key
     */
    public void setKey(K key) {
        this.key = key;
    }
    /**
     * 获取参数的值
     * @return 返回参数的值
     */
    public V getValue() {
        return value;
    }/**
     * 设置参数的Value
     * @param value key
     */
    public void setValue(V value) {
        this.value = value;
    }
}
