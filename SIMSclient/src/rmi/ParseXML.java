package rmi;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * ����XML
 * @author Lijie
 * @date 2017��11��28��
 */
public class ParseXML {

	private String filePath = "DATA/DataService.xml";
	private Document document;
	private Element element;
	private Element root;

	public ParseXML(String fileName) {

	}

	public void init(String filePath, String fileName) {
		try {
			/* ����һ��DocumentBuilderFactory�Ķ��� */
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();  //����DocumentBuilder����
			document = db.parse(new File(filePath));  //ͨ��DocumentBuilder�����parser��������DataService.xml�ļ�����ǰ��Ŀ��
			root = document.getDocumentElement();
			element = (Element)selectSingleNode("/DATA/Data[name='" + fileName + "']", root);
		} catch (DOMException e) {
			System.out.println(e.getMessage());
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private Element selectSingleNode(String string, Element root2) {
		return null;
	}


}
