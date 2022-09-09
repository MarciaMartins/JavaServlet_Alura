<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.alura.gerenciador.model.dto.CompanyResponse, java.util.List, java.io.IOException"%> 
<%
	List<CompanyResponse> listCompany = (List<CompanyResponse>) request.getAttribute("listCompany");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<p>Empresas cadastradas no sistema</p>
		<ul>
			<%for(CompanyResponse company: listCompany){%>
				<li><%=company.getName() %>.CNPJ - <%=company.getCnpj() %></li>
			<%}%>
		</ul>
	</body>
</html>

