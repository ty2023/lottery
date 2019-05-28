package com.bysj.dao;

import com.bysj.entity.Lottery;

import java.util.List;

/**
 * @author 29029
 * @Version 1.0
 * @Time 16:00
 */
public interface LotteryMapper {

    /**
     * 查询某个类别下面的彩票
     * @param cateId
     * @return
     */
    List<Lottery> getLotteryList(Integer cateId);

    Integer insertLottery(Integer id, String name, Integer num);
}
