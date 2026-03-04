package com.deploy.praktikum1.service;

import com.deploy.praktikum1.modul.dto.UserAddRequest;
import com.deploy.praktikum1.modul.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto addUser(UserAddRequest request);

    List<UserDto> getAllUsers();

    UserDto getUserById(String id);

    UserDto updateUser(String id, UserAddRequest request);

    void deleteUser(String id);
}
