package com.labticket.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.annotation.PostConstruct;

import com.labticket.controller.CreateTicketController;
import com.labticket.data.Ticket;
import com.labticket.database.DataBaseAccess;

@SuppressWarnings("restriction")
@ManagedBean
@SessionScoped
public class HomePageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<String> getGetWIP() {
		return getWIP;
	}

	public void setGetWIP(List<String> getWIP) {
		this.getWIP = getWIP;
	}

	private List<Ticket> myTickets;
	private List<Ticket> queues;
	public List<Ticket> priority;
	public List<Ticket> status;

	private List<Ticket> allTickets;


	private List<Ticket> filteredTickets;
	private List<String> getHigh;
	private List<String> getUnassigned;
	private List<String> getWIP;
	private List<String> getHold;
	private List<String> getClosed;
	private List<String> comments;
	private List<Ticket> allPrios;
	

	public List<Ticket> getAllPrios() {
		return allPrios;
	}

	public void setAllPrios(List<Ticket> allPrios) {
		this.allPrios = allPrios;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public List<String> getGetClosed() {
		return getClosed;
	}

	public void setGetClosed(List<String> getClosed) {
		this.getClosed = getClosed;
	}

	public List<String> getGetHold() {
		return getHold;
	}

	public void setGetHold(List<String> getHold) {
		this.getHold = getHold;
	}

	public List<String> getGetUnassigned() {
		return getUnassigned;
	}

	public void setGetUnassigned(List<String> getUnassigned) {
		this.getUnassigned = getUnassigned;
	}

	CreateTicketController createTicketController = new CreateTicketController();

	@PostConstruct
	public void init() {
		try {
			Session.getInstance().init();
			myTickets = createTicketController.getTickets("ebilen");
			queues = createTicketController.getTickets("labticket");
			allTickets = createTicketController.getAllTickets();

			getHigh = createTicketController.getHigh();
			getUnassigned = createTicketController.getUnassigned();
			getWIP = createTicketController.getWIP();
			getHold = createTicketController.getHold();
			getClosed = createTicketController.getClosed();
			comments = createTicketController.getComments();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	public List<String> getGetHigh() {
		return getHigh;
	}

	public void setGetHigh(List<String> getHigh) {
		this.getHigh = getHigh;
	}

	public List<Ticket> getQueues() {
		return queues;
	}

	public List<Ticket> getMyTickets() {
		return myTickets;
	}

	public List<Ticket> getPriority() {
		return priority;
	}

	public void assign(Ticket ticket, String fullname) throws Exception {
		DataBaseAccess.getInstance().assign(ticket,fullname);
	}

	public void deletePrio(Ticket ticket) throws Exception {
		// DataBaseAccess.getInstance().deletePrio(ticket);
	}

	public void updatePrio(Ticket ticket) throws Exception {
		// DataBaseAccess.getInstance().updatePrio(ticket);
	}

	@SuppressWarnings("unchecked")
	public boolean filterByPrice(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim();
		if (filterText == null || filterText.equals("")) {
			return true;
		}

		if (value == null) {
			return false;
		}

		return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
	}

	public List<String> getLabNamesFiltretion() {
		return createTicketController.getLabNamesFiltretion();
	}

	public List<String> getTypeNamesFiltretion() {
		return createTicketController.getTypeNamesFiltretion();
	}
	
	public List<String> getPrioNamesFiltretion() {
		return createTicketController.getPrioNamesFiltretion();
	}
	
	
	public List<String> getStatusNamesFiltretion() {
		return createTicketController.getStatusNamesFiltretion();
	}
	
	public List<Ticket> getAllTickets() {
		return allTickets;
	}

	public List<Ticket> getFilteredTickets() {
		return filteredTickets;
	}

	public void setFilteredTickets(List<Ticket> filteredTickets) {
		this.filteredTickets = filteredTickets;
	}
}
