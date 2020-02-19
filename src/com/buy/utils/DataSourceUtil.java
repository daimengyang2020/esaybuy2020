package com.buy.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceUtil {
    private static final  String driver="com.mysql.jdbc.Driver";
    private static final  String url="jdbc:mysql://localhost:3306/easybuy";
    private static final  String user="root";
    private static final  String pwd="1234";
    private static DruidDataSource druidDataSource=null;
    static{
        try {
            init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //创建数据源对象

    public static void init() throws SQLException {
        druidDataSource = new DruidDataSource();
        //设置druid数据源对象的属性
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        //设置连接池相关属性
        druidDataSource.setInitialSize(5);//初始化连接池数量
        druidDataSource.setMaxActive(100);//最大连接数
        druidDataSource.setMinIdle(1);//最大空闲连接数
        druidDataSource.setMaxWait(1000);//连接等待时长，单位：毫秒
        druidDataSource.setFilters("stat");//设置监控
    }
    //创建一个连接的方法
    //返回连接对象
    public static Connection getconn(){
        Connection conn=null;
        //加载mysql驱动
        try {
            Class.forName(driver);
            //如果数据库没有连接则创建连接
            if(conn==null){
                conn=druidDataSource.getConnection(user,pwd);
                System.out.println("数据库连接成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //关闭连接的方法
    public static void closeConnection(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
