package org.example.domain.product.service;

import org.example.domain.product.adapter.repository.IProductRepository;
import org.example.domain.product.model.entity.ProductEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 17:58
 */

@Service
public class ProductDomainService {

    @Resource
    private IProductRepository productRepository;

    public List<ProductEntity> queryProductList() {
        return productRepository.findAll();
    }

}