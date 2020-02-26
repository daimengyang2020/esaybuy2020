package com.buy.test;


import com.buy.dao.user.EasybuyUserImpl;
import com.buy.entity.EasybuyUser;

import java.sql.SQLException;

public class tasttablet {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        EasybuyUserImpl user=new EasybuyUserImpl();
        EasybuyUser u=user.getUserByLoginName("admin");
        System.out.println(u.getPassword());
    }
}
