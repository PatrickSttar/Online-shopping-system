package org.example.domain.product.adapter.repository;

import org.example.domain.product.model.entity.ProductEntity;

import java.util.List;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 17:57
 */

public interface IProductRepository {

    /**
     * 查询所有商品实体列表
     *
     * @return 商品实体列表
     */
    List<ProductEntity> findAll();

}