package SIMSclient.src.vo;

import java.io.*;

import javafx.scene.image.ImageView;

public class UserVO implements Serializable {
     /**
	 *
	 */
	public enum Authority{
		
		HIGHEST("最高权限"),NORMAL("普通权限");
		
		public final String value;

		Authority(String value){
			this.value = value;
		}
	}

	public enum UserRole {
		MANAGER("总经理"), FINANCIALSTAFF("财务人员"), SALESPERSON("进货销售人员"), COMMODITYPERSON("库存管理人员"), USERMANAGER("用户管理人员");

		public final String value;

		UserRole(String value){
			this.value = value;
		}
	}


	private static final long serialVersionUID = 1L;
	int id;
     String name;
     String password;
     UserRole role;
     Authority authority;
     ImageView image;   //头像


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
