package com.mjc.school.repository.impl;

import com.mjc.school.repository.DBEmulation;
import com.mjc.school.repository.ModelDAO;

import java.util.List;

public class ModelDAOImpl implements ModelDAO {
    DBEmulation dbEmulation = DBEmulation.getInstance();

    @Override
    public List<Model> readAll() {
        return dbEmulation.readAll();
    }

    @Override
    public Model readById(Long id) {
        return dbEmulation.readById(id);
    }

    @Override
    public Model create(Model model) {
        return dbEmulation.create(model);
    }

    @Override
    public Model update(Long id) {
        return dbEmulation.update(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        return dbEmulation.delete(id);
    }
}
