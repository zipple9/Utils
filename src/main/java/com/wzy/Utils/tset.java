package com.wzy.Utils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.wzy.Utils.File.FileCopy;
import com.wzy.Utils.File.FileCount;
import com.wzy.Utils.JSON.JSONUtil;
import com.wzy.Utils.Search.binarySearch;
import com.wzy.Utils.Sort.bubbleSort;
import com.wzy.Utils.codeTransformation.GBKtoUTF8;
import com.wzy.Utils.txtProcessing.ADFilter;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by wzy on 2018/11/6 17:48
 **/
public class tset {


    public static void main(String []args) throws IOException {

        JSONObject obj1=JSONObject.parseObject("{code:'01',parentCode:'02'}");
        JSONObject obj2=JSONObject.parseObject("{code:'02',parentCode:'03'}");
        JSONObject obj3=JSONObject.parseObject("{code:'03'}");
        JSONObject obj4=JSONObject.parseObject("{code:'04'}");
        JSONObject obj5=JSONObject.parseObject("{code:'05',parentCode:'03'}");


        List<JSONObject> objList=new ArrayList<>();
        objList.add(obj1);
        objList.add(obj2);
        objList.add(obj3);
        objList.add(obj4);
        objList.add(obj5);

        Map<String,JSONObject> objMap=new HashMap();
        for(JSONObject obj :objList){
            objMap.put(obj.get("code").toString(),obj);
        }

        System.out.println(objMap);
        List<JSONObject> resultList=new ArrayList<>();


        for(int i=0;i<objList.size();i++){
            if(StringUtils.isEmpty(objList.get(i).get("parentCode").toString())){
                System.out.println(i);
                resultList.add(objList.get(i));
                objList.remove(objList.get(i));
                i--;
            }
        }


//        Map<String,JSONObject> result=new HashMap();
//        for(Map.Entry<String,JSONObject> entry:objMap.entrySet()){
//
//            //如果没有父级代码，直接将obj放入结果集
//            String parentCode=entry.getValue().get("parentCode").toString();
//            if(StringUtils.isEmpty(parentCode)){
//                result.put(parentCode,entry.getValue());
//            }
//            //如果有父级代码，开始遍历
//            else{
//                //得到父级obj
//                JSONObject parentObj=objMap.get(parentCode);
//
//                //为父级obj 添加children
//                List<JSONObject> temp=(List)entry.getValue().get("children");
//                if(temp==null){
//                    parentObj.put("children", Lists.newArrayList(entry.getValue()));
//                }else{
//                    parentObj.put("children",temp.add(entry.getValue()));
//
//                }
//
//                objMap.put(parentCode,parentObj);
//
//
//            }
//
//        }


    }
}
