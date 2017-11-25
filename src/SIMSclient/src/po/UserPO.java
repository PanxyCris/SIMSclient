package SIMSclient.src.po;

import java.io.*;

import SIMSclient.src.dataenum.UserRole;
import javafx.scene.image.ImageView;

public class UserPO implements Serializable {

	private static final long serialVersionUID = 1L;
	String id;
     String name;
     String password;
     UserRole role;
     ImageView image;

     public UserPO(String i,String n,String p, UserRole r,ImageView im){
    	 id = i;
    	 name = n;
    	 password = p;
    	 role = r;
    	 image = im;
     }

     public String getName(){
    	 return name;
     }

     public String getID(){
    	 return id;
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
