package _02_structual_patterns._10_facade._02_after;

public class EmailSetting {

  private final String hosts;

  public EmailSetting(String hosts) {
    this.hosts = hosts;
  }

  public String getHosts() {
    return hosts;
  }
}
