<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TFG View</title>
</head>
<body>
<shiro:user>
    Welcome back <shiro:principal />! Click <a href="LogoutServlet">here</a> to logout.
</shiro:user>
<hr>
	<h2>Vista de TFG</h2>
	
	
		 
		<h3>Listado de tu TFG</h3>
		<table border="1">
			<tr>
				<th>Título</th>
				<th>Email alumno</th>
				<th>Nombre del alumno</th>
				<th>Email tutor</th>
				<th>Nombre del tutor</th>
				<th>Estado del TFG</th>
				<th>Memoria</th>
				<th>Acción requerida</th>
			</tr>
	
				<tr>
					<td>${email.title} </td>
					<td>${email.email }</td>
					<td>${email.name }</td>
					<td>${email.advisor.email }</td>
					<td>${email.advisor.name }</td>
					<td>${email.status }</td>
					<td><c:if test="${email.status > 3}">
							<form action="ServeFileServlet">
								<input type="hidden" name="email" value="${email.email}" />
								<button type="submit">Descargar</button>
							</form>
						</c:if></td>
					<td><c:if test="${email.status == 2}">
							<form action="Form3SecretaryServlet" method="post">
								<input type="hidden" name="email" value="${email.email}" />
								<button type="submit">Aceptar tfg</button>
							</form>
						</c:if></td>
				</tr>
			
		</table>


</body>
</html>