<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/static/css/application.css">
    <link rel="icon" type="image/png" href="/static/favicon.png" />
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="/static/js/recherche.js"></script>
    <title><tiles:getAsString name="title" /></title>
</head>
<body>
    <header id="header">
        <tiles:insertAttribute name="header" />
    </header>
    <section id="content">
        <tiles:insertAttribute name="body" />
    </section>
    <section id="footer">
        <tiles:insertAttribute name="footer" />
    </section>
</body>
</html>