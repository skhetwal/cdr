package sun.cdr.data.factory;

import sun.cdr.data.DataSource;
import sun.cdr.data.DataSourceType;
import sun.cdr.data.source.DBMSSQL;
import sun.cdr.data.source.DBMYSQL;
import sun.cdr.data.source.DBMongoDB;
import sun.cdr.data.source.FileCSV;
import sun.cdr.data.source.FileJASON;
import sun.cdr.data.source.FileProperty;
import sun.cdr.data.source.FileXML;
import sun.cdr.data.source.FileXSSF;

public class DataSourceFactory {
	String type;
	String ref;
	
	Object fileObject;
	
	public DataSourceFactory(String type,String ref) {
		
	}
	
	DataSource getFileObject(DataSourceType sourceType, String sourceRef){
		switch(sourceType){
		case PROPERTIES:
			return new FileProperty(sourceRef);
		case XSSF:
			return new FileXSSF(sourceRef);
		case CSV:
			return new FileCSV(sourceRef);
		case XML:
			return new FileXML(sourceRef);
		case JASON:
			return new FileJASON(sourceRef);
		case MONGODB:
			return new DBMongoDB(sourceRef);
		case MSSQL:
			return new DBMSSQL(sourceRef);
		case MYSQL:
			return new DBMYSQL(sourceRef);
		default:
			break;
		}
		return null;
	}

}
