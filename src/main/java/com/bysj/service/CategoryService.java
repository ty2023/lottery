package com.bysj.service;

import com.bysj.entity.Category;

import java.util.List;

/**
 * @author 29029
 */
public interface CategoryService {

    /**
     * 查询所有彩票类型
     * @return
     */
    List<Category> getCategoryList();

    /**
     * 查询该类彩票的库存
     * @param id
     * @return
     */
    Category getByCategory(Integer id);

    Integer updatenum(Integer id,Integer num);
}
