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


			<p>あなたのIDは${id}です</p>

			<html:link action="/logout">
                     ログアウト
            </html:link>



			<div id="menu">
			</div>
		</div>
			<div id="container">
					<div id="main">



			<!-- 変更フォーム ↓-->
				<html:form method="POST" action="/update.do" onsubmit="return changeCheck()">
					<p>
		    			<html:hidden property="empId" value="${userEmpDto.empId}"/>

	    			</p>
					<p>
		    			パスワード
		    			<html:text property="empPass" value="${userEmpDto.empPass}"/>

	    			</p>

					<p>
		    			社員名
		    			<html:text property="empName" value=" ${userEmpDto.empName}"/>
	    			</p>
					<p>
		    			性別
		    				<input type="radio" id="gender" name="gender" value="1"
		    					<c:if test="${userEmpDto.gender==1}" >checked</c:if>
		    				>男
			    			<input type="radio" id="gender" name="gender" value="2"
			    			<c:if test="${userEmpDto.gender==2}" >checked</c:if>
			    			>女
	    			</p>
					<p>
		    			住所
		    			<html:text property="address" value="${userEmpDto.address}"/>
	    			</p>
	    			<p>
		    			生年月日
		    			<input type="text" name="birthday" value="${userEmpDto.birthday}">
	    			</p>
	    			<p>
		    			権限
		    				<input type="radio" id="authority" name="authority" value="1"
			    				<c:if test="${userEmpDto.authority==1}" >checked</c:if>

		    				>一般
			    			<input type="radio" id="authority" name="authority" value="2"
			    				<c:if test="${userEmpDto.authority==2}" >checked</c:if>
							>管理者
	    			</p>
	    			<p>
		    			部署ID
		    				${userEmpDto.deptId}
		    				<html:select property="deptId" >
	    					<html:options collection="selectDeptDto" property="deptId" labelProperty="deptName"/>
					</html:select>
	    			</p>


					<html:submit property="method"  value="更新">
                            <bean:message key="button.check" />
                    </html:submit>


				</html:form>
			<!-- 変更フォーム ↑-->


					</div>
			</div>
		<div id="footer">
		</div>
</div>


</body>
</html>