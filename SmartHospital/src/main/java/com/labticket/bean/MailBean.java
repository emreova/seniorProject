package com.labticket.bean;

import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
@ManagedBean
@RequestScoped
public class MailBean {
static String gorus;
static String ad;
static String mailAdresi;
 
    public String getGorus() {
        return gorus;
    }
 
    public void setGorus(String gorus) {
        this.gorus = gorus;
    }
 
    public String getAd() {
        return ad;
    }
 
    public void setAd(String ad) {
        this.ad = ad;
    }
 
    public String getMailAdresi() {
        return mailAdresi;
    }
 
    public void setMailAdresi(String mailAdresi) {
        this.mailAdresi = mailAdresi;
    }
 
    public  void mailAt(){
             final String username = "emreova5@gmail.com";
             final String password = "Emre1905";
             Properties properties = new Properties();
             properties.put("mail.smtp.auth", "true");
             properties.put("mail.smtp.starttls.enable", "true");
             properties.put("mail.smtp.host", "smtp.gmail.com");
             properties.put("mail.smtp.port", "587");
 
             Session session = Session.getInstance(properties,
                           new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                           return new PasswordAuthentication(username, password);
                    }
             }); 
             try {
 
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("biseyler@bisey.com"));
                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("emreova5@gmail.com"));
                    message.setSubject("Smart Hospital Information");
                    message.setText(mailAdresi+"'den gelen mail su sekilde:n"+ad+" "+gorus); 
                    Transport.send(message);
 
             } catch (MessagingException ex) {
                    throw new RuntimeException(ex);
             }
       }
}