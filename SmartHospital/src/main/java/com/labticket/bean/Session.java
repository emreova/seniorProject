package com.labticket.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.security.core.context.SecurityContextHolder;

import com.labticket.database.DataBaseAccess;
import com.labticket.database.SqlQuery;

public class Session implements SqlQuery {

   private static Session instance;
   private UserAccount    user;

   public synchronized static Session getInstance() {

      if (instance == null) {
         instance = new Session();
      }
      return instance;
   }
   
	public ResultSet executeQuery(String query) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/netas", "root", "root");

		Statement statement = con.createStatement();

		ResultSet result = statement.executeQuery(query);

		return result;

	}

   public void init() throws Exception {
      String username = SecurityContextHolder.getContext().getAuthentication().getName();
      UserAccount user = DataBaseAccess.getInstance().getUser(username);
      setUser(user);
   }

   public UserAccount getAllUser(String allUsers) throws Exception {
		ResultSet resultSet = executeQuery(queryAllUsers + "'"
				+ allUsers + "'");
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String username = resultSet.getString("username");
			String mail = resultSet.getString("mail");
			String fullname = resultSet.getString("fullname");
			boolean role = resultSet.getBoolean("role");
			UserAccount user = new UserAccount(id, username, mail,fullname, 
					role);
			return user;
			//dbden userlari cek
		}
		return null;
	}

   public UserAccount getSessionInfo() {
      return getUser();
   }

   public UserAccount getUser() {
      return user;
   }

   public void setUser(UserAccount user) {
      this.user = user;
   }
}
