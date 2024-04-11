# Singleton Patterns

◼︎ LegacySingleton

- 멀티쓰레드 환경에서 동시 접근 시 N개의 오브젝트가 반환될 수 있음

```java
public class LegacySingleton {

  private static LegacySingleton instance;

  private LegacySingleton() {

  }

  public static LegacySingleton getInstance() {
    if (instance == null) {
      return new LegacySingleton();
    }
    return instance;
  }
}
```

◼ 싱글턴 패턴 정의
︎
> 싱글턴 패턴은 해당 클래스의 인스턴스가 하나만 만들어지고 어디서든지 그 인스턴스에 접근할 수 있도록 하기 위한 패턴

◼︎ 멀티스레드 환경에서의 싱글턴 패턴 해결법

1. synchronized 메서드

- 멀티스레드 환경에서 synchronized 메서드로 해결
- getInstance 메서드 호출 시 마다 synchronized 처리가 되기 때문에 불필요한 오버헤드 증가 > 성능에 좋지 못함

```java
public class SynchronizedSingleton {

  private static SynchronizedSingleton instance;

  private SynchronizedSingleton() {

  }

  public static synchronized SynchronizedSingleton getInstance() {
    if (instance == null) {
      return new SynchronizedSingleton();
    }
    return instance;
  }
}
```

2. 어플리케이션 기동 시 초기화

- JVM 클래스 로드 시 초기화

```java
public class ApplicationInitializedSingleton {

  private static ApplicationInitializedSingleton instance = new ApplicationInitializedSingleton();

  private ApplicationInitializedSingleton() {

  }

  public static ApplicationInitializedSingleton getInstance() {
    return instance;
  }
}
```

3. DCL(double-checking-lock)을 써서 getInstance 동기화 로직 최초 1번 처리

- volatile 키워드를 사용하면 멀티스레딩 환경에서도 instance 변수가 최초 1번 생성될 때 동기화 블럭을 수행해 오버헤드를 줄입니다.
- DCL은 java 1.4 이전 버전에서는 사용할 수 없음

```java
public class VolatileSingleton {

  private volatile static VolatileSingleton instance;

  private VolatileSingleton() {

  }

  public static VolatileSingleton getInstance() {
    if (instance == null) {
      synchronized (VolatileSingleton.class) {
        if (instance == null) {
          instance = new VolatileSingleton();
        }
      }
    }
    return instance;
  }
}
```

4. LazyHolder

- 가장 많이 사용되는 싱글턴 구현 방식
- LazyHolderSingleton 클래스에 InnerClass 변수가 없기 때문에 InnerClass가 static 클래스이지만 클래스 로더가 어플리케이션 기동 시 초기화
  하지 않음
- getInstance 메서드 호출 할 때 초기화 되며 static으로 이미 할당된 class이기 때문에 Thread-Safe 함

```java
public class LazyHolderSingleton {

  private LazyHolderSingleton() {

  }

  public static LazyHolderSingleton getInstance() {
    return InnerClass.instance;
  }

  private static class InnerClass {

    private static final LazyHolderSingleton instance = new LazyHolderSingleton();
  }
}
```