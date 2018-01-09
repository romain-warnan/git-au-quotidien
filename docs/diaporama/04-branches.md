<!-- .slide: data-background-image="images/git-logo.png" data-background-size="600px" class="chapter" -->
## 4
### Branches


===


<!-- .slide: class="slide" -->
### Branches locales

Passer d’une branche à l’autre est très rapide avec Git
 - car tout se passe en local

Créer une nouvelle branche locale :
```bash
git branch nom-branche 
```

Extraire une branche existante :
```bash
git checkout nom-branche 
```
 - conserve les modifications locales
 - combiner les deux opérations grâce à `git checkout -b nom-branche`


%%%

<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Créer une nouvelle branche locale (1)

On va basculer sur la nouvelle branche dans la foulée
<div class="center">
    <img src="egit/local-branch-0.png" class="boxed-img" />
</div>


%%%

<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Créer une nouvelle branche locale (2)

Donner un nom à la branche
<div class="center">
    <img src="egit/local-branch-1.png" class="boxed-img" />
</div>


%%%

<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Créer une nouvelle branche locale (3)

On est désormais sur une nouvelle branche
<div class="center">
    <img src="egit/local-branch-2.png" class="boxed-img" />
</div>


===


<!-- .slide: class="slide" -->
### Branches distantes

Partager une branche locale :
```bash
git push --set-upstream origin nom-branche-distante
```
 - il faut être dans la branche locale
 - en général `nom-branch-distante` = `nom-branche`


%%%

<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Partager une branche (1)

Au début la branche n’existe que dans votre copie de travail
<div class="center">
    <img src="egit/push-branch-0.png" class="boxed-img" />
</div>


%%%

<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Partager une branche (2)

On peut choisir de configurer le *Pull* pour faire un rebasage par défaut plutôt qu’une fusion
<div class="center">
    <img src="egit/push-branch-1.png" class="boxed-img" />
</div>


%%%

<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Partager une branche (3)

<div class="center">
    <img src="egit/push-branch-2.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Partager une branche (4)

La branche est visible dans le dépôt distant
<div class="center">
    <img src="egit/push-branch-3.png" class="boxed-img" />
</div>


===


<!-- .slide: class="slide" -->
### Branches distantes

Suivre une branche distante :
```bash
git checkout nom-branche-distante
```
 - attention au cas où il existe déjà une branche locale portant ce nom


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Suivre une branche distante (1)

On commence par un *Fetch* pour récupérer les dernières informations du dépôts distant
<div class="center">
    <img src="egit/fetch-branch-0.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Suivre une branche distante (2)

On va basculer sur une nouvelle branche locale, connectée à la branche distante
<div class="center">
    <img src="egit/fetch-branch-1.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Suivre une branche distante (3)

Dans la partie *Remote Tracking*, choisir la branche adéquate
<div class="center">
    <img src="egit/fetch-branch-2.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Suivre une branche distante (4)

<div class="center">
    <img src="egit/fetch-branch-3.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Suivre une branche distante (5)

Par défaut, la branche locale sera connectée à la branche distante de même nom
<div class="center">
    <img src="egit/fetch-branch-4.png" class="boxed-img" />
</div>


===


<!-- .slide: class="slide" -->
### Fusionner une branche

Intégrer les commits dans la branche principale :
```bash
git checkout master
git merge nom-branche
```
 
Cas simple : *fast-forward*
 - pas de commit de fusion
 - simple avance rapide

Supprimer une branche locale fusionnée ou partagée :
```bash
git branch -d nom-branche
```


===


<!-- .slide: class="slide" -->
### Fusionner une branche

Cas intermédiaire : fusion à trois branchep walls
 - commit du résultat de la fusion


<div class="center">
    <img src="images/fusion.png" />
</div>

Cas difficile : fusion avec conflits
 - résoudre les conflits avant de pouvoir commiter