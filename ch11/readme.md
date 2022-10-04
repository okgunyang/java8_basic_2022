==== 자바 API 도큐먼트

11장부터는 자바에서 제공하는 API(Application Programming Interface)를 학습한다.

API는 라이브러리라고 부르기도 하는데, 프로그램 개발에 자주 사용되는 클래스 및 인터페이스의 모음을 말한다.

String 클래스와 System 클래스도 모두 API에 속하는 클래스들이다.

[TIP]
====
API 도큐먼트는 HTML 페이지로 작성되어 있기 때문에 웹 브라우저를 열고 오라클에서 제공하는 URL을 방문하면 볼 수 있다.

link:http://docs.oracle.com/javase/8/docs/api/[JAVA 8 API Document]

다른 버전의 API Document를 확인하고 싶다면
link:https://docs.oracle.com/en/java/javase/index.html[여기]에서 확인할 수 있다.

현재 Latest Release는 JDK 15 버전이다.('20.10.10 기준)
====

==== java.lang과 java.util 패키지

자바를 이용해 개발할 때 가장 많이 사용하는 패키지는 java.lang, java.util, java.time 패키지일 것이다.

* java.lang
** 자바 프로그램의 기본적인 클래스를 담고 있는 패키지
** import 없이 사용할 수 있음
** Object, System, Class, String, StringBuffer, StringBuilder, Math, Wrapper 등

* java.util
** 자바 프로그램 개발에 조미료 같은 역할을 하는 클래스를 포함
** 컬렉션 클래스들이 대부분을 차지(15장에서 학습)
** Arrays, Calendar, Date, Objects, StringTokenizer, Random 등

==== Object 클래스

클래스를 선언할 때 extends 키워드로 다른 클래스를 상속하지 않으면 암시적으로 java.lang.Object 클래스를 상속하게 된다.

Object 클래스는 자바의 최상위 부모 클래스이다.

* equals()
** 비교 연산자인 ==과 동일한 결과를 리턴한다.
** equals() 메소드의 매개 타입은 Object로 모든 객체가 매개값으로 대입될 수 있다.
** 두 객체를 비교해서 논리적으로 동등하면 true, 논리적으로 동등하단 것은 같은 객체이건 다른 객체이건 상관없이 객체가 저장하고 있는 데이터가 동일함을 뜻한다.
** Object의 equals() 메소드는 직접 사용되지 않고 하위 클래스에서 재정의하여 사용된다.

[source, java]
----
public boolean equals(Object obj) { ... }

// 예시

Object obj1 = new Object();
Object obj2 = new Object();

// 결과 동일
boolean result = obj1.equals(obj2);
boolean result = (obj1 == obj2);
----

.equals() 메소드 재정의
[source, java]
----
public class Member {
  public String id;

  public Member(String id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Member) { // 매개값이 해당 클래스 타입인지 확인
      Member member = (Member) obj;
      if(id.equals(member.id)) {
        return true;
      }
    }
    return false;
  }
}
----

* hashCode()
** 객체 해시코드란 객체를 식별할 하나의 정수값이다.
** hashCode() 메소드는 객체의 메모리 번지를 이용해 해시코드를 만들어 리턴하기 때문에 객체마다 다른 값을 가지고 있다.
** 컬렉션 프레임워크에서 HashSet, HashMap, HashTable은 hashCode() 메소드를 실행해서 리턴된 해시코드 값이 같은지를 비교하고, 같다면 equals() 메소드로 다시 비교한다.
** hashCode() 메소드는 재정의를 통해서 많이 사용한다.

.hashCode() 재정의하지 않음
[source, java]
----
public class Key {
  public int number;

  public Key(int number) {
    this.number = number;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Key) {
      Key compareKey = (Key) obj;
      if(this.number == compareKey.number) {
        return true;
      }
    }
    return false;
  }
}

// hashCode() 메소드 재정의 하지 않으면 다른 키로 인식
public class KeyExample {
  public static void main(String[] args) {
    HashMap<Key, String> hashMap = new HashMap<Key, String>();

    hashMap.put(new Key(1), "장봉");

    String value = hashMap.get(new Key(1));
    System.out.println(value); // null 값이 출력
  }
}
----

.hashCode() 메소드 재정의
[source, java]
----
public class Key {
  ...

  @Override
  public int hashCode() {
    return number;
  }

  ...
}
----

* toString()
** 객체의 문자 정보를 리턴한다.
** Object 클래스의 toString() 메소드는 "클래스명@16진수 해시코드"로 구성된 문자 정보 리턴
** Object의 toString() 메소드의 리턴값은 별 의미가 없으므로 메소드를 재정의하여 유용한 정보를 리턴하도록 한다.
** 예를들어 java.util의 Date 클래스는 toString() 메소드로 현재 시스템의 날짜와 시간 정보를 리턴한다.
** 예 : SmartPhone 클래스에서 toString() 메소드를 오버라이딩하여 제작사와 운영체제를 리턴

.toString() 예제
[source, java]
----
public class ToStringExample {
  public static void main(String[] args) {
    Object obj1 = new Object();
    Date obj2 = new Date();

    System.out.println(obj1.toString());
    System.out.println(obj2.toString());
  }
}
----

----
java.lang.Object@11bbd2
SUN OCT 11 21:00:05 KST 2020
----

* clone()
** 객체 복제는 원본 객체의 필드값과 동일한 값을 가지는 새로운 객체를 생성하는 것을 뜻한다.
** 객체 복제 이유는 원본 객체를 보호하기 위함
** 객체 복제 방법에는 얕은 복제와 깊은 복제가 있다.
** 얕은 복제(thin clone) : 단순히 필드값을 복사해서 객체를 복제하는 것
*** 필드값만 복제하기 때문에 필드가 기본 타입일 경우 값 복사가 일어나고, 필드가 참조 타입일 경우에는 객체의 번지가 복사된다.
** 깊은 복제(deep clone) : 참조하고 있는 객체도 복제하는 것
*** 깊은 복제를 하려면 Object의 clone() 메소드를 재정의해서 참조 객체를 복제하는 코드를 직접 작성해야 한다.
** clone() 메소드로 객체를 복제하려면 원본 객체는 반드시 java.lang.Cloneable 인터페이스를 구현하고 있어야 한다.

.얕은 복제를 위한 Member 클래스
[source, java]
----
public class Member implements Cloneable {
  public String id;
  public String name;
  public String password;
  public int age;
  public boolean adult;

  public Member(String id, String name, String password, int age, boolean adult) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.age = age;
    this.adult = adult;
  }

  public Member getMember() {
    Member cloned = null;

    try {
      cloned = (Member) clone();
    } catch(CloneNotSupportedException e) {
      return cloned;
    }
  }
}
----

.얕은 복제 Example
[source, java]
----
public class MemberExample {
  public static void main(String[] args) {
    // 원본 객체 생성
    Member original - new Member("jang", "장봉", "123", 27, true);

    // 복제 객체를 얻은 후에 패스워드 변경
    Member cloned = original.getMember();
    cloned.password = "456";
  }
}
----

----
위 예제에서 복제된 객체에서 패스워드만 변경하여도 원본 객체의 패스워드는 변함 없음
----

.깊은 복제를 위한 Member 클래스(clone() 메소드 재정의)
[source, java]
----
public class Member implements Cloneable {
  public String name;
  public int age;
  public int[] scores;
  public Car car;

  public Member(String name, int age, int[] scores, Car car) {
    this.name = name;
    this.age = age;
    this.scores = scores;
    this.car = car;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    Member cloned (Member) super.clone();

    cloned.scores = Array.copyOf(this.scores, this.scores.length);

    cloned.car = new Car(this.car.model);

    return cloned;
  }

  public Member getMember() {
    Member cloned = null;

    try {
      cloned = (Member) clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return cloned;
  }
}
----

.깊은 복제 예제에서 사용하는 Car 클래스
[source, java]
----
public class Car {
  public String model;

  public Car(String model) {
    this.model = model;
  }
}
----

.깊은 복제 Example
[source, java]
----
public class MemberExample {
  public static void main(String[] args) {
    Member original = new Member("장봉", 27, new int[] {100,100}, new Car("SM7"));
    Member cloned = original.getMember();
    cloned.scores[0] = 90;
    cloned.car.model = "E220d";
  }
}
----

----
위 예제에서 참조 타입인 scores와 차 model을 변경해도 원본에선 변경되지 않는다.
----

* finalize()
** 참조하지 않는 배열이나 객체는 Garbage Collector가 힙 영역에서 자동적으로 소멸시킨다.
** finalize()는 Garbage Collector가 객체를 소멸하기 직전에 실행시킨다.
** Object의 finalize()는 기본적으로 실행내용이 없으나, 객체 소멸전에 자원을 닫거나 중요한 데이터를 저장하고자 한다면 재정의를 통해서 할 수 있다.

.finalize() 예제
[source, java]
----
public class Counter {
  private int number;

  public Counter(int number) {
    this.number = number;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println(number + "번 객체의 finalize()가 실행됨");
  }
}
----

==== Objects 클래스

Object와 유사한 이름을 가진 java.util.Objects 클래스는 객체비교, 해시코드 생성, null 여부, 객체 문자열 리턴 등의 연산을 수행하는 정적 메소드들로 구성된 클래스이다.

* 객체 비교(compare(T a, T b, Comparator<T>c))
** java.util.Comparator<T> 는 재네릭 인터페이스 타입이다. 재네릭은 13장에서 학습
** compare() 메소드의 리턴 타입은 int이다.

* 동등 비교(equals()와 deepEquals())
** Object.equals(Object a, Object b)는 두 객채의 동등을 비교하는데 a와 b가 모두 null일 경우 true를 리턴한다.
** Object.deepEquals(Object a, Object b)는 a와 b가 서로 다른 배열일 경우, 항목 값이 같다면 true를 리턴한다.
** p.477 예제 참고

* 해시코드 생성(hash(), hashCode())

* 널 여부(isNull(), nonNull(), requireNonNull())

* 객체 문자 정보(toString())
** Object.toString()은 객체의 문자 정보를 리턴한다.
** toString(Object o)
** toString(Object o, String nullDefault) : o가 널일경우 nullDefault

==== System 클래스

자바 프로그램은 JVM(Java Virtual Machine) 위에서 실행된다. 운영체제의 모든 기능을 자바 코드로 접근하기는 어렵다.

java.lang.System 클래스를 이용하면 운영체제의 기능중 일부를 이용할 수 있다.

예를 들어 프로그램 종료, 키보드 입력, 모니터 출력, 메모리 정리, 현재 시간 읽기, 시스템 프로퍼티 읽기, 환경 변수 읽기 등이 가능하다.

System 클래스의 모든 필드와 메소드는 정적(static) 필드와 정적(static) 메소드로 구성되어 있다.

* 프로그램 종료 : exit()
** 프로그램을 작성하다보면 경우에 따라서 강제적으로 JVM을 종료시킬 때가 있는데 이때 System 클래스의 exit() 메소드를 호출하면 된다. exit() 메소드는 현재 실행하고 있는 프로세스를 강제 종료시키는 역할을 한다.
** exit() 메소드는 int형의 매개값을 지정하도록 되어있는데(종료 상태값) 일반적으로 종료일 경우엔 0으로 지정하고 비정상 종료일 경우 0 이외의 다른값을 준다.

----
System.exit(0);
----

* 쓰레기 수집기 실행 : gc()
* 현재 시각 읽기 : currentTimeMillis(), nanoTime()
* 시스템 프로퍼티 읽기 : getProperty()
* 환경 변수 읽기 : getenv()

==== Class 클래스

클래스와 인터체이스의 메타 데이터를 java.lang.Class 클래스로 관리한다.
(메타 데이터란 클래스의 이름, 생성자 정보, 필드 정보, 메소드 정보 등)

* getClass(), forName()
* getDeclaredConstructors(), getDeclaredFields(), getDeclaredMethods()
* newInstance()


==== String 클래스

프로그램을 작성할때 문자열이 많이 사용된다. 문자열을 생성, 추출, 비교, 분리, 변환 등을 제공하는 메소드에 대해서 알아본다.

====== String 생성자

자바의 문자열은 java.lang.String 클래스의 인스턴스로 관리된다.

소스에서의 문자열 리터럴은 String 객체로 자동 생성되지만 String 클래스는 다양한 생성자를 제공한다.

Deprecated된 생성자를 제외한 약 13개의 생성자를 제공한다.

[source, java]
----
// 자주 사용하는 생성자들
String str = new String(byte[] bytes);
// 지정된 문자셋으로 디코딩
String str = new String(byte[] bytes, String decoding);

// 배열의 offset index 위치부터 length 만큼 String 객체로 생성
String str = new(byte[] bytes, int offset, int length);
// 지정한 문자셋으로 디코딩
String str = new(byte[] bytes, int offset, int length, String decoding);
----

.바이트 배열을 문자열로 변환
[source, java]
----
public class ByteToStringExample {
  public static void main(String[] args) {
    byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};

    String str1 = new String(bytes);
    System.out.println(str1);

    String str2 = new String(bytes, 6, 4);
    System.out.println(str2);
  }
}
----

----
Hello Java
Java
----

키보드로부터 입력 받은 바이트 배열을 문자열로 변환할 때는 주의해야 한다.

예를 들어 Hello를 입력하고 엔터(Enter)를 눌렀다면 Hello + 캐리지리턴(\r) + 라인피드(\n)의 코드값이 바이트 배열에 저장되고 총7개의 바이트를 읽는다.

System.in.read()를 통해서 키보드 값을 입력 받았다면 다음 예제와 같이 이용하면 원하는 문자열만 얻어낼 수 있다.

.KeyboardToStringExample.java
[source, java]
----
public class KeyboardToStringExample {
  public static void main(String[] args) {
    byte[] bytes = new byte[100];

    System.out.print("입력 : ");
    int readByteCount = System.in.read(bytes);

    String str = new String(bytes, 0, readByteCount-2);
    System.out.println(str);
  }
}
----

----
입력 : Hello
Hello
----

====== String 메소드

String은 문자열의 추출, 비교, 찾기, 분리, 변환 등과 같은 다양한 메소드를 가지고 있다.

String 클래스의 메소드는 모든 프로그램에서 자주 사용된다. 메소드의 이름을 보면 기능과 연관이 있기 때문에 쉽게 기억할 수 있다.

* charAt()
** 매개값으로 주어진 인덱스의 문자를 리턴
** 인덱스 : 0에서부터 '문자열길이 -1'까지의 번호

* equals()
** 기본 타입 변수의 값을 비교할 때에는 ==를 사용
** 문자열을 비교할 때에는 equals()를 사용

* getBytes()
** 문자열을 바이트 배열로 변환

* indexOf()
** 매개값으로 주어진 문자열이 시작되는 인덱스를 리턴
** 포함되어 있지 않으면 -1을 리턴

* length()
** 문자열의 길이(문자의 수)를 리턴한다.

* replace()
** 첫 번째 매개값인 문자열을 찾아 두 번째 매개값인 문자열로 대치한 새로운 문자열을 생성하고 리턴

* substring()
** 주어진 인덱스에서 문자열을 추출
** substring(int beginIndex, int endIndex) : 주어진 시작과 끝 사이의 문자열 추출
** substring(int beginIndex) : 주어진 인덱스 이후부터 끝까지 문자열 추출

* toLowerCase(), toUpperCase()
** 알파벳 소,대문자 변경
** toLowerCase() : 문자열을 모두 소문자로 바꾼 새로운 문자열 생성한 후 리턴
** toUpperCase() : 문자열을 모두 대문자로 바꾼 새로운 문자열 생성한 후 리턴

* trim()
** 문자열의 앞뒤 공백을 제거한 새로운 문자열을 생성하고 리턴

* valueOf()
** 기본 타입의 값을 문자열로 변환하는 기능을 가짐

==== StringTokenizer 클래스

문자열이 특정 구분자로 연결되어 있는 경우, 구분자를 기준으로 부분 문자열을 분리할 때 우리는 String의 split() 메소드를 이용하거나, java.util 패키지의 StringTokenizer 클래스를 이용할 수 있다.

split()은 정규 표현직으로 구분하고, StringTokenizer는 문자로 구분한다는 차이점이 있다.

====== split() 메소드

String 클래스의 split() 메소드는 아래와 같이 호출한다.

정규표현식을 구분자로 사용해 문자열을 분리하고 배열에 저장한 뒤 리턴한다.

[source, java]
----
String[] result = "문자열".split("정규표현식");

// Example
public class StringSplitExample {
  public static void main(String[] args) {
    String text = "장병순&장봉, 홍길동, 장보고, 병순-봉";

    String[] result = text.split("&|,|-");

    for(String name : result) {
      System.out.println(name);
    }
  }
}
----

----
장병순
장봉
홍길동
장보고
병순
봉
----

====== StringTokenizer 클래스

구분하려는 문자열이 한 종류의 구분자로 연결되어 있을 경우, StringTokenizer 클래스를 사용하면 쉽게 토큰을 분리할 수 있다.

StringTokenizer 객체를 생성할 때 첫 번째 매개값으로 전체 문자열을 주고, 두 번째 매개값으로 구분자를 준다.

[source, java]
----
StringTokenizer stringTokenizer = new StringTokenizer("문자열", "구분자");
----

만약 구분자를 생략하면 공백(Space)이 기본 구분자가 된다.

.StringTokenizer 예제
[source, java]
----
String text = "장병순/장봉/봉";
StringTokenizer stringTokenizer = new StringTokenizer(text, "/");
----

* StringTokenizer 객체 생성되면 부분 문자열 분리를 위해 다음 메소드를 통해서 전체 토큰 수, 남아있는 토큰 여부를 확인하고 토큰을 읽으면 된다.
** int countTokens() : 꺼내지 않고 남아있는 토큰의 수
** boolean hasMoreTokens() : 남아있는 토큰이 있는지에 대한 여부
** String nextToken() : 토큰을 하나씩 꺼냄

[TIP]
====
nextToken() 메소드로 토큰을 하나 꺼내오면 StringTokenizer 객체에는 해당 토큰이 없어진다.

만약 StringTokenizer 객체에서 더 이상 가져올 토큰이 없다면 nextToken() 메소드는 java.util.NoSuchElementException 예외를 발생시킨다.

nextToken() 메소드를 사용하기 전에 hasMoreTokens() 메소드로 꺼내올 수 있는 토큰이 있는지에 대해서 체크한 후에 호출하는 것이 좋다.
====

.StringTokenizer로 토큰을 분리하는 두가지 방법
[source, java]
----
public class StringTokenizerExample{
  public static void main(String[] args) {
    String text = "장병순/병순/장봉";

    // 방법 1: 전체 토큰 수를 구해서 for문으로 해당 수 만큼 반복
    StringTokenizer stringTokenizer = new StringTokenizer(text, "/");
    int countTokens = stringTokenizer.countTokens();

    for(int=0; int<countTokens ; i++) {
      String token = stringTokenizer.nextToken();
      System.out.println(token);
    }

    System.out.println();

    // 방법 2: 남아 있는 토큰을 확인하고 while문으로 반복
    StringTokenizer stringTokenizer = new StringTokenizer(text, "/");
    while(stringTokenizer.hasMoreTokens()) {
      String token = stringTokenizer.nextToken();
      System.out.println(token);
    }
  }
}
----
