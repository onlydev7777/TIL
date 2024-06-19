package _03_behavioral_patterns._18_memento._02_after;


public class Client {

  public static void main(String[] args) {
    Game game = new Game();
    game.setRedTeamScore(10);
    game.setBlueTeamScore(20);

    GameSave save = game.save();

    game.setBlueTeamScore(12);
    game.setRedTeamScore(24);

    game.restore(save);

    System.out.println(game.getBlueTeamScore());
    System.out.println(game.getRedTeamScore());
  }
}
