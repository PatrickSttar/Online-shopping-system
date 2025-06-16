package org.example.trigger.http;

import org.example.api.dto.ProductDTO;
import org.example.api.response.Response;
import org.example.domain.product.model.entity.ProductEntity;
import org.example.domain.product.service.ProductDomainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 18:01
 */

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Resource
    private ProductDomainService productDomainService;

    @GetMapping
    public Response<List<ProductDTO>> queryProductList() {
        try {
            // 1. 调用领域服务查询商品列表
            List<ProductEntity> productEntities = productDomainService.queryProductList();

            // 2. 将实体列表转换为DTO列表
            List<ProductDTO> productDTOS = productEntities.stream()
                    .map(entity -> ProductDTO.builder()
                            .id(entity.getId())
                            .productName(entity.getProductName())
                            .description(entity.getDescription())
                            .price(entity.getPrice())
                            .stock(entity.getStock())
                            .build())
                    .collect(Collectors.toList());

            // 3. 返回成功响应
            return Response.success(productDTOS);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("500", "查询商品列表失败");
        }
    }
}