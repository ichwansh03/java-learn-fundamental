package org.example.repository;

import org.example.entity.Comments;

import java.util.List;

public interface CommentRepository {

    void insert(Comments comments);

    void update(Comments comments);

    void delete(Integer id);

    Comments findById(Integer id);

    List<Comments> findAll();

    List<Comments> findByEmail(String email);
}
