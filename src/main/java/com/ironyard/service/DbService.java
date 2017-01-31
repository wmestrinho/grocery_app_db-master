package com.ironyard.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by WagnerMestrinho on 1/31/17.
 */
public class DbService {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "2abetterlife";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void truncate(String tablename){
        try {
            Connection con = this.getConnection();
            Statement s = con.createStatement();
            s.execute("TRUNCATE "+tablename);
        }catch(Throwable t){
            t.printStackTrace();
        }

    }

}

