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
### Résoudre les conflits de fusion

Choisir la branche distante adéquate
<div class="center">
    <img src="egit/fetch-rebase-3.png" class="boxed-img" />
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
### Résoudre les conflits de rebasage

Choisir la branche distante adéquate
<div class="center">
    <img src="egit/rebase-conflict-0.png" class="boxed-img" />
</div>




%%%

<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Résoudre les conflits de rebasage

Choisir d’annuler le rebasage *Abort rebase*
<div class="center">
    <img src="egit/rebase-conflict-1.png" class="boxed-img" />
</div>


%%%

<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Résoudre les conflits de rebasage

Lancer une fusion comme dans l’exemple précédent
<div class="center">
    <img src="egit/rebase-conflict-2.png" class="boxed-img" />
</div>

