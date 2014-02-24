/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.util;

//import java.io.UnsupportedEncodingException;
//import java.util.Date;
//import java.util.Properties;
//import java.util.Random;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
 
 //import javax.mail
//import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SendEmail {

    private Log log = LogFactory.getLog("SendEmail.java");

    public SendEmail() {
    }

    public String sendMail(String userName, String passWord, String to) {

        log.info("IN SEND EMAIL");
        Properties myProperties = new Properties();
        myProperties.put("mail.smtp.host", "smtp.gmail.com");
        myProperties.put("mail.smtp.port", "587");
        myProperties.put("mail.smtp.auth", "true");
        myProperties.put("mail.debug", "true");
        myProperties.put("mail.smtp.starttls.enable", "true");
        log.info("MYPORPERTIES DONE");
        Session ses = Session.getDefaultInstance(myProperties, null);
        Message msg = new MimeMessage(ses);
        try {

            InternetAddress fromAddress = new InternetAddress("c1xproto@gmail.com", "c1xproto");
            InternetAddress toAddress = new InternetAddress(to);/* OSend to one receipient */
            msg.setFrom(fromAddress);
            msg.setRecipient(Message.RecipientType.TO, toAddress);    /* OSend to more  receipient */
            msg.setSubject("Welcome to C1");  
            String htmlContent = "<table width= '100%'  border= '0' cellspacing='3'  cellpadding= '3'  bgcolor= '#F4F4F4' >"
                    + "<tr bgcolor=\"#333334\">     <td colspan=2 align= center > <h1><font color=\"#FFFFFF\">Welcome to C1</font></h1> </td> </tr> "
                    + "<tr>   "
                    + "<td colspan=2 align= center > <hr/> </td> </tr>   <tr>"
                    + "<td width= 30% ><b>Your User name is</b> </td>"
                    + "<td width= 79% >" + userName + "</td> "
                    + "</tr> "
                    + "<tr> "
                    + "<td width= 30% ><b>Your Password is</b> </td> "
                    + "<td>" + passWord + "</td> "
                    + "</tr>"
                    + "<tr><td colspan=2 align= center > <hr/> </td>   </tr>"
                    + "<tr><td>&nbsp;</td><td>Click the  link to <a href= #  title= c1.com  target= _blank >login</a>: </td>    </tr>"
                    + "</table>";
            msg.setContent(htmlContent, "text/html"); /* HTML Message */
            msg.setSentDate(new Date());
            Transport trans = ses.getTransport("smtp");
            String password = "c1x123456";
            trans.connect("smtp.gmail.com", "c1xproto@gmail.com", password);
            msg.saveChanges();
            trans.sendMessage(msg, msg.getAllRecipients());
            trans.close();
            Random n = new Random();
            return "sending success" + n.nextLong();

        } catch (AddressException e) {
            e.printStackTrace();
            return "EXE 1";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "EXE 2";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "EXE 3";
        }

    }
    
    
    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
        
  String userName="C1 x proto"; String passWord="c1x123456"; String to="pjayam.thee@gmail.com";
      //  log.info("IN SEND EMAIL");
        Properties myProperties = new Properties();
        myProperties.put("mail.smtp.host", "smtp.gmail.com");
        myProperties.put("mail.smtp.port", "587");
        myProperties.put("mail.smtp.auth", "true");
        myProperties.put("mail.debug", "true");
        myProperties.put("mail.smtp.starttls.enable", "true");
       // log.info("MYPORPERTIES DONE");
        Session ses = Session.getDefaultInstance(myProperties, null);
        Message msg = new MimeMessage(ses);
        try {

            InternetAddress fromAddress = new InternetAddress("c1xproto@gmail.com", "c1xproto");
            InternetAddress toAddress = new InternetAddress(to);/* OSend to one receipient */
            msg.setFrom(fromAddress);
            msg.setRecipient(Message.RecipientType.TO, toAddress);    /* OSend to more  receipient */
            msg.setSubject("Welcome to C1");  
            String htmlContent = "<table width= '100%'  border= '0' cellspacing='3'  cellpadding= '3'  bgcolor= '#F4F4F4' >"
                    + "<tr bgcolor=\"#333334\">     <td colspan=2 align= center > <h1><font color=\"#FFFFFF\">Welcome to C1</font></h1> </td> </tr> "
                    + "<tr>   "
                    + "<td colspan=2 align= center > <hr/> </td> </tr>   <tr>"
                    + "<td width= 30% ><b>  User name :</b> </td>"
                    + "<td width= 79% >" + userName + "</td> "
                    + "</tr> "
                    + "<tr> "
                    + "<td width= 30% ><b>  Password :</b> </td> "
                    + "<td>" + passWord + "</td> "
                    + "</tr>"
                    + "<tr><td colspan=2 align= center > <hr/> </td>   </tr>"
                    + "<tr><td>&nbsp;</td><td>Click the  link to <a href= #  title= c1.com  target= _blank >login</a>: </td>    </tr>"
                    + "</table>";
            msg.setContent(htmlContent, "text/html"); /* HTML Message */
            msg.setSentDate(new Date());
            Transport trans = ses.getTransport("smtp");
            String password = "c1x123456";
            trans.connect("smtp.gmail.com", "c1xproto@gmail.com", password);
            msg.saveChanges();
            trans.sendMessage(msg, msg.getAllRecipients());
            trans.close();
            Random n = new Random();
            System.out.println(" n "+n);
           // return "sending success" + n.nextLong();

        } catch (AddressException e) {
            e.printStackTrace();
           // return "EXE 1";
        } catch (MessagingException e) {
            e.printStackTrace();
           // return "EXE 2";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
           // return "EXE 3";
        }

    }
}
