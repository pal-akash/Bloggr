package com.akash.bloggr.dao;

import com.akash.bloggr.mapper.UserMapper;
import com.akash.bloggr.models.User;
import com.akash.bloggr.payloads.UserDto;
import com.akash.bloggr.repositories.UserRepository;
import com.akash.bloggr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = userMapper.dtoToUser(userDto);
        User savedUser = userRepository.save(user);

        return userMapper.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto user, Integer userId) {
        return null;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }
}
