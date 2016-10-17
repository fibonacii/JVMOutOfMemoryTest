package com.lu.outOfMemory;

/**
 * Created by yuanchen on 16-10-17.
 */
public class StackOverFlowError {

    private static int index = 1;

    private void recur(){
        System.out.println("Stack deep:" + index);
        index++;
        recur();
    }

    public static void main(String[] args){
        StackOverFlowError stackOverFlowError = new StackOverFlowError();

        try {
            stackOverFlowError.recur();.ssh
        } catch (Exception e){
            System.out.println("Stack deep:" + index);
            e.printStackTrace();
        }
    }
}
