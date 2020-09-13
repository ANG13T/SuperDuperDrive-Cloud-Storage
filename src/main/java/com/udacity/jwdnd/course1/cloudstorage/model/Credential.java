package com.udacity.jwdnd.course1.cloudstorage.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Credential {
     @Id
     @Column(name = "credentialid")
     @GeneratedValue
     private Long credentialid;

     private String url;
     private String username;
     private String key;
     private String password;
     private String decryptedPassword;
     private int userid;

     public Credential(String url, String username, String key, String password, String decryptedPassword){
          this.url = url;
          this.username = username;
          this.decryptedPassword = decryptedPassword;
          this.key = key;
          this.password = password;
     }

     public Credential(){}

     public void setCredentialid(Long credentialid){
          this.credentialid = credentialid;
     }

     public Long getCredentialid(){
          return this.credentialid;
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

     public String getDecryptedPassword() {
          return decryptedPassword;
     }

     public void setDecryptedPassword(String decryptedPassword) {
          this.decryptedPassword = decryptedPassword;
     }
}
