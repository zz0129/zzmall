package com.zzmall.service;

import com.zzmall.common.ServerResponse;
import com.zzmall.pojo.Category;

import java.util.List;

/**
 * Created by zz on 2018/5/10.
 */
public interface ICategoryService {

    ServerResponse<String> addCategory(String categoryName, Integer parentId);

    ServerResponse<String> updateCategoryName(Integer categoryId, String categoryName);

    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);
}
