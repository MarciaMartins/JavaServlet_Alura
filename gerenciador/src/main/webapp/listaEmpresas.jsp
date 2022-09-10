<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="br.com.alura.gerenciador.model.dto.CompanyResponse"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<p>Empresas cadastradas no sistema</p>
		<ul>
			<c:forEach items="${listCompany}" var="company">
				<li><p>${company.name}; CNPJ: ${company.cnpj};Dt.Inclusão: <fmt:formatDate value="${company.date}" pattern="dd/MM/yyyy"/></p>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>

