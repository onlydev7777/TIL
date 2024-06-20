package generic.ex5;

import generic.animal.Animal;

public class WildcardEx {

  public static <T> void printGenericV1(Box<T> box) {
    T t = box.get();
    System.out.println("t.getClass() = " + t.getClass());
  }

  public static void printWildcardV1(Box<?> box) {
    Object object = box.get();
    System.out.println("object.getClass() = " + object.getClass());
  }

  public static <T extends Animal> void printGenericV2(Box<T> box) {
    T t = box.get();
    System.out.println("이름 = " + t.getName());
  }

  public static void printWildcardV2(Box<? extends Animal> box) {
    Animal animal = box.get();
    System.out.println("이름 = " + animal.getName());
  }

  public static <T extends Animal> T printAndReturnGeneric(Box<T> box) {
    T t = box.get();
    System.out.println("이름 = " + t.getName());
    return t;
  }

  public static Animal printAndReturnWildcard(Box<? extends Animal> box) {
    Animal animal = box.get();
    System.out.println("이름 = " + animal.getName());
    return animal;
  }
}
