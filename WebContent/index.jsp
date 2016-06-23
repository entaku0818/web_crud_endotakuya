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
					<html:form method="POST" action="/login.do" onsubmit="return loginCheck()">

					<div class="form-group">
		    			<label class="column">ID:</label>
		    			<html:text styleId="empName"  property="id" name="id" value="" />

	    				<div id="chkIdMsg"></div>
	    			</div>

					<div class="form-group">
		    			<label class="column">PASSWORD:</label>
		    			<html:password property="password"  name="password" value=""/>

	    				<div id="chkPasswordMsg"></div>
	    			</div>


							    <br>
							    <html:submit>ログイン</html:submit>
							  </html:form>
					<!-- ログインフォームの表示-->

					</div>
			</div>
		<div id="footer">
		</div>
</div>

</body>
</html:html>