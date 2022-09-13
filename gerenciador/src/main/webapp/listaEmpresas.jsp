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
		<c:if test="${ not empty company }">
			<p>Empresa <i><b>${company}</i></b> cadastrada com sucesso.</p>
			<p>CNPJ - ${cnpj}</p>
		</c:if>
		<p>Empresas cadastradas no sistema</p>
		<ul>
			<c:forEach items="${listCompany}" var="company">
				<li><p>${company.name}; CNPJ: ${company.cnpj}; 
				Dt.Inclusão: <fmt:formatDate value="${company.date}" pattern="dd/MM/yyyy"/>
				<a href="/gerenciador/editarEmpresa?cnpj=${company.cnpj}"">editar</a>        
				<a href="/gerenciador/excluirEmpresa?cnpj=${company.cnpj}">    excluir</a></p>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>

