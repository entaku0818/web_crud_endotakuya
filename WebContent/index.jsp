<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="<html:rewrite page="/css/stylesheet.css"/>" type="text/css"/>
<script type="text/javascript" src="<html:rewrite page="/js/inputCheck.js"/>" ></script>

<title>ログイン画面</title>


</head>
<body>

<div id="contents">
		<div id="header">
			<h1>社員管理システム</h1>
			<div id="menu">

			</div>
		</div>


		<div id="container">
					<div id="main">
						  		<h2>ログイン画面</h2>
							  <html:form method="POST" action="/login.do" onsubmit="return loginCheck()">
							    ID: <html:text property="id" name="id" value="" />
				<!-- <html:errors property="id" /> -->
							    <div id="chkIdMsg"></div>


							    <br>
							    PASSWORD: <html:password property="password"  name="password" value=""/>

							   <!-- <html:errors property="password" /> -->
							   <div id="chkPasswordMsg"></div>

							    <br>
							    <html:submit>ログイン</html:submit>
							  </html:form>

					</div>
			</div>
		<div id="footer">
		</div>
</div>

</body>
</html:html>