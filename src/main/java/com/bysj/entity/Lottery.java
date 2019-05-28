package com.bysj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 彩票表
 * @author 29029
 * @Version 1.0
 * @Time 15:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lottery {
    /**
     * 彩票编号
     */
    private Integer id;

    /**
     *彩票名字
     */
    private String lotteryName;

    /**
     * 彩票价格
     */
    private Double price;

    /**
     * 该彩票的库存
     */
    private Integer lotteryNum;

    /**
     * 彩票的图片
     */
    private String img;

    /**
     * 所属类别信息
     */
    private Integer cateId;
    private String cateName;
    private String categoryDesc;

    /**
     * 彩票描述
     */
    private String desc;

    /**
     * 添加时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

}
