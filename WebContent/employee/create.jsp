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
			<h1>社員登録画面</h1>


			<p>あなたのIDは${id}です</p>

			<html:link action="/logout">
                     ログアウト
            </html:link>



			<div id="menu">
			</div>
		</div>
			<div id="container">
					<div id="main">



			<!-- 登録フォーム ↓-->
				<html:form method="POST" action="/create.do" onsubmit="return changeCheck()">
					<p>
		    			パスワード
		    			<html:text property="empPass" value=""/>

	    			</p>

					<p>
		    			社員名
		    			<html:text property="empName" value=""/>
	    			</p>
					<p>
		    			性別
		    				<input type="radio" id="gender" name="gender" value="1" checked="checked">男
			    			<input type="radio" id="gender" name="gender" value="2" >女
	    			</p>
					<p>
		    			住所
		    			<html:text property="address" value=""/>
	    			</p>
	    			<p>
		    			生年月日
		    			<input type="text" name="birthday" value="">
	    			</p>
	    			<p>
		    			権限
		    				<input type="radio" id="authority" name="authority" value="1" checked="checked">管理者
			    			<input type="radio" id="authority" name="authority" value="2" >一般
	    			</p>
	    			<p>
		    			部署ID
		    				<html:select property="deptId" >
	    						<html:options collection="selectDeptDto" property="deptId" labelProperty="deptName"/>
							</html:select>
	    			</p>


					<html:submit property="method">
                            <bean:message key="button.check" />
                    </html:submit>


				</html:form>

				<html:form method="POST" action="/create.do" >
						<html:submit property="method" >
                            <bean:message key="button.top" />
                    	</html:submit>
				</html:form>

			<!-- 登録フォーム ↑-->


					</div>
			</div>
		<div id="footer">
		</div>
</div>


</body>
</html>