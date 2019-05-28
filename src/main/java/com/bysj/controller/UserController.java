package com.bysj.controller;

import com.bysj.entity.User;
import com.bysj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 29029
 * @Version 1.0
 * @Time 9:46
 */
@Controller
@RequestMapping("user")
public class UserController extends IndexController{

    @Autowired
    private UserService userService;

    /**
     *  检查用户原密码是否正确
     * @param id
     * @param password
     * @return
     */
    @RequestMapping(value = "/getByUserPass",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getByUserPass(Integer id,String password){
        User byUserId = userService.getByUserId(id);
        if (byUserId.getPassword().equals(password)){
            return flag("true","原密码正确");
        }
        return flag("false","原密码错误请重新输入");
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUserPass",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String updateUserPass(User user){
        Integer byUserId = userService.updatePassword(user);
        if (byUserId >0){
            return flag("true","修改成功，即将返回登录页");
        }
        return flag("false","修改失败");
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteUser",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String deleteUser(Integer id){
        Integer integer = userService.deleteUser(id);
        if (integer >0){
            return flag("true","删除成功");
        }
        return flag("false","删除失败");
    }

    @RequestMapping("/getUserPage")
    public String getUserList(Model model){
        List<User> userList =userService.getUserList();
        User user = toUser();
        model.addAttribute("userList",userList);
        if (user != null){
            model.addAttribute("user",user);
            model.addAttribute("RoleName",RoleName(user));
        }
        model.addAttribute("categoryList",list());
        return "user/userShow";
    }

    /**
     * ajax：登录方法
     * @param username
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "/toLogin",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String toLogin(String username, String password, HttpServletRequest request){
        User user = userService.toLogin(username, password);
        if (user != null){
            request.getSession().setAttribute("LOGIN_USER",user);
            return flag("true","登录成功，即将进入首页");
        }
        return flag("false","登录失败，请检查您的用户名密码");
    }

    /**
     * ajax：注册方法
     * @param user
     * @return
     */
    @RequestMapping(value = "/toRegister",produces="text/html;charset=utf8")
    @ResponseBody
    public String toRegister(User user){
        Integer integer = userService.insertUser(user);
        if (integer > 0){
            return flag("true","注册账号成功");
        }
        return flag("false","注册账号失败，请检查您输入的信息是否全部正确");
    }

    /**
     * 用户名唯一
     * @param username
     * @return
     */
    @RequestMapping(value = "/getByUserName",produces="text/html;charset=utf8")
    @ResponseBody
    public String getByUserName(String username){
        User user = userService.getByUserName(username);
        if (user == null){
            return flag("true","用户名可用");
        }
        return flag("false","用户名已存在");
    }

    /**
     * 邮箱唯一
     * @param email
     * @return
     */
    @RequestMapping(value = "/getByEmail",produces="text/html;charset=utf8")
    @ResponseBody
    public String getByEmail(String email){
        User user = userService.getByEmail(email);
        if (user == null){
            return flag("true","邮箱可用");
        }
        return flag("false","邮箱已存在请重新输入");
    }

    /**
     * 电话唯一
     * @param phone
     * @return
     */
    @RequestMapping(value = "/getByPhone",produces="text/html;charset=utf8")
    @ResponseBody
    public String getByPhone(String phone){
        User user = userService.getByPhone(phone);
        if (user == null){
            return flag("true","联系方式可用");
        }
        return flag("false","联系方式已存在请重新输入");
    }


    /**
     * 查询该用用户密码
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/getByUserPassId")
    public String getByUserPassId(Integer id, Model model){
        User byUserId = userService.getByUserId(id);
        model.addAttribute("user",byUserId);
        if (byUserId != null){
            model.addAttribute("RoleName",RoleName(byUserId));
        }
        model.addAttribute("categoryList",list());
        return "user/updateUserPass";
    }


    /**
     * 查询用户信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/getByUserId")
    public String getByUserId(Integer id, Model model){
        User byUserId = userService.getByUserId(id);
        model.addAttribute("user",byUserId);
        User user = toUser();
        if (user != null){
            model.addAttribute("login_user",user);
            model.addAttribute("RoleName",RoleName(byUserId));
        }
        model.addAttribute("categoryList",list());
        return "user/updateUser";
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUser",produces="text/html;charset=utf8")
    @ResponseBody
    public String updateUser(User user){
        Integer integer = userService.updateUser(user);
        if (integer > 0){
            return flag("true","修改成功");
        }
        return flag("false","修改失败");
    }

    @RequestMapping("/addUser")
    public String addUser(Model model){
        User user = toUser();
        if (user != null){
            model.addAttribute("login_user",user);
            model.addAttribute("RoleName",RoleName(user));
        }
        model.addAttribute("categoryList",list());
        return "user/userAdd";
    }



}
