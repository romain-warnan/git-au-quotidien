<!-- .slide: data-background-image="images/git-logo.png" data-background-size="800px" class="chapter" -->
## 2
### Interagir avec le dépôt distant


===


<!-- .slide: class="slide" -->
### Partager son travail

```bash
git push
```

Tous les commits du dépôt local sont envoyés vers le dépôt distant.

Cas le plus simple car :
 - on a clôné le dépôt distant
 - il existe une branche master distante
 - il n’y a pas eu de modifications dans la branche distante

Gérer les droits d’accès :
 - échange de clés SSH
 - identifiant / mot de passe
 - `credential.helper`