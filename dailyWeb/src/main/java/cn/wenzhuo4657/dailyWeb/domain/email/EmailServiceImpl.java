package cn.wenzhuo4657.dailyWeb.domain.email;

import cn.wenzhuo4657.dailyWeb.Main;
import cn.wenzhuo4657.dailyWeb.config.EmailProperties;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private EmailProperties emailProperties;

    @Override
    public boolean sendEmail() {
        return sendEmail(emailProperties.from(), emailProperties.password(), emailProperties.to(), "daily-WEB", "备份", Main.getDbfilePath());
    }


    private boolean sendEmail(String from, String password, String to, String subject, String content, Path beifen) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress( from, "DailyWeb"));
            msg.setReplyTo(new Address[]{new InternetAddress(to)});
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to,  false));
            msg.setSubject( subject);


            MimeBodyPart html = new MimeBodyPart();
            html.setContent("<p>"+content+"</p>", "text/html; charset=UTF-8");
            MimeBodyPart attach = new MimeBodyPart();
            attach.attachFile(beifen.toFile());
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(html);
            multipart.addBodyPart(attach);


            msg.setContent(multipart);


            Transport.send(msg);


            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
