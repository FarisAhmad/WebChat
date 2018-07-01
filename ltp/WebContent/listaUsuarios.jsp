<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="css/estilo.css" rel="stylesheet">
<body>

<form>
	<table >
		<tr>
			<th>Nome</th>
			<th>Data de Nascimento</th>
			<th>Login</th>
		</tr>

		<c:forEach var="user" items="${requestScope.listaUsers}">
			<tr>
				<td><c:out value="${user.nome}"></c:out></td>
				<td><c:out value="${user.dataNascimento}"></c:out></td>
				<td><c:out value="${user.login}"></c:out></td>
			</tr>
		</c:forEach>

	</table>
</form>
</body>
</html>