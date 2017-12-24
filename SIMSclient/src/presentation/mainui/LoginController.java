package presentation.mainui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import bussinesslogic.userbl.UserController;
import bussinesslogicservice.userblservice.UserBLService;
import dataenum.findtype.FindUserType;
import vo.uservo.UserVO;

public class LoginController {

	UserBLService userservice = new UserController();

	public boolean writeUser(UserVO user) {

		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("Login.txt"));
			fw.write(user.getName());
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();

		}
		return true;
	}

	public UserVO readUser() {
		// TODO Auto-generated method stub
	     File path=new File("Login.txt");
	     try {
			FileReader rw=new FileReader(path);
				rw.read();
				rw.close();
				return userservice.find(rw.toString(), FindUserType.NAME).get(0);
			} catch (IOException e) {

				e.printStackTrace();
			}
		return null;



	}

}
