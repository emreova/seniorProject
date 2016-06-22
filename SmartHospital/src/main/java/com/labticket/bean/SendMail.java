package com.labticket.bean;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

   public static void main(String[] args) throws IOException, AddressException {
      // Set the host smtp address
      String message = "Still not getting result";
      String subject = "test2";
      Properties props = new Properties();
      props.put("mail.smtp.host", "netcas00.netas.com.tr");
      props.put("mail.transport.protocol", "smtp");

      // InternetAddress[] addressTo = new InternetAddress[10];
      // addressTo[0] = new InternetAddress("nince@netas.com.tr");

      // create some properties and get the default Session
      Session session = Session.getInstance(props, null);
      session.setDebug(false);

      // create a message
      Message msg = new MimeMessage(session);

      // set the from and to address
      InternetAddress addressFrom;
      try {
         addressFrom = new InternetAddress("emreova5@gmail.com");
         msg.setFrom(addressFrom);
         msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("emreova5@gmail.com"));

         // msg.setRecipients(Message.RecipientType.TO, addressTo);

         msg.setSubject(subject);
         msg.setHeader("Content-Type", "text/html");
         msg.setText(message);
         Transport.send(msg);
         
         
      }
      catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}