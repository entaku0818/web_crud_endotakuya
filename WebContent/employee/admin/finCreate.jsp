<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href=<html:rewrite page="/css/stylesheet.css"/> type="text/css"/>
 <script type="text/javascript" src="<html:rewrite page="/js/inputCheck.js"/>" ></script>

<title>社員管理システム</title>
</head>
<body>

<div id="contents">
		<div id="header">
			<h1>社員一覧表示画面</h1>


			<p>あなたのIDは${id}です</p>

								<html:form method="POST" action="/employee/change.do">
                     						 <html:submit property="method" value="登録">
                             					<bean:message key = "button.create"/>
                      						</html:submit>

               					</html:form>



								<!-- 登録ボタン-->
								<html:form styleClass="create" method="POST" action="/employee/change.do">
                     						 <html:submit property="method" value="登録">
                             					<bean:message key = "button.create"/>
                      						</html:submit>
               					</html:form>
               					<!-- 登録ボタン-->


								<!-- ログアウトボタン-->
               					<html:form styleClass="logout" method="POST" action="/logout.do" >
							    	<html:submit>ログアウト</html:submit>
							  	</html:form>
							  	<!-- ログアウトボタン-->


			<div id="menu">
			</div>
		</div>
			<div id="container">
					<div id="main">




			登録完了しました！！！！
				<html:form method="POST" action="/employee/change.do" >
						<html:submit property="method" >
                            <bean:message key="button.top" />
                    	</html:submit>
				</html:form>

					</div>
			</div>
		<div id="footer">
		</div>
</div>

</body>
</html>