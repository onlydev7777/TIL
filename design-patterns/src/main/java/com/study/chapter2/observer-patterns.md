### Observer-Patterns

- 기상 모니터링 애플리케이션 v1

```java
public class WeatherData {

  public float getTemperature() {
    return new Random().nextFloat();
  }

  public float getHumidity() {
    return new Random().nextFloat();
  }

  public float getPressure() {
    return new Random().nextFloat();
  }

  //기상 관측 값이 갱신 될 때 마다 디스플레이에 알려줘야 하는 메서드
  public void measurementsChanged() {
    float temperature = getTemperature();
    float humidity = getHumidity();
    float pressure = getPressure();

    //인터페이스 변수
    //currentConditionDisplay.update(temp,humidity,pressure);
    //statisticsDisplay.update(temp,humidity,pressure);
    //forecastDisplay.update(temp,humidity,pressure);
  }
}
```

- What I know now

1. WeatherData 클래스에는 기상센서가 측정해주는 getter 메서드 3개가 정의되어 있음
2. 새로운 기상 측정 데이터가 나오면 measurementsChanged 메서드가 호출될 것임

- TODO

1. 기상데이터를 사용하는 3개의 디스플레이 항목을 구현해야 함
    1) 현재조건(기온/습도/기압)
    2) 기상통계(평균기온/최저기온/최고기온)
    3) 기상예보

2. 시스템이 확장 가능해야 함
    1) 다른 개발자들이 별도의 디스플레이를 만들 수 있도록 해야 함
    2) 사용자들이 마음대로 디스플레이 항목을 추가/제거 할 수 있도록 해야 함

- 연습문제

> 위에 구현한 코드를 바탕으로 옳은 것을 모두 고르시오
>
> A. 인터페이스가 아닌 구체적인 구현을 바탕으로 코딩하고 있습니다.   
> B. 새로운 디스플레이 항목이 추가될 때마다 코드를 변경해야 합니다.   
> C. 실행 중에 디스플레이 항목을 추가/제거 할 수 없습니다.   
> D. 디스플레이 항목들이 공통적인 인터페이스를 구현하지 않습니다.   
> E. 바뀌는 부분을 캡슐화 하지 않았습니다.   
> F. WeatherData 클래스를 캡슐화하지 않고 있습니다.
>
> A. measurementsChanged 메서드는 인터페이스가 아닌 구현 메서드임   
> B. 새로운 디스플레이 항목이 추가되면 measurementsChanged 메서드에 코드가 추가되어야 함   
> C. measurementsChanged 메서드에 추가/제거 기능 없음   
> D. 인터페이스 변수로 구현되어 있음   
> E. measurementsChanged 메서드는 캡슐화 되어 있지 않은 구현 메서드임   
> F. measurementsChanged 메서드 내부에서는 캡슐화된 인스턴스 변수의 메서드를 호출함

- 옵저버 패턴의 정의   
  옵저버 패턴은 신문사(subject)와 정기구독자(observer)로 이루어지는 관계
  옵저버 패턴에서는 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들한테 연락이 가고 자동으로 내용이 갱신되는 방식으로   
  일대다(one-to-many) 의존성을 정의합니다.

- 느슨한 결합의 위력   
  두 객체가 느슨하게 결합되어 있다는 것은 두 객체가 상호작용을 하지만 서로에 대해 잘 모른다는 것을 의미   
  옵저버 패턴에서는 주제와 옵저버가 느슨하게 결합되어 있는 객체 디자인을 제공

1. 주제가 옵저버에 대해서 아는 것은 옵저버가 특정 인터페이스를 구현한다는 것 뿐입니다.      
   => 옵저버의 구상 클래스가 무엇인지, 옵저버가 무엇을 하는지에 대해서 알 필요가 없습니다.

2. 옵저버는 언제든지 새로 추가할 수 있습니다.   
   => 실행 중에 옵저버를 추가/삭제가 가능합니다.

3. 새로운 형식의 옵저버를 추가하려고 할 때도 주제를 변경할 필요가 없습니다.   
   => 옵저버가 되는 새로운 구상 클래스가 생겼다고 가정해도 주제는 어떠한 변경도 필요하지 않습니다.

4. 주제와 옵저버는 서로 독립적으로 사용할 수 있습니다.   
   => 서로 단단하게 결합되어 있지 않기 때문입니다.

5. 주제나 옵저버가 바뀌더라도 서로에게 영향을 미치지 않습니다.

- 디자인 원칙

> 서로 상호작용을 하는 객체 사이에서는 가능하면 느슨하게 결합하는 디자인을 사용해야 한다.

