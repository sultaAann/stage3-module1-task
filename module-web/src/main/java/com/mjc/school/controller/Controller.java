package com.mjc.school.controller;


import com.mjc.school.service.exceptions.AuthorIDException;
import com.mjc.school.service.exceptions.NewsIDException;
import com.mjc.school.service.exceptions.TitleOrContentLengthException;

import java.util.List;

public interface Controller {
    List<String> getAll();
    String getById(long id) throws NewsIDException;
    String create(String title, String content, long authorID) throws AuthorIDException, TitleOrContentLengthException;
    String update(long id, String title, String content, long authorID) throws AuthorIDException, NewsIDException, TitleOrContentLengthException;
    boolean delete(long id) throws NewsIDException;
}
