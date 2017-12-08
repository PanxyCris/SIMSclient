

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
* ���ڱ���Ͷ�ȡ����
* ���·��ͳһ������data�ļ�����
*/
public class IOHelper<E> implements Serializable{

	private static final long serialVersionUID = 1L;
	private String filePath = null;
	private ArrayList<E> dataList = new ArrayList<E>(); //��������

	public IOHelper(String filePath) {
		this.filePath = filePath;
		this.read();
	}

	/*�����ݴ��ļ��ж�ȡ����*/
	@SuppressWarnings("unchecked")
	public void read() {

		/*�����ļ���*/
		File dataDirectory = new File("data/log");
		if (!dataDirectory.isDirectory()) {
			dataDirectory.mkdirs();
		}

		/*�����ļ�*/
		File dataFile = new File(filePath);
		if (!dataFile.isFile()) {
			try {
				dataFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/*����ļ�Ϊ�գ��򷵻�*/
		if(dataFile.length() == 0) {
			return;
		}

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filePath));
			dataList = (ArrayList<E>)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/* �����ݴ����ļ��� */
	public void save() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filePath));
			oos.writeObject(dataList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public E getData(int index) {
		return dataList.get(index);
	}

	public E setData(int index, E element) {
		E e = dataList.set(index, element);
		save();
		return e;
	}

	public boolean add(E e) {
		boolean b = dataList.add(e);
		save();
		return b;
	}

	public void add(int index, E e) {
		dataList.add(index, e);
		save();
	}

	public E remove(int index) {
		E e = dataList.remove(index);
		save();
		return e;
	}

	public boolean remove(Object o) {
		boolean b = dataList.remove(o);
		save();
		return b;
	}

	public void clear() {
		dataList.clear();
		save();
	}

	public ArrayList<E> getdataList() {
		return this.dataList;
	}

	public boolean isEmpty() {
		return dataList.isEmpty();
	}

	public int getSize() {
		return dataList.size();
	}
}
