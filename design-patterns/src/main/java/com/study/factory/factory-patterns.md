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

◼︎
◼︎
◼︎
◼︎
◼︎
◼︎
◼︎
◼︎
◼︎
◼︎ 