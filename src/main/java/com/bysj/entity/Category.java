package com.bysj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 彩票列表
 * @author 29029
 * @Version 1.0
 * @Time 15:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {

    /**
     * 类别编号
     */
    private Integer id;

    /**
     * 类别名
     */
    private String categoryName;

    /**
     * 类别描述
     */
    private String categoryDesc;

    /**
     * 彩票总量
     */
    private Integer categoryNum;

}
