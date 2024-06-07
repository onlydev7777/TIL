package _01_creational_patterns._01_singleton;

public class App {

  public static void main(String[] args) {
    //1. private 생성자 방식 : 멀티스레드 환경에서 싱글톤 보장 할 수 없음
    Setting1 setting1 = Setting1.getInstance();
    Setting1 setting1_2 = Setting1.getInstance();
    System.out.println(setting1 == setting1_2);

    //2. synchronized 방식 : 동기화 블럭에 대한 처리 비용 발생
    Setting2 setting2 = Setting2.getInstance();
    Setting2 setting2_2 = Setting2.getInstance();
    System.out.println(setting2 == setting2_2);

    //3. DCL 방식 : 2번의 성능 이슈 해결, 그러나 코드 복잡
    Setting3 setting3 = Setting3.getInstance();
    Setting3 setting3_2 = Setting3.getInstance();
    System.out.println(setting3 == setting3_2);

    //4. static inner class holder : 호출 시점 메모리 할당, 성능/멀티스레드 이슈 해결, 가장 많이 쓰이는 싱글톤 패턴
    Setting4 setting4 = Setting4.getInstance();
    Setting4 setting4_2 = Setting4.getInstance();
    System.out.println(setting4 == setting4_2);
  }
}
