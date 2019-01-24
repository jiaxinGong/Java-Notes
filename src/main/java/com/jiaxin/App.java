package com.jiaxin;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        System.out.println("Hello World!");

        LongAdder longAdder = new LongAdder();
        longAdder.add(1L);
    }

}
