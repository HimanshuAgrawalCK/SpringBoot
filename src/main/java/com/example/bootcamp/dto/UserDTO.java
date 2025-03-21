package com.example.bootcamp.dto;

public class UserDTO
{
    private String name;
    private long id;
    private String email;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

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
}
