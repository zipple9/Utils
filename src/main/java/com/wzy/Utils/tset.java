package com.wzy.Utils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.wzy.Utils.File.FileCopy;
import com.wzy.Utils.File.FileCount;
import com.wzy.Utils.JSON.JSONUtil;
import com.wzy.Utils.Search.binarySearch;
import com.wzy.Utils.Sort.Tree;
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
        JSONObject obj3=JSONObject.parseObject("{code:'03',parentCode:''}");
        JSONObject obj4=JSONObject.parseObject("{code:'04',parentCode:''}");
        JSONObject obj5=JSONObject.parseObject("{code:'05',parentCode:'03'}");


        List<JSONObject> objList=new ArrayList<>();
        objList.add(obj1);
        objList.add(obj2);
        objList.add(obj3);
        objList.add(obj4);
        objList.add(obj5);


//        System.out.println(Tree.getChildren(objList,obj3));

        Map<String,JSONObject> objMap=new HashMap();
        for(JSONObject obj :objList){
            objMap.put(obj.get("code").toString(),obj);
        }

//        System.out.println(objMap);
        List<JSONObject> resultList=new ArrayList<>();
        List<JSONObject> lastLevel=new ArrayList<>();


        for(int i=0;i<objList.size();i++){
            if(StringUtils.isEmpty(objList.get(i).get("parentCode").toString())){
                resultList.add(Tree.getChildren(objList,objList.get(i),"code","parentCode"));
                objList.remove(objList.get(i));
                i--;
            }
        }

        System.out.println(resultList);
        for(int i=0;i<objList.size();i++) {
            String parentCode = objList.get(i).get("parentCode").toString();
//            if(lastLevel.size()==0 && StringUtils.isEmpty(parentCode)){
//                resultList.add(objList.get(i));
//                objList.remove(objList.get(i));
//                i--;
//            }



            for (int j = 0; j < resultList.size(); j++) {
                //在resultList中找到上级，并给上级单位写children
                if (parentCode.equals(resultList.get(j).get("code"))) {

                    List<JSONObject> temp = (List) resultList.get(j).get("children");
                    if (temp == null) {
                        resultList.get(j).put("children", Lists.newArrayList(objList.get(i)));
                    } else {
                        temp.add(objList.get(i));
                        resultList.get(j).put("children", temp);
                    }
                    lastLevel.add(objList.get(i));
                    objList.remove(i);
                    i--;
                    break;
                }
            }
        }
//        System.out.println(objList);
//
//        System.out.println(resultList);


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
