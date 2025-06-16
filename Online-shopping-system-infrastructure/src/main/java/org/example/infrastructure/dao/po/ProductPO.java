package org.example.infrastructure.dao.po;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 17:53
 */

@Data
public class ProductPO {

    /**
     * 自增ID
     */
    private Long id;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 库存数量
     */
    private Integer stock;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}