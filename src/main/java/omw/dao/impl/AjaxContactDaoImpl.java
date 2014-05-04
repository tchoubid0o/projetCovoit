package omw.dao.impl;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

import omw.dao.AjaxContactDao;


public class AjaxContactDaoImpl implements AjaxContactDao {
	
	public AjaxContactDaoImpl() {
	}
	
	public String addContactMessage(String email,String nom,String message) throws UnknownHostException{
		

			
			Properties props = System.getProperties();
	        props.put("mail.smtps.host","smtp.gmail.com");
	        props.put("mail.smtps.auth","true");
	        Session session = Session.getInstance(props, null);
	        Message msg = new MimeMessage(session);
	        try {
				msg.setFrom(new InternetAddress(email));
			} catch (AddressException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			};
	        try {
				msg.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("covoituragehei@gmail.com", false));//Destinataire
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				msg.setSubject("Contact CoVoiturageHEI");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				msg.setText("De: "+nom+"\n Email: "+email+"\n Message: "+message+"\n");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				msg.setHeader("X-Mailer", "Tov Are's program");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				msg.setSentDate(new Date());
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        SMTPTransport t = null;
			try {
				t = (SMTPTransport)session.getTransport("smtps");
			} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				t.connect("smtp.gmail.com", "covoituragehei@gmail.com", "tamaman001@");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				t.sendMessage(msg, msg.getAllRecipients());
			} catch (SendFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("Response: " + t.getLastServerResponse());
	        try {
				t.close();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "Votre formulaire de contact a bien &eacute;t&eacute; transmis.";
	}
}
