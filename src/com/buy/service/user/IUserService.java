package com.buy.service.user;

import com.buy.entity.EasybuyUser;

import java.sql.SQLException;

public interface IUserService {
    EasybuyUser getUserByName(String loginName) throws SQLException, ClassNotFoundException;
}
