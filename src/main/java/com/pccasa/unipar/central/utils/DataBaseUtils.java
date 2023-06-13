package com.pccasa.unipar.central.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseUtils {
     public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/uniparcentral",
                "postgres", "Ai201181");
    }
}
