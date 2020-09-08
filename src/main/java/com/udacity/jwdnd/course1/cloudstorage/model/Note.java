package com.udacity.jwdnd.course1.cloudstorage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note {
     @Id
     @Column(name = "id")
     @GeneratedValue
     private Long id;

     private String title;
     private String description;
     private Integer userid;

     public Note(String title, String description, Integer userid){
          this.title = title;
          this.description = description;
          this.userid = userid;
     }

     public Note(){}

     public Note(Integer userid){
          this.userid = userid;
     }

     public void setId(Long id){
          this.id = id;
     }

     public void setTitle(String title){
          this.title = title;
     }

     public void setDescription(String description){
          this.description = description;
     }

     public void setUserid(Integer userId){
          this.userid = userId;
     }

     public Integer getUserid(){
          return this.userid;
     }

     public Long getId(){
          return this.id;
     }

     public String getDescription(){
          return this.description;
     }

     public String getTitle(){
          return this.title;
     }

}
