package _02_structual_patterns._06_adapter._02_after;

import _02_structual_patterns._06_adapter._01_before.AccountService;
import _02_structual_patterns._06_adapter._01_before.security.LoginHandler;
import _02_structual_patterns._06_adapter._01_before.security.UserDetailsService;

public class App {

  public static void main(String[] args) {
    AccountService accountService = new AccountService();
    UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
    LoginHandler loginHandler = new LoginHandler(userDetailsService);
    String login = loginHandler.login("ykj", "ykj");
    System.out.println("login = " + login);
  }
}
