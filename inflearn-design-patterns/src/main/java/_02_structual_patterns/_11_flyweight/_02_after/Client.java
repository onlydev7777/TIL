package _02_structual_patterns._11_flyweight._02_after;

public class Client {

  public static void main(String[] args) {
    FontFactory fontFactory = new FontFactory();
    Character c1 = new Character('h', "white", fontFactory.createFont("nanum:12"));
    Character c2 = new Character('e', "white", fontFactory.createFont("nanum:12"));
    Character c3 = new Character('l', "white", fontFactory.createFont("nanum:12"));
  }
}
