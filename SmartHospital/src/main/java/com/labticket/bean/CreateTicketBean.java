package com.labticket.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

import com.labticket.controller.CreateTicketController;

import com.labticket.data.Ticket;
import com.labticket.database.DataBaseAccess;

@SuppressWarnings("restriction")
@ManagedBean
@SessionScoped
public class CreateTicketBean {

	CreateTicketController createTicketController = new CreateTicketController();

	private String labName;
	private List<String> labNames;
	private String typeName;
	private List<String> typeNames;
	private String prioName;
	private List<String> prioNames;
	private String subject;
	private String description;
	private String insertname;
	public Ticket oldTicket;
	public String newTicket;
	private String status;
	private String insertcomment;

	public String getInsertcomment() {
		return insertcomment;
	}

	public void setInsertcomment(String insertcomment) {
		this.insertcomment = insertcomment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInsertname() {
		return insertname;
	}

	public void setInsertname(String insertname) {
		this.insertname = insertname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEsc_prime() {
		return esc_prime;
	}

	public void setEsc_prime(String esc_prime) {
		this.esc_prime = esc_prime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	private String esc_prime;
	private String comment;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPrioName() {
		return prioName;
	}

	public void setPrioName(String prioName) {
		this.prioName = prioName;
	}

	public List<String> getPrioNames() {
		return prioNames;
	}

	public void setPrioNames(List<String> prioNames) {
		this.prioNames = prioNames;
	}

	public List<String> getTypeNames() {
		return typeNames;
	}

	public void setTypeNames(List<String> typeNames) {
		this.typeNames = typeNames;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<String> getLabNames() {
		return labNames;
	}

	public void setLabNames(List<String> labNames) {
		this.labNames = labNames;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	@PostConstruct
	public void init() {
		try {
			loadLabNames();
			loadTypeNames();
			loadPrioNames();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadLabNames() {
		try {
			labNames = createTicketController.getLabNames();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadTypeNames() {
		try {
			typeNames = createTicketController.getTypeNames();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadPrioNames() {
		try {
			prioNames = createTicketController.getPrioNames();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Ticket> createTickets(int size) {
		List<Ticket> list = new ArrayList<Ticket>();
		for (int i = 0; i < size; i++) {
			list.add(new Ticket(getLabName(), getSubject(), getDescription(),
					getEsc_prime(), getPrioName(), getTypeName()));
		}

		return list;
	}

	public void createTicket(ActionEvent actionEvent) throws Exception {
		Ticket ticket = new Ticket(labName, subject, description, esc_prime,
				prioName, typeName);
		DataBaseAccess.getInstance().createTicket(ticket);
		// MailManager.sendcreateTicketMail();

	}

	public Ticket getOldTicket() {
		return oldTicket;
	}

	public void setOldTicket(Ticket oldTicket) {
		this.oldTicket = oldTicket;
	}

	public String getNewTicket() {
		return newTicket;
	}

	public void setNewTicket(String newTicket) {
		this.newTicket = newTicket;
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
