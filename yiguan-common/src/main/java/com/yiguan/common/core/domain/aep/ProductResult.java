package com.yiguan.common.core.domain.aep;

import java.util.List;

/**
  *@Author 俞晨钟
  *@Date: Created in 2020/12/22 9:31
  */
public class ProductResult {

    private Integer pageNum;

    private Integer pageSize;

    private Integer total;

    private List<Product> list;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }
}
