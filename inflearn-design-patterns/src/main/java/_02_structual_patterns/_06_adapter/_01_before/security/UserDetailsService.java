package _02_structual_patterns._06_adapter._01_before.security;

public interface UserDetailsService {

  UserDetails loadUser(String username);

}
