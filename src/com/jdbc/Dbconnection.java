package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {
	
		public static  Connection getConnection()
	    {
			Connection con = null;
	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver");
	             con=DriverManager.getConnection("jdbc:mysql:///intellect", "root", "root");
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
		return con;
		
	}

}
