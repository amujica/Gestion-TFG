<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Professor View</title>
</head>
<body>
<shiro:user>
    Welcome back <shiro:principal />! Click <a href="LogoutServlet">here</a> to logout.
</shiro:user>
<hr>
	<h2>Vista del profesor</h2>
			 
		<h3>Aquí tiene su información</h3>
		
		<table border="1">
			<tr>
				<th>Nombre</th>
				<th>Email</th>
				<th>TFGs</th>
			</tr>
			
				<tr>
					<td>${professor.name }</td>
					<td>${professor.email }</td>
					<td>${fn:length(professor.advisedTFGs) }</td>
				</tr>
			
		</table>
		 
		<h3>Listado de tfgs</h3>
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
			<c:forEach items="${professor.advisedTFGs}" var="advisedTFG">
				<tr>
					<td>${advisedTFG.title }</td>
					<td>${advisedTFG.email }</td>
					<td>${advisedTFG.name }</td>
					<td>${advisedTFG.advisor.email }</td>
					<td>${advisedTFG.advisor.name }</td>
					<td>${advisedTFG.status }</td>
					<td><c:if test="${advisedTFG.status > 3}">
							<form action="ServeFileServlet">
								<input type="hidden" name="email" value="${advisedTFG.email}" />
								<button type="submit">Descargar</button>
							</form>
						</c:if></td>
					<td><c:if test="${advisedTFG.status == 1}">
							<form action="Form2ProfessorServlet" method="post">
								<input type="hidden" name="email" value="${advisedTFG.email}" />
								<button type="submit">Aceptar tfg</button>
							</form>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
		

</body>
</html>