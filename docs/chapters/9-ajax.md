<!-- .slide: data-background-image="images/spring.png" data-background-size="1200px" class="chapter" -->
## 8
### Ajax





<!-- .slide: class="slide" -->
### Rappels sur Ajax

Appel serveur depuis le Javascript

Asynchrone
 - Callback lorsque la réponse est arrivée
  - `done(function(){…})` — `success`
  - `fail(function(){…})` — `error`
  - `always(function(){…})` — `complete`

Envoyer et recevoir des objets JavaScript

Pas de rechargement de la page
 - notion d’application single page

Facile à utiliser avec jQuery (ou avec fecth, ou encore superagent)
 - `$.ajax(), $.get(), $.post(), $(…).load()`





<!-- .slide: class="slide" -->
### Spring MVC et Ajax

Un contrôleur peut recevoir et retourner des objets JSON

La conversion JAVA &hArr; JSON est automatique
 - il suffit qu’il existe une librairie capable de la réaliser dans le classpath
 - Jackson par exemple

Renvoyer un objet dans le corps de la réponse 
 - &ne; vers une JSP comme d’habitude
 - `@ResponseBody`

Récupérer un objet présent dans le corps de la requête
 - &ne; dans l’URL ou posté par un formulaire
 - `@RequestBody`





<!-- .slide: class="slide" -->
### Appel Ajax avec jQuery – GET

```javascript
$.ajax({
    url: '/path/resource',
    method: 'GET',
    data: {
        'p1': encodeURI('Ma chaîne'),
        'p2': 123456
    }
})
.done(function(data, textStatus, xhr) {
    …
})
.fail(function(data, textStatus, error) {
    …
})
.always(function(data, textStatus, error | xhr) {
    …
});
```

`GET http://localhost/path/resource?p1=Ma+cha%C3%Aene&p2=123456`





<!-- .slide: class="slide" -->
### Traiter un GET Ajax avec Spring MVC

```java
@GetMapping(value = "/path/resource", produces = "application/json; charset=UTF-8")
@ResponseBody
public Personne personne(@RequestParam("nom") String nom) {
   return personneService.trouver(nom);
}
```

```java
@GetMapping(value = "/path/resource", produces = "application/json; charset=UTF-8")
public ResponseEntity<Personne> personne(@RequestParam("nom") String nom) {
    Personne personne = personneService.trouver(nom);
    ResponseEntity<Personne> response = new ResponseEntity<>(HttpStatus.OK, personne);
    return response;
}
```





<!-- .slide: class="slide" -->
### Appel Ajax avec jQuery – POST

```javascript
$.ajax({
    url: '/path/resource',
    method: 'POST',
    contentType : 'application/json; charset=utf-8',
    data: JSON.stringify(request)
}).done(function(response) {
    …  
});
```

`POST http://localhost/path/resource`

```javascript
{
    "p1": "Ma chaîne",
    "p2": "123456"
}
```





<!-- .slide: class="slide" -->
### Traiter un POST Ajax avec Spring MVC

```java
@PostMapping("/path/resource")
@ResponseStatus(HttpStatus.OK)
public void post(@RequestBody Personne personne) {
    personneService.modifier(personne);
}

```

```java
@PostMapping("/path/resource")
public ResponseEntity<HttpStatus> post(@RequestBody Personne personne) {
    ResponseEntity<HttpStatus> response = new ResponseEntity<>(HttpStatus.OK);
    if (ko) {
        response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return response;
}
```

`ResponseEntity` > `@ResponseStatus`





<!-- .slide: class="slide" -->
### Ajax avec Spring MVC : cas général

```java
@PostMapping(value = "/path/resource", produces = "application/json; charset=UTF-8")
@ResponseBody
public Commande post(@RequestBody Personne personne) {
    Commande commande = commandeService.trouver(personne);
    return commande;
}
```





<!-- .slide: data-background-image="images/tp.png" data-background-size="500px" class="tp" -->
## [TP6](https://github.com/Insee-CNIP/formation-spring-mvc#6-ajax)