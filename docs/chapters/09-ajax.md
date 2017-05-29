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

===

<!-- .slide: class="slide" -->
### Conversion JAVA &hArr; JSON

```java
public class Personne {
    private String nom;
    private Integer age;
    private Adresse adresse;
    
    // Getters et Setters
}

public class Adresse {
    private String voie;
    private List<String> complement;
    
    // Getters et Setters
}
```

```json
{
  "nom": "Prénom Nom",
  "age": 33,
  "adresse": {
    "voie": "34 rue des Rosiers",
    "complement": ["complément 1", "complément 2"]
  }
}
```




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





<!-- .slide: data-background-image="images/question.png" data-background-size="700px" class="exercice" -->
## En plus…

===

<!-- .slide: class="slide" -->
### Contrôleur qui retourne une image
```java
@GetMapping("/image/{nom:.+}")
public ResponseEntity<byte[]> image(@PathVariable("nom") String nom, HttpServletResponse response) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.IMAGE_JPEG);
    try (InputStream in = FileUtils.openInputStream(path.toFile())) {
        byte[] bytes = IOUtils.toByteArray(in);
        return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
    }
    catch (IOException e) {
        …
    }
    new ResponseEntity<byte[]>(null, headers, HttpStatus.NOT_FOUND);
}
```

===

<!-- .slide: class="slide" -->
### Télécharger un fichier
```java
@GetMapping("/telechargement")
public HttpEntity<FileSystemResource> telechargement() {
    File file = …
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());
    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);  // Ou autre
    headers.setContentLength(file.length());
    return new HttpEntity<FileSystemResource>(new FileSystemResource(file), header);
}
```