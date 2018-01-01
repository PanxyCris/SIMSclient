package data.messagedata;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.midi.MetaMessage;

import data.DBManager;
import dataenum.ResultMessage;
import dataservice.messagedataservice.MessageDataService;
import po.UserPO;
import po.messagepo.MessagePO;

public class MessageDataServiceImpl implements MessageDataService{

	private Connection conn;
	public MessageDataServiceImpl() {
		conn = DBManager.getConnection();
	}

	public static void main(String[] args) {
		String info = "�������� ����JHD-20171228-00001�����������ɹ�";
		MessageDataServiceImpl data = new MessageDataServiceImpl();
	}

	@Override
	public ResultMessage save(MessagePO message, UserPO user) {
		String sql = "" + "update message set object = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, message);
			ps.setString(2, user.getID());
			ps.executeUpdate();
			ps.close();
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

                    list.add(po);
                }
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;

	}

}
