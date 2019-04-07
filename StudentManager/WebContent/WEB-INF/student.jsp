<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>学员管理</title>
<link rel="stylesheet" type="text/css" href="./css/student.css"/>
<style type="text/css">
</style>
</head>
<body>
	<DIV>
		<table id="items" >
	<tr>
		<td>id</td>
		<td>姓名</td>
		<td>出生年月</td>
		<td>年龄</td>
		<td>分数</td>
	</tr>

    <c:forEach items="${studentFormList}" var="student" >
	    <tr>
			<td id="id${student.id }">${student.id}</td>
			<td id="name${student.id }">${student.name}</td>
			<td id="birthday${student.id}">${student.birthday}</td>
			<td id="age${student.id }">${student.age}</td>
			<td id="score${student.id}">${student.score}</td>
		 </tr>
	 </c:forEach>
  </table>
	</DIV>
</body>
</html>