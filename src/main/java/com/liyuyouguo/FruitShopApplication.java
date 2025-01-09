package com.liyuyouguo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@SpringBootApplication
@MapperScan("com.liyuyouguo.mapper")
public class FruitShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(FruitShopApplication.class, args);
    }

}
