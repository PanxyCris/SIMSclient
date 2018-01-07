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
		String info = "进货单： 您的JHD-20171228-00001进货单审批成功";
		MessageDataServiceImpl data = new MessageDataServiceImpl();
//		MessageWarmingPO message = new MessageWarmingPO("000003","N JIAACD",400,500);
//		data.save(message);
//		System.out.println(data.getMessage(new UserPO("000003",null,null,null,null)).size());

	}

	@Override
	public ResultMessage save(MessagePO message) {
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

	@Override
	public ArrayList<MessagePO> getMessage(UserPO user) {
		ArrayList<MessagePO> list = new ArrayList<>();
		String sql = "select object from message";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Blob inBlob = (Blob) rs.getBlob("object");   //获取blob对象
				InputStream is = inBlob.getBinaryStream();                //获取二进制流对象
                BufferedInputStream bis = new BufferedInputStream(is);    //带缓冲区的流对象
                byte[] buff = new byte[(int) inBlob.length()];

                while(-1!=(bis.read(buff, 0, buff.length))){            //一次性全部读到buff中
                    ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buff));
                    MessagePO po = (MessagePO)in.readObject();                   //读出对象

                    if (user.getID().equals(po.getMessageID())) {
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
//				Blob inBlob = (Blob) rs.getBlob("object");   //获取blob对象
//				InputStream is = inBlob.getBinaryStream();                //获取二进制流对象
//                BufferedInputStream bis = new BufferedInputStream(is);    //带缓冲区的流对象
//                byte[] buff = new byte[(int) inBlob.length()];
//
//                while(-1!=(bis.read(buff, 0, buff.length))){            //一次性全部读到buff中
//                    ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buff));
//                    MessagePO po = (MessagePO)in.readObject();                   //读出对象
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
		int result = list.get(list.size()-1)+1;
		return String.valueOf(result);
	}

}
