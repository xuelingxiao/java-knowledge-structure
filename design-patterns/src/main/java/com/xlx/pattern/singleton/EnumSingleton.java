package com.xlx.pattern.singleton;

/**
 * 枚举实现
 * 特点: 简单, 但不具备延迟加载, 可防止反射攻击, 可自己处理序列化
 * 枚举也是类, 可以随意添加方法,使用枚举的实现是单例的最佳实线; 调用方式:EnumSingleton.INSTANCE.方法名()
 */
public enum EnumSingleton {

    INSTANCE;

}