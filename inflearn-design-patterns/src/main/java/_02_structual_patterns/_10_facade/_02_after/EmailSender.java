package _02_structual_patterns._10_facade._02_after;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {

  private final EmailSetting setting;

  public EmailSender(EmailSetting setting) {
    this.setting = setting;
  }

  public void sendEmail(EmailMessage emailMessage) {
    Properties properties = System.getProperties();
    properties.setProperty("mail.smtp.host", setting.getHosts());

    Session session = Session.getDefaultInstance(properties);

    try {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(emailMessage.getFrom()));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailMessage.getTo()));
      message.addRecipient(Message.RecipientType.CC, new InternetAddress(emailMessage.getCc()));
      message.setSubject(emailMessage.getSubject());
      message.setText(emailMessage.getText());

      Transport.send(message);
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }
}
