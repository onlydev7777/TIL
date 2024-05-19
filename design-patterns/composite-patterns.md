# Composite Patterns

### Iterator 패턴으로 구현된 객체마을 식당에서 디저트 서브 메뉴를 추가해달라고 하네요.

- 컴포지트 패턴을 통해서 해결해 봅시다.

***
### Composite Patterns 정의

> 컴포지트 패턴을 이용하면 객체들을 트리 구조로 구성하여 부분과 전체를 나타내는 계층 구조를 만들 수 있습니다.
> 
> 이 패턴을 이용하면 클라이언트에서 개별 객체와 다른 객체들로 구성된 복합 객체(composite)를 똑같은 방법으로 다룰 수 있습니다.

- 메뉴 및 메뉴 항목을 똑같은 구조로 처리할 수 있습니다.
- 부분-전체 계층구조(part-whole hierarchy) 를 생성해서 처리 합니다.
- 부분-전체 계층구조란?
  : 부분(메뉴 및 메뉴항목)들이 모여있지만, 모든 것을 하나로 묶어서 전체로 다룰 수 있는 구조를 뜻합니다.

- 트리구조
  - 자식이 있는 원소는 "노드(node)" 라고 칭합니다.
  - 자식이 없는 원소는 "잎(leave)" 라고 칭합니다.
  - Menu는 노드이고, MenuItem은 잎이 됩니다.

***
### 컴포지트 패턴을 적용한 메뉴 디자인

**- MenuComponent(Component)**
- 복합객체 내에 들어 있는 모든 객체들에 대한 인터페이스를 정의
- 복합노드 뿐만 아니라 잎 노드에 대한 메서드 까지 정의 해야 한다.

```java
/**
 * 자식 클래스가 구현하지 않은 메서드는 default로 예외를 던지도록 디자인
 */
public interface MenuComponent {
  // ------------- Menu 메서드 --------------- //
  default void add(MenuComponent menuComponent) {
    throw new UnsupportedOperationException();
  }

  default void remove(MenuComponent menuComponent) {
    throw new UnsupportedOperationException();
  }

  default MenuComponent getChild(int i) {
    throw new UnsupportedOperationException();
  }
  // ------------- MenuItem 메서드 --------------- //
  default void print() {
    throw new UnsupportedOperationException();
  }
}

```

**- Menu(Composite)**
- 자식이 있는 구성요소의 행동을 정의
  - add, remove 등
- 자식 구성요소를 저장
  - ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
- 재귀처리에 필요한 Leaf(MenuItem) 관련 메서드 재정의
  - print() 메서드
- 그 외 Leaf(MenuItem) 메서드는 정의할 필요 없음
  - MenuComponent 에 이미 예외를 던지도록 구현되어 있음

```java
public class Menu implements MenuComponent {

  ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
  String name;
  String description;

  public Menu(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public void add(MenuComponent menuComponent) {
    menuComponents.add(menuComponent);
  }

  public void remove(MenuComponent menuComponent) {
    menuComponents.remove(menuComponent);
  }

  public MenuComponent getChild(int i) {
    return (MenuComponent) menuComponents.get(i);
  }
  
  
  public void print() {
    System.out.print("\n" + getName());
    System.out.println(", " + getDescription());
    System.out.println("---------------------");

    Iterator<MenuComponent> iterator = menuComponents.iterator();
    while (iterator.hasNext()) {
      MenuComponent menuComponent = iterator.next();
      menuComponent.print();
    }
  }
}

```


**- MenuItem(Leaf)**
- MenuItem에 필요한 메서드만 재정의
  - getName, getPrice, print 등

```java
public class MenuItem implements MenuComponent {
  //...(중략)
  public void print() {
    System.out.print("  " + getName());
    if (isVegetarian()) {
      System.out.print("(v)");
    }
    System.out.println(", " + getPrice());
    System.out.println("     -- " + getDescription());
  }
}

```

**- Waiteress**
- 루트노드 만을 갖고 print 한다.
```java
public class Waitress {

  MenuComponent allMenus;

  public Waitress(MenuComponent allMenus) {
    this.allMenus = allMenus;
  }

  public void printMenu() {
    allMenus.print();
  }
}

```

**- MenuTestDrive(Client)**
- Client 에서 루트노드에, 자식노드(Menu, MenuItem)를 설정 후 Waiteress에 루트노드를 전달 후 메뉴를 출력한다.

```java
public class MenuTestDrive {

  public static void main(String args[]) {
    MenuComponent pancakeHouseMenu =
        new Menu("PANCAKE HOUSE MENU", "Breakfast");
    MenuComponent dinerMenu =
        new Menu("DINER MENU", "Lunch");
    MenuComponent cafeMenu =
        new Menu("CAFE MENU", "Dinner");
    MenuComponent dessertMenu =
        new Menu("DESSERT MENU", "Dessert of course!");
    MenuComponent coffeeMenu = new Menu("COFFEE MENU", "Stuff to go with your afternoon coffee");

    MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");

    allMenus.add(pancakeHouseMenu);
    allMenus.add(dinerMenu);
    allMenus.add(cafeMenu);

    pancakeHouseMenu.add(new MenuItem(
        "K&B's Pancake Breakfast",
        "Pancakes with scrambled eggs and toast",
        true,
        2.99));
    pancakeHouseMenu.add(new MenuItem(
        "Regular Pancake Breakfast",
        "Pancakes with fried eggs, sausage",
        false,
        2.99));

    dinerMenu.add(new MenuItem(
        "Vegetarian BLT",
        "(Fakin') Bacon with lettuce & tomato on whole wheat",
        true,
        2.99));
    dinerMenu.add(new MenuItem(
        "BLT",
        "Bacon with lettuce & tomato on whole wheat",
        false,
        2.99));
    
    dinerMenu.add(dessertMenu);

    dessertMenu.add(new MenuItem(
        "Apple Pie",
        "Apple pie with a flakey crust, topped with vanilla icecream",
        true,
        1.59));

    dessertMenu.add(new MenuItem(
        "Cheesecake",
        "Creamy New York cheesecake, with a chocolate graham crust",
        true,
        1.99));
    
    cafeMenu.add(new MenuItem(
        "Veggie Burger and Air Fries",
        "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
        true,
        3.99));
    cafeMenu.add(new MenuItem(
        "Soup of the day",
        "A cup of the soup of the day, with a side salad",
        false,
        3.69));

    cafeMenu.add(coffeeMenu);

    coffeeMenu.add(new MenuItem(
        "Coffee Cake",
        "Crumbly cake topped with cinnamon and walnuts",
        true,
        1.59));
    coffeeMenu.add(new MenuItem(
        "Bagel",
        "Flavors include sesame, poppyseed, cinnamon raisin, pumpkin",
        false,
        0.69));

    Waitress waitress = new Waitress(allMenus);

    waitress.printMenu();
  }
}

```