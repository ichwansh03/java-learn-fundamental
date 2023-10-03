package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchTest {

    @Test
    void testBatchStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO comments(email, comment) VALUES ('ichwan@gmail.com', 'hello world')";

        for (int i = 0; i < 100; i++) {
            statement.addBatch(sql);
        }

        statement.executeBatch();

        statement.close();
        connection.close();
    }

    @Test
    void testBatchPreparedStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO comments(email, comment) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        for (int i = 0; i < 100; i++) {
            //hapus data sebelumnya
            statement.clearParameters();
            statement.setString(1,"ichwan@test.com");
            statement.setString(2,"halo!");
            statement.addBatch();
        }

        statement.executeBatch();

        statement.close();
        connection.close();
    }
}
