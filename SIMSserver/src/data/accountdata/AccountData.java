package data.accountdata;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.DBManager;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountType;
import po.AccountPO;

/**     
*  
* @author Lijie 
* @date 2017��12��3��    
*/
public class AccountData {
//	public static void main(String[] args) throws RemoteException {
//		AccountData a = new AccountData();
//		AccountPO po = new AccountPO("000007", "���Ӳ�", 4000);
//		a.delete("000005");
//		ArrayList<AccountPO> list = a.show();
//		for (AccountPO p : list) {
//			System.out.println(p.getId() + " " + p.getName() + " " + p.getMoney());
//		}
//		
//	}

	public ResultMessage insert(AccountPO po) {
		Connection conn = DBManager.getConnection();// �����õ����ݿ������
		String sql = "" + "insert into account(id, object) values (?,?)";
		try{
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, po.getId());
            ps.setObject(2, po);
            ps.executeUpdate();
            conn.commit();
            ps.close();
            conn.close();
            return ResultMessage.SUCCESS;
        }catch(SQLException e){
            e.printStackTrace();    
        }
		return ResultMessage.FAIL;
	}
	

	public ResultMessage delete(String id) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "delete from account where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			ps.close();
			conn.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public ResultMessage update(AccountPO po) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "update account set object = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, po);
			ps.setString(2, po.getId());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public ArrayList<AccountPO> show() {
		ArrayList<AccountPO> list = new ArrayList<>();
		Connection conn = DBManager.getConnection();
		String sql = "select object from account";
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
                    AccountPO po = (AccountPO)in.readObject();                   //��������  
                      
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


	public ArrayList<AccountPO> find(String keyword, FindAccountType type) { 
		ArrayList<AccountPO> list = new ArrayList<>();
		AccountPO po = null;
		Connection conn = DBManager.getConnection();
		String sql = "" + "select object from account";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// �����Ƕ�ȡ�ķ���һ��Ҫע���ˣ�
				Blob inblob = (Blob) rs.getBlob("object");
				InputStream is = inblob.getBinaryStream();
				BufferedInputStream input = new BufferedInputStream(is);

				byte[] buff = new byte[(int) inblob.length()];// �ŵ�һ��buff �ֽ�����
				while (-1 != (input.read(buff, 0, buff.length)));

				ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buff));
				po = (AccountPO) in.readObject();
				
				if (type == FindAccountType.ID) {
					if (keyword.equals(po.getId())) list.add(po);
				}
				else if (type == FindAccountType.NAME) {
					if (keyword.equals(po.getName())) list.add(po);
				}
				else {
					if (Double.parseDouble(keyword) == po.getMoney()) list.add(po);
				}
			}
					
		}catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return list;
	}


	
}
