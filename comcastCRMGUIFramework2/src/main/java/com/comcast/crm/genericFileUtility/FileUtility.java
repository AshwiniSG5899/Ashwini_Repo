package com.comcast.crm.genericFileUtility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
		Properties PObj=new Properties();
		PObj.load(fis);
		String data=PObj.getProperty(key);
		
	return data;
		
	}

}
