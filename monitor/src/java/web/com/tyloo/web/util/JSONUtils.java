/**
 * 文件名称：  JSONUtils.java
 * 文件版权:  China Gowin Technologies Co., Ltd. Copyright 2007-2012,All rights reserved
 * 文件描述:  <描述>
 * 修改作者:  LiXiangDong
 * 修改时间:  2012-11-8
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.tyloo.web.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * JSON工具
 * @author LiXiangDong
 * @version V1.0, 2012-11-8
 */
public class JSONUtils implements Serializable
{
    
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 7138415887022916030L;
    
    /**
     * 解析JSON数据,将数据合成数据对象
     * @param  parameXML JSON字符串
     * @return Object    返回的字符串
     */
    @SuppressWarnings("unchecked")
    public static final Object parseJSON(String parameXML, Class classes)
    {
        JSONObject object = JSONObject.fromObject(parameXML);
        return JSONObject.toBean(object, classes);
    }
    
    /**
     * 解析JSON数据,封装成对象
     * @param  jsonString JSON字符串
     * @param  clazz      需要转换的对象
     * @param  map        对象中的对象的类型
     * @return Object     需要转换的对象
     */
    @SuppressWarnings("unchecked")
    public static Object parseJSON(String jsonString, Class clazz, Map<String, Class> map)
    {
        JSONObject jsonObject = null;
        try
        {
            jsonObject = JSONObject.fromObject(jsonString);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return JSONObject.toBean(jsonObject, clazz, map);
    }
    
    /**
     * 封装JSON数据
     * 
     * @param  bean   需要生产JSON的对象
     * @return String JSON字符串
     */
    public static final String encapJSON(Object bean)
    {
        JSONObject object = JSONObject.fromObject(bean);
        return object.toString();
    }
    
    /**
     * 封装LIST数据，将数据转换成JSON数据
     * 
     * @param  list   需要生产JSON的集合
     * @return String 获取的JSON字符串
     */
    @SuppressWarnings("unchecked")
    public static final String encapJSON(List list)
    {
        JSONArray jsonArray = new JSONArray();
        for (Object treeNode : list)
        {
            jsonArray.add(JSONObject.fromObject(treeNode));
        }
        return jsonArray.toString();
    }
    
    public static final String encapJSON(List list, JsonConfig config)
    {
        JSONArray jsonArray = new JSONArray();
        for (Object treeNode : list)
        {
            jsonArray.add(JSONObject.fromObject(treeNode, config));
        }
        return jsonArray.toString();
    }
    
    /**
     * 简单是的list封装
     * @param  list   List<Object>,其中Object位简单数据类型
     * @return String JSON数据
     */
    public static final String encapForGeneric(List<Object> list)
    {
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }
    
}