<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	String company = (String) request.getAttribute("company");
	String cnpj = (String) request.getAttribute("cnpj");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Empresa <i><b><%= company %></i></b> cadastrada com sucesso.</p>
	<p>CNPJ - <%=cnpj %></p>
</body>
</html>


						