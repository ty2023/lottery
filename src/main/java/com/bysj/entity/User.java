package com.bysj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 29029
 * @Version 1.0
 * @Time 21:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Integer id;

    private String username;

    private String trueName;

    private Integer sex;

    private Integer age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String password;

    private String email;

    private String phone;

    private String qq;

    private String address;

    private Integer userRole;

}
