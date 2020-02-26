package com.buy.service.product;

import com.buy.dao.product.IProductCategory;
import com.buy.dao.product.ProductCategoryImpl;
import com.buy.entity.EasybuyProductCategory;
import com.buy.entity.EasybuyUser;

import java.util.List;

public class ProductCategoryServiceimpl implements IproductCategoryService {
    private IProductCategory productCategory=new ProductCategoryImpl();
    @Override
    public List<EasybuyProductCategory> queryAllProductCategory(String parentId) {
        parentId="0";
        return productCategory.queryAllProductCategory(parentId);
    }

    @Override
    public boolean update(EasybuyProductCategory epc) {
        return productCategory.update(epc)>0?true:false;
    }

    @Override
    public boolean delete(int id) {
        return productCategory.delete(id)>0?true:false;
    }

    @Override
    public boolean add(EasybuyUser eu) {
        return productCategory.AddEasybuy(eu)>0?true:false;
    }

    @Override
    public boolean login(String name, String pwd) {
        return productCategory.Login(name,pwd);
    }
}
