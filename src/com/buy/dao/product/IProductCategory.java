package com.buy.dao.product;

import com.buy.entity.EasybuyProductCategory;

import java.util.List;

public interface IProductCategory {
    List<EasybuyProductCategory> queryAllProductCategory(String parentId);
}
