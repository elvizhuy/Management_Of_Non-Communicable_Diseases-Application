package com.devteam.management_of_noncommunicable_diseases.Controller;

import java.sql.*;

public class DBConnection {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mon_cda";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "Huynn@0908";

    private static Connection connection = null;

    public static Connection open() {
        System.out.println("Connecting database.......");
        try {
            System.out.println("Database connected!");
            return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (java.sql.SQLException e) {
            System.out.println("Cannot connect the database!");
            return null;
        }
    }

    public static void closeAll(Connection con, PreparedStatement stm, ResultSet rs) throws java.sql.SQLException {
        if (rs != null) {
            try {
                rs.close();
            } catch (java.sql.SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (stm != null) {
            try {
                stm.close();
            } catch (java.sql.SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (java.sql.SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static ResultSet dbPrepareStatementAndExecuteQuery(String queryStmt, String name, String id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            open();
            preparedStatement = connection.prepareStatement(queryStmt);
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, id);
            resultSet = preparedStatement.executeQuery();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            closeAll(connection, preparedStatement, resultSet);
        }
        return resultSet;
    }

    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        Statement stmt;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.open();
            System.out.println("Select statement: " + queryStmt + "\n");
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(queryStmt);
        } catch (SQLException e) {
            System.out.println("Lỗi khi thực thi lệnh : " + e);
            throw e;
        }
        return resultSet;
    }

    //DB Execute Update (For Update/Insert/Delete) Operation
    public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        try {
            open();
            stmt = connection.createStatement();
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("Lỗi khi thực thi lệnh : " + e);
            throw e;
        }
    }

    public static ResultSet dbPrepareStatementAndExecuteQueryForPeople (String queryStmt, String phone_number, String idNumber) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            open();
            preparedStatement = connection.prepareStatement(queryStmt);
            preparedStatement.setString(1, phone_number);
            preparedStatement.setString(2, idNumber);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
}