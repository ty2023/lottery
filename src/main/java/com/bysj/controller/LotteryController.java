package com.bysj.controller;

import com.bysj.entity.Category;
import com.bysj.entity.Lottery;
import com.bysj.entity.User;
import com.bysj.service.CategoryService;
import com.bysj.service.LotteryService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 29029
 */
@Controller
@RequestMapping("lottery")
public class LotteryController extends IndexController{

    @Autowired
    private LotteryService lotteryService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/getLotteryList")
    public String getLotteryList(Integer cateId, Model model){
        List<Lottery> lotteryList = lotteryService.getLotteryList(cateId);
        List<Category> categoryList = categoryService.getCategoryList();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("lotteryList",lotteryList);
        model.addAttribute("category",getByCategory(cateId));
        User user =toUser();
        model.addAttribute("user",user);
        if (user != null){
            model.addAttribute("RoleName",RoleName(user));
        }
        return "lottery/lotteryShow";
    }

    @RequestMapping(value = "/insertLottery",produces = "text/html;charset=utf8")
    @ResponseBody
    public String insertLottery(Integer id,String name,Integer num){
        if (id != 0){
            lotteryService.insertLottery(id,name,num);
        }
        return flag("false","注册失败");
    }


    @Override
    public String flag(String flag, String msg){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("fl",flag);
        map.put("msg",msg);
        return new Gson().toJson(map);
    }

    /**
     * 查询某类的库存
     * @param id
     * @return
     */
    public Category getByCategory(Integer id){
       Category category = categoryService.getByCategory(id);
        return category;
    }

}
