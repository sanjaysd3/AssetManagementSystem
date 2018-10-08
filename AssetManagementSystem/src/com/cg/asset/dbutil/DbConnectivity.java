package com.cg.asset.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectivity {

	static Connection conn=null;
	public static Connection getConnected() throws SQLException{
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:","system","sanjaysd3");
		return  conn;
	}
}