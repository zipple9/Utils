package com.wzy.Utils.JSON;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author wzy
 * @Date 2019/4/24
 */
public class JSONUtil {




    public static void JSONTest(){


        //组装JSONObject的时候 字段单引号和 转义双引号都可。不加引号转换失败
        String str2="{'userName': 'wzy','userStatus': '1','roleInfo': '0'}";
        String str3="{\"userName\": \"wzy\",\"userStatus\": 1,\"roleInfo\": \"0\"}";

        //组装JSONArray同理
        String str1="[{'roleCode': '001','roleName': '操作员'},{'roleCode': '002','roleName': '管理员'}]";

        JSONObject JO1=JSON.parseObject(str2);
        JSONObject JO2=JSON.parseObject(str3);



        JSONArray JO3=JSON.parseArray(str1);

        System.out.println(JO1);
        System.out.println(JO2);

        JO2.put("roleInfo",JO3);
        System.out.println(JO2);


    }
}
