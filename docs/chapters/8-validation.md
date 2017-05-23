<!-- .slide: data-background-image="images/spring.png" data-background-size="1200px" class="chapter" -->
## 8
### Validation





<!-- .slide: class="slide" -->
### Validation

Contrôler les données avant de les intégrer dans le système

Validation côté client : facultative
 - Pour le confort de l’utilisateur
 - Javascript

Validation côté serveur : __obligatoire et systématique__
 – contrôles unitaires sur le format des données (type, taille…)
  - on les retrouve quelle que soit l’application
  - Spring offre une solution clé en main
 – contrôles métiers
  - parfois compliqués, ils dépendent largement de l’application
  - Spring permet d’intégrer ces contrôles dans son schéma de fonctionnement





<!-- .slide: class="slide" -->
### Validation unitaire

Spring s’appuie sur la JSR 303 : Bean Validation
 - Java Specification Requests 

Une série d’annotations
 - à ajouter sur les champs de la classe
 - définissant des contraintes en plus du type
  - taille, non nullité…
 - acceptant plus ou moins de paramètres
  - min, message…

Ces annotations seules ne font rien
 - il faut ajouter un moteur de traitement
 - en général on utilise l’implémentation d’Hibernate





<!-- .slide: class="slide" -->
### Mise en place de la validation unitaire

```xml
<!– JSR 303 : Bean validation -->
<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
    <version>1.1.0.Final</version>
</dependency>

<!-- Bean validation : implémentation -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>5.3.1.Final</version>
</dependency>
```





<!-- .slide: class="slide" -->
### Liste des annotations de validation

`@Min,@Max`
```java
@Min(0)
private Integer quantite;
```

`@NotNull,@Null`
```java
@NotNull
private Ville ville;
```

`@Pattern`
```java
@Pattern(regexp = "0\\d-(?:\\d{2}-){3}\\d{2}")
private String numeroTelephone;
```

`@Past,@Future`
```java
@Future
private Date dateRendezVous;
```

===

<!-- .slide: class="slide" -->
`@Size`
```java
@Size(min = 1, max = 50)
private String pseudo;@Size(min = 1, max = 3)private List<Long> choixUtilisateur;
```

`@AssertTrue,@AssertFalse`
```java
@AssertTrue
private Boolean conditionsAcceptees;
```

`@DecimalMin,@DecimalMax`
```java
@DecimalMax(0.20)
private BigDecimal reduction;
```

`@Digits`
```java
@Size(integer = 2, fraction = 2)
private BigDecimal tauxChomage;
```





<!-- .slide: class="slide" -->
### Déclencher la validation dans le contrôleur

Dans la signature de la méthode de contrôleur
 - ajouter l’annotation `@Valid` devant l’objet posté
 - ajouter un paramètre de type `BindingResult`
  - juste après l’argument `@Valid`
  - pour stocker le résultat de la validation
  - nombre d’erreurs,messages d’erreurs
 - `@Valid @ModelAttribute` peut être simplifié en `@Valid`

Dans le corps de la méthode
 - utiliser la méthode `hasErrors()` de l’objet bindingResult
 




<!-- .slide: class="slide" -->
### Exemple de validation unitaire

```java
public class Personne {
    @NotNull
    @Size(max = 500)private String nom;
    
    public String getNom() {…
    public void setNom(String nom) {…
}
```

```java
@PostMapping("/modification")
public String modificationPersonnePost(@Valid Personne personne, BindingResult result) {
    if (result.hasErrors()) {
        return "modification-personne";
    }
    return "redirect:/liste-personnes";
}
```

Le BindingResult est ajouté au modèle, donc :
 - on peut afficher les erreurs dans la JSP
 - le formulaire sera prérempli avec les données que l’on vient de saisir (y compris les erreurs)
