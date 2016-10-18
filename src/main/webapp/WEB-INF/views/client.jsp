<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="/static/css/application.css">
	</head>
	<body>
		<h1>Informations client</h1>
		<strong>Client n<sup>o</sup> ${client.id}</strong>
		<ul>
			<li><label>Nom :</label> ${client.nom}</li>
			<li><label>Email :</label> ${client.email}</li>
			<li><label>Date de naissance :</label> <fmt:formatDate value="${client.dateNaissance}" pattern="dd MMMM yyyy"/></li>
		</ul>
		<c:url var="url" value="/accueil" />
		<p><a href="${url}">Accueil</a></p>
	</body>
</html>
