package com.udacity.jwdnd.course1.cloudstorage.form;

public class CredentialsForm {
    private String id;
    private String username;
    private String password;
    private String key;
    private String url;

    public void setId(String id){
        this.id = id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setKey(String key){
        this.key = key;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getId(){
        return this.id;
    }

    public String getKey(){
        return this.key;
    }

    public String getUrl(){
        return this.url;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }
}
