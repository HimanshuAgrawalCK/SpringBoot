package com.example.bootcamp.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class UserEntity
{
    @Column
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Override
    public String toString() {
        return "UserEntity{" +
                "email='" + email + '\'' +
                ", Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }

    @Column(name = "first_name")
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }



}
