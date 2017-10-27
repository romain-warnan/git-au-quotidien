<!-- .slide: data-background-image="images/git-logo.png" data-background-size="800px" class="chapter" -->
## 1
### Opérations de base


===


<!-- .slide: class="slide" -->
### Cloner le code depuis le dépôt distant

```bash
git clone git@github.com:romain-warnan/git-au-quotidien.git
cd git-au-quotidien
```

Différence majeure par rapport à SVN
 - le dépôt entier est cloné : y compris l’historique
  - répertoire `.git/`
  - `git log`
 - dépôt local ≠ dépôt distant


===


<!-- .slide: class="slide" -->
### Ignorer des fichiers

Fichier `.gitignore`
 - à la racine du dépôt local
 - nom important

Exemple
```
target/
.settings/

*.log

.classpath
.project
.*-credentials
```

Ignorer de nouveaux fichiers :
```bash
echo "*.class" >> .gitignore
git commit -am "Ignorer les fichiers .class"
```


===


<!-- .slide: class="slide" -->
### Modifier des fichiers

```bash
git add '*.java'
```

Ou bien, souvent :

```bash
git add .
```

Voir l’état de la copie locale :

```bash
git status
```

<div class="center">
    <img src="images/git-status.png" />
</div>