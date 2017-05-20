<!-- .slide: data-background-image="images/spring.png" data-background-size="1200px" class="chapter" -->
## 5
### JSP : Java server pages





<!-- .slide: class="slide" -->
### Accéder aux objets du modèle dans les JSP
EL : Expression language

`${personne.nom}`
```java
((Personne)request.getAttribute("personne")).getNom()
```

`${sessionScope.personne.nom}`
```java
((Personne)session.getAttribute("personne")).getNom()
```

`${liste[0]}`
```java
list.get(0)
```

`${map["nom"]}`
```java
map.get("nom")
```





<!-- .slide: class="slide" -->
### Accéder aux objets du modèle dans les JSP
EL : Expression language

`${empty personnes}`
```java
CollectionUtils.isEmpty(personnes)
```

`${not empty personnes}`
```java
CollectionUtils.isNotEmpty(personnes)
```

`${empty personne.nom}`
```java
StringUtils.isEmpty(personne.getNom())
```

`${not empty personne.nom}`
```java
StringUtils.isNotEmpty(personne.getNom())
```





<!-- .slide: class="slide" -->
### JSTL : JSP Standard Tag Library
```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```



```jsp

<c:set var="nom" value="${personne.nom}"
<c:set var="nom">Valeur</c:set>

(vide)
```
 
```jsp
<c:url var="url" value="/accueil" />
<a href="${url}">Lien</a>
<a href="<c:url value="/accueil" />">Lien</a>

<a href="contextPath/accueil">Lien</a>
```
 
```jsp
<c:out value="${personne.nom}" />

Nom
```
 
```jsp
<c:out value="${personne.nom}" default="Inconnu" />

Nom / Inconnu
```




<!-- .slide: class="slide" -->
### Structures de contrôle
```jsp
<c:if test="${empty personne.nom}">Inconnu</c:if>

(vide) / Inconnu
```

```jsp
<c:forEach items="${personnes}" var="personne">
    ${personne.nom}<br/>
</c:forEach>

Nom0
Nom1
Nom2
```

```jsp
<c:choose>
    <c:when test="${personne.titre == 'M.'}">
        Bonjour Monsieur
    </c:when>
    <c:when test="${personne.titre == 'Mme'}">
        Bonjour Madame
    </c:when>
    <c:otherwise>
        Bonjour
    </c:otherwise>
</c:choose>

Bonjour Monsieur / Bonjour Madame / Bonjour
```





<!-- .slide: class="slide" -->
### Formattage et internationalistation (i18n) 
JSTL : JSP Standard Tag Library
```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

```jsp
<fmt:bundle basename="message">
    <fmt:message key="a.b.bonjour" />
</fmt:bundle>

Bonjour / ???a.b.bonjour???
Hello / ???a.b.bonjour???
```

```jsp
<fmt:formatNumber value="${1234.5}" minIntegerDigits="1" minFractionDigits="2" />

1 234,50 
1,234.50
```

```jsp
<fmt:formatDate value="${date}" pattern="dd/mmmm/YYYY"/>

31 avril 2015
31 April 2015
```

```jsp
<fmt:formatDate value="${date}" dateStyle="short"/>

31/04/15
4/31/15
```





<!-- .slide: data-background-image="images/tp.png" data-background-size="500px" class="tp" -->
## [TP2](https://github.com/Insee-CNIP/formation-spring-mvc#21-liste-de-tous-les-clients) 