package com.intership.springdemo.service;

import com.intership.springdemo.persistance.UserRepository;
import com.intership.springdemo.persistance.entity.UserEntity;
import com.intership.springdemo.service.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getUsers(String firstName) {
        //Some logic
        return UserDto.mapUserEntityToUserDto(userRepository.getByFirstName(firstName));
    }

    public UserDto getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
        return UserDto.mapUserEntityToUserDto(userEntity);
    }

    public UserDto createUser(UserDto userDto) {
        UserEntity savedUser = userRepository.save(UserDto.mapUserDtoToUserEntity(userDto));
        return UserDto.mapUserEntityToUserDto(savedUser);
    }
}
