package com.yiguan.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtils {

  private JsonUtils() {}

  public static String toString(Object obj) {
    return JSON.toJSONString(obj);
  }

  public static String toString(Object object, SerializeFilter filter, SerializerFeature... features) {
    return JSON.toJSONString(object, SerializeConfig.globalInstance, new SerializeFilter[] {filter}, null, JSON.DEFAULT_GENERATE_FEATURE, features);
  }

  public static Object toObject(String str) {
    return JSON.parse(str);
  }

  @SuppressWarnings("unchecked")
  public static Map<String, Object> toMap(String str) {
    try {
      return (Map<String, Object>) JSON.parse(str);
    } catch (Exception e) {
      e.printStackTrace();
      return new HashMap<String, Object>();
    }
  }

  @SuppressWarnings("unchecked")
  public static Map<String, Object> tryToMap(String str) {
    try {
      return (Map<String, Object>) JSON.parse(str);
    } catch (Exception e) {
      return new HashMap<String, Object>();
    }
  }

  @SuppressWarnings("unchecked")
  public static List<Map<String, Object>> toList(String str) {

    return (List<Map<String, Object>>) JSON.parse(str);
  }

  public static <T> T toBean(String str, Class<T> cls) {
    return JSON.parseObject(str, cls);
  }

  public static <T> List<T> toBeanList(String str, Class<T> cls) {

    return JSON.parseArray(str, cls);
  }
}
