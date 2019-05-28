package com.bysj.service.impl;

import com.bysj.dao.CategoryMapper;
import com.bysj.entity.Category;
import com.bysj.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.dc.pr.PRError;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询所有类别
     * @return
     */
    @Override
    public List<Category> getCategoryList() {
        return categoryMapper.getCategoryList();
    }


    /**
     * 查询某类的库存
     * @param id
     * @return
     */
    @Override
    public Category getByCategory(Integer id) {
        return categoryMapper.getByCategory(id);
    }

    @Override
    public Integer updatenum(Integer id,Integer num) {
        return categoryMapper.updatenum(id,num);
    }
}
