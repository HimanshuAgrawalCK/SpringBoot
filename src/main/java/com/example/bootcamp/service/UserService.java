package com.example.bootcamp.service;

import com.example.bootcamp.dto.UserDTO;

import java.util.List;

public interface UserService
{

    public UserDTO createUser(UserDTO user);
    public UserDTO getUser(Long id);
    public List<UserDTO> getAllUser();
    public List<UserDTO> getFilteredUser(String userStartWith);
    public UserDTO updateUser(Long id, UserDTO user);
    public String deleteUser(Long id);
}
