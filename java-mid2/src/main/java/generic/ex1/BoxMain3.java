package generic.ex1;

public class BoxMain3 {

  public static void main(String[] args) {
    GenericBox<Integer> integerGenericBox = new GenericBox<>();
    integerGenericBox.set(10);
    Integer integer = integerGenericBox.get();
    System.out.println("integer = " + integer);

    GenericBox<String> stringGenericBox = new GenericBox<>();
    stringGenericBox.set("hello");
    String str = stringGenericBox.get();
    System.out.println("str = " + str);
  }
}
