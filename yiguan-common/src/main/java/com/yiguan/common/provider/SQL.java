package com.yiguan.common.provider;

import com.yiguan.common.utils.BeanUtils;
import com.yiguan.common.utils.CollectionUtil;
import com.yiguan.common.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.AbstractSQL;

import java.util.List;

/**
 * 重写SQL对象，扩展where方法
 * 
 * @author ycz
 */
public class SQL extends AbstractSQL<SQL> {
  @Override
  public SQL getSelf() {
    return this;
  }

  public SQL WHERE_IS_NULL(String columnName) {
    WHERE(columnName + " is null");
    return getSelf();
  }

  public SQL WHERE_IS_NOT_NULL(String columnName) {
    WHERE(columnName + " is not null");
    return getSelf();
  }

  public SQL WHERE_EQUAL_TO(String columnName, String value) {
    return buildWhere(columnName, "=", "'", value, "'");
  }

  public SQL WHERE_EQUAL_TO(String columnName, Integer value) {
    return buildWhere(columnName, "=", "", StrUtils.null2empty(value), "");
  }

  public SQL WHERE_EQUAL_TO(String columnName, Long value) {
    return buildWhere(columnName, "=", "", StrUtils.null2empty(value), "");
  }

  public SQL WHERE_EQUAL_TO(String columnName, Object paramsObject) {
    return buildWhere(columnName, paramsObject, "=");
  }

  public SQL WHERE_EQUAL_TO(String columnName, String propertyName, Object paramsObject) {
    return buildWhere(columnName, propertyName, paramsObject, "=");
  }

  public SQL WHERE_NOT_EQUAL_TO(String columnName, String value) {
    return buildWhere(columnName, "<>", "'", value, "'");
  }

  public SQL WHERE_NOT_EQUAL_TO(String columnName, Integer value) {
    return buildWhere(columnName, "<>", "", StrUtils.null2empty(value), "");
  }

  public SQL WHERE_NOT_EQUAL_TO(String columnName, Long value) {
    return buildWhere(columnName, "<>", "", StrUtils.null2empty(value), "");
  }

  public SQL WHERE_NOT_EQUAL_TO(String columnName, Object paramsObject) {
    return buildWhere(columnName, paramsObject, "<>");
  }

  public SQL WHERE_NOT_EQUAL_TO(String columnName, String propertyName, Object paramsObject) {
    return buildWhere(columnName, propertyName, paramsObject, "<>");
  }

  public SQL WHERE_GREATER_THAN(String columnName, String value) {
    return buildWhere(columnName, ">", "'", value, "'");
  }

  public SQL WHERE_GREATER_THAN(String columnName, Integer value) {
    return buildWhere(columnName, ">", "", StrUtils.null2empty(value), "");
  }

  public SQL WHERE_GREATER_THAN(String columnName, Long value) {
    return buildWhere(columnName, ">", "", StrUtils.null2empty(value), "");
  }

  public SQL WHERE_GREATER_THAN(String columnName, Object paramsObject) {
    return buildWhere(columnName, paramsObject, ">");
  }

  public SQL WHERE_GREATER_THAN(String columnName, String propertyName, Object paramsObject) {
    return buildWhere(columnName, propertyName, paramsObject, ">");
  }

  public SQL WHERE_GREATER_THAN_OR_EQUAL_TO(String columnName, String value) {
    return buildWhere(columnName, ">=", "'", value, "'");
  }

  public SQL WHERE_GREATER_THAN_OR_EQUAL_TO(String columnName, Integer value) {
    return buildWhere(columnName, ">=", "", StrUtils.null2empty(value), "");
  }

  public SQL WHERE_GREATER_THAN_OR_EQUAL_TO(String columnName, Long value) {
    return buildWhere(columnName, ">=", "", StrUtils.null2empty(value), "");
  }

  public SQL WHERE_GREATER_THAN_OR_EQUAL_TO(String columnName, Double value) {
    return buildWhere(columnName, ">=", "", StrUtils.null2empty(value), "");
  }
  
  public SQL WHERE_GREATER_THAN_OR_EQUAL_TO(String columnName, Object paramsObject) {
    return buildWhere(columnName, paramsObject, ">=");
  }

  public SQL WHERE_GREATER_THAN_OR_EQUAL_TO(String columnName, String propertyName,
                                            Object paramsObject) {
    return buildWhere(columnName, propertyName, paramsObject, ">=");
  }

  public SQL WHERE_LESS_THAN(String columnName, String value) {
    return buildWhere(columnName, "<", "'", value, "'");
  }

  public SQL WHERE_LESS_THAN(String columnName, Integer value) {
    return buildWhere(columnName, "<", "", StrUtils.null2empty(value), "");
  }

  public SQL WHERE_LESS_THAN(String columnName, Long value) {
    return buildWhere(columnName, "<", "", StrUtils.null2empty(value), "");
  }

  public SQL WHERE_LESS_THAN(String columnName, Object paramsObject) {
    return buildWhere(columnName, paramsObject, "<");
  }

  public SQL WHERE_LESS_THAN(String columnName, String propertyName, Object paramsObject) {
    return buildWhere(columnName, propertyName, paramsObject, "<");
  }

  public SQL WHERE_LESS_THAN_OR_EQUAL_TO(String columnName, String value) {
    return buildWhere(columnName, "<=", "'", value, "'");
  }

  public SQL WHERE_LESS_THAN_OR_EQUAL_TO(String columnName, Integer value) {
    return buildWhere(columnName, "<=", "", StrUtils.null2empty(value), "");
  }

  public SQL WHERE_LESS_THAN_OR_EQUAL_TO(String columnName, Long value) {
    return buildWhere(columnName, "<=", "", StrUtils.null2empty(value), "");
  }

  public SQL WHERE_LESS_THAN_OR_EQUAL_TO(String columnName, Double value) {
    return buildWhere(columnName, "<=", "", StrUtils.null2empty(value), "");
  }
  
  public SQL WHERE_LESS_THAN_OR_EQUAL_TO(String columnName, String propertyName,
                                         Object paramsObject) {
    return buildWhere(columnName, propertyName, paramsObject, "<=");
  }

  public SQL WHERE_LESS_THAN_OR_EQUAL_TO(String columnName, Object paramsObject) {
    return buildWhere(columnName, paramsObject, "<=");
  }

  public SQL WHERE_IN(String columnName, List<String> values) {
    if (values != null && values.size()!=0) {
    StringBuilder sb = new StringBuilder();
     sb.append(columnName).append(" ").append("in").append(" ").append("(")
         .append(CollectionUtil.buildSQL(values)).append(")");
     return  WHERE(sb.toString());
    }else{
      return getSelf();
    }
  }

  public SQL WHERE_IN_CONTAIN_EMPTY(String columnName, List<String> values) {
    if (values != null && values.size()!=0) {
    StringBuilder sb = new StringBuilder();
     sb.append(columnName).append(" ").append("in").append(" ").append("(")
         .append(CollectionUtil.buildSQLContainEmpty(values)).append(")");
     return  WHERE(sb.toString());
    }else{
      return getSelf();
    }
  }

  public SQL WHERE_NOT_IN(String columnName, List<String> values) {
    if (values != null && values.size()!=0) {
			StringBuilder sb = new StringBuilder();
			sb.append(columnName).append(" ").append("not in").append(" ").append("(")
			     .append(CollectionUtil.buildSQL(values)).append(")");
			return  WHERE(sb.toString());
    }else{
    	return getSelf();
    }
  }

  public SQL WHERE_LIKE_LEFT(String columnName, String value) {
    return buildWhere(columnName, "like", "'%", value, "'");
  }

  public SQL WHERE_LIKE_RIGHT(String columnName, String value) {
    return buildWhere(columnName, "like", "'", value, "%'");
  }

  public SQL WHERE_LIKE_ALL(String columnName, String value) {
    return buildWhere(columnName, "like", "'%", value, "%'");
  }

  public SQL WHERE_NOT_LIKE_LEFT(String columnName, String value) {
    return buildWhere(columnName, "not like", "'%", value, "'");
  }

  public SQL WHERE_NOT_LIKE_RIGHT(String columnName, String value) {
    return buildWhere(columnName, "not like", "'", value, "%'");
  }

  public SQL WHERE_NOT_LIKE_ALL(String columnName, String value) {
    return buildWhere(columnName, "not like", "'", value, "%'");
  }

  private SQL buildWhere(String columnName, String conjunction, String open, String value,
                         String close) {
    if (StringUtils.isNotBlank(value)) {
      StringBuilder sb = new StringBuilder();
      sb.append(columnName).append(" ").append(conjunction).append(" ").append(open)
          .append(CollectionUtil.buildSQL(value)).append(close);
      WHERE(sb.toString());
    }
    return getSelf();
  }

  private SQL buildWhere(String columnName, Object paramsObject, String conjunction) {
    return buildWhere(columnName, StrUtils.replaceFiledFirstLowwer(getPropertyName(columnName)),
        paramsObject, conjunction);
  }

  private SQL buildWhere(String columnName, String propertyName, Object paramsObject,
                         String conjunction) {
    if (hasPropertyValue(propertyName, paramsObject)) {
      StringBuilder sb = new StringBuilder();
      sb.append(columnName).append(" ").append(conjunction).append(" #{").append(propertyName)
          .append("}").toString();
      WHERE(sb.toString());
    }
    return getSelf();
  }

  private boolean hasPropertyValue(String propertyName, Object paramsObj) {

    try {
      Object value = BeanUtils.getFieldValueByName(propertyName, paramsObj);
      if (StringUtils.isBlank(StrUtils.null2empty(value))) {
        return false;
      }
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

  }

  private String getPropertyName(String property) {
    if (StringUtils.isNotBlank(property)) {
      return property.substring(property.lastIndexOf(".") + 1);
    }
    return property;
  }

}
