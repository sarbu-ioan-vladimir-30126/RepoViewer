/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package utcn.repoviewer;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author ocuibus
 */
public class StudentManager {

    public static final boolean DoSendEmails = false;

    public StudentManager() {
        try {
            this.loadStudentsInformation();
        } catch (Exception e) {
            System.err.println("Some error occured when parsing the csv file. You may not use this functionality.");
            e.printStackTrace();
        }
    }

    public void sendEmail(String fromEmail, String password, String toEmail, String emailBody, String fullPathToAttachment) throws MessagingException {
        String host = "smtp.office365.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject("Your git feedback");
        // Create the message with body and attachment
        Multipart multipart = new MimeMultipart();
        BodyPart messageBodyPart;
        //body
        messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(emailBody);
        multipart.addBodyPart(messageBodyPart);
        //attachment
        if (fullPathToAttachment != null) {
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(fullPathToAttachment);
            messageBodyPart.setDataHandler(new DataHandler(source));
            String fileName = Paths.get(fullPathToAttachment).getFileName().toString();
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);
        }
        // Send the complete message parts
        message.setContent(multipart);
        Transport.send(message);
    }

    private void loadStudentsInformation() throws FileNotFoundException, IOException {
        studentsInformation.clear();
        CSVReader reader = new CSVReader(new FileReader("./src/main/resources/ISP_Formular_de_inscriere.csv"));
        List list = reader.readAll();
        Iterator it = list.iterator();
        it.next(); // this is the header line of the file
        while (it.hasNext()) {
            String[] str = (String[]) it.next();
            StudentInformation studentInfo = new StudentInformation(str[3], str[2], str[4], str[1], str[5]);
            studentsInformation.add(studentInfo);
        }
    }

    public ArrayList<StudentInformation> getStudentsInformation() {
        return studentsInformation;
    }

    private ArrayList<StudentInformation> studentsInformation = new ArrayList<StudentInformation>();
}
