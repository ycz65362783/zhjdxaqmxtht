package com.yiguan.system.Base;

import tk.mybatis.mapper.common.*;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseInsertMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;

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
	

}
