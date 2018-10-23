package Agentconsumer.Controller;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailVer {
    public static void main(String[] args) {

        final String username = "IConsumerAgentCSCI3300@gmail.com";
        final String password = "FreezeDriedLiquorMonkeys";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("IConsumerAgentCSCI3300@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("AlexKirby7@gmail.com"));
            message.setSubject("Email Test");
            message.setText("Dear tester,"
                    + "\n\n Testing!!!!!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

