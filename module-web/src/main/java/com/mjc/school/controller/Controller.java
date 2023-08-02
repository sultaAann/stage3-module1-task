package com.mjc.school.controller;


import java.util.List;

public interface Controller {
    List<String> getAll();
    String getById(long id);
    String create(String title, String content, long authorID);
    String update(long id, String title, String content, long authorID);
    boolean delete(long id);
}
