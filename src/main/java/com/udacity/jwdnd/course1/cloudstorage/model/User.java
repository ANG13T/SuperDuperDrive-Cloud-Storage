package com.udacity.jwdnd.course1.cloudstorage.model;

public class User {
    private Integer userId;
    private String username;
    private String salt;
    private String password;
    private String firstName;
    private String lastName;

    public User(Integer id, String name, String salt, String pass, String first, String last){
        userId = id;
        username = name;
        this.salt = salt;
        password = pass;
        firstName = first;
        lastName = last;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getUserId(){
        return this.userId;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setSalt(String salt){
        this.salt = salt;
    }

    public String getSalt(){
        return this.salt;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return this.firstName;
    }


    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return this.lastName;
    }

}
