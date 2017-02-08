package sun.cdr.data.source;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import sun.cdr.data.DataSource;

public class FileXML extends DataSource{
	public FileXML(String context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	String fileRef;
	
	Document getDocument(){
		File file;
		DocumentBuilderFactory docfactory;
		DocumentBuilder docBuilder;
		Document doc = null;
		
		file = new File(fileRef);
		docfactory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = docfactory.newDocumentBuilder();
			doc = docBuilder.parse(file);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		return doc;
	}
	
}
