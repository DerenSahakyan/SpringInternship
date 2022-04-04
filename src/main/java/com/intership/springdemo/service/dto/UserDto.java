package com.intership.springdemo.service.dto;

import com.intership.springdemo.persistance.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Long age;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static UserDto mapUserEntityToUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setAge(userEntity.getAge());
        userDto.setAddress(userEntity.getAddress());

        return userDto;
    }

    public static List<UserDto> mapUserEntityToUserDto(List<UserEntity> userEntities) {
        return userEntities.stream().map(UserDto::mapUserEntityToUserDto).collect(Collectors.toList());
    }

    public static UserEntity mapUserDtoToUserEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setAge(userDto.getAge());
        userEntity.setAddress(userDto.getAddress());

        return userEntity;
    }
}
