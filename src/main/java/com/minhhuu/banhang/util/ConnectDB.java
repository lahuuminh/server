package com.minhhuu.banhang.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection con(){
        try {

            return DriverManager.getConnection("jdbc:mysql://mysqldb:3306/banhang", "root", "test");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
