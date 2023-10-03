package org.example;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class SampleTimeTest {

    @Test
    void testSampleTime() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO sample_times(sample_time, sample_date, sample_timestamp) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setTime(1, new Time(System.currentTimeMillis()));
        statement.setDate(2, new Date(System.currentTimeMillis()));
        statement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    @Test
    void testShowDataTime() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "SELECT * FROM sample_times";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            Time time = resultSet.getTime("sample_time");
            System.out.println(time);
            Date date = resultSet.getDate("sample_date");
            System.out.println(date);
            Timestamp timestamp = resultSet.getTimestamp("sample_timestamp");
            System.out.println(timestamp);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
