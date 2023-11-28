package Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {

	Properties pro;
	public PropertyFileReader() {
		try{
			pro = new Properties();
			FileInputStream File = new FileInputStream("D:\\Workspace3\\XYZ\\Resources\\Config.Properties");
			pro.load(File);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String getUrl() {
		String TUrl = pro.getProperty("Url");
		return TUrl;
	}
	
	public String getChromePath() {
		String TPath = pro.getProperty("ChromePath");
		return TPath;
	}
	
	public String getUserName() {
		String TUs = pro.getProperty("UserName");
		return TUs;
	}
	
}
