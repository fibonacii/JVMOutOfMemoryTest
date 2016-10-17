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

    public static void main(String[] args) {
//        makeOOM(OOMObject4b.class);
        makeOOM(OOMObject40b.class);
    }

    private static <T> void makeOOM(Class<T> clazz) {
        List<T> oomObjects=new ArrayList<T>();
        int index=0;

        try {
            while(true){
                index++;
                oomObjects.add(clazz.newInstance());
            }
        } catch (Throwable e){
            System.out.println("index:"+index);
            e.printStackTrace();
        }


    }
}
