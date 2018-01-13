package data.messagedata;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.sound.midi.MetaMessage;

import data.DBManager;
import data.userdata.UserDataServiceImpl;
import dataenum.ResultMessage;
import dataenum.findtype.FindUserType;
import dataservice.messagedataservice.MessageDataService;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import po.messagepo.MessagePO;
import po.messagepo.MessageWarmingPO;

public class MessageDataServiceImpl implements MessageDataService{

	private Connection conn;
	public MessageDataServiceImpl() {
		conn = DBManager.getConnection();
	}

	public static void main(String[] args) {
		String info = "�������� ����JHD-20171228-00001�����������ɹ�";
		MessageDataServiceImpl data = new MessageDataServiceImpl();
	//	MessageWarmingPO message = new MessageWarmingPO("1","000003",true,"N JIAACD",400,500);
	System.out.println(data.getMessage(new UserPO("000003",null,null,null,null)).get(0).getInfo());

	}

	@Override
	public ResultMessage save(MessagePO message) {
		try {
		    PreparedStatement ps0 = conn.prepareStatement("select count(*) from message where id = ?");
		    ps0.setString(1, message.getMessageID());
			ResultSet rs = ps0.executeQuery();

			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
				if (count == 0) {
					return insert(message);
				}

				else {
					return update(message);
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public ResultMessage insert(MessagePO message) {
		String sql = "" + "insert into message(id, object) values (?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.valueOf(message.getMessageID()));
			ps.setObject(2, message);
			ps.executeUpdate();
			ps.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public ResultMessage update(MessagePO message) {
		String sql = "" + "update message set object = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, message);
			ps.setString(2, message.getMessageID());
			ps.executeUpdate();
			ps.close();
//			conn.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ArrayList<MessagePO> getMessage(UserPO user) {
		ArrayList<MessagePO> list = new ArrayList<>();
		String sql = "select object from message";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Blob inBlob = (Blob) rs.getBlob("object");   //��ȡblob����
				InputStream is = inBlob.getBinaryStream();                //��ȡ������������
                BufferedInputStream bis = new BufferedInputStream(is);    //����������������
                byte[] buff = new byte[(int) inBlob.length()];

                while(-1!=(bis.read(buff, 0, buff.length))){            //һ����ȫ������buff��
                    ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buff));
                    MessagePO po = (MessagePO)in.readObject();                   //��������

                    if (user.getID().equals(po.getUserID())) {
                         list.add(po);
                    }
                }
			}
			rs.close();
			ps.close();
			//conn.close();
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public String getMessageID() throws RemoteException {
		ArrayList<Integer> list = new ArrayList<>();
		String sql = "select id from message";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
//				Blob inBlob = (Blob) rs.getBlob("object");   //��ȡblob����
//				InputStream is = inBlob.getBinaryStream();                //��ȡ������������
//                BufferedInputStream bis = new BufferedInputStream(is);    //����������������
//                byte[] buff = new byte[(int) inBlob.length()];
//
//                while(-1!=(bis.read(buff, 0, buff.length))){            //һ����ȫ������buff��
//                    ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buff));
//                    MessagePO po = (MessagePO)in.readObject();                   //��������
//                }

                int id = rs.getInt("id");
                list.add(id);
			}
			rs.close();
			ps.close();
			//conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Collections.sort(list);
		if(list.size()==0)
			return "1";
		int result = list.get(list.size()-1)+1;
		return String.valueOf(result);
	}

}