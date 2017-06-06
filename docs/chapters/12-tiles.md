<!-- .slide: data-background-image="images/spring.png" data-background-size="1200px" class="chapter" -->
## 12
### Introduction à Tiles






<!-- .slide: class="slide" -->
### Mutualiser la mise en page

Les pages d’une application se ressemblent entre elles

Tiles : « tuile, carreau »

<div class="center">
    <img src="images/tiles.png" style="width: 400px" />
</div>






<!-- .slide: class="slide" -->
### Installation

Dépendances Maven

```xml
<dependency>
    <groupId>org.apache.tiles</groupId>
    <artifactId>tiles-extras</artifactId>
    <version>${tiles.version}</version>
</dependency>
```

Définition du nouveau viewResolver

```xml
<bean id="viewResolver" class="org.springframework.web.servlet.view.tiles3.TilesViewResolver"/>
<bean id="tilesConfigurer" class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
    <property name="definitions">
        <list>
            <value>/WEB-INF/views/tiles.xml</value>
        </list>
    </property>
</bean>
```

Le fichier tiles.xml contient les descriptions des structures des pages. 





<!-- .slide: class="slide" -->
```xml
<tiles-definitions>  
   <definition name="default-layout" template="/WEB-INF/views/tiles/layout/defaultLayout.jsp">  
       <put-attribute name="title" value="" />  
       <put-attribute name="header" value="/WEB-INF/views/tiles/template/defaultHeader.jsp" />
       <put-attribute name="menu" value="/WEB-INF/views/tiles/template/defaultMenu.jsp" />  
       <put-attribute name="content" value="" />  
       <put-attribute name="footer" value="/WEB-INF/views/tiles/template/defaultFooter.jsp" />  
   </definition>  
  
   <!-- Page d’accueil -->
   <definition name="home" extends="default-layout">  
       <put-attribute name="title" value="Accueil" />  
       <put-attribute name="content" value="/WEB-INF/views/pages/accueil.jsp" />  
   </definition>  
       
   <!-- Page nous contacter -->
   <definition name="contactus" extends="default-layout">  
       <put-attribute name="title" value="Nous contacter" />  
       <put-attribute name="content" value="/WEB-INF/views/pages/nous-contacter.jsp" />  
   </definition>  
</tiles-definitions>
```

Les pages héritent d’une structure de base
 - `template` : nom de la JSP qui contient effectivement cette structure
 - pour définir une page : surcharger les zones pour lesquelles elle est spécialisée






<!-- .slide: class="slide" -->
### Exemple de structure de base

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/static/css/style.css">
    <script src="https://code.jquery.com/jquery.min.js"></script>
    <title><tiles:getAsString name="title" /></title>
</head>
<body>
    <header id="header">
        <tiles:insertAttribute name="header" />
    </header> 
    <header id="menu">
        <tiles:insertAttribute name="menu" />
    </header>
    <section id="content">
        <tiles:insertAttribute name="content" />
    </section>
    <section id="footer">
        <tiles:insertAttribute name="footer" />
    </section>
</body>
</html>
```






<!-- .slide: class="slide" -->
### Fonctionnement de tiles

Il y a correspondance entre les instruction de tiles.xml et les instruction dans la JSP :
```xml
<put-attribute name="attributeName" value="…" />
```

```jsp
<tiles:insertAttribute name="attributeName" />
<tiles:getAsString name="attributeName" />
```


<!-- .slide: data-background-image="images/tp.png" data-background-size="500px" class="tp" -->
## [TP9](https://github.com/Insee-CNIP/formation-spring-mvc#9-tiles)