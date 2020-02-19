package com.buy.test;


import com.buy.dao.product.IProductCategory;
import com.buy.dao.product.ProductCategoryImpl;
import com.buy.entity.EasybuyProductCategory;

import java.util.List;

public class demo1 {
    public static void main(String[] args) {
        IProductCategory productCategorg=new ProductCategoryImpl();
        List<EasybuyProductCategory> productCategories=productCategorg.queryAllProductCategory("0");
        for (EasybuyProductCategory category:productCategories){
            System.out.println(category.getName());
        }
    }
}
