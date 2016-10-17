package com.lu.outOfMemory;

/**
 *
 *
 * Created by yuanchen on 16-10-17.
 */
public class StackOverFlowError {

    private static int index = 1;

    private void recur(){
        index++;
        recur();
    }

    public static void main(String[] args){
        StackOverFlowError stackOverFlowError = new StackOverFlowError();

        try {
            stackOverFlowError.recur();
        } catch (Throwable e){
            System.out.println("index:" + index);
            e.printStackTrace();
        }
    }
}
