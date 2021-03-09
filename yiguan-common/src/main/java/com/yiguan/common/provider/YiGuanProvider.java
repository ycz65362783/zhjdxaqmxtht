package com.yiguan.system.provider;

import com.yiguan.common.utils.BeanUtils;
import com.yiguan.common.utils.CollectionUtil;
import com.yiguan.common.utils.StrUtils;
import com.yiguan.common.utils.StringUtils;

import javax.persistence.Column;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * @Author ycz
 * @Date: Created in 2020/12/29 16:14
 */
public class YiGuanProvider {

    /**
     * 生成批量插入的SQL
     * @param params
     * @return
     */
    public String batchInsertSQL(Map<String, List<?>> params) {
        return generateBatchInsertSQL(params, false);
    }

    /**
     * 生成批量插入可以为null的SQL
     * @param params
     * @return
     */
    public String batchInsertSelectiveSQL(Map<String, List<?>> params) {
        return generateBatchInsertSQL(params, true);
    }

    private String generateBatchInsertSQL(Map<String, List<?>> params, boolean insertNull) {
        List<?> list = (List<?>) params.get("list");

        if (CollectionUtil.isNotNullList(list)) {

            Class<?> cls = list.get(0).getClass();
            List<Field> selfFields = BeanUtils.getFields(cls);

            initInsertProperty(selfFields, list);

            StringBuilder insertSb = new StringBuilder();
            StringBuilder valuesSb = new StringBuilder();
            StringBuilder formatSb = new StringBuilder();

            for (Field field : selfFields) {
                field.setAccessible(true);
                try {
                    Object fieldValue = field.get(list.get(0));
                    if (fieldValue != null || insertNull) {
                        insertSb.append(getColumnName(field)).append(",");
                        valuesSb.append("#'{'list[{0}].").append(field.getName()).append("},");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            formatSb.append("( ").append(valuesSb.substring(0, valuesSb.length() - 1)).append(")");

            StringBuffer sb = new StringBuffer();
            sb.append("insert into ").append(BeanUtils.getTabelName(cls)).append(" (")
                    .append(insertSb.substring(0, insertSb.length() - 1)).append(") values ");
            MessageFormat mf = new MessageFormat(formatSb.toString());
            for (int i = 0; i < list.size(); i++) {
                sb.append(mf.format(new Object[] { i }));
                if (i < list.size() - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        return null;
    }

    /**
     * 设置新增数据时公共字段的值
     * @param selfFields
     * @param list
     */
    private void initInsertProperty(List<Field> selfFields,List<?> list ){
        String idName = null;
        for (Field field : selfFields) {
            Id idAnno = field.getAnnotation(Id.class);
            if (idAnno != null) {
                idName = field.getName();
                break;
            }
        }

        for (Object object : list) {
            try {
                if (BeanUtils.getFieldValueByName(idName, object) == null) {
                    BeanUtils.setProperty(object, idName, StrUtils.randomUUID());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            BeanUtils.initInsertProperty(object);
        }
    }


    private String getColumnName(Field field){
        Column column = field.getAnnotation(Column.class);
        if(column==null|| StringUtils.isBlank(field.getName())){
            return StrUtils.replaceFiled(field.getName());
        }else{
            return column.name();
        }
    }
}
