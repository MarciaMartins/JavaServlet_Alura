<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<c:url value="/armazenaEmpresaAlterada" var="servletAlteraEmpresa"/>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>teste</p>
	<form action="${servletAlteraEmpresa }" method="post">
		<p><label>Name</label> <input type="text" name="name" value="${company.name}" /></p>
		<p><label>CNPJ</label> <input type="text" name="cnpj" value="${company.cnpj}"/></p>
		<p><label>Data Inclusão</label> <input type="date" name="date" value="${company.date}"/></p>
		<p><input type="submit"></p>
	</form>
</body>
</html>