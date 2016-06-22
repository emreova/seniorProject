package com.labticket.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.labticket.controller.CreateTicketController;
import com.labticket.data.Ticket;
import com.labticket.database.DataBaseAccess;


@SuppressWarnings("restriction")
@ManagedBean
@SessionScoped
public class TicketDetailsBean {
	
	CreateTicketController createTicketController = new CreateTicketController();
	
	private String labName;
	private List<String> labNames;
	private String typeName;
	private List<String> typeNames;
	private String prioName;
	private List<String> prioNames;
	private String subject;
	private String description;
	private String assignee;
	private String reporter;
	private String status;
	private String crdate;
	private String escprime;
	private String frdate;
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}
	public List<String> getLabNames() {
		return labNames;
	}
	public void setLabNames(List<String> labNames) {
		this.labNames = labNames;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public List<String> getTypeNames() {
		return typeNames;
	}
	public void setTypeNames(List<String> typeNames) {
		this.typeNames = typeNames;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCrdate() {
		return crdate;
	}
	public void setCrdate(String crdate) {
		this.crdate = crdate;
	}
	public String getEscprime() {
		return escprime;
	}
	public void setEscprime(String escprime) {
		this.escprime = escprime;
	}
	public String getFrdate() {
		return frdate;
	}
	public void setFrdate(String frdate) {
		this.frdate = frdate;
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

	
	
	

	
	
	

}
