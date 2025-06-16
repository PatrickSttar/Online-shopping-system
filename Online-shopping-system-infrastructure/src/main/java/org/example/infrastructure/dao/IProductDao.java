package org.example.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.dao.po.ProductPO;

import java.util.List;

/**
 * @author zhangwenhao
 * @description
 * @create 2025/6/16 17:56
 */

@Mapper
public interface IProductDao {

    /**
     * 查询所有商品列表
     * @return 商品PO列表
     */
    List<ProductPO> queryProductList();

}