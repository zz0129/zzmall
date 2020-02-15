package com.zzmall.service;

import com.github.pagehelper.PageInfo;
import com.zzmall.common.ServerResponse;
import com.zzmall.pojo.Product;
import com.zzmall.vo.ProductDetailVo;

/**
 * Created by zz on 2018/5/11.
 */
public interface IProductService {

    ServerResponse<String> SaveOrUpdateProduct(Product product);

    ServerResponse<String> setSaleStatus(Integer productId, Integer status);

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);

    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductByKeywordCategoryId(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);
}
