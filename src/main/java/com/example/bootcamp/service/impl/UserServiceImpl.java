package com.example.bootcamp.service.impl;

import com.example.bootcamp.dto.UserDTO;
import com.example.bootcamp.entity.UserEntity;
import com.example.bootcamp.repository.UserRepository;
import com.example.bootcamp.service.UserService;
import com.example.bootcamp.util.UserEntityToDTOMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepository userRepository;


    public UserDTO createUser(UserDTO user)
    {
        UserEntity entity = UserEntityToDTOMapping.map(user);
        userRepository.save(entity);
        user.setId(entity.getId());
        return user;
    }

    @Override
    public UserDTO getUser(Long id)
    {
        Optional<UserEntity> optionalEntity = userRepository.findById(id);
        return UserEntityToDTOMapping.map(optionalEntity.get());
//        return null;
    }
    public List<UserDTO> getAllUser()
    {
        List<UserEntity> allUser = userRepository.findAll();
        List<UserDTO> userList= allUser.stream().map((usr) -> UserEntityToDTOMapping.map(usr)).toList();
        return userList;
    }

    public List<UserDTO> getFilteredUser(String userStartWith)
    {
        List<UserDTO> allData= getAllUser();
        List<UserDTO> filteredData = allData.stream().filter((user) -> user.getName().toLowerCase().startsWith(userStartWith)).toList();
        System.out.println(filteredData);
        return filteredData;
    }

    public UserDTO updateUser(Long id, UserDTO userdto)
    {
        Optional<UserEntity> Optuser = userRepository.findById(id);
        if(Optuser.isPresent())
        {
            UserEntity user = Optuser.get();
            user.setName(userdto.getName());
            user.setEmail(userdto.getEmail());
            userRepository.save(user);
            return UserEntityToDTOMapping.map(user);
        }
        return null;
    }

    public String deleteUser(Long id)
    {
        userRepository.deleteById(id);
        return HttpStatus.OK.toString();
    }
}
