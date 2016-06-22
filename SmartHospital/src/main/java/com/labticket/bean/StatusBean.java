package com.labticket.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import com.labticket.controller.CreateTicketController;
import com.labticket.database.DataBaseAccess;

@SuppressWarnings("restriction")
@ManagedBean
@SessionScoped
public class StatusBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String statusName;
	private List<String> statusNames;
	private String insertname; 
	
	
	public String getInsertname() {
		return insertname;
	}

	public void setInsertname(String insertname) {
		this.insertname = insertname;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<String> getStatusNames() {
		return statusNames;
	}

	public void setStatusNames(List<String> statusNames) {
		this.statusNames = statusNames;
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
			statusNames = createTicketController.getStatusNames();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void handleStatusDelete(String status) throws Exception{
		DataBaseAccess.getInstance().deleteStatus(status);

	}
	
	public void handleStatusAdd() throws Exception {
		DataBaseAccess.getInstance().addStatus(insertname);

	
	}
	
	  public void addMessage(String summary) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }

}