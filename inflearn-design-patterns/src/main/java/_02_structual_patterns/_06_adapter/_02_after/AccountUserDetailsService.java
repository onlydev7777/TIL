package _02_structual_patterns._06_adapter._02_after;

import _02_structual_patterns._06_adapter._01_before.Account;
import _02_structual_patterns._06_adapter._01_before.AccountService;
import _02_structual_patterns._06_adapter._01_before.security.UserDetails;
import _02_structual_patterns._06_adapter._01_before.security.UserDetailsService;

public class AccountUserDetailsService implements UserDetailsService {

  private final AccountService accountService;

  public AccountUserDetailsService(AccountService accountService) {
    this.accountService = accountService;
  }

  @Override
  public UserDetails loadUser(String username) {
    Account account = accountService.findAccountByUsername(username);
    return new AccountUserDetails(account);
  }
}
