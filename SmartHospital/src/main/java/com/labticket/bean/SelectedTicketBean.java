package com.labticket.bean;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;

import com.labticket.controller.CreateTicketController;
import com.labticket.data.Ticket;
import com.labticket.database.DataBaseAccess;

@ManagedBean
@SessionScoped
public class SelectedTicketBean implements Serializable {



	private static final long serialVersionUID = 1L;

	public Ticket selectedTicket;

	
	private String labName;
	private List<String> labNames;
	private String typeName;
	private List<String> typeNames;
	private String prioName;
	private List<String> prioNames;
	private String subject;
	private String description;
	private String escprime;
	private String insertcomment;
	private File attach;

	

	 public String getInsertcomment() {
			return insertcomment;
		}
		public void setInsertcomment(String insertcomment) {
			this.insertcomment = insertcomment;
		}

	public String getEscprime() {
		return escprime;
	}
	public void setEscprime(String escprime) {
		this.escprime = escprime;
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
	public List<String> getLabNames() {
		return labNames;
	}
	public void setLabNames(List<String> labNames) {
		this.labNames = labNames;
	}

	

	public String getLabName() {
		return labName;
	}


	public Ticket getSelectedTicket() {
		return selectedTicket;
	}

	public void setSelectedTicket(Ticket selectedTicket) {
		this.selectedTicket = selectedTicket;
	}
	

	public File getAttach() {
		return attach;
	}
	public void setAttach(File attach) {
		this.attach = attach;
	}


	

	
	public void updateTicket(ActionEvent actionEvent) throws Exception {
		DataBaseAccess.getInstance().updateTicket(selectedTicket);
		addMessage("Appointment is updated.");
	}
	
	public void assignTicket(ActionEvent actionEvent) throws Exception {
		DataBaseAccess.getInstance().assignTicket(selectedTicket);
	
	}
	
	public void createComment(ActionEvent actionEvent) throws Exception {
		selectedTicket.setComment(insertcomment);
		DataBaseAccess.getInstance().createComment(selectedTicket);
		addMessage("Your comment is saved.");
	
	}
	


	public void handleFileUpload(FileUploadEvent event) throws Exception {
		selectedTicket.setAttach(attach);
		DataBaseAccess.getInstance().insertFile(selectedTicket);
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
	


	
	public void addMessage(String summary) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	  
	

	


}
