package com.mjc.school.controller.impl;

import com.mjc.school.controller.Controller;
import com.mjc.school.service.Service;
import com.mjc.school.service.dto.NewsDTO;
import com.mjc.school.service.serviceIMPL.ServiceImpl;

import java.util.List;

public class ControllerImpl implements Controller {
    Service service = new ServiceImpl();
    @Override
    public List<String> getAll() {
        return service.getAll().stream()
                .map(NewsDTO::toString)
                .toList();
    }

    @Override
    public String getById(long id) {
        return service.getById(id).toString();
    }

    @Override
    public String create(String title, String content, long authorID) {
        return service.create(title, content, authorID).toString();
    }

    @Override
    public String update(long id, String title, String content, long authorID) {
        return service.update(id, title, content, authorID).toString();
    }

    @Override
    public boolean delete(long id) {
        return service.delete(id);
    }
}
