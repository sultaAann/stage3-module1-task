package com.mjc.school.repository;

import com.mjc.school.repository.impl.Model;

import java.util.List;

public interface ModelDAO {
    List<Model> readAll();

    Model readById(int id);

    Model create(Model model);

    Model update(int id, Model model);

    Boolean deleteById(int id);
}
