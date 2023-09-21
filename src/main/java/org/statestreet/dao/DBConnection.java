package org.statestreet.dao;

import org.statestreet.util.ApplicationPropertyUtil;

import java.sql.*;

public class DBConnection {

    protected static Connection getDbConnection(){
        String url = ApplicationPropertyUtil.getDbUrlFromProperty();
        String user = ApplicationPropertyUtil.getDbUserFromProperty();
        String pwd = ApplicationPropertyUtil.getDbPasswordFromProperty();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void main(String[] args){
        try{
            Connection conn = getDbConnection();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from employee");
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", First: " + rs.getString("firstname"));
                System.out.println(", Last: " + rs.getString("lastname"));
            }} catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
