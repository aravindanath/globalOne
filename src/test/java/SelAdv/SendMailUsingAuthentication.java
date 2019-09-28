/*
Some SMTP servers require a username and password authentication before you
can use their Server for Sending mail. This is most common with couple
of ISP's who provide SMTP Address to Send Mail.

This Program gives any example on how to do SMTP Authentication
(User and Password verification)

This is a free source code and is provided as it is without any warranties and
it can be used in any your code for free.

Author : Sudhir Ancha
*/
package SelAdv;

import javax.mail.*;
import javax.mail.internet.*;

import org.testng.annotations.Test;

import java.util.*;
import java.io.*;

/**
 * Add: <!-- https://mvnrepository.com/artifact/javax.mail/javax.mail-api -->
 * <dependency> <groupId>javax.mail</groupId>
 * <artifactId>javax.mail-api</artifactId> <version>1.6.2</version>
 * </dependency>
 * 
 * 
 * https://myaccount.google.com/lesssecureapps
 * 
 * 
 * @author aravindanathdm
 *
 */

public class SendMailUsingAuthentication {

	public static final String SMTP_HOST_NAME = "smtp.gmail.com";
	public static final String SMTP_AUTH_USER = "senderEMAIL@gmail.com";
	public static final String SMTP_AUTH_PWD = "password";

	public static final String emailMsgTxt = "Error found while clicking on an element";
	public static final String emailSubjectTxt = "Please correct the Xpath, since on a click event no element was found";
	public static final String emailFromAddress = "senderEMAIL@gmail.com";

	// Add List of Email address to who email needs to be sent to
	public static final String[] emailList = { "email@gmail.com", "email@gmail.com" };

	public static void main(String args[]) throws Exception {
		SendMailUsingAuthentication smtpMailSender = new SendMailUsingAuthentication();
		smtpMailSender.postMail(emailList, emailSubjectTxt, emailMsgTxt, emailFromAddress);
		System.out.println("Sucessfully Sent mail to All Users");
	}

	public void postMail(String recipients[], String subject, String message, String from) throws MessagingException {
		boolean debug = false;

		// Set the host smtp address
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");

		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props, auth);

		session.setDebug(debug);

		// create a message
		Message msg = new MimeMessage(session);

		// set the from and to address
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);

		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++) {
			addressTo[i] = new InternetAddress(recipients[i]);
		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);

		// Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(message, "text/plain");

		Transport.send(msg);
		System.out.println("Sucessfully Sent mail to All Users");
	}

	/**
	 * SimpleAuthenticator is used to do simple authentication when the SMTP server
	 * requires it.
	 */
	private class SMTPAuthenticator extends javax.mail.Authenticator {

		public PasswordAuthentication getPasswordAuthentication() {
			String username = SMTP_AUTH_USER;
			String password = SMTP_AUTH_PWD;
			return new PasswordAuthentication(username, password);
		}
	}

}
