package com.buy.service.product;

import com.buy.entity.EasybuyProductCategory;

import java.util.List;

public interface IproductCategoryService {
    //查询一级菜单
    List<EasybuyProductCategory> queryAllProductCategory(String parentId);
}
