package com.buy.dao.product;

import com.buy.entity.EasybuyProductCategory;

import java.util.List;

public interface IProductCategory {
    //查询一级菜单
    List<EasybuyProductCategory> queryAllProductCategory(String parentId);
}
