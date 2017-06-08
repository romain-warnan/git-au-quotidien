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





<!-- .slide: class="slide" -->
### Les méthodes d’un intercepteurs

```java
boolean preHandle(
    HttpServletRequest request,
    HttpServletResponse response,
    Object handler) 

void postHandle(HttpServletRequest request,
    HttpServletResponse response,
    Object handler,
    ModelAndView mav) 

void afterCompletion(HttpServletRequest request,
    HttpServletResponse response,
    Object handler,
    Exception e)
```





<!-- .slide: class="slide" -->
### Exemple d’intercepteur

Seule la méthode postHandle() a accès au modèle
 - `preHandle()` : le modèle n’existe pas encore
 - `afterCompletion()` : la vue est déjà générée

La méthode preHandle() permet d’interrompre la chaîne d’appel
  - on peut ne même pas passer dans le contrôleur
    - `true` : la chaîne d’appel se poursuit
    - `false` : la chaîne s’arrête et la réponse est retournée

Chaque méthode a accès à la réponse
 - on peut retourner un code d’erreur ou autre

Attention : les intercepteurs sont des singletons
 - passer par la requête ou éventuellement la session pour stocker des valeurs





<!-- .slide: class="slide" -->

```java
@Component
public class UtilisateurInterceptor extends HandlerInterceptorAdapter implements HandlerInterceptor {

    @Autowired
    private AnnuaireService annuaireService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        HttpSession session = request.getSession(true);
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur == null) {
            utilisateur = annuaireService.utilisateur(request.getUserPrincipal().getName());
            session.setAttribute("utilisateur", utilisateur);
        }
        return true;
    }
}
```





<!-- .slide: data-background-image="images/tp.png" data-background-size="500px" class="tp" -->
## [TP3](https://github.com/romain-warnan/formation-spring-mvc#3-intercepteurs)