package com.mjc.school.repository;

import java.util.List;

public interface NewsDAO<T> {
    List<T> getAll();
    T getById(long id);
    T create(T t);
    T update(T t);
    boolean delete(long id);
}