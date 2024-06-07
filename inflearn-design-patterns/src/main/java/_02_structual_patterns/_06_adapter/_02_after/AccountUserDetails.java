package _02_structual_patterns._06_adapter._02_after;

import _02_structual_patterns._06_adapter._01_before.Account;
import _02_structual_patterns._06_adapter._01_before.security.UserDetails;

public class AccountUserDetails implements UserDetails {

  private final Account account;

  public AccountUserDetails(Account account) {
    this.account = account;
  }

  @Override
  public String getUsername() {
    return account.getName();
  }

  @Override
  public String getPassword() {
    return account.getPassword();
  }
}
