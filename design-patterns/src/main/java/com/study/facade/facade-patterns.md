# facade-patterns

> 어떤 서브시스템의 일련의 인터페이스에 대한 통합된 인터페이스를 제공합니다.
> 퍼사드에서 고수준 인터페이스를 정의하기 때문에 서브시스템을 더 쉽게 사용할 수 있습니다.

### 홈시어터를 보려면?

아래의 일련의 서브시스템 인터페이스 요청이 요구된다.

```
popper.on();                    // 1. 팝콘 기계 켜기
popper.pop();                   // 2. 팝콘 튀기기
lights.dim(10);                 // 3. 전등 밝기 10 조절
screen.down();                  // 4. 스크린 내리기
projector.on();                 // 5. 프로젝터 켜기
projector.wideScreenMode();     // 6. 와이드 스크린 모드 전환
amp.on();                       // 7. 앰프 켜기
amp.setStreamingPlayer(player); // 8. 앰프 DVD 플레이어 세팅
amp.setSurroundSound();         // 9. 앰프 서라운드 모드 전환
amp.setVolume(5);               // 10. 앰프 볼륨 설정
player.on();                    // 11. DVD 켜기
player.play(movie);             // 12. DVD 재생하기
```

### 이제 퍼사드 패턴을 적용해서 홈시어터를 보자!

```java
public class HomeTheaterFacade {

  Amplifier amp;
  Tuner tuner;
  StreamingPlayer player;
  CdPlayer cd;
  Projector projector;
  TheaterLights lights;
  Screen screen;
  PopcornPopper popper;

  public HomeTheaterFacade(Amplifier amp,
      Tuner tuner,
      StreamingPlayer player,
      Projector projector,
      Screen screen,
      TheaterLights lights,
      PopcornPopper popper) {

    this.amp = amp;
    this.tuner = tuner;
    this.player = player;
    this.projector = projector;
    this.screen = screen;
    this.lights = lights;
    this.popper = popper;
  }

  public void watchMovie(String movie) {
    popper.on();
    popper.pop();
    lights.dim(10);
    screen.down();
    projector.on();
    projector.wideScreenMode();
    amp.on();
    amp.setStreamingPlayer(player);
    amp.setSurroundSound();
    amp.setVolume(5);
    player.on();
    player.play(movie);
  }
}
```

HomeTheaterFacade는 고수준 인터페이스를 정의해서 서브시스템의 일련의 과정을 보다 쉽게 사용할 수 있게 한다.

```
homeTheaterFacade.watchMovie();     // 고수준 인터페이스 호출
```

## 최소 지식 원칙

정말 친한 친구하고만 얘기하라.

#### 퍼사드 패턴 : 최소 지식 원칙

퍼사드 패턴은 최소 지식 원칙을 따른다.   
클라이언트에서는 저수준 인터페이스에 대한 의존성 없이 Facade 객체만을 의존하기 때문에 프로그램이 보다 간결해진다.

#### 최소 지식 원칙을 잘 따르는 메서드 가이드 라인

- 객체 자체
- 메서드에 파라미터로 전달된 객체
- 메서드에서 생성하거나 인스턴스를 만든 객체
- 그 객체에 속하는 구성요소

```java
public class Car {

  Engine engine;

  public void start(Key key) {
    Doors doors = new Doors();
    boolean authorized = key.turns();   // 파라미터로 전달된 객체 메서드
    if (authorized) {
      engine.start();                   // 객체에 속하는 구성요소 메서드 
      updateDashboardDisplay();         // 객체 자체 메서드
      doors.lock();                     // 메서드에서 생성한 객체
    }
  }

  private void updateDashboardDisplay() {

  }
}
```
