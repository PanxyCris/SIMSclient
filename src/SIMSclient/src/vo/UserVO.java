package SIMSclient.src.vo;

import java.io.*;

public class UserVO implements Serializable {
     /**
	 *
	 */
	public enum Authority{
		HIGHEST,NORMAL
	}

	public enum UserRole {
		MANAGER, FINANCIALSTAFF, SALESPERSON, COMMODITYPERSON
	}


	private static final long serialVersionUID = 1L;
	int id;
     String name;
     String password;
     UserRole role;
     Authority authority;


     public UserVO(int i,String n,String p, UserRole r,Authority a){
    	 id = i;
    	 name = n;
    	 password = p;
    	 role = r;
    	 authority = a;
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

     public Authority getAuthority(){
    	 return authority;
     }
}
