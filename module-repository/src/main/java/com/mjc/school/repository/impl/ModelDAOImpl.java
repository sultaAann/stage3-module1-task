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
    public Model readById(int id) {
        return dbEmulation.readById(id);
    }

    @Override
    public Model create(Model model) {
        return dbEmulation.create(model);
    }

    @Override
    public Model update(int id, Model model) {
        return dbEmulation.update(id, model);
    }

    @Override
    public Boolean deleteById(int id) {
        return dbEmulation.delete(id);
    }
}
