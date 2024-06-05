package _01_singleton;

public class RuntimeExample {

  public static void main(String[] args) {
    //java 런타임 라이브러리에서 싱글톤 패턴 사용, 어플리케이션 기동시점 메모리 할당 방식
    Runtime runtime = Runtime.getRuntime();
    System.out.println("runtime.freeMemory = " + runtime.freeMemory());
    System.out.println("runtime.maxMemory = " + runtime.maxMemory());
  }
}
