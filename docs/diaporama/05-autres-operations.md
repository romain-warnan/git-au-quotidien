<!-- .slide: data-background-image="images/git-logo.png" data-background-size="800px" class="chapter" -->
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