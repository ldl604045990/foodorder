package com.foodorder.util;

import com.github.pagehelper.Page;

import java.util.ArrayList;
import java.util.List;

public class BeanResultUtil {

    public static <T> PagedResult<T> toPagedResult(List<T> datas) {
        PagedResult<T> result = new PagedResult<T>();
        if (datas instanceof Page) {
            Page<T> page = (Page<T>) datas;
            result.setCurrentPage(page.getPageNum());
            result.setPageSize(page.getPageSize());
            result.setTotalCount(page.getTotal());
            result.setTotalPage(page.getPages());
            List<T> list = new ArrayList<>();
            list.addAll(page.getResult());
            result.setResult(list);
            page = null;
        } else {
            result.setCurrentPage(1);
            result.setPageSize(datas.size());
            result.setResult(datas);
            result.setTotalCount(datas.size());
        }
        return result;
    }
}
