<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
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


						<div class="login-id">
							<p>あなたのIDは${id}です</p>
						</div>

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





		</div>
			<div id="container">
					<div id="main">



			<!-- 登録フォーム ↓-->
			<div class="change-contents">
				<html:form styleClass="changeForm" method="POST" action="/employee/admin/create.do" onsubmit="return changeCheck()">
					<div class="form-group">
		    			<span class="column">パスワード</span>
		    			<span class="value">
		    				<html:text styleId="empPass"  property="empPass" value=""/>
						</span>
						<div id="chkEmpPassMsg"></div>
					</div>

					<div class="form-group">
		    			<span class="column">社員名</span>
		    			<span class="value">
		    			<html:text styleId="empName"  property="empName" value=""/>
						</span>
	    				<div id="chkEmpNameMsg"></div>
	    			</div>
					<div class="form-group">
		    			<span class="column">性別</span>
		    			<span class="value">
		    				<input type="radio" id="gender" name="gender" value="1" checked="checked">男
			    			<input type="radio" id="gender" name="gender" value="2" >女
						</span>
	    			</div>
					<div class="form-group">
		    			<span class="column">住所</span>
		    			<span class="value">
		    				<html:text styleId="address" property="address" value=""/>
						</span>
	    				<div id="chkAddressMsg"></div>
	    			</div>
	    			<div class="form-group">
		    			<span class="column">生年月日</span>
						<span class="value">
		    			<input class="birthday" type="date" Id="birthday"  name="birthday" value="">
						</span>
	    				<div id="chkBirthdayMsg"></div>
	    			</div>

	    			<div class="form-group">
		    			<span class="column">権限</span>
		    			<span class="value">
			    			<input type="radio" id="authority" name="authority" value="1" checked="checked">管理者
				    		<input type="radio" id="authority" name="authority" value="2" >一般
						</span>
	    			</div>

	    			<div class="form-group">
		    			<span class="column">部署ID</span>
		    			<span class="value">
		    				<html:select property="deptId" >
	    						<html:options collection="selectDeptDto" property="deptId" labelProperty="deptName"/>
							</html:select>
						</span>
	    			</div>




					<html:submit property="method">
                            <bean:message key="button.create.check" />
                    </html:submit>


				</html:form>

				<html:form method="POST" action="/employee/change.do" >
						<html:submit property="method" >
                            <bean:message key="button.top" />
                    	</html:submit>
				</html:form>
			</div>
			<!-- 登録フォーム ↑-->


					</div>
			</div>
		<div id="footer">
		</div>
</div>


</body>
</html>