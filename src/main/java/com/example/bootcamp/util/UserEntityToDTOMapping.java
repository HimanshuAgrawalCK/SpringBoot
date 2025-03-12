package com.example.bootcamp.util;

import com.example.bootcamp.dto.UserDTO;
import com.example.bootcamp.entity.UserEntity;

public class UserEntityToDTOMapping
{
    public static UserDTO map(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public static UserEntity map(UserDTO dto)
    {
        System.out.println("here");
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}
