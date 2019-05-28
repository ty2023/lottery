package com.bysj.service.impl;

import com.bysj.dao.LotteryMapper;
import com.bysj.entity.Lottery;
import com.bysj.service.CategoryService;
import com.bysj.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryServiceImpl implements LotteryService {

    @Autowired
    private LotteryMapper lotteryMapper;

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询某类下的所有彩票
     * @param cateId
     * @return
     */
    @Override
    public List<Lottery> getLotteryList(Integer cateId) {
        return lotteryMapper.getLotteryList(cateId);
    }

    @Override
    public Integer insertLottery(Integer id, String name, Integer num) {
        Integer integer = lotteryMapper.insertLottery(id, name, num);
        categoryService.updatenum(id,num);
        return integer;
    }
}
