package com.bysj.lottery;

import com.bysj.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LotteryApplicationTests {


    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @Test
    public void contextLoads() {

        String path1 = Thread.currentThread().getContextClassLoader().getResource("").getPath();//获取当前资源的虚拟路径

        System.out.println(path1);

        String currentProjectName= this.request.getContextPath();//获取当前项目名称

        System.out.println(currentProjectName);

        System.out.println(this.request.getContextPath());




    }

}
