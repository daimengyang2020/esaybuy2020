package com.buy.dao.product;

import com.buy.entity.EasybuyProductCategory;
import com.buy.entity.EasybuyUser;

import java.util.List;

public interface IProductCategory {
    //查询一级菜单
    List<EasybuyProductCategory> queryAllProductCategory(String parentId);
    int update(EasybuyProductCategory epc);
    int delete(int id);
    int AddEasybuy(EasybuyUser epc);
    boolean Login(String userName,String pwd);
}
