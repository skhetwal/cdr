package sun.cdr.data.source;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Properties;

import sun.cdr.data.DataSource;

public class FileProperty extends DataSource{
	
	public FileProperty(String context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	String context;
	Properties prop;

	String getProperties(String key) {
		InputStream input = null;
		String value = null;

		try {
			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);

			// get the property value
			value =  prop.getProperty("database");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

	void setProperty(String key, String value) {
		OutputStream output = null;

		try {
			output = new FileOutputStream("config.properties");

			// set the properties value
			prop.setProperty(key, value);

			// save properties
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	void setProperties(Hashtable<String, String> props) {

	}

}
