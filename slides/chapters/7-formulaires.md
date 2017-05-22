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





<!-- .slide: class="slide" -->
### Les balise `<form:…>`
Formulaire
```jsp
<form:form action="/test" modelAttribute="personne">
    <button type="submit">Envoyer</button>
</form:form>
```
```html
<form id="personne" action="/test" method="post">
    <button type="submit">Envoyer</submit>
</form>
```

<form id="personne" action="/test" method="post" style="border: dotted black 1px">
    <button type="submit">Envoyer</button>
</form>

Dans le corps de la balise `<form:form>`, le __path__ est relatif au __modelAttribute__

Champ caché
```jsp
<form:hidden path="id" />
```
```html
<input id="id" name="id" type="hidden" value="1" />
```

===

<!-- .slide: class="slide" -->
Champ de texte
```jsp
<form:input path="email" />
```
```html
<input id="email" name="email" type="text" value="adresse@gmail.com"/>
```
<input id="email" name="email" type="text" value="prenom.nom@gmail.com"/>

Zone de texte
```jsp
<form:textarea path="verbatim"/>
```
```html
<textarea id="verbatim" name="verbatim">Verbatim, long texte</textarea>
```
<textarea id="verbatim" name="verbatim">Verbatim, long texte</textarea>

===

<!-- .slide: class="slide" -->
Boutons radio
```jsp
<form:radiobuttons path="genre.code" items="${genres}" itemLabel="libelle" itemValue="code" />
```
```html
<span>
    <input id="genre.code1" name="genre.code" type="radio" value="1"/>
    <label for="genre.code1">Masculin</label>
</span>
<span>
    <input id="genre.code2" name="genre.code" type="radio" value="2" checked="checked" />
    <label for="genre.code2">Féminin</label>
</span>
```
<span>
    <input id="genre.code1" name="genre.code" type="radio" value="1"/>
    <label for="genre.code1">Masculin</label>
</span>
<span>
    <input id="genre.code2" name="genre.code" type="radio" value="2" checked="checked" />
    <label for="genre.code2">Féminin</label>
</span>

Menu déroulant simple
```jsp
<form:select path="genre.code" items="${genres}" itemLabel="libelle" itemValue="code" />
```
```html
<select id="genre.code" name="genre.code">
    <option value="1" selected="selected">Masculin</option>
    <option value="2">Féminin</option>
</select>
```
<select id="genre.code" name="genre.code">
    <option value="1" selected="selected">Masculin</option>
    <option value="2">Féminin</option>
</select>

