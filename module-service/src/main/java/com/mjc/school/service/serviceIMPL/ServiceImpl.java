package com.mjc.school.service.serviceIMPL;

import com.mjc.school.repository.DAOImpl.NewsDAOImpl;
import com.mjc.school.repository.NewsDAO;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.ModelMapper;
import com.mjc.school.service.Service;
import com.mjc.school.service.dto.NewsDTO;

import java.util.List;

public class ServiceImpl implements Service {
    NewsDAO<NewsModel> newsDAO = new NewsDAOImpl();
    @Override
    public List<NewsDTO> getAll() {
        return newsDAO.getAll().stream()
                /*.map(ModelMapper.INSTANCE::newsToNewsDTO)*/
                .map(newsModel -> ModelMapper.INSTANCE.newsToNewsDTO(newsModel))
                .toList();
    }

    @Override
    public NewsDTO getById(long id) {
        return ModelMapper.INSTANCE.newsToNewsDTO(newsDAO.getById(id));
    }

    @Override
    public NewsDTO create(NewsModel newsModel) {
        return ModelMapper.INSTANCE.newsToNewsDTO(newsModel);
    }

    @Override
    public NewsDTO update(NewsModel newsModel) {
        return ModelMapper.INSTANCE.newsToNewsDTO(newsModel);
    }

    @Override
    public boolean delete(long id) {
        return newsDAO.delete(id);
    }
}
