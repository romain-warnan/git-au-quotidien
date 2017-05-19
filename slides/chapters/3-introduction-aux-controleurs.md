<!-- .slide: data-background-image="images/spring.png" data-background-size="1200px" class="chapter" -->
## 3
### Introduction aux contrôleurs





<!-- .slide: class="slide" -->
### Généralités sur les contrôleurs
Stéréotype `@Controller`

Pas d’interface à implémenter ou de classe à étendre

Constructeur par défaut

Méthode de contrôleur `@RequestMapping`





<!-- .slide: class="slide" -->
### Un contrôleur typique

```java
@Controller // Stéréotype
@RequestMapping("/bar") // Namespace (début de l’URI, facultatif)
public class AccueilController { // Nom libre

     @Autowired
     private MessageService messageService; // Injection de dépendance

     @RequestMapping("/accueil") // Fin de l’URI
     public String accueil(Model model) { // Méthode de contrôleur (nom libre, arguments variables)
          model.addAttribute("message", messageService.message(…)); // Enrichissement du modèle
          return "accueil"; // Choix de la vue
     }
}
```

La méthode accueil() est exécuté
 - http://serveur:port/contextPath/bar/accueil
 - Les arguments de la méthodes sont injectés par Spring
 - Liste extensible d’arguments possibles
 




<!-- .slide: class="slide" -->
### Possibilités de mapping des requêtes

Cas simple :
```java
	@RequestMapping("/accueil")
```

Plusieurs URL vers la même méthode :
```java
	@RequestMapping({ "/accueil", "/" })
```

Préciser la méthode HTTP :
```java
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	@GetRequest – @PostRequest – @PutRequest …
```

Présence ou absence de paramètres
```java
	@RequestMapping(value = "/accueil", params = { "a=1", "b!=0", "!c", "d" })
```

Valeur de l’entête de la requête :
```java
	@RequestMapping(value = "/accueil", headers = "Accept=text/html")
```

---

<!-- .slide: class="slide" -->
Bonus : préciser le type de réponse :
```java
	@RequestMapping(value = "/accueil", produces = "application/json; charset=UTF-8")
```