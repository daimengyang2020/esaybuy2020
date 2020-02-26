package com.buy.dao.user;

import com.buy.entity.EasybuyUser;

import java.sql.SQLException;

public interface IUser {
    EasybuyUser getUserByLoginName(String loginName) throws SQLException, ClassNotFoundException;
}