package com.wzy.Utils.Collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wzy
 * @Date 2019/7/4
 */
public class demo {




    public static void  main (String[] args){
        List<String> strList=new ArrayList<>();
        List<String> test1=new ArrayList<>();

        //取交集
        strList.retainAll(test1);
        //取并集
        strList.addAll(test1);
        //取差集
        strList.removeAll(test1);
    }
}
