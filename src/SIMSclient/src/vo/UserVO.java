package SIMSclient.src.vo;

import java.io.*;

import SIMSclient.src.UserRole;

public class UserVO implements Serializable {
     /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	int id;
     String name;
     String password;
     UserRole role;

     public UserVO(int i,String n,String p, UserRole r){
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

     public String getPassword(){
    	 return password;
     }

     public UserRole getRole(){
    	 return role;
     }
}
