package com.bysj.controller;

import com.bysj.entity.Category;
import com.bysj.entity.User;
import com.bysj.service.CategoryService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 29029
 * @Version 1.0
 * @Time 17:06
 */
@Controller
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String index(Model model){
        User user =toUser();
        model.addAttribute("user",user);
        if (user != null){
            model.addAttribute("RoleName",RoleName(user));
        }
        model.addAttribute("categoryList",list());
        return "index";
    }

    public User toUser(){ HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
       return (User) request.getSession().getAttribute("LOGIN_USER");
    }


    public List<Category> list() {
       return categoryService.getCategoryList();
    }

    public String RoleName(User user){
        if (user.getUserRole() == 2){
            return "超级管理员";
        } else if (user.getUserRole() == 1) {
            return "管理员";
        }else if (user.getUserRole() == 0){
            return "普通用户";
        }
        return "";
    }

    @RequestMapping("/{page}")
    public String toPage(@PathVariable("page") String page){
        return page;
    }

    /**
     * 退出系统
     * @param session
     * @return
     */
    @RequestMapping("/toLogout")
    public String toLogout(HttpSession session){
        session.removeAttribute("LOGIN_USER");
        return "login";
    }

    public String flag(String flag,String msg){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("fl",flag);
        map.put("msg",msg);
        return new Gson().toJson(map);
    }

    @RequestMapping("/upload")
    public String upload(String file){
        System.out.println(file);
        return null;
    }
}
