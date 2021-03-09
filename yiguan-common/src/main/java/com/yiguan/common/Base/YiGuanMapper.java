package com.yiguan.system.Base;

import com.yiguan.system.provider.YiGuanProvider;
import org.apache.ibatis.annotations.InsertProvider;
import tk.mybatis.mapper.common.*;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseInsertMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;

import java.util.List;

public interface YiGuanMapper<T> extends   Marker,
										BaseMapper<T>,
										MySqlMapper<T>,
										IdsMapper<T>,
										RowBoundsMapper<T>,
										BaseSelectMapper<T>,
										BaseInsertMapper<T>,
										BaseDeleteMapper<T>,
										ExampleMapper<T>,
										ConditionMapper<T> {

	/**
	 * 批量插入不为空的值
	 * @param list
	 * @return
	 */
	@InsertProvider(type = YiGuanProvider.class, method = "batchInsertSQL")
	int batchInsert(List<T> list);

	/**
	 * 批量插入(空值也会插入，数据库默认值需要手动设置)
	 * @param list
	 * @return
	 */
	@InsertProvider(type = YiGuanProvider.class, method = "batchInsertSelectiveSQL")
	int batchInsertSelective(List<T> list);
	

}
