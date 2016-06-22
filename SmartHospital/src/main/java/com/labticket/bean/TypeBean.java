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
public class TypeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String typeName;
	private List<String> typeNames;
	private String insertname;

	public String getInsertname() {
		return insertname;
	}

	public void setInsertname(String insertname) {
		this.insertname = insertname;
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
			typeNames = createTicketController.getTypeNames();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void handleTypeAdd() throws Exception {
		DataBaseAccess.getInstance().addType(insertname);

		addMessage("New type is inserted.");
	}
	
	public void handleTypeDelete(String type) throws Exception{
		DataBaseAccess.getInstance().deleteType(type);
		
		addMessage("Selected Ticket is deleted.");
	}
	
	  public void addMessage(String summary) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
}