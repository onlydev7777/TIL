### Strategy-Patterns

- SimUDuck 애플리케이션 v1

```java
public abstract class Duck {

  public void quack() {
    System.out.println("Duck.quack");
  }

  public void swim() {
    System.out.println("Duck.swim");
  }

  public void display() {
    System.out.println("Duck.display");
  }
  //기타 오리 메서드
}
```

```java
public class MallardDuck extends Duck {

  @Override
  public void display() {
    System.out.println("MallardDuck.display");
  }
}
```

```java
public class RedheadDuck extends Duck {

  @Override
  public void display() {
    System.out.println("RedheadDuck.display");
  }
}
```

- SimUDuck 애플리케이션 v2
    - 이제 오리들이 날아다닐 수 있도록 해야 합니다.

```java
  //Duck 클래스에 추가
public void fly(){
    System.out.println("Duck.fly");
    }
```

그런데 문제가 생겼어요. 오리 인형이 화면에서 막 날아다녀요.   
Duck의 모든 자식 클래스가 날 수 있는 것은 아니라는 점을 깜빡했군요.

```java
  @Override
public void fly(){
    // Nothing
    }
```

- 아무것도 하지 않도록 Override 처리?
    - 날 수 없는 오리들을 개발자가 일일이 Override ??
    - 프로그램이 커져서 날 수 없는 오리가 200마리가 생기면 ??
    - 소리를 내지 못하는 오리가 있으면 그 quack 메서드도 일일이 Override ??

> 다음 중 Duck의 행동을 제공하는 데 있어서 상속을 사용할 때 단점이 될 수 있는 것을 모두 고르시오.
>
> A. 서브 클래스에서 코드가 중복된다.   
> B. 실행 시 특징을 바꾸기 힘들다.   
> C. 오리가 춤 추게 만들 수 없다.   
> D. 모든 오리의 행동을 알기 힘들다.   
> E. 오리가 날면서 동시에 꽥꽥 될 수 없다.   
> F. 코드를 변경했을 때 다른 오리들한테 원치 않은 영향을 끼칠 수 있다.

A. "곽곽" 소리를 내는 오리가 있으면 해당하는 서브클래스에 quack 메서드의 코드 중복이 일어난다.   
B. MallardDuck 에 메서드가 정의되어 있으므로 특징을 바꾸기 힘들다.   
D. 하나의 Duck을 상속받는 구조로 모든 오리가 어떤 행동을 하는지 파악하기 힘들다.   
F. 하나의 Duck을 상속받는 구조로 Duck의 코드를 변경했을 때 다른 오리들한테 원치 않은 영향을 끼칠 수 있다.

- SimUDuck 애플리케이션 v3
    - Interface로 구현해볼까?

```java
public interface Flyable {

  void fly();
}
```

```java
public interface Quackable {

  void quack();
}
```

```java
public class RubberDuck extends Duck implements Quackable {

  @Override
  public void display() {
    System.out.println("RubberDuck.display");
  }

  @Override
  public void quack() {
    System.out.println("RubberDuck.quack");
  }
}
```

```java
public class DecoyDuck extends Duck {

  @Override
  public void display() {
    System.out.println("DecoyDuck.display");
  }
}
```

- 문제점
    - 기존의 Duck 추상클래스의 fly 메서드를 모든 서브 클래스 별로 재정의 해야 한다.   
      => 단순히 나는 기능을 하는 오리가 200개라면? 200개의 중복 코드 발생   
      => 코드 재사용 불가


- 디자인 원칙

> 애플리케이션에서 달라지는 부분을 찾아내고 달라지지 않는 부분으로부터 분리 시킨다.   
> "바뀌는 부분은 따로 뽑아서 캡슐화 시킨다.   
> 그렇게 하면 나중에 바뀌지 않는 부분에는 영향을 미치지 않은 채로 그 부분만 고치거나 확장할 수 있다."

- SimUDuck 애플리케이션 v4

```java
public interface FlyBehavior {

  void fly();
}

public class FlyNoWay implements FlyBehavior {

  @Override
  public void fly() {
    System.out.println("FlyNoWay.fly");
  }
}

public class FlyWithWings implements FlyBehavior {

  @Override
  public void fly() {
    System.out.println("FlyWithWings.fly");
  }
}
```

```java
public interface QuackBehavior {

  void quack();
}

public class Quack implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("Quack.quack");
  }
}

public class MuteQuack implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("MuteQuack.quack");
  }
}

public class Squeak implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("Squeak.quack");
  }
}
```

```java
public abstract class Duck {

  protected FlyBehavior flyBehavior;
  protected QuackBehavior quackBehavior;

  public void swim() {
    System.out.println("Duck.swim");
  }

  public void display() {
    System.out.println("Duck.display");
  }

  public void performFly() {
    flyBehavior.fly();
  }

  public void performQuack() {
    quackBehavior.quack();
  }
  //기타 오리 메서드
}
```

```java
public class MallardDuck extends Duck {

  // 구현클래스 대입
  public MallardDuck() {
    this.quackBehavior = new Quack();
    this.flyBehavior = new FlyWithWings();
  }

  @Override
  public void display() {
    System.out.println("MallardDuck.display");
  }
}

```

- 이렇게 하면 Duck은 꽥꽥거리는 행위를 하고자 할 때 참조되는 객체에서 꽥꽥 거리기만 하면 됨
- 객체의 종류는 신경 쓸 필요가 없음. quack()을 수행할 수 있다는 것이 중요

- SimUDuck 애플리케이션 v5
    - ModelDuck은 날지 못하는 새끼 오리 였다가 진화해서 로켓으로 날 수 있다는 고객 요청

```java
public abstract class Duck {

  //...중략
  //동적으로 행동을 바꾸기 위해 setter 메서드 추가
  public void setFlyBehavior(FlyBehavior flyBehavior) {
    this.flyBehavior = flyBehavior;
  }

  public void setQuackBehavior(QuackBehavior quackBehavior) {
    this.quackBehavior = quackBehavior;
  }
}
```

```java
//로켓으로 나는 FlyBehavior 구현체 추가
public class FlyRocketPowred implements FlyBehavior {

  @Override
  public void fly() {
    System.out.println("FlyRocketPowred.fly");
  }
}
```

```java
public class ModelDuck extends Duck {

  public ModelDuck() {
    this.flyBehavior = new FlyNoWay();
    this.quackBehavior = new Quack();
  }

  @Override
  public void display() {
    System.out.println("ModelDuck.display");
  }
}
```

```java
public class MiniDuckSimulator {

  public static void main(String[] args) {
    Duck modelDuck = new ModelDuck();
    modelDuck.performFly();     //FlyNoWay.fly
    modelDuck.performQuack();   //Quack.quack

    modelDuck.setFlyBehavior(new FlyRocketPowred());
    modelDuck.performFly();     //FlyRocketPowred.fly
  }
}
```

- 디자인 원칙

> 상속보다는 구성을 활용한다.   
> => 구성을 이용하면 알고리즘군을 캡슐화 할 수 있도록 만들어주며   
> 객체에 올바른 행동 인터페이스를 구현하면 실행 시에 행동을 바꿀 수도 있게 해준다.

- 스트래티지 패턴(Strategy Pattern)

> 알고리즘군을 정의하고 각각을 캡슐화하여 교환해서 사용할 수 있도록 만든다.   
> 스트래티지를 활용하면 알고리즘을 사용하는 클라이언트와는 독립적으로 알고리즘을 변경할 수 있다.