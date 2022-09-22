# Java 8 Basic
## java sdk study

# JAVA/JSP 위키, to2.kr/cWG
 - JAVA/JSP 위키 : [to2.kr/cWG](https://to2.kr/cWD)
 - 티스토리 블로그 주소: [to2.kr/ch9](https://to2.kr/ch9)
 
---
# 유용한 링크 (JAVA/JSP)
- JavaAPI[docs.oracle](https://docs.oracle.com/en/java/javase/16/)
- JSP set content type utf-8[tistory.blog](https://cbw1030.tistory.com/62)
- JSP contextPath [tistory.blog](https://suyou.tistory.com/78)
- JDBC Description (MySQL for Java)[tistory.blog](https://victorydntmd.tistory.com/145)
- Servlet Multiple URL pattern [stackoverflow.com](https://stackoverflow.com/questions/8995353/many-url-pattern-for-the-same-servlet)

---
# 유용한 링크 (기타)
 - 메이븐 리포지터리 : [Maven Repository](https://mvnrepository.com/)
 - 테일윈드 : [tailwindcss.com](https://tailwindcss.com/)
 - 테일윈드(cheatSheet) : [nerdcave.com/tailwind-cheat-sheet](https://nerdcave.com/tailwind-cheat-sheet)
 - 데이지UI : [daisyui.com](https://daisyui.com/)
 - Apach Tomcat 포트오류 해결법 [java119.tistory](https://java119.tistory.com/96)

---
# Java 학습
## Java의 .gitignore
```
.classpath
.project
.settings/
target/
build/
bin/
.factorypath
```
- 상기 디렉토리들은 java개발시 gitignore에 추가할 항목들이다. gitignore에 추가했다는 것은 버전관리의 대상에 포함되지 않는다는 의미이다.
- 항목에 포함되는 내용들은, src파일을 컴파일 하거나 혹은 에디터로 로드한다면 자동으로 추가되는 항목이기 때문에 굳이 추가할 필요가 없는 내용들이다.
---
## Java 기본
### 메소드 표현법
```
Article::write
(=) Article.write();
Article 클래스의 write 메소드
```
- 자바의 메소드 표현식, stream 에서도 많이 쓰임
### 1. 자동 형변환, 수동 형변환
#### 자동 형변환
```
double a = 3.0F;
// 오류없이 컴파일 가능
```
- 자바는 형변환을 자동으로 처리해주는 기능이 존재한다. 이것을 자동(암시적)형변환이라고 한다.
- 자바에서 컴파일을 할때, 컴파일러는 변수 a의 타입이 상수의 타입보다 더 큰 수를 표현할 수 있다면, 그에 맞추어 자동으로 형 변환(암시적 형변환)을 실행하기 때문에 오류가 발생하지 않는 것이다.
- 그렇다면 반대의 경우는 어떠할까
```
float a = 3.0;
// 컴파일 불가능
```
- 상기와 같이 상수에 어떠한 표시도 하지 않으면 기본 타입(Default Type)인 double인 채로 컴파일이 진행된다. 그렇게 된다면 우리가 기존에 알고 있던 바와 같이 오류가 발생하게 되는 것이다.
- 그 이유는 double은 float의 범위를 포함하고 있지만 float은 double보다 표현가능한 범위가 좁기 때문에 포함할수 없어 형 변환을 할 수 없고 여기에서 오류가 발생하기 때문이다.
- 즉, 자동 형 변환의 원칙은 표현범위가 좁은 데이터 타입에서 넓은 데이터 타입으로의 변환만 허용된다는 것이다. 데이터의 포함도는 다음과 같다.

#### 수동 형변환
- 그렇다면 double에서 float으로, float에서 int와 같은 형 변환은 아예 불가능한 것일까, 프로그램을 구성하다보면 이러한 상황은 분명 발생할 수 있다. 이때 명시적 형 변환을 해주면 충분히 형 변환을 할 수 있다. 해당 타입의 변수에 값을 변환해서 할당하는 식인데 다음과 같다.
```
float a = 100.0; // 상수는 double 이고 변수는 float이기 때문에 오류가 발생한다 

int b = 100.0F; // 상수는 float이고 변수는 int이기 때문에 오류가 발생한다. 

float a = (float)100.0; // 상수의 데이터 형식을 명시적으로 float으로 선언하였기 때문에 오류가 발생하지 않는다. 

int b = (int)100.0F; // 상수의 데이터 형식을 명시적으로 int로 선언하였기 때문에 오류가 발생하지 않는다.
```
- 상기와 같이 변수와 상수의 형을 다르게 할당하고 싶다면, 하기와 같이 명시적으로 할당하고자 하는 값의 형을 선언하면 문제를 해결할 수 있게 된다.
```
(데이터 타입) 데이터 값
```
 - 그러나 이렇게 명시적으로 형변환을 할 경우에는 주의해야할 점이 있다. 만일 100.124241 와 같이 소수점 이하에 어떠한 데이터가 존재할 경우, 명시적으로 int로 형 변환을 한다면, 정수 이하의 부분(소수점 이하의 값)은 소실되게 된다. 따라서 명시적으로 형 변환을 할 경우에는 이러한 점을 유념하고 실행해야 할 것이다
### 2. 자바는 안전하다고 느껴지는 것은 자동으로 형변환을 해준다. + 6. 위험할 때는 사인해야 한다.
- 자바는 데이터의 손실에 대하여 부정적이다. 따라서 데이터의 손실이 일어날 수 있는 형 변환에 대해서는 암시적 형 변환을 거절한다.
```
int b = 100.0F;
```
- 상기 예제와 같이, 상수는 100.0이라는 float타입으로서 소수점 이하의 값(실제로는 0일지언정)을 자료로서 보유하고 있지만, 그것이 할당될 변수 b는 int형 자료(부동소수점이 아닌 정수)이기 때문에 부동소수점 이하의 데이터가 소실된다.
- 따라서 형변환을 하기 위해서는 컴파일러에게 데이터 소실에 대한 확인을 표기해주어야만 형변환이 이루어지는 것이다.
- 이 때 명시적 형변환(수동형변환)이 이루어진다면 만일 기대소실값이 존재하였다면 그 데이터는 소실되어 형변환이 강제로 이루어지게 된다.(위험할때는 사인해야한다.)

### 3. 자바가 위험하다고 생각하는 것, 리모콘의 형태변환이 금지된 이유
```
public static void main(String[] args) {

  Vehicle A = new Truck();
  // 컴파일 불가
  // Truck의 Shpping메소드를 사용불가능
}

class Vehicle () {

  drive() {
   
  }

}

class Truck() {
  
  shipping() {
  
  }
  
}
```
- 클래스는 사용자 정의 데이터 타입을 생성한다 라고 생각할 수 있다. 이와 같은 논리로 같은 타입이 아닌 객체에 다른 타입의 객체를 할당한다는 것은 데이터의 손실을 야기할 수 있는 일이다. 따라서 자바는 이를 허용하지 않는다.
- 상기 예제와 같을 때, 탈것(Vehicle)크래스는 운전(drive)메소드를 갖고있고 트럭(Truck)클래스는 적재(Shipping)메소드를 갖고있다.
- 이때 탈것 이라는 클래스인 변수 A에 트럭 인스턴스를 할당한다면, Truck 클래스 안에 있는 적재 라는 메소드를 사용할 수 없게 된다.(데이터가 소실된다.)
- 자바는 이를 허용하지 않기 때문에 리코몬의 형태변화를 거절하는 것이다.

### 4. 자바가 리모콘 변환을 허용하는 유일한 경우, 버튼을 빼는 거라면 안전하다.
```
public static void main(String[] args) {

  Vehicle A = new Truck();
  // 컴파일 가능, 하지만 Truck은 Shpping메소드를 사용할 수 없음.
}

class Vehicle () {

  drive() {
   
  }

}

class Truck() extends Vehicle {
  
  shipping() {
  
  }
  
}

```
- 3번 예제와는 다르게 상기 예제와 같은 상황에서는 JVM은 컴파일을 거절하지 않는다.
- 그 이유는 다음과 같다.
- Vehicle을 상속받은 Truck클래스는 운전(drive)과 적재(shpping)메소드를 둘다 갖고 있는 상태이다. 그러나 어떠한 의도로 인하여 Truck 인스턴스를 Vehicle이 할당될 변수에 할당한다면, Vehicle로부터 상속받은 메소드는 그대로 사용하면서 Truck에 존재하는 메소드는 소실되록 처리하여 컴파일 하면, 데이터는 소실될지언정 프로그램상 치명적 오류- 사용 혹은 연결할 수 없는 메소드- 를 야기하지 않기 떄문이다.

### 5. 자바는 컴파일 타임에 해당 변수에 어떤 객체가 있는지 모른다.
```
class Vehicle () {

  drive() {
   
  }

}

class Truck() extends Vehicle {
  
  shipping() {
  
  }
  
}
```
- Truck 클래스의 인스턴스는 Vehicle 클래스의 모든 메소드를 사용하고 오버로딩하고 오버라이딩 할 수 있다.
- 그 이유는 Truck은 Vehicle이라는 클래스가 생성된 후, 그것을 그대로 상속받았기 때문이다.
- 그렇다면 Truck클래스의 상위클래스(super)인 Vehicle에서 Truck인스턴스의 기능을 받아서 사용하거나 수정할 수 있을까
- 프로그램이 컴파일을 할 때는 항상 위에서부터 아래로 순차적으로 읽는다고 생각하면 의문에 해답이 생긴다.
- Vehicle 클래스가 생성되었을 때에는 아직 Truck이라는 클래스는 생성되지 않았다. 따라서 Vehicle클래스 내부에서는 Truck에 대한 존재는 없는것이다.
- 그러한 이유로 Vehicle에서는 Truck에 대하여 어떠한 간섭도 이루어질 수가 없다. 그러나 Truck은 Vehicle의 모든 것을 상속받을 수 있고, 그것을 사용하고 수정할 수가 있다.

---

## Java String
### Java 문자열 연산

- 자바에서는 문자열의 덧셈연산이 가능하다. 다음과 같다.
```
String str1 = "hello ";
String str2 = "world !";

System.out.println(str1 + str2);
// hello world !
```

- 상기의 코드는 문제없이 실행되는것 같지만 사실 문제점을 내포하고 있는 코드이다. 자바에서 스트링클래스는 불변클래스이다. 따라서 예제의 의도처럼 문자열을 더하는 것은 의도와 다른 결과를 낼 수 있는 것이다.

- 자바는 문자열을 더하는 연산을 할 때 더하고자 하는 문자열마다 객체를 생성하여 합친다. 

- 자바 뿐만 아니라 프로그램에서 객체가 많이 생성된다면 프로그램이 거대해졌을 때 프로그램의 실행 속도가 느려질 수 있다.

- 따라서 문자열을 더하는 연산을 하고자 한다면, 직접 더하는 상기의 예제보다 StringBuffer 클래스를 이용하여 append()메소드를 사용하는 것이 훨씰 효율적이고 메모리를 절약할 수 있는 방법이다.

```
String str3 = new StringBuffer().append(str1).append(str2).toString();
// hello world!
```
---

## Java Jackson
- Jackson 라이브러리는 데이터를 JSON화 시키는 대표적인 라이브러리다.
- 이와 유사하게 데이터를 JSON으로 변환하는 라이브러리는 Google에서 개발한 GSON이라는 라이브러리가 존재한다.
```
Json 형식
{
    "id" : 1,
    "title" : "제목1"
}

Java - Map

Map<String, Object> articleMap = new HashMap<>();
articleMap.put("id", 1);
articleMap.put("title", "제목");

Java - 객체(Obejct)

Article article = new Article();
article.id = 1;
article.title = "제목";
```

- jackson 라이브러리는 자바에서 상기 json - map - object(객체) 간 형식변화를 도와주는 라이브러리이다.

- .json / java Map / Object 각각의 형식으로 변환하여 데이터를 다룰수 있는 기능이 내제되어있는 라이브러리.
---
## ObjectMapper 
- 관련 링크[tistory.blog](https://hanburn.tistory.com/99)
- 관련 링크[tistory.blog](https://interconnection.tistory.com/137)
- 관련 링크[tistory.blog](https://engaspect.tistory.com/27)
- 관련 링크[tistory.blog](https://alkhwa-113.tistory.com/entry/9%EC%A3%BC%EC%B0%A8-%EC%98%88%EC%99%B8-%EC%B2%98%EB%A6%AC?category=921157)

---

## JDK, JRE, JVM의 차이
- 참고 링크 [wiki.docs](https://wikidocs.net/257)
- 참고 링크 [naver.blog](https://m.blog.naver.com/duqrlwjddns1/221770110714)
---
- 참고 이미지
<img src="https://beginnersbook.com/wp-content/uploads/2013/05/JVM.jpg" alt=""/>
---
### JVM (Java Virtual Machine) + 가비지 컬렉션(Garbage Collection

- JVM은 자방 가상머신이다. 자바로 작성된 코드를 실행할 수 있도록 도와주는 가상의 머신이라고 생각하면 된다. 자바로 코딩된 파일은 .class라는 바이너리 파일로 컴파일 되어 실행되는데 이것을 도와주는 일종의 툴이다.
- 자바는 가상환경에서 실행되는 것이기 때문에 윈도우 뿐만 아니라 다른 운영체제 리눅스, 맥, 심지어 기계에서도 실행이 가능하다.
- 가비지 컬렉터(Garbage Collector), JVM내에서 메모리를 관리하는 프로세스를 지칭하는 용어이다. 자바 프로그램상에서 사용하지 않는 메모리를 지속적으로 찾아 제거함으로서 효율적인 메모리 관리를 가능하게 한다.
- 가령 선언하고 사용하지 않는 변수, 불필요하게 정의된 메소드 등 프로그램 내에서 메모리를 사용하였지만 활용되지 않는 요소들을 찾아서 제거하는 역할을 하고 있다. 기존의 타 언어(C ..)는 메모리를 직접 관리하여야 했지만, 자바에서는 가비지 컬렉터와 같은 것으로 메모리를 자동으로 관리해주기 때문에 효율적이다.

### JRE (Java Runtime Enviroment)

- JRE(Java Runtime Enviroment)는 JVM이 원활하게 작동할 수 있도록 환경을 맞추어 주는 역할을 한다. JRE에는 JVM과 자바 클래스 라이브러리(Java Class Libraries) 그리고 자바 클래스 로더(Java Class Loader)를 포함한다.
- JRE는 자바 클래스 라이브러리와 자바 클래스 로더를 결합하고, JVM에게 제공하여 JVM을 작동한다. JRE는 단어 그대로 JVM이 실행할 수 있는 환경을 의미한다.

### JDK (Java Development Kit)

- JDK(Java Development Kit)이 바로 우리가 java라고 일컫는 것이다. JDK는 JVM과 JRE를 포함한다. JDK안에는 JRE를 포함하고 있고, JRE는 JVM을 포함하고 있기 때문에 JDK를 설치하면 JRE와 JVM이 같이 설치되는 것이다.
- 그렇다면 JRE와 JDK는 어떠한 차이가 있는가? JDK에는 JRE에 없는 자바 컴파일러(JAVAC: Java Compiler)가 포함 되어있다. 따라서 자바를 실행만 하고자 한다면 JRE만 있어도 되지만, 자바를 개발하고자 한다면 JDK가 필요한 것이다.
- 상기와 같은 내용이라면, 자바로 구성된 프로그램을 실행하려면 모두가 JDK를 설치해야 한다. 그러나 실제는 그렇지 않다. 자바로 프로그램을 개발하려고 하는 자는 JDK를 설치하여 환경을 구성하고 개발하여야 하지만 실행만 하고자 하는 자는 JRE만 설치한다면 실행만 하는것이 가능하다.
---
## JPA
 - 관련 링크 : [git.blog](https://velog.io/@adam2/JPA%EB%8A%94-%EB%8F%84%EB%8D%B0%EC%B2%B4-%EB%AD%98%EA%B9%8C-orm-%EC%98%81%EC%86%8D%EC%84%B1-hibernate-spring-data-jpa)
 - 관련 링크 : [git.blog](https://velog.io/@modsiw/JPAJava-Persistence-API%EC%9D%98-%EA%B0%9C%EB%85%90) 
---
 - JPA(Java Persistance API)란?
 - JAVA에서 기본적으로 제공하는 ORM, 즉 JAVA에서 ORM에 대응하여 기본적으로 제공하는 API중 하나이다. ! 스프링에서 제공하는 것이 아니다 !
 - 기존 EJB에서 제공되던 엔티티 빈을 대체하는 기술이다. JPA는 ORM이기 때문에 당연하게도 DB테이블을 매핑한다. - query를 매핑하지 않는다.
 - JPA는 JAVA에 내장되어있는 ORM을 사용하기 위한 인터페이스 들을 모아둔 것이며, JPA를 사용하기 위해서는 JPA를 구현한 ( 인터페이스기 때문에 구현하여 사용하여야 한다.) Hibernate, EclipsLink, DataNucleus와 같은 프레임 워크를 사용하여야 한다.
 
 <img src="https://media.vlpt.us/images/modsiw/post/72f4da2e-7765-4bce-8da4-edd12c55afac/image.png">
 
 - JPA의 동작 과정
 
 <img src="https://media.vlpt.us/images/modsiw/post/f2995abf-638d-4ff4-92ff-30ed76064b61/image.png">
 
 <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile22.uf.tistory.com%2Fimage%2F999ECC33599003FF337D83">
 
 - JPA는 어플리케이션과 JDBC 사이에서 동작한다. 사용자가 JPA를 사용한다면, JPA내부에서 JDBC API를 이용하여 SQL을 호출하고 그것을 통하여 DB와 통신하는 구조로 되어있다. 즉, 직접적으로 JPA와 접촉하는 것이 그것을 사용하려는 사용자(개발자)가 아니라 JPA인 것이다.
 
 - 예시1) insert
 
 - 그렇다면 JPA를 이용하여 관계형 데이터베이스에 데이터를 삽입(insert)하는 것은 어떠한 구조로 이루어져 있는 것일까?
 
 <img src="https://media.vlpt.us/images/modsiw/post/9085c0b7-6d7c-4506-a06d-b5517e8cecbf/image.png">
 
 - 상기 그림과 같이, DAO* 에 있는 객체를 JPA에게 넘기고, JPA는 해당 객체(MEMBER DAO의 객체)를 분석하고, insert에 해당하는 sql(query문)를 생성하고, API를 이용하여 SQL을 DB에 전송하여 결과값을 얻어오는 것이다.
 
 - 그렇다면 상기와 같은 JPA는 왜 이용하는 것일까?
 
 - JPA와 같이 어플리케이션 수준에서 DB의 정보를 매핑하여 불러오는것이 가능하다면, SQL 중심의 개발에서 객체 중심적인 개발이 가능해진다. 이것은 sql 코드가 반복되던 것과 객체지향 패러다임과 관계지향 데이터베이서 페러다임의 불일치를 해소하는 수단이 된다.
 
 - 생산성이 증가한다.
 
 - 유지보수가 용이해진다.
 
---
## Entity
 - 관련 링크 : [github.blog](https://velog.io/@jayjay28/%EC%97%94%ED%8B%B0%ED%8B%B0Entity)
---

- * JPA와 연관되어있음

- JPA에서, 엔티티는 테이블에 대응하는 하나의 클래스이다. 하기의 코드를 보자.

```
// 엔티티 클래스

public class Member {

  String memId;
  String memPW;
  String memName;
  ...

}

```
 - 연습을 진행하였던 자바 텍스트 게시판의 DTO안의 각각의 데이터클래스와 동일한 내용물을 갖고있다.
 
 ```
 
 // 데이터베이스의 테이블 
 
 |memId|memPW|memName|
 |---|---|---|
 |user1|user1|김민수|
 |user2|user2|김영희|
 |user3|user3|홍길동0|
 
 ```

 - DTO의 클래스 내부의 각각의 필드는 DB에서 column에 대응한다. 따라서 JPA에서 하나의 엔티티 타입을 생성한다는 하나의 클래스를 생성한다라는 의미와 상등하다.

## Map, HashMap, ArrayList
- 관련 링크 [tistory.blog](https://coding-factory.tistory.com/556)
- 관련 링크 [tistory.blog](https://sundrystore.tistory.com/15)
- 관련 링크 [tistory.blog](https://moonong.tistory.com/5)
- 관련 링크 [w3school.com](https://www.w3schools.com/java/java_hashmap.asp)
- 관련 링크 [BLOG](https://codechacha.com/ko/java-map-hashmap/)
---
### Collaction Framework
- 자바의 Map/HashMap, ArrayList와 같은 자료형은 컬렉션 프레임워크(Collaction Framework)에 속해있다.
- 컬렉션 프레임워크(Collaction Framework)이란 자료구조를 기반으로 데이터를 읽기,추가, 삭제 검색 등을 사용자가 효율적으로 객체화 하여 사용하기 위하여 작성되어있는 인터페이스와 클래스 등을 의미하며, java.util 패키지 안에 포함되어 있다.

### hashMap
- hashMap은 컬렉션 중 하나로서 key와 Value로서 데이터를 그룹화하여 저장하여 사용할 수 있는 형태를 의미한다.
- hashMap을 사용하기 위해서는 java.util.HashMap을 임포트 하여야 한다. hashmap은 자료를 묶어서 보관한다는 점에서 ArrayList와 유사한방면이 있지만, index로서 자료를 관리/운용 하는 것이 아니라 index의 대체로서 key를 사용하고, 그와 상응하는 Value가 있다는 점에서 ArrayList와는 다른 면모를 가지고 있다.
```
hashMap 예제
import java.util.HashMap

HashMap <DataType(Key), DataType(Value)> VariableName = new HashMap<>();
```
- hashMap은 상기와 같이 사용한다. Value는 중복이 가능하나 index와 같은 논리로서 key는 중복이 불가능하다.
---
## Object...
- 관련링크 [com.blog](https://java.ihoney.pe.kr/155)
---
```
이녀석의 특징은 메소드 등에서 동일한 객체의 파라메터(실행에 필요한 변수, 설정변수?)들을 처리할 때, 메소드마다 파라메터의 갯수를 늘려가며 설정하는 대신,
public void method(Int... args) {}  

로 설정해두면, int 형의 파라메터를 몇개를 받아도 처리가 가능하다.
```

## String.format
- 관련링크 [blog.com](https://blog.jiniworld.me/68)
---
- 내용
---
## ArrayList 정렬
- 관련링크 [tistory.blog](https://manorgass.tistory.com/60)
- 관련링크 [tistory.blog](https://offbyone.tistory.com/154)

<!--
자바 스트림 
https://futurecreator.github.io/2018/08/26/java-8-streams/
-->
## Async   
## java thread
## Optional
- 관련 링크 [blog.com](https://www.daleseo.com/java8-optional-after/)
- 관련 링크 [blog.com](https://jdm.kr/blog/234)
---
- Optional클래스는 null 때문에 java 8 이후 부터 출범된 클래스이다. 




## java concurrenthashmap
## lambda
## Enum
- 관련 링크[tistory.blog](https://itmining.tistory.com/149)
## stream()
```
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();

```
---
# Java - WEB 공통
## JDBC Driver
- 관련 링크 : [tistory.blog](https://dyjung.tistory.com/50)
- 관련 링크 : [naver.blog](https://m.blog.naver.com/bgpoilkj/221672288866)
- 관련 링크 : [tistory.blog](https://sesok808.tistory.com/36)
- 관련 링크 : [tistory.blog](https://hoit89.tistory.com/entry/%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%EC%83%9D%EC%84%B1%EC%BF%BC%EB%A6%AC%ED%85%8C%EC%9D%B4%EB%B8%94columnrow)
---
### JDBC(Java Database Connectivity)
- JDBC는 자바에서 데이터베이스(DB)에 접속할 수 있는 기능을 제공하는 자바API이다. JDBC는 데이터베이스에서 자료를 쿼리* 거나 업데이트 하는 방법을 제공한다.
  - 쿼리(Query) : 쿼리란 데이터베이스에 정보를 요청하는 것을 의미한다. 쿼리는 웹 서버에 특정한 정보를 보여달라는 웹 클라이언트 요청(주로 문자열을 기본요청)에 의한 처리.
  - SQL(Structured Query Language)의 이름 안에서도 쿼리를 알 수 있듯이 데이터베이스에서 정보를 얻는것.
- JDBC는 데이터 베이스를 다루는 기본적인 인터페이스만 제공하고 나머지는 DBMS(Database Management System)* 에 따라 DB를 관리할 수 있도록 구성되어있기 때문에 mySQL(MariaDB), OracleDB등 모든 DB에 자유롭게 호환하여 사용할 수 있는 특징이 있다.
  - DBMS(Database Management System) : 데이터베이스 관리 시스템으로서 데이터베이스 내의 데이터를 접근할 수 있는 기능이 있는 소프트웨어 도구의 집합을 의미한다.
```
JDBC Connection 예제 (Oracle DB)
Connection con = null;
		ResultSet rs = null;
		PreparedStatement psmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "c##web";
			String pw = "oracle";
			System.out.println("DB정상연결");
			try {
				con = DriverManager.getConnection(url,id,pw);
				System.out.println("DB계정일치");
			} catch (SQLException e) {
				System.out.println("DB계정불일치");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("DB연결실패");
			e.printStackTrace();
		}
```
```
JDBC Connection 예제 (Maria DB)
...
Connection conn = null;
try {
    String jdbcDriver = "jdbc:mysql://localhost:3306/chap11?" + "useUnicode=true&characterEncoding=utf-8";
    String dbUser = "DBIDNAME";
    String dbPw = "DBIDPASSWORD";
    conn = DriverManager.getConnection(jebcDriver,dbUser,dbPw);
    ...
}
```
- 상기의 예제들과 같이 DriverManager등을 이용하여 Conncetion객체를 생성하여 DB에 연결한 후 데이터를 쿼리할 수 있다.
- 하기는 JDBC 사용 어플리케이션의 기본 구성 및 값 조회법에 대한 예제이다.

- JDBC API 사용 어플리케이션의 기본 구성

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile27.uf.tistory.com%2Fimage%2F993CBB365B52D9F73210E6"/>

- ResultSet에서 값 조회

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile28.uf.tistory.com%2Fimage%2F994F43415B52DA782EDDF1"/>

---
## 순환참조
## Builder 패턴
- 관련 링크[tistory.blog](https://royleej9.tistory.com/entry/Lombok-Builder)
- 관련 링크[github.blog](https://johngrib.github.io/wiki/builder-pattern/)
- 관련 링크 [github.blog](https://cheese10yun.github.io/lombok/)
- 관련 링크[]()
---
## Mybatis
## COS-MultipartRequest
---
# JSP 학습
## JSP
 - 관련 링크 [tistory.blog](https://mangkyu.tistory.com/14)
---

- JSP 란
- JSP(Java Server Page)란 서블릿의 규칙이 복잡함에 따라 HTML내부에 자바코드를 삽입하여 이용할 수 있도록 보완하여 만든 서블릿 기반의 스크립트 기술이다.
- JSP는 서블릿을 작성하지 않고도 웹프로그래밍을 구현할수 있게 만든 기술이다.
 
- JSP는 HTML안에 태그형식으로 자바코드를 삽입하여 사용할 수 있는 구조로 구성되어있다. HTML속에서 자바코드는 <% 소스코드 %> 또는 <%= 소스코드 =%>형태로 들어가게된다.

- JSP는 WAS(Web Application Server)에 의하여 서블릿 클래스로 변환하여 사용된다.

- JSP의 동작 구조

<img src="https://mblogthumb-phinf.pstatic.net/20150604_85/islove8587_1433408612779SkNsM_JPEG/4_JSP%C0%C7%B5%BF%C0%DB%B1%B8%C1%B6.jpg?type=w2">

```
웹 서버가 사용자로부터 서블릿에 대한 요청을 받으면 서블릿컨테이너에 그 요청을 넘깁니다. 
요청을 받은 컨테이너는 HTTP Request와 HTTP Response 객체를 만들어, 이들을 통해 서블릿 doPost()나 doGet()메소드 중 하나를 호출합니다. 
만약 서블릿만 사용하여 사용자가 요청한 웹 페이지를 보여주려면 out 객체의 println 메소드를 사용하여 HTML 문서를 작성해야 하는데 이는 추가/수정을 어렵게 하고, 가독성도 떨어지기 때문에 JSP를 사용하여 비지니스 로직과 프레젠테이션 로직을 분리합니다. 
여기서 서블릿은 데이터의 입력, 수정 등에 대한 제어를 JSP에게 넘겨서 프레젠테이션 로직을 수행한 후 컨테이너에게 Response를 전달합니다. 
이렇게 만들어진 결과물은 사용자가 해당 페이지를 요청하면 컴파일이 되어 자바파일을 통해 .class 파일이 만들어지고, 두 로직이 결합되어 클래스화 되는것을 확인할 수 있습니다.
즉, out객체의 println 메소드를 사용해서 구현해야하는 번거로움을 JSP가 대신 수행해줍니다.

```
-  내용만 보게 된다면 서블릿이나 JSP나 만드는 방법에 차이가 있을 뿐 동일한 역할을 한다는 것을 알수 있다. 초기에 자바 웹개발은 서블릿을 이용한 개발이였다. 이후 JSP기술이 발표되면서 JSP형태의 개발이 유행하게 되고 지금에 와서 각각의 역할을 나누어 Servlet+JSP형태의 개발이 이루어지고 있다.

-  JSP는 JSP기술의 장점을 최대한 활용 할 수 있는 웹에플리케이션 구조에서 사용자에게 결과를 보여주는 프리젠테이션 층을 담당하고 Servlet은 Servlet기술의 장점을 최대한 활용 할 수 있는 사용자의 요청을 받아 분석하고 비지니스 층과 통신하여 처리하고 처리한 결과를 다시 사용자에게 응답하는 컨트롤러 층을 담당한다.

- MVC 패턴 에서의 JSP와 서블릿

<img src="https://mblogthumb-phinf.pstatic.net/MjAxNzEwMzBfMjkw/MDAxNTA5MzQ1NDM0ODM2.40qv0x-SJdITWEUFVSw0qzCGM1ZISOxkaC5ClBYxOMIg.TrKmJH-Y7_IX0gwqNEQYqn9WS_GEh9Bk20jMEwSJzGgg.PNG.acornedu/jsp.png?type=w800">

- 얼마전까지만 하더라도 JSP만 이용한 개발(Model1 방식)이 유행하다 현재는 유지보수단계에서 많은 단점을 느껴 각각의 역할을 나누어 서블릿과 JSP를 동시에 사용하여 개발하는 방식(Model2 방식*)으로 개발하고 있어 현재는 Servlet과 JSP를 나누어 사용하고 있다.

- 그리하여 JSP는 HTML태그 사용이 용이하고 자바코드 사용이 불편하기 때문에 웹어플리케이션에서 사용자에게 결과를 보여주는 View(Client)를 담당하고 Servlet은 자바코드 작성이 편리하기 때문에 주로 화면과 통신하여 자료를 받아 가공하고 가공한 자료를 다시 화면에 전달하는 Controller역할을 하고 있다.

- Model2 방식
```
- Servlet & JSP 연동 (모델2방식)
- 1. 모델1 방식 (JSP만 이용하는 경우)
- JSP 페이지와 자바빈 클래스로 구성된 모델.
- JSP 페이지의 역할은 클라이언트와의 데이터 송수신 액션을 담당.
- 자바빈 클래스는 데이터베이스와의 데이터 입출력 액션을 담당.

2. 모델2 방식 (Servlet과 JSP가 혼용된 경우)
- JSP 페이지와 Servlet, 자바빈 클래스로 구성된 모델.
- Servlet은 클라이언트와의 데이터 송수신 액션을 담당. 데이터베이스 액션. 결과를 JSP 페이지로 전달해서 결과 출력.
- JSP 페이지는  받은 결과를 출력하는 액션.
- 자바빈은 Servlet로부터 JSP페이지로 결과를 전달하는 과정에서 결과 저장용 객체 역할.
- MVC 패턴이라고도 한다.

```
## JSP - Attribute
- 관련 링크 : [tistory.blog](https://gangzzang.tistory.com/entry/JSP-%EA%B8%B0%EB%B3%B8-%EA%B0%9D%EC%B2%B4%EC%9D%98-%EC%86%8D%EC%84%B1Attribute)
- 관련 링크 : [tistory.blog](https://gap85.tistory.com/entry/JSP-Attribute-%EC%86%8D%EC%84%B1)
---

## JSP Model Architecture
### Model 2 MVC
- 관련링크 [naver.blog](https://m.blog.naver.com/jhc9639/220967034588)
- 관련링크 [wikipedia.org](https://ko.wikipedia.org/wiki/%EB%AA%A8%EB%8D%B8-%EB%B7%B0-%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC)
- 관련링크 [tistory.blog](https://msmk530.tistory.com/88)
---
- MVC for java
  - M: 모델(Service, Repository(DAO), DTO(VO))
  - V: 뷰(JSP)
  - C: 컨트롤러(Controller)
---
#### DTO, DAO
## JSP WEB 디자인 패턴
### 1. 어댑터 패턴
- 관련 링크 : [tistory.blog](https://niceman.tistory.com/141)
- 관련 링크 : [javagists.com](https://www.javagists.com/adapter-design-pattern)
---
- 어댑터 패턴은 한 클래스의 인터페이스를 사용하고자 하는 다른 인터페이스로 변환할 때 주로 사용하는 것이며, 이를 이용함으로서 인터페이스 호환성이 맞지 않아 같이 사용할 수 없는 클래스를 연관 관계로 연결하여 사용할 수 있도록 하는 객체지향 디자인 패턴 중 하나이다.

<img src="https://www.javagists.com/ezoimgfmt/i1.wp.com/www.javagists.com/wp-content/uploads/2018/01/adapter-Example.png?w=688&ssl=1&ezimgfmt=ng:webp/ngcb2">

- 상기 그림과 같이, 하나의 클래스를 다른 클래스와 연결할 수 있도록 기능을 하는 클래스를 구축하는것이 어댑터 패턴이다.
- The adapter is the main component in this pattern, which acts as a coordinator between the two incompatible systems. Usually, this will be a class, which contains connection points to both systems. The inner mechanism inside the adapter class will convert the requests from the sending system to match with the receiving system.

---
### JAVA 캡슐화 (Encapsulation)
- 참고 링크 [tistory.blog](https://radait.tistory.com/5)
- 참고 링크 [tistory.blog](https://javacpro.tistory.com/31)
- 참고 링크 [tistory.blog](https://mainpower4309.tistory.com/7)
---
#### 캡슐화(Encapuslation)

- 캡슐화는 은닉화라고도 불리는 일종의 객체지향 디자인 패턴을 의미한다. 캡슐화의 정의는 필요한 속성(Attribute)와 행위(Method)를 하나로 묶고 그 중 일부를 외부에서 사용하지 못하도록 은닉하는 것이다. 캡슐화는 중요한 데이터를 보존, 보호하기 위하여 사용되는 디자인 패턴이다. 즉 캡슐화는 클래스에 담는 내용중 중요한 데이터나 기능을 외부에서 접근하지 못하도록 조치를 취하는 것이다.
- 캡슐화를 하는 방법은 다음과 같다.
```
- 캡슐화 방법
1. 멤버 변수 앞에 접근 제어자 private를 붙인다. (private: 자기 클래스에서만 접근할 수 있는 것 )
2. 멤버 변수에 값을 넣고 꺼내 올 수 있는 메소드를 만든다 (접두어 set/get을 사용해 메소드를 만든다.)
```
- 외부에 공개하기 위한 라이브러리를 한 개 제작했다고 가정하자. 라이브러리 안에는 각각 역할에 맞는 클래스들이 존재할 것이다. 그리고 개개의 변수 또는 메소드역시 각자의 역할에 맞게 설계되어 있을 것이다. 그렇다는 것은 클래스 안의 메소드 혹은 변수의 값이 어떠한 의도를 내포하고 있다는 것이 된다.
- 만일 어떠한 의도를 내포하고 있는 변수와 메소드가, 의도와는 다르게 변경되었다면 그 로직은 어떻게 작동이 될까? 분명 오류를 발생시킬 것이다.
- 캡슐화는 이러한 상황을 방지하기 위하여 생긴 일종의 객체를 디자인하는 패턴 중 하나이다. 라이브러리와 같이 작성된 코드가 외부에서 사용될 가능성이 있을 때, 설계와 다르게 움직일 수 있게 만드는 일말의 가능성을 없애고자 고안된 패턴인 것이다.
- 작성된 객체에서 사용자가 접근하도록 의도한 혹은 접근해도 프로그램이 의도한 바와 같이 동작하는데 일말의 영향이 없는 메소드와 필드는 자유롭게 접근하도록 조치하고(public), 접근하여 그 값을 변경 혹은 수정하였을 떄 의도한 바와 같이 동작하지 않거나 프로그램에 치명적 결함 혹은 공개하지 않아야 하는 상황에 놓여진 필드 혹은 메소드는 접근을 제한하도록 조치(private ...)하는 것이 캡슐화이다.
---
### 추상화
## Servlet
 - 관련 링크 : [github.blog](https://gmlwjd9405.github.io/2018/10/28/servlet.html)
 - 관련 링크 : [naver.blog](https://m.blog.naver.com/acornedu/221128616501)
 - 관련 링크 : [tistory.blog](https://mangkyu.tistory.com/14)
---
 - 서블릿(Servlet)이란?
 ```
 웹 기반의 요청에 대한 동적인 처리가 가능한 하나의 !! 클래스 !!
 ```
 - 서블릿(Servlet)은 서버에서 웹페이지 등을 동적으로 생성하거나 데이터 처리를 수행하기 위하여 자바로서 작성된 하나의 프로그램이다. 서블릿은 자바 코드안에 HTML태그로 삽입되며 자바 언어로 되어있고 확장자 역시 .java이다.
 - 서블릿은 '클라이언트 요청을 처리하고 그 결과를 다시 클라이언트에게 전송하는 servlet 클래스의 구현 규칙을 지킨 자바프로그램'으로 정리 가능하다. 즉, 웹상에서 클라이언트가 어떠한 요청(request)을 하면 그에 대한 결과를 다시 전송(response)해주어야 하는데, 이러한 역할을 하는 자바 프로그램이 서블릿 인 것이고, 이러한 서블릿은 자바를 이용하여 웹을 제작하기 위해 필요한 기술인 것이다.
 
 - 서블릿의 특징 
   - HTTP 프로토콜 서비스를 지원하는 javax.servlet.http.HttpServlet 클래스를 상속받는다.
   - MVC모델에서 Controller로서 이용 된다.
   - html을 이용하여 요청에 응답한다.
 
 - 서블릿의 동작방식
 
 <img src="https://t1.daumcdn.net/cfile/tistory/993A7F335A04179D20">
 
 - 서블릿의 동작 과정
 
 <img src="https://gmlwjd9405.github.io/images/web/servlet-program.png">
 
 - 클라이언트가 URL을 입력하면 HTTP REQUEST가 서블릿 컨테이너로 요청을 전송한다.
 - 요청을 받은 서블릿 컨테이너는 HttpServletRequest와 HttpServletResponse 객체를 생성한다.
 - xml기반으로 사용자가 요청한 URL이 어느 서블릿에 대한 요청인지를 색인한다.
 - 해당 서블릿에서 service() 메소드를 호출한 후 클라이언트의 get/post의 여부에 따라 doGet() / doPost()를 호출한다.
 - doGet() / doPost()메소드는 동적 페이지를 생성한 후 HttpServletResponse객체에 요청에 대한 응답을 보낸다.
 - 응답을 다 보낸 후 HttpServletReques와 HttpServletResponse 두 객체 모두를 소멸시킨다.
 ```
  서블릿 메서드 구현 예제
  
  // `javax.servlet.http.HttpServlet`를 상속받은 Servlet 클래스
  
public class LoginServlet extends HttpServlet {
    // doPost() 오버라이드
    protected void doPost(HttpServletRequest request, HttpServletResponse response throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
         
        
        PrintWriter writer = response.getWriter();

        /* 여기서 -> DB 접근 등 Business Logic 부분을 처리 */
         
        
        String htmlResponse = "<html>";
        htmlResponse += "<h2>Your username is: " + username + "<br/>";      
        htmlResponse += "Your password is: " + password + "</h2>";    
        htmlResponse += "</html>";	
         
        
        writer.println(htmlResponse);         
    }
}

 ```
 ### 서블릿 컨테이너 (Servlet Container)
 
 ```
 
 서블릿을 관리하여주는 컨테이너
 
 ```
 - 서버에 서블릿을 생성한것 만으로는 스스로 작동할 수 없다. 따라서 서블릿을 관리하여 주는 무언가가 필요한데, 그것이 바로 서블릿 컨테이너이다. 
 - 서블릿이 어떠한 기능에 대한 설명서라고 한다면, 서블릿 컨테이너는 설명서를 보고 기능을 수행하는 주체라고 볼 수 있는 셈이다.
 - 서블릿 컨테이너는 즉, 클라이언트의 요청(response)과 응답(response)을 할 수 있도록 웹서버와 소켓으로 통신하는 것 이다.
 - 서블릿 컨테이너의 대표적인 예로는 톰캣(Tomcat)이 있다. 톰캣은 웹서버와 통신을 하며 JSP와 서블렛이 작동할 수 있는 환경을 제공하여준다.
```
[Servlet Container 역할]
  1. 웹서버와의 통신 지원
서블릿 컨테이너는 서블릿과 웹서버가 손쉽게 통신할 수 있게 해줍니다. 일반적으로 우리는 소켓을 만들고 listen, 
accept 등을 해야하지만 서블릿 컨테이너는 이러한 기능을 API로 제공하여 복잡한 과정을 생략할 수 있게 해줍니다.
그래서 개발자가 서블릿에 구현해야 할 비지니스 로직에 대해서만 초점을 두게끔 도와줍니다.

  2. 서블릿 생명주기(Life Cycle) 관리 
서블릿 컨테이너는 서블릿의 탄생과 죽음을 관리합니다. 서블릿 클래스를 로딩하여 인스턴스화하고, 
초기화 메소드를 호출하고, 요청이 들어오면 적절한 서블릿 메소드를 호출합니다. 
또한 서블릿이 생명을 다 한 순간에는 적절하게 Garbage Collection(가비지 컬렉션)을 진행하여 편의를 제공합니다.


  3. 멀티쓰레드 지원 및 관리 
서블릿 컨테이너는 요청이 올 때 마다 새로운 자바 쓰레드를 하나 생성하는데, HTTP 서비스 메소드를
실행하고 나면, 쓰레드는 자동으로 죽게됩니다. 원래는 쓰레드를 관리해야 하지만 서버가 다중 쓰레드를
생성 및 운영해주니 쓰레드의 안정성에 대해서 걱정하지 않아도 됩니다.


  4. 선언적인 보안 관리 
서블릿 컨테이너를 사용하면 개발자는 보안에 관련된 내용을 서블릿 또는 자바 클래스에 구현해 놓지 않아도 됩니다.
일반적으로 보안관리는 XML 배포 서술자에 다가 기록하므로, 보안에 대해 수정할 일이 생겨도 자바 소스 코드를 
수정하여 다시 컴파일 하지 않아도 보안관리가 가능합니다.

```
## Servlet - JSP 연동
```
		- Servlet
    
		response.getWriter().append(name);
    
```
 - 서블릿 코드 내에서 getWriter() 메소드를 이용하여 요청을 직접 수취하고, 요청에 따라 html을 직접 작성하여줄 수 있지만, 그렇게 되면 코드가 복잡해지고 비효율적으로 되기 때문에 디스패쳐 등을 이용하여 서블릿에서는 요청만을 처리하고, view와 관련된 영역은 jsp에게 위임하는 형태를 취할 수 있다.
 
 - html 마크들 사이에서 태그로서 java코드를 사용할 수 있는 jsp가 상기와 같은일을 위임받아 처리하는 것이 보다 효율적이기 때문에 이런식으로 이루어져있는 것이다. 코드는 하기와 같다.
 ```
 // 파라미터를 받음
		String name = request.getParameter("name");
		
		// 요청을 UTF-8로 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 응답을 UTF-8로 인코딩	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 요청을 Dispatcher가 수취하고 JSP에게 VIEW를 위임
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/usr/article/write.jsp");
		requestDispatcher.forward(request, response);
 ```
 - JSP 파일을 wevapp 의 wev-inf 디렉토리에 포함시키는 이유:
 - JSP와 서블릿을 분리시키는 이유와 상통한다. 요청을 처리하는 것은 서블릿이 훨씬 효율적이고(자바를 사용하여 처리할 수 있기 때문) 페이지를 구성하여 클라이언트에게 노출시키는 것은 JSP가 훨씬 효율적이기 때문에(html 을 바탕으로 java코드를 삽입하기 때문)둘의 역할을 나눈것인데,
 - 클라이언트가 서블릿을 통하지 않고 직접 jsp파일로 이동한다면, 요청에대한 전처리가 없이 날것으로 접촉하는 것이기 때문에 상기와 같이 역할을 구분한 이유가 없어지게 된다.
 - 따라서 이런것을 미연에 방지하고자 규약으로 정해놓은 겅시 web-inf의 디렉토리에 있는 jsp파일은 서블릿을 통하여 접촉할 수 있고 직접적인 접촉은 막아놓은 것이다.
 - 이와 같은 이유로서 jsp는 web-inf디렉토리에 위치시키고 사용하는것이다.
## Servlet Uri Mappinng
- 관련 링크 : [tistory.blog](https://codevang.tistory.com/194)

---
 - 서블릿에서 URI 를 매핑하는 방법은 두가지가 존재한다.
 
 ```
 @WebServlet("/URI")
 @WebServlet(urlPatterns = {"/main", "/test", "/join"})
 
 ```
 
 - 1. 서블릿의 어노테이션을 사용한 매핑
 - 어노테이션을 직접 수정해도 무방하지만, 서블릿 파일을 생성할 때에 직접 지정해 줄 수 있다. 다음 그림과 같다.
 
 <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FyTU2U%2FbtqBZftoHbK%2FKqdRJsDG1s3Np7K21Af3sk%2Fimg.png">
 
 - 이렇게 서블릿 파일에 URI를 매핑하고, URL로 접속하면 톰캣(tomcat) 서버 컨테이너가 매핑된 서블릿을 찾아 해당 서블릿을 실행하는 구조로 되어있다.
 
 - 상기의 코드블럭과 같이, @WebServlet 어노테이션에 Url을 입력하는 방식과 여러개의 Url을 배열의 형태로서 입력하는 형태 모두 가능하다.
 
 - 2. web.xml을 통한 매핑
 
 - web.xml 환경설정 파일에서 직접 매핑하여주는 방벙도 존재한다. 1번 방법보다는 비교적 복잡하지만, 웹 서비스가 복잡해지고, 서블릿의 갯수가 많아진다면 web.xml에서 한번에 관리하는 것이 보다 효율적일 수 있다.
 ```
 /*
 이클립스에서 web.xml 파일을 텍스트 편집기로 연 뒤 아래의 형식으로 코드를 입력합니다. 
 주의할 점은 만약 패키지가 있다면 "패키지명.서블릿 클래스 이름"으로 전체 path를 입력해줘야 한다는 것입니다.
*/

<servlet>
		<servlet-name>Name</servlet-name>
		<servlet-class>com.java.example.ClassName</servlet-class>
	</servlet>
	
	<servlet-mapping>
		<servlet-name>Name</servlet-name>
		<url-pattern>/class</url-pattern>
	</servlet-mapping>
    
    
	<servlet>
		<servlet-name>Name2</servlet-name>
		<servlet-class>com.java.example.ClassName</servlet-class>
	</servlet>
	
	<servlet-mapping>
		<servlet-name>Name2</servlet-name>
		<url-pattern>/main</url-pattern>
	</servlet-mapping>
```
- 이렇게 xml을 변경하였다면 publish를 하여야만 실제 톰캣의 설정 파일과 동기화가 된다.

---
 - URI에서 프로젝트명 생략하기
 - 로컬에서 작업을 한다면, 서블릿에서 지정한 URL의 규칙이 다음과 같다는 것을 알 수 있다.

```

로컬:포트/프로젝트 명/서블릿에 지정한 URL

```
 - 이 때 프로젝트명을 제외하고 URI를 구성할 수 있다.
 - 이클립스를 기준으로, server탭에서 톰캣 서버를 열어 Modules탬으로 이동한 후 edit을 통하여 Path뒤의 값을 지운 후 "/"만 남긴다음 확인을 누르면 된다.
 
 - 상기의 과정으로 적용여부를 확인하기 위해서는 server.xml을 편집기로 연 후, 가장 아래쪽에 있는 Context의 Path정보를 확인하면 된다. Context의 Path부분이 "/"만 남았다면 성공이다. 

## Servlet 파라미터 수취
```
@WebServlet("/usr/home/main")

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터를 받음
		String name = request.getParameter("name");
		
		// 요청을 UTF-8로 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 응답을 UTF-8로 인코딩	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 페이지에 출력
		response.getWriter().append(name);
	}
```

- 요청을 GET방식으로 발송하는 경우, HttpServletRequest의 doGet을 구현한 메소드에 request의 getParameter 메소드를 이용하여 파라미터를 받을 수 있다.

- 상기의 예제에선 서블릿의 어노테이션이 /usr/home/main이고, 파라미터를 name으로 수취하고 있기 때문에 "/usr/home/main?name=파라미터 값" 형식으로 입력하여 요청을 전송하면 서블릿 컨테이너는 요청을 받고 해당 서블릿에 name에 해당 파라미터 값을 전송하는 형식으로 이루어져 있다.


## Dispatcher
- 관련 링크 [tistory.blog](https://cbts.tistory.com/286)
- 관련 링크 [tistory.blog](https://velog.io/@lzhxxn/Servlet-Dispatcher%EB%B0%A9%EC%8B%9D%EA%B3%BC-Redirect-%EB%B0%A9%EC%8B%9D)
- 관련 링크 [tistory.blog](https://mangkyu.tistory.com/18)
---

### Servlet - Controller 관계

- 정석대로라면 매 요청마다 Servlet을 생성하는 것이 원칙이지만, 요청마다 서블릿을 생성하는 것은 현실적으로 어려움이 있음, 따라서 실무에서는 경량 servlet의 개념으로서 Controller를 생성하여 요청을 처리하고, jsp를 전달해주는 역할을 한다.

### Dispatcher란?

```
 Servlet Container에서 HTTP프로토콜을 통해 들어오는 모든 요청을 프레젠테이션 계층의 제일앞에 둬서 중앙집중식으로 처리해주는 프론트 컨트롤러(Front Controller)
 
```
```
- 라이언트로부터 어떠한 요청이 오면 Tomcat(톰캣)과 같은 서블릿컨테이너가 요청을 받는데, 이때 제일 앞에서 서버로 들어오는 모든 요청을 처리하는 *프론트 컨트롤러를 Spring에서 정의하였고, 이를 Dispatcher-Servlet이라고 합니다. 그래서 공통처리 작업을 Dispatcher 서블릿이 처리한 후, 적절한 세부 컨트롤러로 작업을 위임해줍니다. 

- 물론 Dispatcher-Servlet이 처리하는 url 패턴을 지정해주어야 하는데 일반적으로는 /*.do와 같으 /로 시작하며 .do로 끝나는 url 패턴에 대해서 처리하라고 지정해줍니다. 

```
- Redirect 방식으로 페이지를 이동시키는 것이 아닌 Forward방식으로 페이지를 이동시키기 위하여 사용되는 방법*

---
#### Forward방식과 Redirect방식

<img src="https://media.vlpt.us/images/lzhxxn/post/ef46fd74-8bfe-4e6e-9b91-8656b993172c/download.png">

- forward, redirect 둘다 서블릿에서 특정 url 혹은 페이지로 이동하게 하는 방식이다. 

- Forward :: Dispatcher 방식
- 포워드는 전달하는 방식으로서 클라이언트가 요청하면서 전송한 데이터를 그대로 유지한다. 즉, 포워딩 된 주소는 변경되지 않는다.(같은 request 영역을 공유한다.)

- Redirect :: sendRedirect
- 리다이렉트 방식은 이동하기 방식으로서, 새로운 페이지로 완전히 이동하여 기존 데이터를 하나도 이용할 수 없게 된다. 리다이렉트방식은 새로운 페이지로 이동이 된 것이기 때문에 URL역시 변하게 된다. 

---
### Dispatcher를 사용하는 이유
- 파라미터를 POST타입으로 전달하기 위하여 사용한다.
- 디스패쳐를 사용하면, 값을 Object타입으로 전달할 수 있다.
- POST방식은 header정보를 파라미터로 전송하지만, GET방식은 URL을 통하여 값을 전송한다.
- URL응로 값을 넘기면 byte타입으로 변형되어 넘어가는데, 이때 인코딩상 이유로서 문자열의 인코딩을 변형해야한다. 이때 한글 깨짐이 발생하여 인코딩 코드를 명기하는 것이다.
- Spring MVC는 DispatcherServlet이 등장함에 따라 web.xml의 역할을 상당히 축소시켰다. 기존에는 모든 서블릿에 대해 URL 매핑을 활용하기 위해서 web.xml에 모두 등록해주어야 했지만, dispatcher-servlet이 해당 어플리케이션으로 들어오는 모든 요청을 핸들링해주면서 작업을 상당히 편리하게 할 수 있게 되었다. 그리고 이 서블릿을 이용한다면 @MVC 역시 사용할 수 있게되어 여러모로 장점이 많다.

---
### Dispatcher - Servlet의 흐름

<img src="https://blog.kakaocdn.net/dn/MRXX3/btqK7014LOZ/wMKgG9RVkdZR7Ag5nD4wh0/img.png">

```
Dispatcher Servlet이 요청을 Controller로 넘겨주는 방식은 효율적으로 보입니다. 하지만 모든 요청을 처리하다보니 이미지나 HTML 파일을 불러오는 요청마저 전부 Controller로 넘겨버립니다. 게다가 JSP 파일 안의 JavaScript나 StyleCSS 파일들에 대한 요청들 까지도 모두 디스패처 서블릿이 가로채는 까닭에 자원을 불러오지 못하는 상황도 발생하곤 했습니다.  이에 대한 해결책은 두가지가 있는데 첫번째는 클라이언트의 요청을 2가지로 분리하여 구분하는 것입니다.

1. /apps 의 URL로 접근하면 Dispatcher Servlet이 담당한다.

2. /resources 의 URL로 접근하면 Dispatcher Servlet이 컨트롤할 수 없으므로 담당하지 않는다.

이러한 방식은 괜찮지만 상당히 코드가 지저분해지며, 모든 요청에 대해서 저런 URL을 붙여주기 때문에 직관적인 설계가 될 수 없습니다. 두번째 방법은 모든 요청을 컨트롤러에 등록하는 것인데, 상당히 무식한 방법입니다. 

Spring은 이러한 문제들을 해결함과 동시에 편리한 방법을 제공해주는데, 그것은 바로 <mvc:resources />를 이용한 방법인데, 이것은 만약 Dispatcher Servlet에서 해당 요청에 대한 컨트롤러를 찾을 수 없는 경우에, 2차적으로 설정된 경로에서 요청을 탐색하여 자원을 찾아내는 것입니다. 이렇게 영역을 분리하면 효율적인 리소스관리를 지원할 뿐 아니라 추후에 확장을 용이하게 해준다는 장점이 있습니다.

```
## Java bean
---
### Getter / Setter
- 자바 빈 규약
- 프로퍼티 접근 방식
## JSTL
- 관련링크 [github.blog](https://daesuni.github.io/jstl/)
---
- JSTL 이란?
```
JSTL의 정식 명칭은 자바서버 페이지 표준 태그 라이브러리(JavaServer Pages Standard Tag Library)이고 줄여서 JSTL이라 부른다.
```
- 일반적으로 사용되고 있는 JSTL은 JSTL과 EL의 조합을 일컫는다. 기존의 HTML에 JAVA코드를 삽입하여 사용하려면 <%%> 와같은 태그 안에서 사용하고, 코드의 무게가 비교적 무거웠는데, JSTL과 EL을 같이 사용하면 해당 문제를 해결할 수 있다.

- JSTL의 사용법
- JSTL은 라이브러리이기 때문에 사용하기전에 core를 header에 추가해주어야 한다.
```
//JSTL 라이브러리 태그
//문서 문두에 사용하여야 한다.
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
```
- 사용 예제는 하기와 같다.
```
<c:if test=""></c:if>
<c:forEach items=""></c:forEach>
```
- JSTL core 태그
```
|태그명|설명|
|---|---|
|<c:set/>|변수명에 값을 할당 var="variable name"|
|<c:out>|값을 출력|
|<c:if>|조건식에 해당하는 블럭과 사용될 스코프를 설정|
|<c:choose>|switch와 상등|
|<c:when>|switch의 case와 상등|
|<c:otherwise>|switch의 default와 상등|
|<c:forEach>|java내의 foreach와 동일|
```
- JSTL의 내용이 상기와 같다면 EL* 은 무엇인가, 하기와 같다.

### EL (Expression Language)
- EL의 정식 명칭은 표현 언어(Expression Language)라고 하며 줄여서 EL이라고 부른다.

- EL의 사용법
```
<%= name %>
${name}
```

- EL의 연산자 종류
```
|연산부호|연산자|
|---|---|
|+|+|
|*|*|
|/|div|
|\&\&|and|
| \|\| | or |
| == |  eq |
|!=|ne|
|<|ge|
|>|lt|
|<=|ge|
|>=|le|

```

## ORM( Object Relational Mapping )
 - 관련 링크 : [git.blog](https://gmlwjd9405.github.io/2019/02/01/orm.html)
---
 - ORM (Object Relational Mapping : 객체-관계 매핑)을 이해하기 위해선 우선 영속성(Persistance)에 대한 선수학습 및 이해가 있어야 한다. 따라서 하기에 영속성에 대한 내용을 정리하였다. 
 
### 영속성(persistance)
 - 프로그램 내에서 발생한 데이터 혹은 그것과 상등한 것이 프로그램이 종료되더라도 사라지지 않는 데이터의 특성을 의미한다.
 - 프로그램이 실행되고 그것을 컴퓨터의 저장소에 저장하지 않는 이상은 메모리 영역에서만 존재하게 되며, 메모리(RAM)는 프로그램의 종료와 동시에 관련 데이터를 소실하게 되므로 저장하지 않은 데이터는 소멸되게 되는 것이다.
 - 상기와 같은 상황을 면하기 위하여 프로그램을 종료하기 전에 영구적으로 보관하고자 하는 데이터 혹은 그와 상등한 것이 있다면, 컴퓨터의 저장소에 상등하는 곳(HDD, SSD)에 저장을 하여야만 한다.
 - 데이터의 영구적인 저장을 위해서는 영구적인 객체를 활용할 수 있다. 메모리상의 데이터를 파일 시스템, 관계형 데이터베이스(Map, DB) 혹은 객체 데이터베이스화 하여 영구적으로 저장하영 영속성을 부여할 수 있는 것이다.
 
 <img src="https://gmlwjd9405.github.io/images/database/orm-persistence.png">
 
 - 이렇게 데이터를 저장하는 방법에는 다음과 같은 것들이 있다.
   - JDBC(java)활용
   - Spring JDBC ( ex ) JDBC Template);
   - Persistance Framework ( ex ) Hibernate, Mybatis etc..);
 
 - 프로그램에서 데이터에 영속성을 부여하는 계층을 Persistance Layer라고 일컫는다. 이렇게 프로그램 내에서 영속성을 부여하는 계층은 JDBC를 통하여 직접 구현할 수도 있지만, 상기 Persistance Framework*, 즉 프레임워크를 이용하여 개발하는 것이 더욱 빈번하다.
 
   - Persistance Framework? : JDBC를 이용하여 데이터에 영속성을 부여하는 환경을 마련하는 복잡함이나 번거로움 없이, 간단한 작업만으로 데이터베이스와 연동되는 시스템을 빠르게 개발할 수 있도록 도움을 주는 프레임워크.
   - Persistance Framework는 SQL MAPPER와 ORM**으로 나눌 수 있다.
 
 
---

 - 영속성의 내용과 같이, ORM은 영속성 프레임워크의 분류 중 하나이다. ORM이란, Object Relational Mappinng 이라는 뜻으로서, 객체와 관계형 데이터베이스의 데이터를 자동으로 매핑(연결)하여 주는 것을 일컫는 말이다.
   - 객체 지향 프로그래밍은 클래스를 사용하고, 이것과 상등하게 관계형 데이터베이스에서는 테이블을 사용한다.
   - 따라서 객체 모델과 관계형 모델간은 클래스-테이블 이라는 불일치가 존재한다.
   - 이에 따라 ORM을 통하여 객체 간의 관계를 바탕으로 SQL(Query)를 자동 생성하여 불일치를 해결하도록 돕는다.
 ---
 
 - ORM을 이용한 장점 및 단점
   -  장점
      - 객체지향적 코드로 직관적이다 : 가독성 및 생산성의 증가
      - 재사용 및 유지보수의 편리성 증가 : 객체들의 재활용이 가능하다.
      - DBMS에 대한 종속성이 줄어든다 : 대부분의 ORM솔루션이 DB에 종속적이지 않기 때문
    - 단점
      - ORM으로만 서비스를 구현하기 어렵다 : 복잡성이 가중될수록 ORM을 구추축하는 난이도가 급격히 상승한다.
      - 프로시저가 많은 시스템에선 객체지향적 장점을 활용하기 난해하다 : 객체가 많아진다면 그 자체로 리스크 및 생산성 저하가 발생될 우려가 높다.
 ---
---