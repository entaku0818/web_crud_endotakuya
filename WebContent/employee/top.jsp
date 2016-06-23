<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<html:rewrite page="/css/stylesheet.css"/>" type="text/css"/>
<script type="text/javascript" src="<html:rewrite page="/js/inputCheck.js"/>" ></script>


<title>社員管理システム</title>
</head>
<body>

<div id="contents">
		<div id="header">
			<h1>社員一覧表示画面</h1>
			<img src="<html:rewrite page="/img/employee.jpg"">

			<p>あなたのIDは${id}です</p>

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

			<!-- エラーメッセージの表示-->
				${errorMessage}
			<!-- エラーメッセージの表示-->

			<!-- 検索フォーム ↓-->
				<html:form styleClass="find" method="POST" action="/employee/find.do" onsubmit="return findCheck()">

	  				<input type="radio" id="empId" name="findColumn" value="empId" checked="checked" >社員ID
	  				<input type="text" id="findId" name="findId" value="">

	    			<input type="radio" id="empName" name="findColumn" value="empName"  >社員名
	    			<input type="text" id="findName" name="findName" value="" >


	    			<input type="radio" id="deptName" name="findColumn" value="deptName" >部署名
	    			<html:select property="findDeptId" >
	    					<html:options collection="selectDeptDto" property="deptId" labelProperty="deptName"/>
					</html:select>
					<html:submit>検索</html:submit>
					<div id="chkFindMsg"></div>

				</html:form>
			<!-- 検索フォーム ↑-->


			<!-- 検索結果 ↓-->
				<c:if test="${!getTopDataFlag}" >
					<table class="empTable">
							<tbody>
							<tr>
							<th>社員ID</th>
							<th>社員名</th>
							<th>性別</th>
							<th>住所</th>
							<th>生年月日</th>
							<th>権限</th>
							<th>部署名</th>
							<th colspan="2">操作</th>
							</tr>
					<c:forEach var="emp" items="${userEmpDto}">
							<tr>
							<td>${emp.empId}</td>
							<td>${emp.empName}</td>
							<td>${emp.genderName}</td>
							<td>${emp.address}</td>
							<td>${emp.birthday}</td>
							<td>${emp.authorityName}</td>
							<td>${emp.deptName}</td>
							<td>
								 <html:form method="POST" action="/employee/change.do">
								 			<input type="hidden" name="findId" value="${emp.empId}">
                     						 <html:submit property="method">
                             					<bean:message key="button.update"/>
                      						</html:submit>
               					</html:form>
							</td>
							<td>
								<html:form method="POST" action="/employee/change.do">
								 			<input type="hidden" name="findId" value="${emp.empId}">
                     						 <html:submit property="method">
                     						 	<bean:message key="button.delete"/>
                      						</html:submit>
               					</html:form>
							</td>
							</tr>
					</c:forEach>
							</tbody>
							</table>

				</c:if>
				<c:if test="${getTopDataFlag}" >
					<p>該当する社員は存在しませんでした</p>

				</c:if>
			<!-- 検索結果 ↑-->




				<html:form styleClass="top" method="POST" action="/employee/change.do" >
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