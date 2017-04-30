

package com.java.bean;

   
import   java.util.Date;

public class Users {

  
private   String   id;
private   String   email;
private   String   password;
private   Integer   status;
private   String   username;
private   Date   addTime;
private   Integer   bindStatus;
private   String   phone;
public String   getId(){
       return this.id;
}
public  void  setId(String id){
       this.id = id;
}
public String   getEmail(){
       return this.email;
}
public  void  setEmail(String email){
       this.email = email;
}
public String   getPassword(){
       return this.password;
}
public  void  setPassword(String password){
       this.password = password;
}
public Integer   getStatus(){
       return this.status;
}
public  void  setStatus(Integer status){
       this.status = status;
}
public String   getUsername(){
       return this.username;
}
public  void  setUsername(String username){
       this.username = username;
}
public Date   getAddTime(){
       return this.addTime;
}
public  void  setAddTime(Date addTime){
       this.addTime = addTime;
}
public Integer   getBindStatus(){
       return this.bindStatus;
}
public  void  setBindStatus(Integer bindStatus){
       this.bindStatus = bindStatus;
}
public String   getPhone(){
       return this.phone;
}
public  void  setPhone(String phone){
       this.phone = phone;
}

}