package com.akash.bloggr.dao;

import com.akash.bloggr.exceptions.ResourceNotFoundException;
import com.akash.bloggr.mapper.UserMapper;
import com.akash.bloggr.models.User;
import com.akash.bloggr.payloads.UserDto;
import com.akash.bloggr.repositories.UserRepository;
import com.akash.bloggr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

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
    public UserDto updateUser(UserDto userDto, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser = userRepository.save(user);

        return userMapper.userToDto(updatedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        return userMapper.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> userMapper.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepository.delete(user);
    }
}
