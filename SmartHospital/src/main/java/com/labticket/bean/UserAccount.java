package com.labticket.bean;

public class UserAccount {

	   private int     id;
	   private String  username;
	   private String  fullname;
	   private String  email;
	   private boolean admin;


	   public UserAccount(String username, String fullname, String email, boolean admin) {
	      this.username = username;
	      this.fullname = fullname;
	      this.email = email;
	      this.admin = admin;
	   }

	   public UserAccount(int id, String username, String fullname, String email, boolean admin) {
	      this.id = id;
	      this.username = username;
	      this.fullname = fullname;
	      this.email = email;
	      this.admin = admin;
	   }

	   public int getId() {
	      return id;
	   }

	   public void setId(int id) {
	      this.id = id;
	   }

	   public String getUsername() {
	      return username;
	   }

	   public void setUsername(String username) {
	      this.username = username;
	   }

	   public String getFullname() {
	      return fullname;
	   }

	   public void setFullname(String fullname) {
	      this.fullname = fullname;
	   }

	   public boolean isAdmin() {
	      return admin;
	   }

	   public void setAdmin(boolean admin) {
	      this.admin = admin;
	   }

	   public String getEmail() {
	      return email;
	   }

	   public void setEmail(String email) {
	      this.email = email;
	   }

	}
