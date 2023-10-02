package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {

    @Test
    void testHikariConfig() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
    }
}
