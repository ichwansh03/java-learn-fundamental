package org.example.repository;

import org.example.ConnectionUtil;
import org.example.entity.Comments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository {
    @Override
    public void insert(Comments comments) {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
          String sql = "INSERT INTO comments(email, comment) VALUES (?, ?)";
          try(PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
              statement.setString(1, comments.getEmail());
              statement.setString(2, comments.getComment());
              statement.executeUpdate();

              try(ResultSet resultSet = statement.getGeneratedKeys()) {
                  if (resultSet.next())
                      comments.setId(resultSet.getInt(1));
              }
          }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Comments comments) {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "UPDATE comments SET email = ?, comment = ? WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, comments.getEmail());
                statement.setString(2, comments.getComment());
                statement.setInt(3, comments.getId());
                statement.executeUpdate();

                try(ResultSet resultSet = statement.getGeneratedKeys()) {
                    if (resultSet.next())
                        comments.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "DELETE FROM comments WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Comments findById(Integer id) {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM comments WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);

                try(ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Comments(resultSet.getInt("id"),
                                resultSet.getString("email"),
                                resultSet.getString("comment"));
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Comments> findAll() {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM comments";
            try(Statement statement = connection.createStatement()) {
                try(ResultSet resultSet = statement.executeQuery(sql)) {
                    List<Comments> comments = new ArrayList<>();
                    while (resultSet.next()){
                        comments.add(new Comments(
                                resultSet.getInt("id"),
                                resultSet.getString("email"),
                                resultSet.getString("comment")
                        ));
                    }
                    return comments;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Comments> findByEmail(String email) {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM comments WHERE email = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                try(ResultSet resultSet = statement.executeQuery()) {
                    List<Comments> comments = new ArrayList<>();
                    while (resultSet.next()){
                        comments.add(new Comments(
                                resultSet.getInt("id"),
                                resultSet.getString("email"),
                                resultSet.getString("comment")
                        ));
                    }
                    return comments;
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
