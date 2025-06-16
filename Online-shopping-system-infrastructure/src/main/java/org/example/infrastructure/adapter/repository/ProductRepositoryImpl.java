package org.example.infrastructure.adapter.repository;

import org.example.domain.product.adapter.repository.IProductRepository;
import org.example.domain.product.model.entity.ProductEntity;
import org.example.infrastructure.dao.IProductDao;
import org.example.infrastructure.dao.po.ProductPO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 18:00
 */

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    @Resource
    private IProductDao productDao;

    @Override
    public List<ProductEntity> findAll() {
        List<ProductPO> productPOList = productDao.queryProductList();
        // 使用Stream API将PO列表转换为Entity列表
        return productPOList.stream()
                .map(po -> ProductEntity.builder()
                        .id(po.getId())
                        .productName(po.getProductName())
                        .description(po.getDescription())
                        .price(po.getPrice())
                        .stock(po.getStock())
                        .build())
                .collect(Collectors.toList());
    }
}
