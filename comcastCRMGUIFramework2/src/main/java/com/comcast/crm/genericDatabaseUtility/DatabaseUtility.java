package com.comcast.crm.genericDatabaseUtility;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {

	Connection con;
	public void getDBConnection(String url,String UserName,String password)
	{
		try {
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			con=DriverManager.getConnection(url, UserName, password);
			}
		catch(Exception e)
		{
		}
	}
	public void closeDBConnection()
	{
		try {
			con.close();
		}
		catch(Exception e)
		{
		}
	}
	public ResultSet executeSelectQuery(String query)
	{
		ResultSet result=null;
		try {
			Statement stat=con.createStatement();
		   result=stat.executeQuery(query);
		}
		catch(Exception e)
		{
			
		}
		return result;
		
		
		
	}
}
