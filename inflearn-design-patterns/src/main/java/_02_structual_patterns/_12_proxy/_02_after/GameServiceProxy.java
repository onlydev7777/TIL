package _02_structual_patterns._12_proxy._02_after;

public class GameServiceProxy implements GameService {

  private final GameService gameService;

  public GameServiceProxy(GameService gameService) {
    this.gameService = gameService;
  }

  @Override
  public void startGame() {
    long before = System.currentTimeMillis();
    this.gameService.startGame();
    System.out.println("delay = " + (System.currentTimeMillis() - before));
  }
}
