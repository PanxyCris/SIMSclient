package SIMSclient.src.vo;

import java.io.*;

import SIMSclient.src.dataenum.UserRole;
import javafx.scene.image.ImageView;

public class UserVO implements Serializable {
     /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	 String ID;
     String name;
     String password;
     UserRole role;
     ImageView image;   //Í·Ïñ


     public UserVO(String i,String n,String p,UserRole r/*,ImageView im*/){
    	 ID = i;
    	 name = n;
    	 password = p;
    	 role = r;
    	// image = im;


     }


     public String getName(){
    	 return name;
     }

     public String getID(){
    	 return ID;
     }

     public String getPassword(){
    	 return password;
     }

     public UserRole getRole(){
    	 return role;
     }


     public ImageView getImage(){
    	 return image;
     }

}
