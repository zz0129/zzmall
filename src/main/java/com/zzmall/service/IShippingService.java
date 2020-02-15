package com.zzmall.service;

import com.github.pagehelper.PageInfo;
import com.zzmall.common.ServerResponse;
import com.zzmall.pojo.Shipping;

/**
 * Created by zz on 2018/5/14.
 */
public interface IShippingService {

    ServerResponse add(Integer userId, Shipping shipping);

    ServerResponse<String> delete(Integer userId, Integer shippingId);

    ServerResponse<String> update(Integer userId, Shipping shipping);

    ServerResponse<Shipping> select(Integer userId, Integer shippingId);

    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);
}
