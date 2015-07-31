<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${bookList}" var="book">
			<tr>
				<td><c:out value="${book.id}"></c:out></td>
				<td><c:out value="${book.title}"></c:out></td>
				<td><a href="deleteBook?id=${book.id}">Delete</a> | <a href="editBook?id=${book.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form action="http://localhost:8080/crud/addBook" method="post">
		<input type="text" name="title"> <input type="submit"
			value="Adauga carte">
	</form>
</body>
</html>