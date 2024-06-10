package _02_structual_patterns._10_facade._02_after;

public class Client {

  public static void main(String[] args) {
    EmailSender emailSender = new EmailSender(new EmailSetting("127.0.0.1"));
    EmailMessage emailMessage = new EmailMessage();
    emailMessage.setFrom("from_ykj");
    emailMessage.setTo("to_test");
    emailMessage.setCc("일남");
    emailMessage.setSubject("오징어게임");
    emailMessage.setText("밖은 더 지옥이더라고..");

    emailSender.sendEmail(emailMessage);
  }
}
