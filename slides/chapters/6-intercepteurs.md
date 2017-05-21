<!-- .slide: data-background-image="images/spring.png" data-background-size="1200px" class="chapter" -->
## 6
### Intercepteurs





<!-- .slide: class="slide" -->
### Description d’un intercepteur
Classe implémentant l’interface `HandlerInterceptor`
 - appelée à chaque requête
 - ou pour un sous-groupe d’URL

On peut définir un ensemble ordonné d’intercepteur

```xml
<mvc:interceptors>
    <mvc:interceptor>
        <mvc:mapping path="/**"/>
        <bean class="x.y.z.SecuriteInterceptor" />
    </mvc:interceptor>
    <mvc:interceptor>
        <mvc:mapping path="/**"/>
        <mvc:exclude-mapping path="/healthcheck"/>
        <bean class="x.y.z.UtilisateurInterceptor" />
    </mvc:interceptor>
</mvc:interceptors>
```





<!-- .slide: class="slide" -->
<h3>Positionnement des intercepteurs</h3>
<div class="center">
    <img src="images/intercepteurs.png" style="width: 700px" />
</div>