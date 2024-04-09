# Factory Patterns

◼︎ 피자가게 어플리케이션 v1

- 바뀌는 부분 파악하기
- 피자 종류별로 피자 주문하기

```java
public class PizzaStore {

  public Pizza orderPizza(String type) {
    Pizza pizza;

    //바뀌는 부분 : 피자 종류 변경(추가/수정/삭제)
    if ("cheese".equals(type)) {
      pizza = new CheesePizza();
    } else if ("pepperoni".equals(type)) {
      pizza = PepperoniPizza();
    } else if ("clam".equals(type)) {
      pizza = ClamPizza();
    } else if ("eggie".equals(type)) {
      pizza = EggiePizza();
    }

    //바뀌지 않는 부분 : 피자 세팅 과정
    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }
}
```

◼︎ 바뀌는 부분 캡슐화

- 간단한 팩토리 패턴

```java
public class SimplePizzaFactory {

  public Pizza createPizza(String type) {
    if ("cheese".equals(type)) {
      return new CheesePizza();
    } else if ("pepperoni".equals(type)) {
      return new PepperoniPizza();
    } else if ("clam".equals(type)) {
      return new ClamPizza();
    } else if ("eggie".equals(type)) {
      return new EggiePizza();
    }

    return null;
  }
}
```

```java
public class PizzaStore {

  private SimplePizzaFactory pizzaFactory;

  public PizzaStore(SimplePizzaFactory pizzaFactory) {
    this.pizzaFactory = pizzaFactory;
  }

  public Pizza orderPizza(String type) {
    Pizza pizza = pizzaFactory.createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }
}
```

간단한 팩토리는 디자인 패턴이라 할 수 없다. 자주 쓰이는 관용구에 가깝다.

◼︎ 피자 어플리케이션 v2

- 피자 프랜차이즈 사업 PizzaStore 분점
    - 뉴욕, 시카고 지역에 따라 Pizza 종류 별로 제조방법이 달라짐

- UML

![v2-UML.png](v2-UML.png)

```java
public abstract class PizzaStore {

  public Pizza orderPizza(String type) {
    Pizza pizza = createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }

  public abstract Pizza createPizza(String type);
}

public class NYPizzaStore extends PizzaStore {

  @Override
  public Pizza createPizza(String type) {
    if ("cheese".equals(type)) {
      return new NYStyleCheesePizza();
    } else if ("pepperoni".equals(type)) {
      return new NYStylePepperoniPizza();
    } else if ("clam".equals(type)) {
      return new NYStyleClamPizza();
    } else if ("eggie".equals(type)) {
      return new NYStyleEggiePizza();
    }
    return null;
  }
}

public class PizzaTestDrive {

  public static void main(String[] args) {
    PizzaStore nyPizzaStore = new NYPizzaStore();
    Pizza nyCheesePizza = nyPizzaStore.orderPizza("cheese");
    System.out.println("nyCheesePizza = " + nyCheesePizza.name);

    PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
    Pizza chicagoCheesePizza = chicagoPizzaStore.orderPizza("cheese");
    System.out.println("chicagoCheesePizza = " + chicagoCheesePizza.name);
  }
}

```

- PizzaStore 추상 클래스에서 피자를 주문받은 이후의 행동은 변하지 않는다.
  하지만 PizzaStore 가게 별로 Pizza 만드는 방식은 다르다.
  이를 PizzaStore를 추상클래스로 선언해 orderPizza에서 createPizza를 호출하도록 했고
  createPizza는 각 피자 점포별 서브클래스(NYPizzaStore, ChicagoPizzaStore)에서 정의하도록 추상 메서드로 선언하였다.
  이렇게 했을 때 orderPizza 메서드는 어떤 방식의 피자로 만들어 질지 알지 못한다.
  **캡슐화가 잘 되어 있음**
  ₩> 갈아끼우기 용이하다.
  ₩> 슈퍼클래스의 클라이언트 코드와 서브클래스의 객체생성 코드 분리 가능하다.

◼︎ 팩토리 메서드 패턴

> 팩토리 메서드 패턴에서는 객체를 생성하기 위한 인터페이스를 정의하는데, 어떤 클래스의 인스턴스를 만들지는 서브 클래스에서 결정하게 만듭니다.
> 팩토리 메서드 패턴을 이용하면 클래스의 인스턴스를 만드는 일을 서브클래스에게 맡기는 거죠.


◼︎
◼︎
◼︎
◼︎
◼︎
◼︎
◼︎ 