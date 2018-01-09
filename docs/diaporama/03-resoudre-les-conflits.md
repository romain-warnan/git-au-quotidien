<!-- .slide: data-background-image="images/git-logo.png" data-background-size="600px" class="chapter" -->
## 3
### Résoudre les conflits


===


<!-- .slide: class="slide" -->
### Résoudre les conflits

#### Cas de la fusion


```bash
git pull
```
 - on est avertis qu’il y a des conflits

Quand un fichier est corrigé :
```bash
git add fichier-conflit
```

Une fois que tous les conflits sont corrigés :
```bash
git commit -m "Message de résolution du conflit."
```

Pour revenir à l’état sans conflit et annuler la fusion :
```bash
git merge --abort
```


%%%

<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Résoudre les conflits de fusion (1)

Pendant un *Pull* on est prévenu qu’il y a des conflits
<div class="center">
    <img src="egit/pull-conflict-0.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Résoudre les conflits de fusion (2)

Double-cliquer sur le fichier en conflit

 - cela ouvre l’outils de résolution des conflits

<div class="center">
    <img src="egit/pull-conflict-1.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Résoudre les conflits de fusion (3)

 - résoudre le conflit à l’aide de l’outils et enregister les fichiers
 - glisser le fichier dans la zone d’index
 - saisir un message de *commit* et commiter

<div class="center">
    <img src="egit/pull-conflict-2.png" class="boxed-img" />
</div>

%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Résoudre les conflits de fusion (4)

La branche distante est fusionnée dans la copie locale

<div class="center">
    <img src="egit/pull-conflict-2.png" class="boxed-img" />
</div>


===


<!-- .slide: class="slide" -->
### Résoudre les conflits

#### Cas du rebasage

Il est déconseillé d’utiliser cette technique, mieux vaut utiliser une fusion en cas de conflit

```bash
git pull --rebase
```

Pour revenir à l’état sans conflit et annuler le rebasage :
```bash
git rebase --abort
```

Puis on se ramène a cas de la fusion :
```bash
git pull
```


%%%

<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Résoudre les conflits de rebasage (1)

Choisir la branche distante adéquate
<div class="center">
    <img src="egit/rebase-conflict-0.png" class="boxed-img" />
</div>


%%%

<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Résoudre les conflits de rebasage (2)

Choisir d’annuler le rebasage *Abort rebase*
<div class="center">
    <img src="egit/rebase-conflict-1.png" class="boxed-img" />
</div>


%%%

<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Résoudre les conflits de rebasage (3)

Lancer une fusion comme dans l’exemple précédent
<div class="center">
    <img src="egit/rebase-conflict-2.png" class="boxed-img" />
</div>

