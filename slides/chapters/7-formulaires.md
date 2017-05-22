<!-- .slide: data-background-image="images/spring.png" data-background-size="1200px" class="chapter" -->
## 7
### Formulaires





<!-- .slide: class="slide" -->
### Les formulaires
On sait afficher des informations provenant du serveur

Comment les modifier ? À l’aide d’un formulaire
 - Balise `<form>`
 - Méthode POST de préférence
 - Champ `<input>`, `<select>`, `<textarea>`
   - avec un name renseigné
   - `disabled="false"`
 - Des données sont envoyées vers le serveur
 - Sous forme de couple clé / valeur :
```
        personne.nom=Nom
        personne.prenom=Prénom
        personne.email=nom.prenom@gmail.com
```





<!-- .slide: class="slide" -->
### Les formulaires dans Spring — JSP

Utiliser les balises `<form:…>`
 - Préciser `modelAttribute`

Dans le contrôleur, ajouter l’objet au modèle
 - L’objet est éventuellement vide
  - en cas de création par exemple
  - ici, `model.addAttribute("personne", new Personne());`
 - Sinon, les propriétés de l’objet servent à pré-remplir le formulaire
 
```jsp
<form:form action="/personne/modifier" modelAttribute="personne" method="post">
    <form:hidden path="id" />
    <label>Email : </label><form:input type="text" path="email" />
    <button type="submit">Modifier</button>
</form:form>

```
