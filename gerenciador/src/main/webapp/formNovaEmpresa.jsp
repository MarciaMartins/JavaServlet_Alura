<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<c:url value="/novaEmpresa" var="servletNovaEmpresa"/>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${servletNovaEmpresa }" method="post">
		<p><label>Name</label> <input type="text" name="name"/></p>
		<p><label>CNPJ</label> <input type="text" name="cnpj"/></p>
		<p><input type="submit"></p>
	</form>
</body>
</html>