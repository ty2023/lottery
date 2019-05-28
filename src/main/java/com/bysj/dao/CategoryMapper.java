package com.bysj.dao;

import com.bysj.entity.Category;

import java.util.List;

/**
 * @author 29029
 * @Version 1.0
 * @Time 16:01
 */
public interface CategoryMapper {
    /**
     * 查询所有类型
     * @return
     */
    List<Category> getCategoryList();

    /**
     * 查询某类的库存
     * @param id
     * @return
     */
    Category getByCategory(Integer id);

    /**
     * 修改坐在分类库存
     * @param num
     * @return
     */
    Integer updatenum(Integer id,Integer num);
}
