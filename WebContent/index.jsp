<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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

			<img class="icon" src="./img/employee.jpg">

		</div>


		<div id="container">
					<div id="main">



						  		<h2>ログイン画面</h2>


					<!-- ログインフォームの表示-->
			<div class="login-contents">
					<html:form styleClass="loginForm" method="POST" action="/login.do" onsubmit="return loginCheck()">

					<div class="form-group">
		    			<label class="column">ID:</label>
		    			<html:text styleId="empName"  property="id" name="id" value="" />

	    				<div class="errorMessage"  id="chkIdMsg"></div>
	    			</div>

					<div class="form-group">
		    			<label class="column">PASSWORD:</label>
		    			<html:password property="password"  name="password" value=""/>

	    				<div class="errorMessage" id="chkPasswordMsg"></div>
	    			</div>


					<div class="submit"><html:submit>ログイン</html:submit></div>
					</html:form>
			</div>

					<!-- ログインフォームの表示-->

					</div>
			</div>
		<div id="footer">
		</div>
</div>

</body>
</html:html>