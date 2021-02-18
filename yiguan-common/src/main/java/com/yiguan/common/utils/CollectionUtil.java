package com.yiguan.common.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.yiguan.common.utils.bean.BeanUtils;
import org.apache.commons.lang3.StringUtils;

public class CollectionUtil {
	/**
	 * 将List 分为多个List
	 * 
	 * @param list
	 *          需要分开的List
	 * @param batchCount
	 *          设置每个List的大小
	 * @return List<List<String>>
	 */
	public static List<List<String>> splitStr(List<String> list, int batchCount) {

		if (isNullList(list)) {
			return null;
		}
		List<List<String>> listAll = new ArrayList<List<String>>();
		List<String> listTemp = new ArrayList<String>();
		int i = 0;
		for (String fCode : list) {
			if (StringUtils.isNotBlank(fCode)) {
				listTemp.add(fCode);
			}
			i++;
			if (i == batchCount) {
				listAll.add(listTemp);
				listTemp = new ArrayList<String>();
				i = 0;
			}
		}
		if (isNotNullList(listTemp)) {
			listAll.add(listTemp);
		}
		return listAll;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<List<?>> splitObject(List<?> list, int batchCount) {

		if (isNullList(list)) {
			return null;
		}
		List<List<?>> listAll = new ArrayList<List<?>>();
		List listTemp = new ArrayList();
		int i = 0;
		for (Object item : list) {
			if (null != item) {
				listTemp.add(item);
			}
			i++;
			if (i == batchCount) {
				listAll.add(listTemp);
				listTemp = new ArrayList();
				i = 0;
			}
		}
		if (isNotNullList(listTemp)) {
			listAll.add(listTemp);
		}
		return listAll;
	}

	/**
	 * 将List 分为多个List
	 * 
	 * @param list
	 *          需要分开的List
	 * @param batchCount
	 *          设置每个List的大小
	 * @return List<List<String>>
	 */
	public static List<List<Object[]>> splitList(List<Object[]> list, int batchCount) {

		if (isNullList(list)) {
			return null;
		}
		List<List<Object[]>> listAll = new ArrayList<List<Object[]>>();
		List<Object[]> listTemp = new ArrayList<Object[]>();
		int i = 0;
		for (Object[] fCode : list) {
			listTemp.add(fCode);
			i++;
			if (i == batchCount) {
				listAll.add(listTemp);
				listTemp = new ArrayList<Object[]>();
				i = 0;
			}
		}
		if (isNotNullList(listTemp)) {
			listAll.add(listTemp);
		}
		return listAll;
	}

	/**
	 * 将List 分为多个List
	 * 
	 * @param list
	 *          需要分开的List
	 * @param batchCount
	 *          设置每个List的大小
	 * @return List<List<String>>
	 */

	public static List<List<Map<String, Object>>> splitMap(List<Map<String, Object>> list, int batchCount) {
		if (isNullList(list)) {
			return null;
		}
		List<List<Map<String, Object>>> listAll = new ArrayList<List<Map<String, Object>>>();
		List<Map<String, Object>> listTemp = new ArrayList<Map<String, Object>>();
		int i = 0;
		for (Map<String, Object> item : list) {
			listTemp.add(item);
			i++;
			if (i == batchCount) {
				listAll.add(listTemp);
				listTemp = new ArrayList<Map<String, Object>>();
				i = 0;
			}
		}
		if (isNotNullList(listTemp)) {
			listAll.add(listTemp);
		}
		return listAll;
	}

	/**
	 * 判断List是否空，空返回True,非空返回false
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isNullList(List<?> list) {

		if (null == list || list.size() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断List是否不为空，非空返回True,空返回false
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isNotNullList(List<?> list) {

		if (null != list && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 判断Set是否空，空返回True,非空返回false
	 * 
	 * @param set
	 * @return
	 */
	public static boolean isNullSet(Set<?> set) {

		if (null == set || set.size() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断Set是否不为空，非空返回True,空返回false
	 * 
	 * @param set
	 * @return
	 */
	public static boolean isNotNullSet(Set<?> set) {

		if (null != set && set.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	public static String buildSQL(String str) {
		if (StringUtils.isNotEmpty(str)) {
		  str = str.replace("\\", "\\\\");
			str = str.replace("'", "\\'");
			str = str.replaceAll("\\s+and\\s+", "");
			str = str.replaceAll("\\s+or\\s+", "");
			//查询条件带空格，并且数据带空格，会查询不到
			//str = str.replace(" ", "");
		}
		return str;
	}

  /**
   * 根据List生成SQL语句中in ()内的字符串
   * 
   * @param list
   * @return
   */
  public static String buildSQL(List<String> list) {
    if (isNotNullList(list)) {
      StringBuilder sb = new StringBuilder();
      for (String str : list) {
        if (StringUtils.isNotEmpty(str)) {
          str = buildSQL(str);
          sb.append(",'").append(str.trim()).append("'");
        }
      }
      if (sb.toString().length() >= 1) {
        return sb.toString().substring(1);
      } else {
        return "";
      }
    } else {
      return "";
    }
  }

  /**
   * 根据List生成SQL语句中in ()内的字符串
   * 
   * @param list
   * @return
   */
  public static String buildSQLContainEmpty(List<String> list) {
    if (isNotNullList(list)) {
      StringBuilder sb = new StringBuilder();
      for (String str : list) {
        str = buildSQL(str);
        sb.append(",'").append(str.trim()).append("'");
      }
      if (sb.toString().length() >= 1) {
        return sb.toString().substring(1);
      } else {
        return "";
      }
    } else {
      return "";
    }
  }

	/**
	 * 判断Map是否空，空返回True,非空返回false
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isNullMap(Map<?, ?> map) {

		if (null == map || map.size() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断map是否不为空，非空返回True,空返回false
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isNotNullMap(Map<?, ?> map) {

		if (null != map && map.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("rawtypes")
	public static String db(Map map, String key) {
		String value = "";
		if (null == map) {
			return value;
		}
		if (null == map.get(key)) {
			return value;
		}

		if (map.get(key) instanceof BigDecimal) {
			BigDecimal bigValue = (BigDecimal) map.get(key);
			value = new Long(bigValue.longValue()).toString();
			return value;
		}
		if (map.get(key) instanceof Long) {
			Long l = (Long) map.get(key);
			return l.toString();
		}

		return map.get(key).toString();

	}

	/**
	 * 获取list中字段fieldName的list集合
	 * @param list
	 * @param fieldName
	 * @return
	 */
	public static <T extends Object> List<T> fieldList(List<?> list, String fieldName) {
		return fieldList(list, fieldName, true);
	}

	/**
	 * 获取list中字段fieldName的list集合
	 * @param list
	 * @param fieldName
	 * @param containNull
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> List<T> fieldList(List<?> list, String fieldName, boolean containNull) {
		if (StringUtils.isBlank(fieldName)) {
			return null;
		}
		if(CollectionUtil.isNullList(list)){
			return null;
		}
		try {
			List<T> resultList = new ArrayList<>();
			for (Object obj : list) {
				Object objVal = BeanUtils.getFieldValueByName(fieldName, obj);
				if (!containNull && objVal == null)
					continue;
				resultList.add((T) objVal);
			}
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static int length(List<?> list) {
		return list == null ? 0 : list.size();
	}

	/**
	 * List<Map<String, String>>转List<Map<String, Object>>
	 *   用于导入数据处理
	 * @param mapList
	 * @return
	 */
	public static List<Map<String, Object>> converObjectMap(List<Map<String, String>> mapList) {
		if (CollectionUtil.isNotNullList(mapList)) {
			final List<Map<String, Object>> objectMapList = new ArrayList<>();
			for (Map<String, String> map : mapList) {
				final Map<String, Object> objectMap = new HashMap<>();
				for (Map.Entry<String, String> entry : map.entrySet()) {
					objectMap.put(entry.getKey(), entry.getValue());
				}
				objectMapList.add(objectMap);
			}
			return objectMapList;
		}
		return null;
	}
	
  /**
   * 移除list中 t=null的数据
   * @param list
   * @return
   */
  public static <T> List<T> removeNull(List<T> list) {
    return list == null ? Collections.emptyList() : list.stream().filter(t -> t != null).collect(Collectors.toList());
  }
  
  /**
   * 取list中的最小值（排除空值），如果没取到，则返回null
   * @param list
   * @return
   */
  public static <T extends Comparable<T>> T min(List<T> list) {
    list = removeNull(list);
    if(list == null || list.size() == 0) {
      return null;
    }
    return list.stream().min((t1, t2) -> { return t1.compareTo(t2);}).get();
  }
  
  /**
   * 取list中的最大值（排除空值），如果没取到，则返回null
   * @param list
   * @return
   */
  public static <T extends Comparable<T>> T max(List<T> list) {
    list = removeNull(list);
    if(list == null || list.size() == 0) {
      return null;
    }
    return list.stream().max((t1, t2) -> { return t1.compareTo(t2);}).get();
  }
  
  /**
   * 去除list中重复的数据，
   * 
   * @param list
   * @param removeNull 是否移除list中的空值
   */
  public static <T extends Comparable<T>> void distinct(List<T> list, boolean removeNull) {
    for (int i = 0; i < list.size(); i++) {
      if(list.get(i) == null) {
        if(removeNull) {
          list.remove(i);
          i--;
        }
        continue;
      }
      for (int j = i + 1; j < list.size(); j++) {
        if (list.get(i).compareTo(list.get(j)) == 0) {
          list.remove(j);
          j--;
        }
      }
    }
  }
  
  /**
   * 获取map中key所对应的值，如果不存在该key，则返回null
   * 
   * @param map map对象
   * @param key key值
   * @return
   */
  public static <T> T getValue(Map<String, T> map, String key) {
    if (map == null) {
      return null;
    }
    if (!map.containsKey(key)) {
      return null;
    }
    return map.get(key);
  }
  
  /**
   * 将childList添加到list中
   * 
   * @param list
   * @param
   */
  @SafeVarargs
  public static <T> void addToList(final List<T> list, final List<T>... childLists) {
    if (childLists == null) {
      return;
    }
    for (List<T> childList : childLists) {
      if (isNotNullList(childList)) {
        list.addAll(childList);
      }
    }
  }
  
  /**
   * 判断数组是否为空数组
   * 
   * @param array
   * @return
   */
  public static <T> boolean isEmpty(final T[] array) {
    return array == null || array.length == 0;
  }
  
  /**
   * 判断数组是否为空数组
   * 
   * @param array
   * @return
   */
  public static <T> boolean isNotEmpty(final T[] array) {
    return !isEmpty(array);
  }
  /**
   * 去除 list中重复的元素，返回没有重复元素的list集合
   * @param list
   * @return
   */
  public static List<String> removeRepeat(List<String> list){
    if(list == null || list.size() == 0){
      return null;
    }
    List<String> result = new ArrayList<>();
    List<String> listContain = new ArrayList<>();
    for(String str : list){
      if(StringUtils.isNotBlank(str) && !listContain.contains(str)){
        listContain.add(str);
        result.add(str);
      }
    }
    return result;
  }

	/**
	 * 根据对象指定字段去重
	 */
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
  
}
