package com.udacity.jwdnd.course1.cloudstorage.model;

public class Credential {
     private Integer credentialid;
     private String url;
     private String username;
     private String key;
     private String password;
     private int userid;

     public Credential(String url, String username, String key, String password){
          this.url = url;
          this.username = username;
          this.key = key;
          this.password = password;
     }

     public void setCredentialid(Integer credentialid){
          this.credentialid = credentialid;
     }

     public void setUsername(String username){
          this.username = username;
     }

     public void setKey(String key){
          this.key = key;
     }

     public void setUrl(String url){
          this.url = url;
     }

     public void setPassword(String password){
          this.password = password;
     }

     public void setUserid(Integer userid){
          this.userid = userid;
     }

     public String getUrl(){
          return this.url;
     }

     public String getUsername(){
          return this.username;
     }

     public String getKey(){
          return this.key;
     }

     public String getPassword(){
          return this.password;
     }
}
