<!-- .slide: data-background-image="images/git-logo.png" data-background-size="600px" class="chapter" -->
## 5
### Autres opérations


===


<!-- .slide: class="slide" -->
### Remisage

Stocker toutes les modifications non commitées :
```bash
git stash
```
 - copie locale propre
 - modifications dans la remise

Réappliquer le contenu de la remise :
```bash
git stash pop
```
 - `git stash drop` pour abandonner le contenu de la remise
 

%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Remiser des modifications (1)

<div class="center">
    <img src="egit/stash-0.png" class="boxed-img" />
</div>
 

%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Remiser des modifications (2)

Choisir d’inclure ou non les fichiers nouvellements créés
<div class="center">
    <img src="egit/stash-1.png" class="boxed-img" />
</div>
 

%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Appliquer des modifications remisées (1)

<div class="center">
    <img src="egit/stash-apply-0.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Appliquer des modifications remisées (2)

Appliquer puis supprimer la remise
<div class="center">
    <img src="egit/stash-apply-1.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Appliquer des modifications remisées (3)

Appliquer puis supprimer la remise
<div class="center">
    <img src="egit/stash-apply-2.png" class="boxed-img" />
</div>

===


<!-- .slide: class="slide" -->
### Revenir en arrière

Revenir au dernier commit :
```bash
git reset --hard
```
 - __attention__ on perd définitivement les modifications non commitées
 - *cf.* `svn revert`

Annuler les 3 derniers commits :
```bash
git reset --hard HEAD~3 --
```
 - en cas d’erreur de manipulation : `git reset HEAD@{3}`
  - chercher sur internet selon les cas

Pour retourner en arrière à un commit donné :
```bash
git reset --hard 46e273cc54
```

Seulement si le travail n’a pas été paratgé
 - Sinon, voir `git revert`


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Revenir en arrière (1)

<div class="center">
    <img src="egit/reset-0.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Revenir en arrière (2)

Choisr le type de retour en arrière : *Hard* pour annuler toutes les modifications locales
<div class="center">
    <img src="egit/reset-1.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Revenir en arrière (3)

Le *Reset Hard* provoque la perte des modifications non commitées
<div class="center">
    <img src="egit/reset-2.png" class="boxed-img" />
</div>


===


<!-- .slide: class="slide" -->
### Étiquettes

Marquer un commit comme particulier :
```bash
git tag -a v1.1 -m "Version livrée en production le 10/11/2017"
```
 - photographie du code à un moment donné

Poser une étiquette *a posteriori* :
```bash
git tag -a v1.1 -m "Version livrée en production le 10/11/2017" 5978c73
```

Envoyer des étiquettes dans le dépôt distant :
```bash
git push origin --tags
```

Récupérer le code associé à une étiquette donnée :
```bash
git checkout v1.1
```

%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Poser un étiquette (1)

Clic droit sur le *commit* adéquat
<div class="center">
    <img src="egit/tag-0.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Poser un étiquette (2)

Nommer et décrire l’étiquette
<div class="center">
    <img src="egit/tag-1.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Poser un étiquette (3)

Envoyer l’étiquette dans le dépôt distant
<div class="center">
    <img src="egit/tag-2.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Poser un étiquette (4)

<div class="center">
    <img src="egit/tag-3.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Poser un étiquette (5)

L’étiquette est bien visible dans le dépôt distant
<div class="center">
    <img src="egit/tag-4.png" class="boxed-img" />
</div>


===


<!-- .slide: class="slide" -->
### Autres possibilités

Voir les modifications
 - `git diff`

Modifier un commit
 - `commit --amend`

Réorganiser l’historique local
 - `rebase --interactive`

Réécrire l’historique distant
 - `filter-branch`
 
Déclencher des actions
 - `.git/hooks`

Gérer des sous-modules 

…


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Rebasage interactif (1)

L’historique n’est pas linéaire, il est difficile à relire
<div class="center">
    <img src="egit/rebase-interactive-0.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Rebasage interactif (2)

Clic droit sur le *commit* à partir duquel on souhaite rebaser
<div class="center">
    <img src="egit/rebase-interactive-1.png" class="boxed-img" />
</div>


%%%

<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->

### Rebasage interactif (3)

On peut annuler le rebasage
<div class="center">
    <img src="egit/rebase-interactive-2.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Rebasage interactif (4)

Réorganiser les *commits* et cliquer sur *Start*

 - on en garde un pour la correction du *bug* et on le place en premier
 - on fusionne les autres *commits* en un seul
 
<div class="center">
    <img src="egit/rebase-interactive-3.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Rebasage interactif (5)

Message du *commit* résultat de la fusion
<div class="center">
    <img src="egit/rebase-interactive-4.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Rebasage interactif (6)

On écrit un message de *commit* plus lisible
<div class="center">
    <img src="egit/rebase-interactive-5.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Rebasage interactif (7)

L’historique est devenu linéaire et plus court
<div class="center">
    <img src="egit/rebase-interactive-6.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Rebasage interactif (8)

Reste à supprimer les branches de travail
<div class="center">
    <img src="egit/rebase-interactive-7.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Rebasage interactif (9)

<div class="center">
    <img src="egit/rebase-interactive-8.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Rebasage interactif (10)

L’historique est devenu plus lisible
<div class="center">
    <img src="egit/rebase-interactive-9.png" class="boxed-img" />
</div>


===


<!-- .slide: class="slide" -->
### Ressources utiles


Documentation Git en français :

<div class="center">
	<a href="https://git-scm.com/book/fr/v2" target="_blank"><img src="images/documentation.png" style="width: 300px" /></a>
</div>

Code de la présentation :

<div class="center">
	<a href="https://github.com/romain-warnan/git-au-quotidien" target="_blank"><img src="images/github.png" /></a>
</div>
