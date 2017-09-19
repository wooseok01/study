WEB-INF와 webapp
=============

## WEB-INF란
1. WEB-INF란 Web-information의 약자로써 웹 어플리케이션에서 필요한 설정파일이나 클래스 파일, 라이브러리를 포함한 각종 리소스들을 관리하는 디렉토리 구조이다.

![Alt text](/resources/pic1.PNG)

2. maven에서 spring을 이용하여 배포하게 되는 경우에는 WEB-INF안에 maven에서 컴파일된 클래스 파일들과 라이브러리들 그리고 jsp 페이지들이 안에 내부 

이렇게 어플리케이션 내부에서 필요한 대부분의 정보를 WEB-INF 안에 저장하기 때문에 사용자는 WEB-INF 경로 아래의 파일을 직접 접근하게 되면 어플리케이션의 중요한 정보나 어플리케이션의 기본 경로를 알아내는 것이 가능하기 때문에 보안상의 목적을 이유로 servlet의 action을 통한 접근 이외에 외부의에서의 직접적인 접근은 막아두었다.
<http://www.jtmelton.com/2012/04/03/year-of-security-for-java-week-14-store-jsps-in-web-inf/>

웹 프로젝트를 진행하다 보면 WEB-INF 안에는 