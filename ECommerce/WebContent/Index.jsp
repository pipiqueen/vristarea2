<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<select id=categoria onchange="changeCategory()">
		<option value="1">Clickee aqui para buscar por categoria</option>
		<c:if test="${not empty categories}">
			
			<c:forEach var="categoria" items="${categories}">
			
			
			<option value="${categoria.id}"> ${categoria.name} </option>
			
			</c:forEach>
		</c:if>

	</select>
	<script type="text/javascript">
		function changeCategory() {
			var x = document.getElementById("categoria").value;
			window.location.href = "Servlet?category=" + x;
		}
	</script>
	<c:if test="${not empty productos}">
		<table>

			<c:forEach var="producto" items="${productos}">

				<tr>

					<td>${producto.fotoUrl}</td>
					<td>${producto.name}</td>
					<td>${producto.price}</td>

				</tr>

			</c:forEach>
		</table>
	</c:if>

</body>
</html>