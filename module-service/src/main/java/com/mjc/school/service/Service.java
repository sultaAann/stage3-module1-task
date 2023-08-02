package com.mjc.school.service;

import com.mjc.school.service.dto.NewsDTO;
import com.mjc.school.service.exceptions.AuthorIDException;
import com.mjc.school.service.exceptions.NewsIDException;
import com.mjc.school.service.exceptions.TitleOrContentLengthException;

import java.util.List;

public interface Service {
    List<NewsDTO> getAll();
    NewsDTO getById(long id) throws NewsIDException;
    NewsDTO create(String title, String content, long authorID) throws TitleOrContentLengthException, AuthorIDException;
    NewsDTO update(long id, String title, String content, long authorID) throws NewsIDException, TitleOrContentLengthException, AuthorIDException;
    boolean delete(long id) throws NewsIDException;
}
