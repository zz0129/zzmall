package com.zzmall.service;

import com.zzmall.common.ServerResponse;
import com.zzmall.vo.CartVo;

/**
 * Created by zz on 2018/5/13.
 */
public interface ICartService {

    ServerResponse<CartVo> add(Integer uerId, Integer productId, Integer count);

    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVo> delete(Integer userId, String productIds);

    ServerResponse<CartVo> list(Integer userId);

    ServerResponse<CartVo> selectOrUnSelect(Integer userId,Integer productId, Integer checked);

    ServerResponse<Integer> getCartProductCount(Integer userId);
}
