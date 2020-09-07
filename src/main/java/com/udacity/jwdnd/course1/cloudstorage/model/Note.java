package com.udacity.jwdnd.course1.cloudstorage.model;

public class Note {
     private String noteid;
     private String notetitle;
     private String notedescription;
     private Integer userid;

     public Note(String noteid, String notetitle, String notedescription, Integer userid){
          this.noteid = noteid;
          this.notetitle = notetitle;
          this.notedescription = notedescription;
          this.userid = userid;
     }

     public void setNoteid(String noteid){
          this.noteid = noteid;
     }

     public void setNotetitle(String notetitle){
          this.notetitle = notetitle;
     }

     public void setNotedescription(String notedescription){
          this.notedescription = notedescription;
     }

     public void setUserid(Integer userId){
          this.userid = userId;
     }

     public Integer getUserid(){
          return this.userid;
     }

     public String getNoteid(){
          return this.noteid;
     }

     public String getNotedescription(){
          return this.notedescription;
     }

     public String getNotetitle(){
          return this.notetitle;
     }

}
