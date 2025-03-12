package com.example.bootcamp.repository;

import com.example.bootcamp.dto.UserDTO;
import com.example.bootcamp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
}
