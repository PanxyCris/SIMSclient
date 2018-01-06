package vo.messagevo;

import vo.uservo.UserVO;

public class MessageExamineVO extends MessageVO{


	private String id; //���ݱ��
	private UserVO user; //�û�

	public MessageExamineVO(String messageID, String id,UserVO user) {
		super(messageID, getFormatInfo(id,user));
		this.setId(id);
		this.setUser(user);

	}

	public static String getFormatInfo(String id,UserVO user){
	   	 return user.getName()+"�����ύ�˵��ݣ�"+id+",��������";
	    }

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
