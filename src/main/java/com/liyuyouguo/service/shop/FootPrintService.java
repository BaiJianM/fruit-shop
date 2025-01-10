package com.liyuyouguo.service.shop;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liyuyouguo.entity.fruitshop.FootPrint;
import com.liyuyouguo.mapper.FootPrintMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 用户足迹服务类
 *
 * @author baijianmin
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FootPrintService extends ServiceImpl<FootPrintMapper, FootPrint> implements IService<FootPrint> {

    private final FootPrintMapper footPrintMapper;

    /**
     * 新增或更新用户足迹
     *
     * @param userId  用户id
     * @param goodsId 商品id
     */
    public void saveFootPrint(Integer userId, Integer goodsId) {
        if (userId > 0 && goodsId > 0) {
            FootPrint footPrint = footPrintMapper.selectOne(Wrappers.lambdaQuery(FootPrint.class)
                    .eq(FootPrint::getUserId, userId)
                    .eq(FootPrint::getGoodsId, goodsId));
            if (footPrint == null) {
                FootPrint newFootPrint = new FootPrint();
                newFootPrint.setUserId(userId);
                newFootPrint.setGoodsId(goodsId);
                newFootPrint.setAddTime(LocalDateTime.now());
            } else {
                footPrint.setAddTime(LocalDateTime.now());
            }
            this.saveOrUpdate(footPrint);
        }

    }

}
