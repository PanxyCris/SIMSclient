package SIMSclient.src.vo;

import SIMSclient.src.UserRole;

public class UserVO {

	  String name;
	  String password;
	  int id;//…Ì∑›
      UserRole role;

      public UserVO(int i,String n,String p,UserRole r){
    	  id = i;
    	  name = n;
    	  password = p;
    	  role = r;
      }

      public String getName(){
    	  return name;
      }

      public int getID(){
    	  return id;
      }

}
