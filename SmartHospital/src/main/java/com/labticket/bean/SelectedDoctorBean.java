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
import com.labticket.data.Doctor;
import com.labticket.data.Ticket;
import com.labticket.database.DataBaseAccess;

@ManagedBean
@SessionScoped
public class SelectedDoctorBean implements Serializable {



	public Doctor getSelectedDoctor() {
		return selectedDoctor;
	}

	public void setSelectedDoctor(Doctor selectedDoctor) {
		this.selectedDoctor = selectedDoctor;
	}

	private static final long serialVersionUID = 1L;

     public Doctor selectedDoctor;

	


}

