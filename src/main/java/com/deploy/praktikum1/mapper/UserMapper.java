package com.deploy.praktikum1.mapper;

import com.deploy.praktikum1.modul.dto.UserDto;
import com.deploy.praktikum1.modul.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    UserDto toUserDto(User user);
}