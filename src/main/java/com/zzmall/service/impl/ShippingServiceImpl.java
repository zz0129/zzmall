package com.zzmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.zzmall.common.ServerResponse;
import com.zzmall.dao.ShippingMapper;
import com.zzmall.pojo.Shipping;
import com.zzmall.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zz on 2018/5/14.
 */

@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    public ServerResponse add(Integer userId, Shipping shipping){
        shipping.setUserId(userId);
        int resultCount = shippingMapper.insert(shipping);
        if(resultCount>0){
            Map result = Maps.newHashMap();
            result.put("shippingId",shipping.getId());
            return ServerResponse.createBySuccess("新建地址成功",result);
        }
        return ServerResponse.createByError("新建地址失败");
    }

    /**
     * 防止横向越权，如果用户没有办法和所删除物品进行连接
     * 则很容易产生横向越权
     * @param userId
     * @param shippingId
     * @return
     */
    public ServerResponse<String> delete(Integer userId, Integer shippingId){
        int resultCount = shippingMapper.deleteByUserIdShippingId(userId, shippingId);
        if(resultCount>0){
            return ServerResponse.createBySuccess("删除地址成功");
        }
        return ServerResponse.createByError("删除地址失败");
    }

    /**
     * 横向越权问题
     * 修改的sql语句当中一定要判断，是不是修改的当前用户的地址,userId不能被更新
     * 先setUserId
     * @param userId
     * @param shipping
     * @return
     */
    public ServerResponse<String> update(Integer userId, Shipping shipping){
        //保证userId不被更新
        shipping.setUserId(userId);
        int resultCount = shippingMapper.updateByShipping(shipping);
        if(resultCount>0){
            return ServerResponse.createBySuccess("更新地址成功");
        }
        return ServerResponse.createByError("更新地址失败");
    }

    public ServerResponse<Shipping> select(Integer userId, Integer shippingId){
        Shipping shipping = shippingMapper.selectByShippingIdUserId(userId, shippingId);
        if(shipping == null){
            return ServerResponse.createByError("未找到该地址");
        }
        return ServerResponse.createBySuccess("查找地址成功",shipping);
    }

    public ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Shipping> shippingList = shippingMapper.selectByUserId(userId);
        PageInfo pageInfo = new PageInfo(shippingList);
        return ServerResponse.createBySuccess(pageInfo);
    }

}
