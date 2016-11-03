<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="/static/css/application.css">
		<title>Spring MVC &ndash; Client</title>
	</head>
	<body>
		<h1>Informations client</h1>
		<strong>Client n<sup>o</sup> ${client.id}</strong>
		<ul>
			<li><label>Titre :</label> ${client.titre.libelle}</li>
			<li><label>Nom :</label> ${client.nom}</li>
			<li><label>Email :</label> ${client.email}</li>
			<li><label>Date de naissance :</label> <fmt:formatDate value="${client.dateNaissance}" pattern="dd MMMM yyyy"/></li>
		</ul>
		<c:url var="url" value="/accueil" />
		<p><a href="${url}">Accueil</a> | <a href="<c:url value="/client/modification/${client.id}" />">Modifier client</a></p>
	</body>
</html>
