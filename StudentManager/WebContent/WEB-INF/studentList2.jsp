<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>学生一覧画面</title>
<script type="text/javascript">
	function doCheck() {

		var name = document.getElementById("name").value.trim();
		var birthday = document.getElementById("birthday").value.trim();
		var age = document.getElementById("age").value.trim();
		var successFlag = checkIsNotNull(name);
		if (successFlag) {
			successFlag = checkLengthLessThan(name, 15);

		}

		if (birthday != null && birthday.length > 0) {
			C = checkDate(birthday);
		}

		if (age != null&& age.length > 0) {
			successFlag = checkNum(age);
		}

		if (successFlag) {
			alert("入力内容が全部ただしい:[" + name + "]");
		}

	}
	function getValue(object) {
		var value = "";
		if (object || object == null) {
			return object.value.trim();
		}

			return value;
	}



	function checkIsNotNull(str) {

		var successFlag = true;
		if (str == null || str.length == 0) {
			successFlag = false;
			alert("入力必要です.");
		}
		return successFlag;

	}

	function checkLengthLessThan(str, maxlength) {

		var successFlag = true;
		if (str.length > maxlength) {
			successFlag = false;
			alert("入力項目のサイズ超")
		}
		return successFlag;
	}

	function checkDate(dateStr) {

		var re = new RegExp(/^((?!0000)[0-9]{4}-((0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-8])|(0[13-9]|1[0-2])-(29|30)|(0[13578]|1[02])-31)|([0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00)-02-29)$/);

		var successFlag = dateStr.match(re);
		if (!successFlag) {
			alert("入力形式不正です");
		}
		return successFlag;
	}

	function checkNum(num) {
		var re = new RegExp(/^((1[0-5])|[1-9])?\d$/);

		var successFlag = num.match(re);
		if (!successFlag) {
			alert("形式不正です")
		}
		return successFlag;
	}
</script>
</head>
<body>

	<DIV>
		<table id="items">
			<tr>
				<td>id</td>
				<td>姓名</td>
				<td>出生年月</td>
				<td>年龄</td>
				<td>分数</td>
			</tr>
<!-- item属性中，引号内是EL表达式，表达式结构为${},大括号内的名称，是与控制层中model方法的第一个参数对应 -->
			<c:forEach items="${student2EntityList}" var="student">
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

	<DIV>
		<Label>名前：    </Label><INPUT type="text" id="name" name="name"><br>
		<br>
	   	<Label>生年月日：</Label><INPUT type="text"id="birthday" name="birthday">

	   	 <Label>nianling：</Label><INPUT type="text"id="age" name="age">
	  	<INPUT type="button"value="登録" onClick="doCheck()">



	</DIV>
</body>
</html>