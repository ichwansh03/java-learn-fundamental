package org.example.repository;

import org.example.entity.Comments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class CommentRepositoryImplTest {

    private CommentRepository repository;

    @Mock(lenient = true)
    private CommentRepository repositoryMock;

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
        Mockito.when(repositoryMock.findById(203)).thenReturn(new Comments(203, "ichwan@test.com","hi"));
        Comments comments = repository.findById(203);
        Assertions.assertNotNull(comments);
        System.out.println(comments.getId());

        Comments notFound = repository.findById(10);
        Assertions.assertNull(notFound);
        Mockito.verify(repositoryMock, Mockito.times(0)).findById(203);
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