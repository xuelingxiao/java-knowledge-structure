package com.xlx.cli;

import java.lang.reflect.Field;

public class SwapInteger {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a;
        Integer b;
        a=1;
        b=2;

        swap(a,b);

        System.out.println("a="+a+";b="+b);
    }

    public static void swap(Integer a,Integer b) throws NoSuchFieldException, IllegalAccessException {
        Field val = Integer.class.getDeclaredField("value");
        val.setAccessible(true);
        int temp = a.intValue();
        val.set(a,b.intValue());
        val.setInt(b,temp);
    }
}
