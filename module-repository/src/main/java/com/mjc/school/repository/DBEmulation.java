package com.mjc.school.repository;

import com.mjc.school.repository.impl.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DBEmulation {
    private static DBEmulation INSTANCE;
    private List<Model> models = new ArrayList<>();

    public List<Model> readAll() {
        return models;
    }

    public Model readById(int id) {
        return models.get(id);
    }

    public Model create(Model aModel) {
        aModel.setId(models.size() + 1);
        models.add(aModel);
        return aModel;
    }

    public Model update(int id, Model aModel) {
        aModel.setLastUpdateDate(LocalDateTime.now());
        models.add(id, aModel);
        return aModel;
    }

    public Boolean delete(int id) {
        int newsLength = models.size();
        models.remove(id);
        if (models.size() < newsLength) {
            return true;
        }
        return false;
    }

    private DBEmulation() {
    }

    public static DBEmulation getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new DBEmulation();
        }

        return INSTANCE;
    }
}
