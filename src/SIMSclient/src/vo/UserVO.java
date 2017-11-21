package SIMSclient.src.vo;

import java.io.*;

import javafx.scene.image.ImageView;

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
     ImageView image;   //Í·Ïñ


     public UserVO(int i,String n,String p, UserRole r,Authority a, ImageView im){
    	 id = i;
    	 name = n;
    	 password = p;
    	 role = r;
    	 authority = a;
    	 image = im;
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

     public ImageView getImage(){
    	 return image;
     }

}
