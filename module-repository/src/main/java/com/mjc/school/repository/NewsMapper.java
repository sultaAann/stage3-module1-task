package com.mjc.school.repository;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewsMapper {

        NewsMapper INSTANCE = Mappers.getMapper( NewsMapper.class );

        NewsDTO newsToNewsDTO(News news);
}
