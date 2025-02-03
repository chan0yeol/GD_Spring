<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 체크</title>
</head>
<body>
	<!-- TODO 02202 @SessionAttributes에 담긴 값 확인 -->
	<fieldset>
		<legend>담겨있는 각 Session의 값을 출력</legend>
		<div>
			<h2>HttpSession : ${sessionScope.httpSessionTest}</h2>
			<h2>@SessionAttributes ${sessionScope.sessionTest}</h2>
		</div>
	</fieldset>
	
	<fieldset>
		<legend>@SessionAttributes를 생성한 Controller (Session_1_Controller)</legend>
		<ul>
			<li>
				<!-- TODO 02203 @SessionAttributes 삭제 -->
				<a href="./test01.do">test01.do @SessionAttributes 삭제</a>
				<button onclick="location.href='./result01.do'">결과 확인 result01.do </button>
			</li>
			<li>
				<!-- TODO 02301 Session의 삭제-->
				<a href="./test02.do">test02.do HttpSession 삭제</a>
				<button onclick="location.href='./result02.do'">결과 확인 result02.do</button>
			</li>
		</ul>
		<div>
			<!-- TODO 024 HttpSession과 @SessionAttributes의 차이 -->
			<pre>
				javax.servlet.http.HttpSession;
				  - HttpSession의 객체에 setAttribute("이름",값);
				org.springframework.web.bind.annotation.SessionAttributes;
				  - org.springframework.ui.Model 을 통해 model.addAttribute("이름",값); => HttpServletRequest이다.
				  	따라서 spring container의 session을 사용하기 위해서는 @SessionAttributes("이름") 사용하여 HttpSession에 담아주고
				  	사용할 때에는 @SessionAttribute(value="이름") String sessionValue 와 같이 바인딩하여 사용한다.
				  	
				  	 
				1)  호출 sessionScope를 통해서 호출은 같은 방법으로 한다 ex) ${sessionScope.SessionName}
				2)  삭제는 HttpSession의 삭제와 @SessionAttribute의 삭제는 다르다.
					HttpSession은 removeAttribute()를 통해서 삭제하거나 / invalidate()를 통해 session을 무효화 시킨다.
					HttpSession을 invalidate를 통해 무효화 하여도 @SessionAttributes는 영향을 받지 않는다.
					
					@SessionAttributes의 삭제는 SessionStatus 을 통해 setComplete() 를 사용하여 삭제함
					 -> session이 생성된 곳과 같은 Controller에서만 적용된다.
			</pre>
		</div>
	</fieldset>
	<fieldset>
		<legend>Session_2_Controller </legend>
		<ul>
			<!-- TODO 02502 다른 Controller에서 생성한 @SessionAttributes -->
			<li>
				<a href="./test03.do">test03.do @SessionAttributes 삭제</a>
				<button onclick="location.href='./result03.do'">결과 확인 result03.do</button>
			</li>
		</ul>
		
		<ul>
			<li>
				<!-- TODO 02600 다른 Controller에서의 Httpsession 삭제  -->
				<a href="./test04.do">test04.do @SessionAttributes 삭제</a>
				<button onclick="location.href='./result04.do'">결과 확인 result04.do</button>
			</li>
		</ul>
		<div>
			<pre> <!-- TODO 027 두 Session의 호출 방법 -->
				Session_1_Controller에서 생성한 HttpSession과 @SessionAttributes는 다른 Controller에서 사용이 가능하다.
					1) HttpSession session.getAttribute("이름") => down casting => 사용
					2)  @SessionAttribute(value="loginVo") UserVo loginVo => 다른 곳에서 생성한 @SessionAttributes를 이름으로 호출하고
						자동으로 Casting되어 바인딩 된다.
				삭제는 다른 Controller 일 경우
				  => @HttpSessionAttributes는 HttpSession과 같이 삭제된다.
				  	 따라서 @HttpSessionAttributes를 삭제하는 SessionStatus를 통해서 삭제할 수 없고
				  	 HttpSession의 삭제 방법인 invalidate() 혹은 removeAttribute를 통해 삭제해야한다.						
			</pre>
		</div>
	</fieldset>
</body>
</html>
