package _02_structual_patterns._12_proxy._02_after;

public class DefaultGameService implements GameService {

  @Override
  public void startGame() {
    System.out.println("DefaultGameService.startGame");
  }
}
