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
### Une autre vision de la page

<div class="center">
    <img src="images/html-3d.png" style="width: 400px" />
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

Définition du nouveau `viewResolver`

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

Le fichier `tiles.xml` contient la description de la structure des pages. 





<!-- .slide: class="slide" -->
### Définitions des Tiles

```xml
<tiles-definitions>  
   <definition name="default-layout" template="/WEB-INF/views/tiles/layout/defaultLayout.jsp">  
       <put-attribute name="title" value="" />  
       <put-attribute name="menu" value="/WEB-INF/views/tiles/template/defaultMenu.jsp" />  
       <put-attribute name="content" value="" />  
       <put-attribute name="footer" value="/WEB-INF/views/tiles/template/defaultFooter.jsp" />  
   </definition>  
  
   <!-- Page d’accueil -->
   <definition name="accueil" extends="default-layout">  
       <put-attribute name="title" value="Accueil" />  
       <put-attribute name="content" value="/WEB-INF/views/pages/accueil.jsp" />  
   </definition>  
       
   <!-- Page nous contacter -->
   <definition name="nous-contacter" extends="default-layout">  
       <put-attribute name="title" value="Nous contacter" />  
       <put-attribute name="content" value="/WEB-INF/views/pages/nous-contacter.jsp" />  
   </definition>  
</tiles-definitions>
```

Les pages héritent d’une structure de base
 - __template__ : nom de la JSP qui contient effectivement cette structure
 - pour définir une page : surcharger les zones pour lesquelles elle est spécialisée






<!-- .slide: class="slide" -->
### Exemple de structure de base

```html
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
### Fonctionnement des Tiles

Dans le contrôleur, on retourne le nom de la définition :
```java
@GetMapping("/accueil")
public String accueil(Model model) {
    …
    return "accueil";
}
```

```xml
<definition name="accueil" extends="…">
    <put-attribute name="attributeName" value="…" />
```

Il y a correspondance entre les balises `<put-attribute>` de tiles.xml et les instructions `<tiles:…>` dans la JSP :

```html
<tiles:insertAttribute name="attributeName" />
<tiles:getAsString name="attributeName" />
```

Les pages JSP ne contiennent que le code qui est différent des autres pages
 
Le code de présentation est découpé en parties homogènes





<!-- .slide: data-background-image="images/tp.png" data-background-size="500px" class="tp" -->
## [TP9](https://github.com/romain-warnan/formation-spring-mvc#9-tiles)