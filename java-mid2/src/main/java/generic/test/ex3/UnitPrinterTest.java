package generic.test.ex3;

import generic.test.ex3.unit.Marine;
import generic.test.ex3.unit.Zealot;
import generic.test.ex3.unit.Zergling;

public class UnitPrinterTest {

  public static void main(String[] args) {
    Shuttle<Marine> shuttle1 = new Shuttle<>();
    shuttle1.in(new Marine("마린", 40));

    UnitPrinter.printV1(shuttle1);
    UnitPrinter.printV2(shuttle1);

    Shuttle<Zealot> shuttle2 = new Shuttle<>();
    shuttle2.in(new Zealot("질럿", 150));

    UnitPrinter.printV1(shuttle2);
    UnitPrinter.printV2(shuttle2);

    Shuttle<Zergling> shuttle3 = new Shuttle<>();
    shuttle3.in(new Zergling("저글링", 35));

    UnitPrinter.printV1(shuttle3);
    UnitPrinter.printV2(shuttle3);
  }
}
