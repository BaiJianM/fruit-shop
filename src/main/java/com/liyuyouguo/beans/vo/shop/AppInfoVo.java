package com.liyuyouguo.beans.vo.shop;

import com.liyuyouguo.entity.fruitshop.Ad;
import com.liyuyouguo.entity.fruitshop.Category;
import com.liyuyouguo.entity.fruitshop.Notice;
import lombok.Data;

import java.util.List;

/**
 * 小程序信息
 *
 * @author baijianmin
 */
@Data
public class AppInfoVo {

    private List<Category> channel;

    private List<Ad> banner;

    private List<Notice> notice;

    private List<CategoryVo> categoryList;

    private Long cartCount;

}
