package com.bysj.service;

import com.bysj.entity.Lottery;

import java.util.List;

/**
 * @author 29029
 */
public interface LotteryService {
    /**
     * 查询某个类别下面的彩票
     * @param cateId
     * @return
     */
    List<Lottery> getLotteryList(Integer cateId);

    Integer insertLottery(Integer id, String name, Integer num);

}
