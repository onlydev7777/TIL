# Iterator-Patterns

### ◼︎ 속보 : 객체마을 식당과 객체마을 팬케이크 하우스 합병

##### 두 식당의 메뉴 관리 방식이 상이하네요.

- 객체마을 식당
    - MenuItem을 배열 형태로 관리


- 객체마을 팬케이크
    - MenuItem 을 ArrayList 형태로 관리

***

### ︎◼︎ 우선 ︎합병된 가게의 메뉴 정보를 인지하고 있는 웨이터리스를 구현해보자

- 웨이터리스 자격요건
    - printMenu() : 메뉴에 있는 모든 항목 출력
    - printBreakfastMenu() : 아침 식사 항목만 출력
    - printLunchMenu() : 점심 식사 항목만 출력
    - isItemVegetarian(name) : 채식주의자 메뉴 여부 확인

```java
public class Waitress {
  public void printMenu(){
    PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    ArrayList<MenuItem> breakfastItems = pancakeHouseMenu.getMenuItems();

    DinerMenu dinerMenu = new DinerMenu();
    MenuItem[] lunchItems = dinerMenu.getMenuItems();

    //팬케이크 식당
    for (int i = 0; i < breakfastItems.size(); i++) {
      MenuItem menuItem = breakfastItems.get();
      //...sout(); // 중략
    }

    //객체마을 식당
    for (int i = 0; i < lunchItems.length; i++) {
      MenuItem menuItem = lunchItems[i];
      //...sout(); // 중략
    }
  }  
}
```

***
### Waitress 클래스 printMenu() 메서드의 문제점을 찾아 볼까요?
1. 웨이터리스는 인터페이스가 아닌 PancakeHouseMenu 와 DinerMenu 구상 클래스에 맞춰서 코딩하고 있습니다.
2. 객체마을 식당에서 메뉴관리를 배열이 아닌 HashTable로 바꾼다면 Waiteress 코드 역시 많은 수정이 필요합니다.
3. 각 식당에서 메뉴 항목의 컬렉션을 관리하는 방법을 알아야 하므로, 캡슐화 원칙이 지켜지지 않았습니다.
4. 서로 다른 방식으로 메뉴를 관리하고 있어서 메뉴 출력코드가 중복됩니다.

***
### 중복되는 반복 코드를 캡슐화 합시다. (2~4번 문제 해결)
```java
public class Waitress {
  public void printMenu() {
    Iterator pancakeIterator = pancakeHouseMenu.createIterator();
    Iterator dinerIterator = dinerMenu.createIterator();

    System.out.println("MENU\n----\nBREAKFAST");
    printMenu(pancakeIterator);
    System.out.println("\nLUNCH");
    printMenu(dinerIterator);

  }

  //Iterator 패턴을 활용해 코드 중복, 캡슐화 문제 해결
  private void printMenu(Iterator iterator) {
    while (iterator.hasNext()) {
      MenuItem menuItem = iterator.next();
      System.out.print(menuItem.getName() + ", ");
      System.out.print(menuItem.getPrice() + " -- ");
      System.out.println(menuItem.getDescription());
    }
  }
}
```

**- Iterator 인터페이스**

```java
public interface Iterator {
  boolean hasNext();
  MenuItem next();
}
```

**- PancakeHouseMenu**

```java
public class PancakeHouseMenu {

  List<MenuItem> menuItems;

  public Iterator createIterator() {
    return new PancakeHouseMenuIterator(menuItems);
  }

}
```

**- PancakeHouseMenuIterator**

```java
public class PancakeHouseMenuIterator implements Iterator {
  List<MenuItem> items;
  int position = 0;

  public PancakeHouseMenuIterator(List<MenuItem> items) {
    this.items = items;
  }

  public MenuItem next() {
    return items.get(position++);
  }

  public boolean hasNext() {
    return items.size() > position;
  }
}
```

> 1. Iterator 라는 반복문 처리를 담당하는 인터페이스를 정의한다.
> 2. 각 식당 별로 PancakeHouseMenuIterator 와 DinerMenuIterator 에서 Iterator 를 implements 해서 반복문 처리를 구현 한다.
> 3. PancakeHouseMenu, DinerMenu 클래스에서 구현체를 반환한다.
> 
>    -> 단일 책임 원칙 : 하나의 클래스에서는 하나의 역할을 담당 한다.

***
### 이제 메뉴 인터페이스를 통일 시켜봅시다 (1번 문제 해결)

```java
public interface Menu {
  Iterator createIterator();
}
```

```java
public class Waitress {
  Menu pancakeHouseMenu;
  Menu dinerMenu;

  //...(중략)
  
  public void printMenu() {
    Iterator pancakeIterator = pancakeHouseMenu.createIterator();
    Iterator dinerIterator = dinerMenu.createIterator();

    System.out.println("MENU\n----\nBREAKFAST");
    printMenu(pancakeIterator);
    System.out.println("\nLUNCH");
    printMenu(dinerIterator);

  }
}
```

Waitress 클래스는 더 이상 구상 클래스 를 참조하지 않고 Menu 인터페이스를 참조합니다.

=> Waitress 클래스와 구상 클래스 간의 의존성을 줄일 수 있습니다.

***
### 이터레이터 패턴 정의
>**이터레이터 패턴**은 컬렉션 구현 방법을 노출시키지 않으면서 그 집합체 안에 들어 있는 모든 항목에 접근할 수 있게 해 주는 방법을 제공합니다.

***
### 단일 역할 원칙
> 클래스를 바꾸는 이유는 한 가지 뿐이어야 한다.

PancakeHouseMenu 클래스가 PancakeHouseMenuIterator 클래스의 역할 까지 해서는 안 된다.

그렇지 않다면, 2가지 이유로 클래스가 바뀔 수 있어 단일 역할 원칙에 어긋난다.

클래스를 고치는 것은 최대한 피해야 한다.

코드를 변경할 만한 이유가 2가지 이상이 되면 그 만큼 그 클래스에 대한 영향도가 높다는 것을 의미하며 이는 유지보수에 좋지 못하다.

**응집도 가 높은 클래스를 작성해야 한다**