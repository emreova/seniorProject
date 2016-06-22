package com.labticket.database;

public interface SqlQuery {

	public String queryAllLabNames = "select name from lab";
	public String queryAllTypeNames = "select name from type";
	public String queryAllPrioNames = "select p.name, p.department from prio p";
	public String queryPrioDepts = "select p.department from prio p";
	public String queryAllStatusNames = "select name from status";
	public String queryLabIDForName = "select id from lab where name=";
	public String queryCommentForName = "select id from log where content=";
	public String queryUserIDForFullName = "select id from user where fullname=";
	public String queryPriorityIDForName = "select id from prio where name=";
	public String queryStatusIDForName = "select id from status where name=";
	public String queryTypeIDForName = "select id from type where name=";
	public String queryTicketForUserName = "select t.id, l.name, t.ticket_sub,  t.ticket_desc, p.name, y.name, u.fullname from lab l, type y, ticket t, prio p, user u where t.lab_id = l.id and t.priority_id = p.id and t.type_id= y.id and  t.assign_id = u.id and u.fullname = ";
	public String queryAllTicket = "select t.id, l.name, t.ticket_sub,  t.ticket_desc, p.name, y.name, u.fullname from lab l, type y, ticket t, prio p, user u where t.lab_id = l.id and t.priority_id = p.id and t.type_id= y.id and  t.assign_id = u.id";
	public String queryQueueForUserName = "select l.name, t.ticket_sub,  t.ticket_desc, p.name, y.name, u.fullname from lab l, type y, ticket t, prio p, user u where t.lab_id = l.id and t.priority_id = p.id and t.type_id= y.id and  t.assign_id = u.id and u.fullname = ";
	public String queryUpdate = "update p.name from priority p set";
	public String queryDeletePrio = "delete id from prio";
	public String queryDeleteStatus = "delete id from status";
	public String queryDeleteType = "delete id from type";
	public String queryUserForUserName = "select * from user where username = ";
	public String queryAllUsers = "select * from user";
	public String queryAllHigh = "select count(priority_id) from ticket where priority_id='19';";
	public String queryAllUnassigned = "select count(status_id) from ticket where status_id='38';";
	public String queryAllWIP= "select count(status_id) from ticket where status_id='37';";
	public String queryAllHold= "select count(status_id) from ticket where status_id='22';";
	public String queryAllClosed= "select count(status_id) from ticket where status_id='19';";
	public String queryComments= "select content from log";
	
	public String queryAllComments = "select t.id, l.content from  ticket t, log l";



	
	
}
