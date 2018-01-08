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
git pull --rebase
```