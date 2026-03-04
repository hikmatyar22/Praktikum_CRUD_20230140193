package com.deploy.praktikum1.service.lmpl;

import com.deploy.praktikum1.mapper.UserMapper;
import com.deploy.praktikum1.modul.dto.UserAddRequest;
import com.deploy.praktikum1.modul.dto.UserDto;
import com.deploy.praktikum1.modul.entity.User;
import com.deploy.praktikum1.repository.UserRepository;
import com.deploy.praktikum1.service.UserService;
import com.deploy.praktikum1.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServicelmpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationUtil validationUtil;

    @Override
    public UserDto addUser(UserAddRequest request) {
        validationUtil.validate(request);

        User saveUser = User.builder()
                .id(UUID.randomUUID().toString())
                .name(request.getName())
                .age(request.getAge())
                .build();

        userRepository.save(saveUser);

        return UserMapper.MAPPER.toUserDto(saveUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        for (User user : users) {
            userDtos.add(UserMapper.MAPPER.toUserDto(user));
        }

        return userDtos;
    }

    @Override
    public UserDto getUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.MAPPER.toUserDto(user);
    }

    @Override
    public UserDto updateUser(String id, UserAddRequest request) {
        validationUtil.validate(request);

        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        User user = User.builder()
                .id(existingUser.getId())
                .name(request.getName())
                .age(request.getAge())
                .build();

        userRepository.save(user);

        return UserMapper.MAPPER.toUserDto(user);
    }

    @Override
    public void deleteUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}


