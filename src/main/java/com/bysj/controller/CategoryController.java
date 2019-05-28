package com.bysj.controller;

import com.bysj.entity.Category;
import com.bysj.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 29029
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询彩票列表
     * @param model
     * @return
     */
    @RequestMapping("/selectCategory")
    public String selectCategory(Model model){
        List<Category> categoryList = categoryService.getCategoryList();
        model.addAttribute("categoryList",categoryList);
        return "lottery/lotteryAdd";
    }


}
