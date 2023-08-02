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
                .map(ModelMapper.INSTANCE::newsToNewsDTO)
                .toList();
    }

    @Override
    public NewsDTO getById(long id) {
        return ModelMapper.INSTANCE.newsToNewsDTO(newsDAO.getById(id));
    }

    @Override
    public NewsDTO create(String title, String content, long authorID) {
        NewsModel model = new NewsModel();
        model.setTitle(title);
        model.setContent(content);
        model.setAuthorID(authorID);
        newsDAO.create(model);
        return ModelMapper.INSTANCE.newsToNewsDTO(model);
    }

    @Override
    public NewsDTO update(long id, String title, String content, long authorID) {
        NewsModel model = newsDAO.getById(id);
        model.setTitle(title);
        model.setContent(content);
        model.setAuthorID(authorID);
        newsDAO.update(model);
        return ModelMapper.INSTANCE.newsToNewsDTO(model);
    }

    @Override
    public boolean delete(long id) {
        return newsDAO.delete(id);
    }
}
