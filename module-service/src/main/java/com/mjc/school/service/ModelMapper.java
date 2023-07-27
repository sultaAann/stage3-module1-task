package com.mjc.school.service;

import com.mjc.school.repository.impl.Model;
import com.mjc.school.repository.impl.ModelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    ModelDTO newsToNewsDTO(Model model);
}
