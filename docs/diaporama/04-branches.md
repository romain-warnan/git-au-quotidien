<!-- .slide: data-background-image="images/git-logo.png" data-background-size="800px" class="chapter" -->
## 4
### Branches


===


<!-- .slide: class="slide" -->
### Branches locales

Créer une nouvelle branche locale :
```bash
git branch nom-branche 
```

Extraire une branche existante :
```bash
git checkout nom-branche 
```
 - conserve les modifications locales
 - combiner les deux opération grâce à `git checkout -b nom-branche`


===


<!-- .slide: class="slide" -->
### Branches distantes

Partager une branche locale :
```bash
git push --set-upstream origin nom-branche-distante
```
 - il faut être dans la branche locale
 - en général `nom-branch-distante` = `nom-branche`


Suivre une branche distante :
```bash
git checkout nom-branche-distante
```
 - attention au cas où il existe déjà une branche locale portant ce nom
