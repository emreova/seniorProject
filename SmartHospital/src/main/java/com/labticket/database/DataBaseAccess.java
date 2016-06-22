package com.labticket.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.labticket.bean.UserAccount;
import com.labticket.data.Ticket;

public class DataBaseAccess implements SqlQuery {

	private static DataBaseAccess instance = null;

	public static DataBaseAccess getInstance() {
		if (instance == null) {
			DataBaseAccess controller = new DataBaseAccess();
			return controller;
		} else {
			return instance;
		}
	}

	public ResultSet executeQuery(String query) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/netas", "root", "root");

		Statement statement = con.createStatement();

		ResultSet result = statement.executeQuery(query);

		return result;

	}

	public int executeUpdate(String query) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/netas", "root", "root");

		Statement statement = con.createStatement();

		int result = statement.executeUpdate(query);

		return result;

	}

	public List<String> getLabNames() throws Exception {
		List<String> labNames = new ArrayList<String>();
		ResultSet resultSet = executeQuery(queryAllLabNames);
		while (resultSet.next()) {
			labNames.add(resultSet.getString(1));
		}
		return labNames;
	}

	public List<String> getTypeNames() throws Exception {
		List<String> typeNames = new ArrayList<String>();
		ResultSet resultSet = executeQuery(queryAllTypeNames);
		while (resultSet.next()) {
			typeNames.add(resultSet.getString(1));
		}
		return typeNames;
	}

	public List<String> getPrioNames() throws Exception {
		List<String> prioNames = new ArrayList<String>();
		ResultSet resultSet = executeQuery(queryAllPrioNames);
		while (resultSet.next()) {
			prioNames.add(resultSet.getString(1));
		}
		return prioNames;
	}
	
	public List<String> getPrioDepts() throws Exception {
		List<String> prioNames = new ArrayList<String>();
		ResultSet resultSet = executeQuery(queryPrioDepts);
		while (resultSet.next()) {
			prioNames.add(resultSet.getString(1));
		}
		return prioNames;
	}
	
	

	public List<String> getStatusNames() throws Exception {
		List<String> statusNames = new ArrayList<String>();
		ResultSet resultSet = executeQuery(queryAllStatusNames);
		while (resultSet.next()) {
			statusNames.add(resultSet.getString(1));
		}
		return statusNames;
	}

	public void createTicket(Ticket ticket) throws Exception {

		String query = "INSERT INTO ticket (lab_id,ticket_sub,ticket_desc,assign_id,reporter_id,priority_id,type_id,status_id,createdate,escprime_id,frdate,closedate) VALUES ("
				+ getLabIDForName(ticket.getLab())
				+ ",'"
				+ ticket.getSubject()
				+ "','"
				+ ticket.getDesc()
				+ "',"
				+ getUserIDForFullName(ticket.getAssign())
				+ ","
				+ getUserIDForFullName(ticket.getReporter())
				+ ","
				+ getPriorityIDForName(ticket.getPriority())
				+ ","
				+ getTypeIDForName(ticket.getType())
				+ ","
				+ getStatusIDForName(ticket.getStatus())
				+ ",'"
				+ ticket.getCrdate()
				+ "',"
				+ getUserIDForFullName(ticket.getEscprime())
				+ ",'"
				+ ticket.getFrdate() + "','" + ticket.getClosedate() + "')";
		executeUpdate(query);
	}
	
	

	public void createComment(Ticket ticket) throws Exception {


		String query ="update ticket set comment= '" + ticket.getComment()
				+ "' where id= "
			+ ticket.getId();
		executeUpdate(query);
	}
	
	public void addComment(String comment) throws Exception {

		String query = "INSERT INTO log (content) VALUES ('" + comment+ "')";
		executeUpdate(query);
		
		
	}


	
	public void insertFile(Ticket ticket) throws Exception{
	

		String query ="update ticket set attach= '" + ticket.getAttach()
				+ "' where id= "
			+ ticket.getId();
		executeUpdate(query);
	}
	

	

	public void assign(Ticket ticket, String fullname) throws Exception {
		// String query =

		String query = "update ticket set assign_id = (select id from user where fullname ='"
				+ fullname + "') where id =" + ticket.getId();

		executeUpdate(query);

	}

	public void deletePrio(String prio) throws Exception {

		String query = "delete from prio where name='" + prio + "'";
		executeUpdate(query);
	}

	public void addPrio(String prio) throws Exception {

		String query = "INSERT INTO prio (name) VALUES ('" + prio + "')";
		executeUpdate(query);
		
		
	}

	public void addStatus(String status) throws Exception {

		String query = "INSERT INTO status (name) VALUES ('" + status + "')";
		executeUpdate(query);
	}

	public void addType(String type) throws Exception {

		String query = "INSERT INTO type (name) VALUES ('" + type + "')";
		executeUpdate(query);
	}

	public void deleteStatus(String status) throws Exception {

		String query = "delete from status where name='" + status + "'";
		executeUpdate(query);
	}

	public void deleteType(String type) throws Exception {

		String query = "delete from type where name='" + type + "'";
		executeUpdate(query);
	}

	public void updatePrio(String newPrio, String oldPrio) throws Exception {

		String query = "update prio set name='" + newPrio + "' where name='"
				+ oldPrio + "'";
		executeUpdate(query);
	}

	public int getLabIDForName(String labName) throws Exception {
		int id = 0;
		ResultSet resultSet = executeQuery(queryLabIDForName + "'" + labName
				+ "'");
		while (resultSet.next()) {
			id = resultSet.getInt(1);
		}
		return id;
	}
	
	
	public int getCommentForName(String comment) throws Exception {
		int id = 0;
		ResultSet resultSet = executeQuery(queryCommentForName + "'" + comment
				+ "'");
		while (resultSet.next()) {
			id = resultSet.getInt(1);
		}
		return id;
	}


	public int getUserIDForFullName(String fullName) throws Exception {
		int id = 0;
		ResultSet resultSet = executeQuery(queryUserIDForFullName + "'"
				+ fullName + "'");
		while (resultSet.next()) {
			id = resultSet.getInt(1);
		}
		return id;
	}

	public int getPriorityIDForName(String name) throws Exception {
		int id = 0;
		ResultSet resultSet = executeQuery(queryPriorityIDForName + "'" + name
				+ "'");
		while (resultSet.next()) {
			id = resultSet.getInt(1);
		}
		return id;
	}

	public int getStatusIDForName(String name) throws Exception {
		int id = 0;
		ResultSet resultSet = executeQuery(queryStatusIDForName + "'" + name
				+ "'");
		while (resultSet.next()) {
			id = resultSet.getInt(1);
		}
		return id;
	}

	public int getTypeIDForName(String name) throws Exception {
		int id = 0;
		ResultSet resultSet = executeQuery(queryTypeIDForName + "'" + name
				+ "'");
		while (resultSet.next()) {
			id = resultSet.getInt(1);
		}
		return id;
	}

	public List<Ticket> geTickets(String userName) throws Exception {
		List<Ticket> tickets = new ArrayList<Ticket>();

		ResultSet resultSet = executeQuery(queryTicketForUserName + "'"
				+ userName + "'");
		while (resultSet.next()) {
			Ticket ticket = new Ticket(resultSet.getString(2),
					resultSet.getString(3), resultSet.getString(4), "",
					resultSet.getString(5), resultSet.getString(6));
			ticket.setId(resultSet.getInt(1));
			tickets.add(ticket);
		}
		return tickets;
	}

	public List<Ticket> getAllTickets() throws Exception {
		List<Ticket> tickets = new ArrayList<Ticket>();

		ResultSet resultSet = executeQuery(queryAllTicket);
		while (resultSet.next()) {
			Ticket ticket = new Ticket(resultSet.getString(2),
					resultSet.getString(3), resultSet.getString(4), "",
					resultSet.getString(5), resultSet.getString(6));
			ticket.setId(resultSet.getInt(1));
			tickets.add(ticket);
		}
		return tickets;
	} 
	
	


	public List<Ticket> getPrioNames(String prio) throws Exception {
		List<Ticket> tickets = new ArrayList<Ticket>();

		ResultSet resultSet = executeQuery(queryAllPrioNames + "'" + prio + "'");
		while (resultSet.next()) {
			Ticket ticket = new Ticket(resultSet.getString(2),
					resultSet.getString(3), resultSet.getString(4), "",
					resultSet.getString(5), resultSet.getString(6));
			ticket.setId(resultSet.getInt(1));
			tickets.add(ticket);
		}
		return tickets;
	}
	
	public List<Ticket> getAllPrioNames(String prio) throws Exception {
		List<Ticket> tickets = new ArrayList<Ticket>();

		ResultSet resultSet = executeQuery(queryAllPrioNames + "'" + prio + "'");
		while (resultSet.next()) {
			Ticket ticket = new Ticket(resultSet.getString(2),
					resultSet.getString(3), resultSet.getString(4), "",
					resultSet.getString(5), resultSet.getString(6));
			ticket.setId(resultSet.getInt(1));
			tickets.add(ticket);
		}
		return tickets;
	}

	public UserAccount getUser(String username) throws Exception {
		ResultSet resultSet = executeQuery(queryUserForUserName + "'"
				+ username + "'");
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String fullname = resultSet.getString("fullname");
			String email = resultSet.getString("mail");
			// boolean admin = resultSet.getBoolean("role");
			UserAccount user = new UserAccount(id, username, fullname, email,
					true);
			return user;
		}
		return null;
	}

	public boolean ifUserExist(String username) throws Exception {
		ResultSet resultSet = executeQuery("select count(*) AS rowCount from user where username='"
				+ username + "'");
		while (resultSet.next()) {
			int rowCount = resultSet.getInt("rowCount");
			if (rowCount > 1) {
				return true;
			}
		}
		return false;
	}
	
	
	public void add(UserAccount user) throws Exception {
	         String addUserQuery = "insert into user values('" + user.getUsername() + "','" + user.getFullname() + "','" + user.getEmail() + "', FALSE)";
	         executeUpdate(addUserQuery);
	   }
	
	
	
	public void updateTicket(Ticket ticket) throws Exception {

		String query = "update ticket set lab_id=" + getLabIDForName(ticket.getLab())
				+ ", ticket_sub= '" + ticket.getSubject()
				+ "', ticket_desc= '" + ticket.getDesc()
				+ "', reporter_id= " + getUserIDForFullName(ticket.getReporter())
				+ ", priority_id= " + getPriorityIDForName(ticket.getPriority())
				+ ", type_id= " + getTypeIDForName(ticket.getType())
				+ ", status_id= " + getStatusIDForName(ticket.getStatus())
				+ " where id= "
			+ ticket.getId();
		executeUpdate(query);
	}
	
	
	
	public void assignTicket(Ticket ticket) throws Exception {

		String query = "update ticket set assign_id=" + getUserIDForFullName(ticket.getAssign())
				+ ", frdate= '" + ticket.getFrdate()
				+ "', escprime_id= " + getUserIDForFullName(ticket.getEscprime())
				+ " where id= "
			+ ticket.getId();
		executeUpdate(query);
	}
	
	

	
	
	public List<String> getHigh() throws Exception {
		List<String> statusNames = new ArrayList<String>();
		ResultSet resultSet = executeQuery(queryAllHigh);
		while (resultSet.next()) {
			statusNames.add(resultSet.getString(1));
		}
		return statusNames;
	}
	
	public List<String> getUnassigned() throws Exception {
		List<String> statusNames = new ArrayList<String>();
		ResultSet resultSet = executeQuery(queryAllUnassigned);
		while (resultSet.next()) {
			statusNames.add(resultSet.getString(1));
		}
		return statusNames;
	}

	public List<String> getWIP() throws Exception {
		List<String> statusNames = new ArrayList<String>();
		ResultSet resultSet = executeQuery(queryAllWIP);
		while (resultSet.next()) {
			statusNames.add(resultSet.getString(1));
		}
		return statusNames;
	}
	
	
	public List<String> getComments() throws Exception {
		List<String> statusNames = new ArrayList<String>();
		ResultSet resultSet = executeQuery(queryComments);
		while (resultSet.next()) {
			statusNames.add(resultSet.getString(1));
		}
		return statusNames;
	}
	
	public List<String> getHold() throws Exception {
		List<String> statusNames = new ArrayList<String>();
		ResultSet resultSet = executeQuery(queryAllHold);
		while (resultSet.next()) {
			statusNames.add(resultSet.getString(1));
		}
		return statusNames;
	}

	public List<String> getClosed() throws Exception {
		List<String> statusNames = new ArrayList<String>();
		ResultSet resultSet = executeQuery(queryAllClosed);
		while (resultSet.next()) {
			statusNames.add(resultSet.getString(1));
		}
		return statusNames;
	}
	
	



}
