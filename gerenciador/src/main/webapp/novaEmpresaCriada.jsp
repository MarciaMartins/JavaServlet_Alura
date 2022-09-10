<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
	<c:if test="${ empty company }">
		<p>Nenhuma empresa cadastrada.</p>
	</c:if>
	
</body>
</html>


						