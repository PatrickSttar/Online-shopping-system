package org.example.domain.product.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 17:58
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    private Long id;
    private String productName;
    private String description;
    private BigDecimal price;
    private Integer stock;

}