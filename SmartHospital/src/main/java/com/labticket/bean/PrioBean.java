package com.labticket.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



import javax.faces.event.ActionEvent;

import com.labticket.controller.CreateTicketController;
import com.labticket.data.Ticket;
import com.labticket.database.DataBaseAccess;

@SuppressWarnings("restriction")
@ManagedBean
@SessionScoped
public class PrioBean implements Serializable {

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String oldPrioName;
	private String newPrioName;
	private List<String> prioNames;
	private List<Ticket> prioDepts;
	
	public Ticket getSelectedPrio() {
		return selectedPrio;
	}

	public void setSelectedPrio(Ticket selectedPrio) {
		this.selectedPrio = selectedPrio;
	}

	public Ticket selectedPrio;


	public List<Ticket> getPrioDepts() {
		return prioDepts;
	}

	public void setPrioDepts(List<Ticket> prioDepts) {
		this.prioDepts = prioDepts;
	}

	private String insertname;
	
	
	public String getInsertname() {
		return insertname;
	}

	public void setInsertname(String insertname) {
		this.insertname = insertname;
	}

	public String getNewPrioName() {
		return newPrioName;
	}

	public void setNewPrioName(String newPrioName) {
		this.newPrioName = newPrioName;
	}

	public String getOldPrioName() {
		return oldPrioName;
	}

	public void setOldPrioName(String oldPrioName) {
		this.oldPrioName = oldPrioName;
	}

	public List<String> getPrioNames() {
		return prioNames;
	}

	public void setPrioNames(List<String> prioNames) {
		this.prioNames = prioNames;
	}

	CreateTicketController createTicketController = new CreateTicketController();

	@PostConstruct
	public void init() {
		try {
			loadLabNames();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadLabNames() {
		try {
			prioNames = createTicketController.getAllPrioNames();
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	 

	public void handlePrioDelete(String prio) throws Exception {
		DataBaseAccess.getInstance().deletePrio(prio);
		addMessage("Selected Prio is deleted.");
	
	}
	

	


	public void handleOldPrioName(String oldPrioName) throws Exception {
		this.oldPrioName = oldPrioName;
	}
	
	public void handlePrioUpdate() throws Exception {
		DataBaseAccess.getInstance().updatePrio(newPrioName, oldPrioName);
	}
	
	public void handlePrioAdd(ActionEvent actionEvent) throws Exception {
		DataBaseAccess.getInstance().addPrio(insertname);
		addMessage("Ticket is created. Confirmation mail is sent to admin.");

	
	}
	
	
	
	
	 public void addMessage(String summary) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	

	
	

	
	



}
