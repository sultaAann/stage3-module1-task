package com.mjc.school;


import com.mjc.school.repository.Database.DataSource;
import com.mjc.school.service.Service;
import com.mjc.school.service.dto.NewsDTO;
import com.mjc.school.service.exceptions.AuthorIDException;
import com.mjc.school.service.exceptions.NewsIDException;
import com.mjc.school.service.exceptions.TitleOrContentLengthException;
import com.mjc.school.service.serviceIMPL.ServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.List;


public class ServiceImplTest {
    DataSource db = DataSource.getInstance();
    Service service = new ServiceImpl();

    @Test
    public void getByIdTest() throws NewsIDException, AuthorIDException, TitleOrContentLengthException {
        service.create("AAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAA", 2);
        NewsDTO res = service.getById(1);
        String title = "AAAAAAAAAAA";
        String content = "AAAAAAAAAAAAAAAAAAAA";

        Assertions.assertEquals(title, res.getTitle());
        Assertions.assertEquals(content, res.getContent());
    }

    @Test
    public void createTest() throws AuthorIDException, TitleOrContentLengthException {
        int size = service.getAll().size();
        service.create("AAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAA", 2);

        Assertions.assertEquals(size + 1, service.getAll().size());
    }

    @Test
    public void update() throws NewsIDException, AuthorIDException, TitleOrContentLengthException {
        service.create("AAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAA", 2);
        int id = service.getAll().size();
        service.update(id, "title", "content", 1);

        Assertions.assertEquals("title", service.getById(id).getTitle());
        Assertions.assertEquals("content", service.getById(id).getContent());
        Assertions.assertEquals(1, service.getById(id).getAuthorID());
    }

    @Test
    public void deleteTest() throws NewsIDException, AuthorIDException, TitleOrContentLengthException {
        service.create("AAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAA", 2);
        int size = service.getAll().size();
        service.delete(1);

        Assertions.assertEquals(size - 1, service.getAll().size());
    }
}
