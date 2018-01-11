<!-- .slide: data-background-image="images/git-logo.png" data-background-size="600px" class="chapter" -->
## 1
### Opérations de base


===


<!-- .slide: class="slide" -->
### Cloner le code depuis le dépôt distant

```bash
git clone https://github.com/romain-warnan/git-au-quotidien.git
cd git-au-quotidien
```

Différence majeure par rapport à SVN
 - le dépôt entier est cloné : y compris l’historique
  - répertoire `.git/`
  - `git log`
 - dépôt local ≠ dépôt distant


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Cloner à partir de FusionForge (1)

FusionForge, onglet « Code source » : copier l’url `git+ssh…`

<div class="center">
    <img src="egit/clone-0.0.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Cloner à partir de FusionForge (2)

Perspective Git : coller l’url à gauche

<div class="center smaller">
	   <img src="egit/clone-0.1.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Cloner à partir de FusionForge (3)

Choisir les branches à importer

<div class="center smaller">
    <img src="egit/clone-0.2.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Cloner à partir de FusionForge (4)

Sélectionner le *workspace* d’Eclipse

<div class="center smaller">
    <img src="egit/clone-0.3.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Cloner à partir de FusionForge (5)

Le projet n’est pas encore dans Eclipse, il faut l’importer

<div class="center smaller">
    <img src="egit/clone-0.4.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Cloner à partir de GitLab (1)

GitLab, onglet « Details » : copier l’url `[git@git.web…`

<div class="center smaller">
    <img src="egit/clone-1.0.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Cloner à partir de GitLab (2)

Eclipse ne comprend pas, corriger les éléments de l’url un par un

<div class="center smaller">
    <img src="egit/clone-1.1.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Cloner à partir de GitLab (3)

Importer le projet avec Maven

<div class="center smaller">
    <img src="egit/clone-1.2.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Cloner à partir de GitLab (4)

Patienter

<div class="center smaller">
    <img src="egit/clone-1.3.png" class="boxed-img" />
</div>



%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Cloner à partir de GitLab (5)

Pour vérifier, faire *Team > Show in history* à la racine du projet

<div class="center">
    <img src="egit/clone-1.4.png" class="boxed-img" />
</div>


===


<!-- .slide: class="slide" -->
### Ignorer des fichiers

Fichier `.gitignore`
 - à la racine du dépôt local
 - nom important

Exemple :
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


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Ignorer des fichiers (1)

Dans la vue *Package Explorer*, *Filters*

<div class="center">
    <img src="egit/ignore-0.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Ignorer des fichiers (2)

Afficher les fichiers cachés

<div class="center">
    <img src="egit/ignore-1.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Ignorer des fichiers (3)

Éditer le fichier `.gitignore`

<div class="center">
    <img src="egit/ignore-2.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Ignorer des fichiers (4)

Commiter le fichier `.gitignore`

<div class="center">
    <img src="egit/ignore-3.png" class="boxed-img" />
</div>


===


<!-- .slide: class="slide" -->
### Modifier des fichiers

```bash
git add '*.java'
```
 - souvent on utilise plus simplement `git add .`

Voir l’état de la copie locale :
```bash
git status
```

<div class="center">
    <img src="images/git-status.png" />
</div>


===


<!-- .slide: class="slide" -->
### Commiter des fichiers

```bash
git commit -m "Message de commit."
```
 - tout ce qui est dans l’index est commité.

Si on souhaite commiter tous les fichiers modifiés : 
```bash
git commit -am "Message de commit."
```
 - ne commite pas les nouveaux fichiers
  - utiliser `add` explicitement dans ce cas

Pour un message de commit plus complet, utiliser l’éditeur de texte :
```bash
git commit
```
 - rappel pour quitter vi : __Esc__ puis « :wq », ou __Esc__ puis __Maj + zz__

__Attention__ : le travail est commité dans le dépôt local.


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Commiter des fichiers (1)

Vue *Git Staging* : glisser-déposer les fichiers à commiter

<div class="center">
    <img src="egit/commit-0.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Commiter des fichiers (2)

Écrire un message et commiter

<div class="center">
    <img src="egit/commit-1.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Commiter des fichiers (3)

Un nouveau *commit* est visible dans l’historique : `5be3cd1`

<div class="center">
    <img src="egit/commit-2.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Amender un *commit* (1)

Éventuellement, réécrire le message et modifier le contenu du *commit*

<div class="center">
    <img src="egit/commit-3.png" class="boxed-img" />
</div>


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Amender un *commit* (2)

Le dernier *commit* est modifié : `14009e8`

<div class="center">
    <img src="egit/commit-4.png" class="boxed-img" />
</div>