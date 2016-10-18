<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="/static/css/application.css">
	</head>
	<body>
		<h1><c:out value="${message}" /></h1>
		<c:url var="url" value="clients" />
		<p><a href="${url}">Liste des clients</a></p>
	</body>
</html>