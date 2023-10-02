package org.example;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class StatementTest {

    @Test
    void testStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        statement.close();
        connection.close();
    }

    @Test
    void testCreateSqlStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                INSERT INTO register(id, email, password, username)
                VALUES ('p002','andi@gmail.com', 'pw1234', 'andikur')
                """;

        int insert = statement.executeUpdate(sql);
        System.out.println(insert);

        statement.close();
        connection.close();
    }

    @Test
    void testDeleteSqlStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                DELETE FROM register WHERE id = 'p002';
                """;

        int insert = statement.executeUpdate(sql);
        System.out.println(insert);

        statement.close();
        connection.close();
    }

    @Test
    void testSelectSqlStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                SELECT * FROM register
                """;

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            String id = resultSet.getString("id");
            //call kolom hasil join dari table lain
            String email = resultSet.getString("register.email");
            String username = resultSet.getString("username");

            System.out.println(String.join(", ",id, email, username));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    void testInjectSqlLoginStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String username = "ichwan'; #";
        String password = "pw123";

        String sql = "SELECT * FROM register WHERE username = '" + username + "'AND password = '"+password+"'";

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            System.out.println("Login success");
        } else {
            System.out.println("Login failed");
        }

//        while (resultSet.next()){
//            String id = resultSet.getString("id");
//            //call kolom hasil join dari table lain
//            String email = resultSet.getString("register.email");
//
//            System.out.println(String.join(", ",id, email));
//        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    void testPrepareStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        String username = "ichwansh";
        String password = "pw123";

        String sql = "SELECT * FROM register WHERE username = ? AND password = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        //bisa juga untuk executeUpdate()
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Login success");
        } else {
            System.out.println("Login failed");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
