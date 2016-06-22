package com.labticket.controller;

import java.util.ArrayList;
import java.util.List;

import com.labticket.data.Ticket;
import com.labticket.database.DataBaseAccess;

public class CreateTicketController {

	private List<String> labNamesFiltretion = new ArrayList<String>();
	private List<String> typeNamesFiltretion = new ArrayList<String>();
	private List<String> prioNamesFiltretion = new ArrayList<String>();
	private List<String> statusNamesFiltretion = new ArrayList<String>();
	
	public void createTicket(Ticket ticket) {

	}

	public List<String> getLabNames() throws Exception {
		return DataBaseAccess.getInstance().getLabNames();

	}
	

	public List<String> getTypeNames() throws Exception {
		return DataBaseAccess.getInstance().getTypeNames();

	}

	public List<String> getPrioNames() throws Exception {
		return DataBaseAccess.getInstance().getPrioNames();

	}
	
	public List<String> getAllPrioNames() throws Exception {
		return DataBaseAccess.getInstance().getPrioNames();

	}
	
	public List<String> getAllPrioDepts() throws Exception {
		return DataBaseAccess.getInstance().getPrioDepts();

	}
	
	public List<String> getPrioDeptNames() throws Exception {
		return DataBaseAccess.getInstance().getPrioDepts();

	}

	public List<String> getHigh() throws Exception {
		return DataBaseAccess.getInstance().getHigh();

	}
	
	public List<String> getUnassigned() throws Exception {
		return DataBaseAccess.getInstance().getUnassigned();

	}
	
	
	public List<String> getWIP() throws Exception {
		return DataBaseAccess.getInstance().getWIP();

	}
	
	public List<String> getComments() throws Exception {
		return DataBaseAccess.getInstance().getComments();

	}
	
	
	
	public List<String> getHold() throws Exception {
		return DataBaseAccess.getInstance().getHold();

	}
	
	public List<String> getClosed() throws Exception {
		return DataBaseAccess.getInstance().getClosed();

	}
	
	public List<String> getStatusNames() throws Exception {
		return DataBaseAccess.getInstance().getStatusNames();

	}
	
	

	public List<Ticket> getTickets(String userName) throws Exception {
		return DataBaseAccess.getInstance().geTickets(userName);
	}

	public List<Ticket> getPrioNames(String prio) throws Exception {
		return DataBaseAccess.getInstance().getPrioNames(prio);
	}

	public List<String> getLabNamesFiltretion() {
		return labNamesFiltretion;
	}

	public List<String> getTypeNamesFiltretion() {
		return typeNamesFiltretion;
	}
	
	public List<String> getPrioNamesFiltretion() {
		return prioNamesFiltretion;
	}
	
	public List<String> getStatusNamesFiltretion() {
		return statusNamesFiltretion;
	}

	public List<Ticket> getAllTickets() throws Exception {
		List<Ticket> allticket = DataBaseAccess.getInstance().getAllTickets();

		for (Ticket ticket : allticket) {
			if (!labNamesFiltretion.contains(ticket.getLab())) {
				labNamesFiltretion.add(ticket.getLab());
			}
			if (!typeNamesFiltretion.contains(ticket.getType())) {
				typeNamesFiltretion.add(ticket.getType());
			}
			if (!prioNamesFiltretion.contains(ticket.getPriority())) {
				prioNamesFiltretion.add(ticket.getPriority());
			}
			if (!statusNamesFiltretion.contains(ticket.getStatus())) {
				statusNamesFiltretion.add(ticket.getStatus());
			}
		}
		return allticket;
	}
	
	
}
