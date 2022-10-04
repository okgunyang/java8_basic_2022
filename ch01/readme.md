# compile-on-terminal

## cmd에서 java compile 및 execute (Windows 10 기준)

## 환경설정

cmd에서 java를 사용하기 위해서는 환경변수 설정이 기본이다. `제어판 - 시스템 및 보안 - 시스템 - 고급 시스템 설정 - 고급 - 환경변수`에 들어간다.

* `시스템 변수 - 새 환경변수`에 이름은 `JAVA_HOME`, 값은 `jdk 경로`.  
* `시스템 변수 - path`에 `%JAVA_HOME%\bin`를 추가.  
* `CLASS_PATH`를 설정하는 경우도 있으나 여기서는 생략한다.  

경로 설정을 알아서 잘 한다는 가정 하에, 예시는 다음과 같다.

```java
(프로젝트 폴더) ┬─ bin(클래스를 관리하는 폴더)
               │
               └─ src(소스파일을 관리하는 폴더)
                   │
                   └─ test(패키지)
                       │
                       └─ A.java

(경로): (프로젝트 폴더)로 설정

(소스 파일 이름.확장자): A.java
```
<!-- 아니 상자만들기 문자 왜 삐꾸나지? -->

## 1. 명령 프롬프트 창에서 cd(Change Directory) 명령어를 통해 경로를 지정

>
```java
(알 수 없음)>cd (프로젝트 폴더의 경로)

(프로젝트 폴더의 경로)>
```

## 2. 작성한 소스 파일을 컴파일

```java
(프로젝트 폴더의 경로)> javac -d bin -sourcepath src src\test\A.java -encoding UTF8
```

```java
문법 : javac -d <classpath> -sourcepath <ref-path> <source>

         javac : 자바 컴파일 명령어.
-d <classpath> : 클래스가 생성될 위치.
   -sourcepath : 참조할 클래스가 있을 경우 그 클래스 위치를 참조시켜 주어야 한다.
    <ref-path> : 참조할 클래스의 최상위 패키지 위치.
                상세한 위치까지 알려줄 필요는 없다.
      <source> : 소스 파일 이름과 확장자.

이제 알아서 bin에 패키지 폴더까지 생성하면서 컴파일 된다.

-encoding UTF8 : 소스 파일에 한글이 들어갈 경우 이 명령어를
                마지막에 추가하여 컴파일 한다.
            .\ : '.'은 현재 경로를 의미한다.
             \ : \(이스케이프)는 해당 경로에서의 하위 구분자
           ..\ : 상위 경로.
```

## 3. 컴파일 한 A.class 파일 실행

```java
(프로젝트 폴더의 경로)> java -classpath bin test.A
또는
(프로젝트 폴더의 경로)> java -cp bin test.A
```

```java
문법 : java -classpath <path> <package.class>

             java : 자바 실행 명령어
-classpath <path> : 클래스의 위치이나 사실상 최상위 패키지의 위치(bin)이다.
                   또한 -classpath 대신 -cp로 줄여서 사용 가능하다.
  <package.class> : 최상위 패키지부터 하위 패키지 구분은 '.'을 넣어
                   클래스의 이름까지 적는다.
```