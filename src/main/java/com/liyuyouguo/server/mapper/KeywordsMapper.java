package com.liyuyouguo.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liyuyouguo.server.entity.shop.Keywords;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author baijianmin
 */
@Repository
public interface KeywordsMapper extends BaseMapper<Keywords> {

}
