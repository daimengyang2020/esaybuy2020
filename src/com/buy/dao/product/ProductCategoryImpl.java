package com.buy.dao.product;

import com.buy.entity.EasybuyProductCategory;
import com.buy.entity.EasybuyUser;
import com.buy.utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Date: 2020/2/19 10:00
 * @Description:
 */
public class ProductCategoryImpl implements IProductCategory {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    @Override
    public List<EasybuyProductCategory> queryAllProductCategory(String parentId) {
        List<EasybuyProductCategory> productCategories = new ArrayList<EasybuyProductCategory>();
        EasybuyProductCategory productCategory = null;

        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from easybuy_product_category where 1=1");

            //判断parentID的值，如果为0，显示的是一级分类
            if (!"".equals(parentId) && null != parentId) {
                sql.append(" and parentId = ?");
            }

            //获取连接
            conn = DataSourceUtil.getConn();
            pstmt = conn.prepareStatement(sql.toString());
            if (!"".equals(parentId) && null != parentId) {
                pstmt.setObject(1, parentId);
            }

            rs = pstmt.executeQuery();

            //处理结果集
            while (rs.next()) {
                //实例化对象
                productCategory = new EasybuyProductCategory();
                productCategory.setId(rs.getInt(1));
                productCategory.setName(rs.getString(2));
                productCategory.setParentid(rs.getInt(3));
                productCategory.setType(rs.getInt(4));
                productCategory.setIconclass(rs.getString(5));
                //将对象填充到集合中
                productCategories.add(productCategory);
            }
            System.out.println(sql.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return productCategories;
    }

    @Override
    public int update(EasybuyProductCategory epc) {
        String sql="update easybuy_product_category set name=? where id=?";//这里修改一个参数，set name=? 可以修改多个逗号隔开
        Connection conn=DataSourceUtil.getConn();
        int irea=0;
        try {
            PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setString(1,epc.getName());
            pstm.setInt(2,epc.getId());
            irea= pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return irea;
    }

    @Override
    public int delete(int id) {
        String sql="delete from easybuy_product_category where id="+id;
        Connection conn=DataSourceUtil.getConn();
        PreparedStatement pstm=null;
        try {
            pstm=conn.prepareStatement(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            return pstm.executeUpdate();
        } catch (SQLException e) {
            e.getErrorCode();
        }
        return 0;
    }

    @Override
    public int AddEasybuy(EasybuyUser epc) {
        String sql="insert into easybuy_user(loginName,userName,password,sex) values(?,?,?,?)";
        Connection conn=DataSourceUtil.getConn();
        PreparedStatement pstm=null;
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,epc.getLoginname());
            pstm.setString(2,epc.getUsername());
            pstm.setString(3,epc.getPassword());
            pstm.setInt(4,epc.getSex());
            return pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean Login(String userName, String pwd) {
        try {
            StringBuffer sql=new StringBuffer();
            sql.append("select * from easybuy_product_category where LoginName="+userName+" and password="+pwd+"");
            Connection conn=DataSourceUtil.getConn();
            PreparedStatement pstm=conn.prepareStatement(sql.toString());
            ResultSet rs=pstm.executeQuery();
            if (rs.next()){
                return true;
            }
        }catch (Exception e){
        }
        return false;
    }
}
