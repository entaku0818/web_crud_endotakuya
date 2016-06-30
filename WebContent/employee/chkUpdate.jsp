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
			<h1>社員更新画面</h1>



						<div class="login-id">
							<p>あなたのIDは${id}です</p>
						</div>

								<!-- 登録ボタン-->
								<html:form styleClass="create" method="POST" action="/employee/change.do">
                     						 <html:submit property="method" value="登録">
                             					<bean:message key = "button.create.check"/>
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




			<!-- 変更内容Check ↓-->
			<div class="change-message">以下の内容で更新します。</div>
			<div class="change-contents">

				<html:form styleClass="changeForm" method="POST" action="/employee/update.do" onsubmit="return changeCheck()">
					<div class="form-group">
		    			<span class="column">パスワード: </span>
		    			<span class="value">
		    			${userEmpDto.empPass}
						</span>
						<div id="chkEmpPassMsg"></div>
					</div>

					<div class="form-group">
		    			<span class="column">社員名:</span>
		    			<span class="value">
		    			${userEmpDto.empName}
						</span>
	    				<div id="chkEmpNameMsg"></div>
	    			</div>
					<div class="form-group">
		    			<span class="column">性別</span>
		    			<span class="value">
		    			 ${userEmpDto.genderName}
						</span>
	    			</div>
					<div class="form-group">
		    			<span class="column">住所</span>
		    			<span class="value">
		    				${userEmpDto.address}
						</span>
	    				<div id="chkAddressMsg"></div>
	    			</div>
	    			<div class="form-group">
		    			<span class="column">生年月日</span>
						<span class="value">
		    			${userEmpDto.birthday}
						</span>
	    				<div id="chkBirthdayMsg"></div>
	    			</div>

	    			<div class="form-group">
		    			<span class="column">権限</span>
		    			<span class="value">
			    			${userEmpDto.authorityName}
						</span>
	    			</div>

	    			<div class="form-group">
		    			<span class="column">部署ID</span>
		    			<span class="value">
		    				${userEmpDto.deptName}
						</span>
	    			</div>
			<!-- 変更内容Check ↓-->




                   <html:submit property="method" value='OK'>
                            <bean:message key="button.finish"/>
                    </html:submit>


				</html:form>

				<html:form method="POST" action="/employee/change.do" >
						<html:submit property="method" >
                            <bean:message key="button.top" />
                    	</html:submit>
				</html:form>
			</div>

			<!-- 登録内容Check ↑-->



					</div>
			</div>
		<div id="footer">
		</div>
</div>


</body>
</html>