<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="addBook" method="post" modelAttribute="book">
		<table>
			<tr>
				<td>Enter isbn</td>
				<td><form:input path="isbn" />
					<form:errors path="isbn" class="error" /></td>
			</tr>
			<tr>
				<td>Enter title</td>
				<td><form:input path="title" />
					<form:errors path="title" class="error" /></td>
			</tr>
			<tr>
				<td>Enter author</td>
				<td><form:input path="author" />
					<form:errors path="author" class="error" /></td>
			</tr>
			<tr>
				<td>Enter price</td>
				<td><form:input path="price" />
					<form:errors path="price" class="error" /></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>