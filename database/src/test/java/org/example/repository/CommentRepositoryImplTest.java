package org.example.repository;

import org.example.entity.Comments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class CommentRepositoryImplTest {

    private CommentRepository repository;

    @BeforeEach
    void setUp(){
        repository = new CommentRepositoryImpl();
    }

    @Test
    void testInsert(){
        Comments comments = new Comments("abdul@test.com","hi");
        repository.insert(comments);

        Assertions.assertNotNull(comments.getId());
        System.out.println(comments.getId());
    }

    @Test
    void testGetId(){
        Comments comments = repository.findById(202);
        Assertions.assertNotNull(comments);
        System.out.println(comments.getId());

        Comments notFound = repository.findById(10);
        Assertions.assertNull(notFound);
    }

    @Test
    void testGetAll(){
        List<Comments> comments = repository.findAll();
        System.out.println(comments.size());
        System.out.println(comments);
    }

    @Test
    void testGetByEmail(){
        List<Comments> comments = repository.findByEmail("ujang@test.com");
        System.out.println(comments.size());
    }

    @Test
    void testUpdate(){
        Comments comments = new Comments(202, "abdullah@test.com","hallo");
        repository.update(comments);

        Assertions.assertNotNull(comments.getId());
    }

    @Test
    void testDelete(){
        repository.delete(202);
    }
}