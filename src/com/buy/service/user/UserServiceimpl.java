package com.buy.service.user;


import com.buy.dao.user.EasybuyUserImpl;
import com.buy.dao.user.IUser;
import com.buy.entity.EasybuyUser;

import java.sql.SQLException;

public class UserServiceimpl implements IUserService {
    IUser uDao=new EasybuyUserImpl();
    @Override
    public EasybuyUser getUserByName(String loginName) throws SQLException, ClassNotFoundException {
        return uDao.getUserByLoginName("loginName");
    }
}