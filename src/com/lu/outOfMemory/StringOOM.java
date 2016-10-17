package com.lu.outOfMemory;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms1m -Xmx1m -XX:+HeapDumpOnOutOfMemoryError
 * Created by yuanchen on 16-10-18.
 */
public class StringOOM {

    public static void main(String[] args){
        String str1="hello,world";
        int index=0;
        List<String> list=new ArrayList<>();
        while (true){
            String str2=str1+str1;
            str1=str2;
            list.add(str2.intern());
            System.out.println("index:"+(++index));
        }
    }
}
