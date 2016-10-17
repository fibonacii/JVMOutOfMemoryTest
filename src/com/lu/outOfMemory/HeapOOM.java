package com.lu.outOfMemory;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms1m -Xmx1m -XX:+HeapDumpOnOutOfMemoryError
 * Created by yuanchen on 16-8-30.
 */
public class HeapOOM {

    static class OOMObject4b{
        private int a;
    }

    static class OOMObject40b{
        private long a1;
        private long a2;
//        private long a3;
//        private long a4;
//        private long a5;
//        private OOMObject4b oomObject4b;
//        private OOMObject40b oomObject40b=new OOMObject40b();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//        makeOOM(OOMObject4b.class);
        makeOOM(OOMObject40b.class);
    }

    private static <T> void makeOOM(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        List<T> oomObjects=new ArrayList<T>();

        int i=0;
        while(true){
            System.out.println(++i);
            oomObjects.add(clazz.newInstance());
        }
    }
}
