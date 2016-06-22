package com.labticket.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.security.core.context.SecurityContextHolder;


public class Main {
	private static Connection connection;
	private static Statement stmt;
	


	  public static void main(String[] argv) {

	  }
	  
	
	  public static void insertDB(String s1,String s2,String s3,String s4, String s5, String s6, String s7) {
			
			
			String query = "insert into ticket values("+s1+",'"+Integer.parseInt(s2)+"','"+Integer.parseInt(s3)+"','"+s4+"','"+s5+"','"+Integer.parseInt(s6)+"','"+Integer.parseInt(s7)+"')";
			System.out.println(query);
			try {
				stmt.executeUpdate(query);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
	  

}
