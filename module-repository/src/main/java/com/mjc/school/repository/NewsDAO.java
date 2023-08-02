package com.mjc.school.repository;

import java.util.List;

public interface NewsDAO<T> {
    List<T> readAll();
    T readById(Long id);
    T create(T t);
    T update(T t);
    Boolean delete(Long id);
}
