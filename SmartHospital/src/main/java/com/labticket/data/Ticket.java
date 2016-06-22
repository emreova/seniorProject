package com.labticket.data;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket{

	public Ticket(String lab, String subject, String desc,
			String escprime, String priority, String type) {
		super();
		this.lab = lab;
		this.subject = subject;
		this.desc = desc;
		this.escprime = escprime;
		this.priority = priority;
		this.type = type;
		this.assign = "labticket";
		
		


		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat(
				"dd.MM.yyyy");
		this.crdate = ft.format(dNow);
		this.frdate = ft.format(dNow);
		this.closedate = ft.format(dNow);
		this.reporter = "labticket";
		this.status = "Unassigned";
		this.release="release";
	
		
		
		
	
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	private String lab;
	private String subject;
	private String desc;
	private String assign;
	private String reporter;
	private String escprime;
	private String priority;
	private String type;
	private String status;
	private String crdate;
	private File attach;
	private int id;
	private String frdate;
	private String closedate;
	private String release;
	private String comment;

	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	


	public String getFrdate() {
		return frdate;
	}

	public void setFrdate(String frdate) {
		this.frdate = frdate;
	}

	public String getClosedate() {
		return closedate;
	}

	public void setClosedate(String closedate) {
		this.closedate = closedate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLab() {
		return lab;
	}

	public void setLab(String lab) {
		this.lab = lab;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAssign() {
		return assign;
	}

	public void setAssign(String assign) {
		this.assign = assign;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getEscprime() {
		return escprime;
	}

	public void setEscprime(String escprime) {
		this.escprime = escprime;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public File getAttach() {
		return attach;
	}

	public void setAttach(File attach) {
		this.attach = attach;
	}

	@Override
	public String toString() {
		return "Ticket [lab=" + lab + ", subject=" + subject + ", desc=" + desc
				+ ", assign=" + assign + ", reporter=" + reporter
				+ ", escprime=" + escprime + ", priority=" + priority
				+ ", type=" + type + ", status=" + status + ", crdate="
				+ crdate + ", attach=" + attach + ", id=" + id + ", frdate="
				+ frdate + ", closedate=" + closedate + ", release=" + release
				+ ", comment=" + comment + "]";
	}

	






}
