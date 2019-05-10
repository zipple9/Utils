package com.wzy.Utils.Sort;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author wzy
 * @Date 2019/5/9
 */
public class Tree {


    public static void toTree() {

        //把数据转换成树形结构 几种方法：1从上到下  2从下到上  3构造map 逐条处理

    }
    //得到一个节点的所有子节点
    public static JSONObject getChildren(List<JSONObject> objList,JSONObject obj,String codeParam,String parentCodeParam){
        String code=obj.get(codeParam).toString();
        for(JSONObject jsonObject:objList){
            String parentCode=jsonObject.get(parentCodeParam).toString();
            if(parentCode.equals(code)){
                List<JSONObject> temp = (List)obj.get("children");
                if (temp == null) {
                    obj.put("children", Lists.newArrayList(jsonObject));
                } else {
                    temp.add(jsonObject);
                    obj.put("children", temp);
                }
                getChildren(objList,jsonObject,codeParam,parentCodeParam);

            }
        }

        return obj;
    }
}
