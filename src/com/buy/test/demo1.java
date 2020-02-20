package com.buy.test;


import com.buy.dao.product.IProductCategory;
import com.buy.dao.product.ProductCategoryImpl;
import com.buy.entity.EasybuyProductCategory;
import com.buy.service.product.IproductCategoryService;
import com.buy.service.product.ProductCategoryServiceimpl;

import java.util.List;

public class demo1 {
    public static void main(String[] args) {
        IproductCategoryService service=new ProductCategoryServiceimpl();
        List<EasybuyProductCategory> productCategories=service.queryAllProductCategory("0");
        for (EasybuyProductCategory category:productCategories){
            System.out.println(category.getName());
        }
    }
}
