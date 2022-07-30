package com.jiaxin;


import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        /*ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        System.out.println("Hello World!");

        LongAdder longAdder = new LongAdder();
        longAdder.add(1L);*/

//        String sql = "DWUSR.H_CMS_CUSTOMER_INFO_L";
//        String sql = "edw.DWUSR.A,edw.DWUSR.B";
//        String sql = "edw.DWUSR.H_CMS_CUSTOMER_INFO_L";
//        String[] ss  = sql.split(".",2);

//        System.out.println(ss);

        String rawPath = "/admin/role/page?current=1&size=20";
        String[] strings = StringUtils.tokenizeToStringArray(rawPath, "/");
        String newPath = "/" + Arrays.stream(StringUtils.tokenizeToStringArray(rawPath, "/")).skip(1L)
            .collect(Collectors.joining("/"));
        System.out.println(newPath);

    }

}
