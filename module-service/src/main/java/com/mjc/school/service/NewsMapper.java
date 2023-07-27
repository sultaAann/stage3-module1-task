package com.mjc.school.service;

import com.mjc.school.repository.impl.News;
import com.mjc.school.repository.impl.NewsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewsMapper {

    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    NewsDTO newsToNewsDTO(News news);
}
