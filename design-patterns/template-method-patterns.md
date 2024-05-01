# Template Method Patterns

## 카페인이 필요하신가요?

***

- 커피 만드는 법
    1. 물을 끓인다.
    2. 끓는 물에 커피를 우려낸다.
    3. 커피를 컵에 따른다.
    4. 설탕과 우유를 추가한다.


- 홍차 만드는 법
    1. 물을 끓인다.
    2. 끓는 물에 차를 우려낸다.
    3. 차를 컵에 따른다.
    4. 레몬을 추가한다.

## 자, 이제 커피와 홍차를 코드로 만들어 봅시다.

***

```java
public class Coffee {

  public void prepareRecipe() {
    boilWater();
    brewCoffeeGrinds();
    pourInCup();
    addSugarAndMilk();
  }

  private void boilWater() {
    System.out.println("Coffee.boilWater");
  }

  private void brewCoffeeGrinds() {
    System.out.println("Coffee.brewCoffeeGrinds");
  }

  private void pourInCup() {
    System.out.println("Coffee.pourInCup");
  }

  private void addSugarAndMilk() {
    System.out.println("Coffee.addSugarAndMilk");
  }
}

```

```java
public class Tea {

  public void prepareRecipe() {
    boilWater();
    steepTeaBag();
    pourInCup();
    addLemon();
  }

  private void boilWater() {
    System.out.println("Tea.boilWater");
  }

  private void steepTeaBag() {
    System.out.println("Tea.steepTeaBag");
  }

  private void pourInCup() {
    System.out.println("Tea.pourInCup");
  }

  private void addLemon() {
    System.out.println("Tea.addLemon");
  }
}
```

### Coffee 클래스와 Tea 클래스에 중복되는 부분이 상당히 많네요. 중복된 코드를 없애봅시다.

***

```java
public abstract class CaffeineBeverageV1 {

  abstract void prepareReceipt();

  void boilWater() {
    System.out.println("CaffeineBeverage.boilWater");
  }

  void pourInCup() {
    System.out.println("CaffeineBeverage.pourInCup");
  }
}

```

```java
public class Coffee extends CaffeineBeverageV1 {

  @Override
  public void prepareRecipe() {
    boilWater();        // 부모 클래스 메서드
    brewCoffeeGrinds();
    pourInCup();        // 부모 클래스 메서드
    addSugarAndMilk();
  }


  private void brewCoffeeGrinds() {
    System.out.println("Coffee.brewCoffeeGrinds");
  }

  private void addSugarAndMilk() {
    System.out.println("Coffee.addSugarAndMilk");
  }
}

```

```java
public class Tea extends CaffeineBeverageV1 {

  @Override
  public void prepareRecipe() {
    boilWater();      // 부모 클래스 메서드
    steepTeaBag();
    pourInCup();      // 부모 클래스 메서드
    addLemon();
  }

  private void steepTeaBag() {
    System.out.println("Tea.steepTeaBag");
  }

  private void addLemon() {
    System.out.println("Tea.addLemon");
  }
}

```

CaffeineBeverageV1 클래스에서 Coffee 클래스와 Tea 클래스의 공통 메서드 3개를 정의하였습니다.

1. prepareRecipe : 추상 메서드
2. boilWater, pourInCup : 구상 메서드

## Coffee와 Tea에서 더 필요한 공통점이 없을까요? prepareRecipe 메서드 알고리즘이 동일합니다. 이를 추상화 해봅시다.

```java
public abstract class CaffeineBeverageV2 {

  final void prepareRecipe() {    // 서브 클래스 에서 재정의 할 수 없도록 final 키워드 넣기.
    boilWater();
    brew();
    pourInCup();
    addCondiments();
  }

  void boilWater() {
    System.out.println("CaffeineBeverage.boilWater");
  }

  void pourInCup() {
    System.out.println("CaffeineBeverage.pourInCup");
  }

  abstract void brew();             // 커피 or 티 를 우려낸다.

  abstract void addCondiments();    // 첨가물을 넣는다.
}

```

```java
public class Coffee extends CaffeineBeverageV2 {

  @Override
  void brew() {
    System.out.println("Coffee.brew");
  }

  @Override
  void addCondiments() {
    System.out.println("Coffee.addCondiments");
  }
}

```

```java
public class Tea extends CaffeineBeverageV2 {

  @Override
  void brew() {
    System.out.println("Tea.brew");
  }

  @Override
  void addCondiments() {
    System.out.println("Tea.addCondiments");
  }
}

```

음료를 준비하는 알고리즘이 동일한 prepareRecipe() 메서드를 부모 클래스에서 final 메서드로 정의하였고

prepareRecipe() 메서드 내부에서 부모 클래스에서 정의한 구상 메서드와 서브 클래스에서 정의해야 하는 추상 메서드를 호출합니다.

위와 같은 방법으로 음료를 준비하는 동일한 알고리즘을 템플릿화 시켰습니다.

따라서 prepareRecipe() 메서드는 템플릿 메서드 입니다.

> 템플릿 메서드에서는 알고리즘의 각 단계들을 정의하며 그 중 한 개 이상의 단계가 서브 클래스에 의해 제공 될 수 있습니다.

## 템플릿 메서드 패턴 정의

***
> 템플릿 메서드 패턴에서는 메서드에서 알고리즘의 골격을 정의합니다.
>
> 알고리즘의 여러 단계 중 일부는 서브 클래스에서 구현할 수 있습니다.
>
> 템플릿 메서드를 이용하면 알고리즘의 구조는 그대로 유지하면서 서브 클래스에서 특정 단계를 재정의할 수 있습니다.

## 템플릿 메서드와 후크

***

```java
public abstract class AbstractClass {

  final void templateMethod() {
    primitiveOperation1();
    primitiveOperation2();
    concreteOperation1();
    concreteOperation2();
    hook();
  }


  abstract void primitiveOperation1();

  abstract void primitiveOperation2();

  final void concreteOperation1() {    // 재정의 불가한 구상 메서드
    System.out.println("AbstractClass.concreteOperation");
  }

  void concreteOperation2() {   // 재정의 가능한 구상 메서드
    System.out.println("AbstractClass.concreteOperation2");
  }

  void hook() {     // 아무것도 하지 않는 메서드, 서브 클래스에서 정의해도 되고 하지 않아도 됨
  }
}

```

```java
public abstract class CaffeineBeverageWithHook {

  final void prepareRecipe() {    // 서브 클래스 에서 재정의 할 수 없도록 final 키워드 넣기.
    boilWater();
    brew();
    pourInCup();
    if (customerWantsCondiments()) {
      addCondiments();
    }
  }

  boolean customerWantsCondiments() {   // default는 true 이지만 서브클래스가 재정의하기에 따라서 첨가물이 들어갈지 말지가 결정됨
    return true;
  }

  void boilWater() {
    System.out.println("CaffeineBeverage.boilWater");
  }

  void pourInCup() {
    System.out.println("CaffeineBeverage.pourInCup");
  }

  abstract void brew();             // 커피 or 티 를 우려낸다.

  abstract void addCondiments();    // 첨가물을 넣는다.
}

```

customerWantsCondiments() 메서드가 후크 역할을 한다.

default는 true를 항상 반환하지만 서브 클래스가 재정의 하기에 따라서 템플릿 메서드 알고리즘이 바뀔 수 있다.

## 할리우드 원칙

***
> 먼저 연락하지 마세요. 저희가 연락 드리겠습니다.

할리우드 원칙을 활용하면 "의존성 부패(dependency rot)"을 방지할 수 있습니다.

고수준 구성요소 A가 저수준 구성요소 B에 의존하고, 저수준 구성요소 B는 다시 고수준 구성요소 A에 의존하고 A는 또 다시 저수준 구성요소이 C를 의존하는 것과 같이 의존성이 복잡하게 꼬여있는 것을 "의존성 부패" 라고 부릅니다.

할리우드 원칙을 사용하면 저수준 구성요소를 사용할 수 있지만, 이를 고수준 구성요소에서 결정할 수 있도록 합니다.

즉, 고수준 구성요소가 저수준 구성요소에게 "먼저 연락하지 마세요. 제가 먼저 연락 드리겠습니다." 라고 얘기하는 것과 같죠.

## 할리우드 원칙과 템플릿 메서드 패턴

***
템플릿 메서드 패턴에서도 할리우드 원칙이 적용되어 있습니다.

CaffeineBeverage 는 음료를 만드는 알고리즘을 정의하는 고수준 구성요소입니다.

Coffee와 Tea는 자질구레한 메서드 구현을 제공하는 저수준 구성요소 입니다.

저수준 구성요소인 Coffee와 Tea는 절대로 고수준 구성요소인 CaffeineBeverage 를 직접 호출하지 않습니다.

