package _02_structual_patterns._12_proxy._02_after;


public class Client {

  public static void main(String[] args) throws InterruptedException {
    GameServiceProxy gameServiceProxy = new GameServiceProxy(new DefaultGameService());
    gameServiceProxy.startGame();
  }
}
