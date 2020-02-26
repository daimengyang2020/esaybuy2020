package com.buy.service.product;

import com.buy.entity.EasybuyProductCategory;
import com.buy.entity.EasybuyUser;

import java.util.List;

public interface IproductCategoryService {
    //查询一级菜单
    List<EasybuyProductCategory> queryAllProductCategory(String parentId);
    boolean update(EasybuyProductCategory epc);
    boolean delete(int id);
    boolean add(EasybuyUser eu);
    boolean login(String name,String pwd);
}
