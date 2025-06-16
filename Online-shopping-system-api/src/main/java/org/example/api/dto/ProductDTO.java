package org.example.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 18:01
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String productName;
    private String description;
    private BigDecimal price;
    private Integer stock;

}