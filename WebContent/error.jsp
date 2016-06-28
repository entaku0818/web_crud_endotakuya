<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="<html:rewrite page="/css/stylesheet.css"/>" type="text/css"/>
<script type="text/javascript" src="<html:rewrite page="/js/inputCheck.js"/>" ></script>

<title>社員管理システム</title>


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
						  		<h2>ログインエラー</h2>

			<!-- エラーメッセージの表示-->
				<div class="errorMessage">${SysDataDto.errorMessage}</div>
			<!-- エラーメッセージの表示-->
							<html:link page="/">ログイン画面へ戻る</html:link>

					</div>
			</div>
		<div id="footer">
		</div>
</div>

</body>
</html:html>