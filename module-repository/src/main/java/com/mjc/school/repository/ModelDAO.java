package com.mjc.school.repository;

import com.mjc.school.repository.impl.Model;

import java.util.List;

public interface ModelDAO {
    List<Model> readAll();

    Model readById(Long id);

    Model create(Model model);

    Model update(Long id);

    Boolean deleteById(Long id);
}
