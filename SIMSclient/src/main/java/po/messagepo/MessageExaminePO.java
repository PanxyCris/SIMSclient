package po.messagepo;

import java.time.LocalDateTime;

import po.userpo.UserPO;

public class MessageExaminePO extends MessagePO{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String id; //���ݱ��
	private UserPO user; //�û�

	public MessageExaminePO(String messageID,LocalDateTime time,boolean hasRead,String id,UserPO user) {
		super(messageID,user.getID(), getFormatInfo(id,user),time,hasRead);
		this.setId(id);
		this.setUser(user);

	}

	public static String getFormatInfo(String id,UserPO user){
	   	 return user.getName()+"�����ύ�˵��ݣ�"+id+",��������";
	    }

	public UserPO getUser() {
		return user;
	}

	public void setUser(UserPO user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
