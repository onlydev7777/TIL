# adapter-patterns

> 한 클래스의 인터페이스를 클라이언트에서 사용하고자 하는 인터페이스로 변환합니다.
> 어댑터를 이용하면 인터페이스 호환성 문제 때문에 같이 쓸 수 없는 클래스들을 연결해서 쓸 수 있습니다.

## 일상 속의 어댑터

110v(유럽 소켓) <> 어댑터 소켓 <> 220v(국내 플러그)

## 객체지향 어댑터

기존 시스템 객체 <> 어댑터 객체 <> 새로운 시스템 객체

## 예제 1. Duck처럼 행동하는 Turkey 구현

#### 타겟 인터페이스 (Duck)

```java
public interface Duck {

  void quack();

  void fly();
}
```

#### 어댑티 (Turkey)

```java
public interface Turkey {

  void gobble();

  void fly();

}
```

#### 어댑터 (TurkeyAdapter)

```java
public class TurkeyAdapter implements Duck {  // Duck 구현

  private final Turkey turkey;  //Turkey(어댑티) 로 객체 구성

  public TurkeyAdapter(Turkey turkey) {
    this.turkey = turkey;
  }

  @Override
  public void quack() { //quack 메서드 호출 시 Turkey의 gobble 메서드 호출
    turkey.gobble();
  }

  @Override
  public void fly() {
    for (int i = 0; i < 5; i++) {
      turkey.fly();
    }
  }
}

```

#### 클라이언트 테스트

```java
public class DuckTestDrive {

  public static void main(String[] args) {
    Duck mallardDuck = new MallardDuck();
    testDuck(mallardDuck);

    Turkey wildTurkey = new WildTurkey();
    wildTurkey.gobble();
    wildTurkey.fly();

    System.out.println("=============================");

    TurkeyAdapter turkeyAdapter = new TurkeyAdapter(wildTurkey);
    testDuck(turkeyAdapter);
  }

  private static void testDuck(Duck duck) {
    duck.quack();
    duck.fly();
  }

}
```

### 예제 2. Enumeration을 Iterator로 변환

#### 어댑터 (EnumerationIterator)

```java
public class EnumerationIterator implements Iterator {

  private final Enumeration enumeration;

  public EnumerationIterator(Enumeration enumeration) {
    this.enumeration = enumeration;
  }

  @Override
  public boolean hasNext() {
    return enumeration.hasMoreElements();
  }

  @Override
  public Object next() {
    return enumeration.nextElement();
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();    // Enumeration은 Iterator의 remove 메서드 지원하지 않음
  }
}

```

#### 클라이언트 테스트 (EnumerationIteratorTest)

```java
public class EnumerationIteratorTest {

  public static void main(String[] args) {
    Vector<String> vector = new Vector<>();
    vector.add("hi");
    vector.add("adapter patterns~");

    Enumeration<String> enumeration = vector.elements();

    Iterator enumerationIterator = new EnumerationIterator(enumeration);

    while (enumerationIterator.hasNext()) {
      System.out.println("enumerationIterator.next() = " + enumerationIterator.next());
    }
  }

}

```

## 예제 3. Iterator를 Enumeration으로 변환

#### 어댑터 (IteratorEnumeration)

```java
public class IteratorEnumeration implements Enumeration {

  private final Iterator iterator;

  public IteratorEnumeration(Iterator iterator) {
    this.iterator = iterator;
  }

  @Override
  public boolean hasMoreElements() {
    return iterator.hasNext();
  }

  @Override
  public Object nextElement() {
    Object result = iterator.next();
    iterator.remove();
    return result;
  }
}

```

#### 클라이언트 테스트 (IteratorEnumerationTest)

```java
public class IteratorEnumerationTest {

  public static void main(String[] args) {
    ArrayList<String> iterator = new ArrayList<>();
    iterator.add("hi");
    iterator.add("hello");

    Enumeration iteratorEnumeration = new IteratorEnumeration(iterator.iterator());

    while (iteratorEnumeration.hasMoreElements()) {
      System.out.println(
          "iteratorEnumeration.nextElement() = " + iteratorEnumeration.nextElement());
    }
  }
}

```