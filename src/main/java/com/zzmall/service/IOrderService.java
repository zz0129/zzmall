package com.zzmall.service;

import com.github.pagehelper.PageInfo;
import com.zzmall.common.ServerResponse;
import com.zzmall.pojo.PayInfo;
import com.zzmall.vo.OrderVo;

import java.util.Map;

/**
 * Created by zz on 2018/5/17.
 */
public interface IOrderService{

    ServerResponse pay(Long orderNo, Integer userId, String path);

    ServerResponse aliCallback(Map<String,String> params);

    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);

    ServerResponse createOrder(Integer userId, Integer shippingId);

    ServerResponse cancel(Integer userId, Long orderNo);

    ServerResponse getOrderCartProduct(Integer userId);

    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);

    ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);

    ServerResponse<PageInfo> manageList(int pageNum, int pageSize);

    ServerResponse<OrderVo> manageDetail(Long orderNO);

    ServerResponse<PageInfo> manageSearch(Long orderNO, int pageNum, int pageSize);

    ServerResponse<String> manageSendGoods(Long orderNo);
}
