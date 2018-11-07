package com.wzy.Utils.Sort;

/**
 * Created by wzy on 2018/11/7 12:18
 **/
public final class bubbleSort {
    private bubbleSort(){}

    public static int[] sort(int[] array){
        boolean needNextPass=true;  // 加了这个在j循环一次都没有发生交换时 直接结束
        int temp;
        for (int i = 0; i <array.length-1 && needNextPass ; i++) {
            needNextPass=false;
            for (int j = 0; j <array.length-1-i ; j++) {
                if(array[j]>array[j+1]){
                    temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;

                    needNextPass=true;
                }
            }
        }
        return array;
    }


}
