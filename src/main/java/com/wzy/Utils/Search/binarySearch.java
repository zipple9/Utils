package com.wzy.Utils.Search;

/**
 * Created by wzy on 2018/11/7 12:57
 **/
public final class binarySearch {


    public static int search(int[] array,int tar){
        int start=0;
        int end=array.length-1;
        boolean result=false;
        while (start<=end){
            int mid=(start+end)>>>1;     //这里和 (int)Math.floor() 效果一样 向下取整

            if(tar==array[mid]){
                return mid;
            }
            if(tar<=array[end] && tar>array[mid]){
                start=mid;
                if(tar==array[end]){return end;}
            }
            if(tar>=array[start] && tar<array[mid]){
                end=mid;
                if(tar==array[start]){return start;}

            }
        }
        return -1;
    }
}
