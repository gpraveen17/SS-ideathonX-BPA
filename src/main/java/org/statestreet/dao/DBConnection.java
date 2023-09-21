package org.statestreet.dao;

import org.statestreet.util.ApplicationPropertyUtil;

import java.sql.*;

public class DBConnection {

    protected static Connection getDbConnection() {
        String url = ApplicationPropertyUtil.getDbUrlFromProperty();
        String user = ApplicationPropertyUtil.getDbUserFromProperty();
        String pwd = ApplicationPropertyUtil.getDbPasswordFromProperty();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void main(String[] args) {
        try {
            ;
            ResultSet rs = getQueryData("select * from employee");
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", First: " + rs.getString("firstname"));
                System.out.println(", Last: " + rs.getString("lastname"));
            }
            executeUpdateQuery("delete from employee");
            executeUpdateQuery("Insert into employee values(2,33,'Shweta','Khatri')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet getQueryData(String query) {
        try {
            Connection conn = getDbConnection();

            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int executeUpdateQuery(String query) {
        try {
            Connection conn = getDbConnection();

            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
