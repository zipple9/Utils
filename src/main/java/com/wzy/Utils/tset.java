package com.wzy.Utils;

import com.wzy.Utils.File.FileCopy;
import com.wzy.Utils.File.FileCount;
import com.wzy.Utils.Search.binarySearch;
import com.wzy.Utils.Sort.bubbleSort;
import com.wzy.Utils.txtProcessing.ADFilter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by wzy on 2018/11/6 17:48
 **/
public class tset {


    public static void main(String []args) throws IOException {

//        for (int i = 0; i <1 ; i++) {
//            try {
////                FileCopy.copyFileUsingFileStreams(("F:/fitness log.xlsx"));
//                FileCopy.fileCopyNIO("F:/fitness log.xlsx");
//
//            }catch (Exception e){}
//
//        }

//        int a=FileCount.filesCountAll("F:\\迅雷下载\\DEEP_Win7x64_CJB");
//        System.out.println(a);
//        System.out.println(FileCount.filesCount("F:/迅雷下载"));

//        int[] array={3,5,1,9,6,5,4,11,56,78,111,12,666,555,18,28,58,17,37,97,57,66};
//
//        array=bubbleSort.sort(array);
//        System.out.println(Arrays.toString(array));
//        System.out.println(binarySearch.search(array,666));
//
//        System.out.println((int)Math.floor(5.5));
//        System.out.println(51>>>1);

        ADFilter.deleteAD("C:\\Users\\Administrator\\Desktop\\t1.txt");

        boolean tf="&#65288;&#26825;&#33457;&#3".matches("(&#[\\d]+;)+(&#[\\d]+)");
        boolean tf2="（wwW.80txt.com 无弹窗广告）".matches("\\（.*80txt.*\\）");


        System.out.println(tf);
        System.out.println(tf2);


        String a="<.*>";
        String aa=Integer.toHexString((int)a.charAt(0)+2);
        System.out.println(aa);
        System.out.println((char)Integer.parseInt(aa,16));





    }
}
