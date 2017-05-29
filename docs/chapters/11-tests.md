<!-- .slide: data-background-image="images/spring.png" data-background-size="1200px" class="chapter" -->
## 11
### Tests





<!-- .slide: class="slide" -->
### Tester un contrôleur

Classe de base : `MockMvc`
 - mocks pour les contrôleurs
Librairie d’assertions adaptée

1. Tests unitaires
 - mode stand-alone
 - pas de runner particulier
 - pas de contexte Spring
 - utilisation massive de Mockito

2. Tests d’intégration
 - chargement du contexte Spring
 - `@RunWith(SpringJUnit4ClassRunner.class)`





<!-- .slide: class="slide" -->
### Test unitaire d’un contrôleur : préparation

Injecter le contrôleur à tester
```java
@InjectMocks
private PersonneController personneController;
```

Injecter des mocks de tous les services
```java
@Mock
private PersonneService personneService;
```

Initialiser les mocks
```java
MockitoAnnotations.initMocks(this);
```

Instancier l’objet `MockMvc` en mode *stand-alone* pour le contrôleur
```java
this.mockMvc = MockMvcBuilders.standaloneSetup(personneController).build();
```





<!-- .slide: class="slide" -->
### Test unitaire d’un contrôleur : exécution

Mocker tous les appels aux services
```java
doNothing().when(validator).validate(any(Personne.class), any(Errors.class));
when(personneDao.find(any(Short.class))).thenReturn(personne);
```

Simuler la requête
```java
mockMvc.perform(get("/accueil"))
```

Et finalement, utiliser des assertions
	
Bien garder en tête que seul le contrôleur existe





<!-- .slide: class="slide" -->
### Test d’intégration d’un contrôleur : préparation

Annoter la classe de test
```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:context.xml", "classpath:servlet.xml" })
@ActiveProfiles("profile")
@WebAppConfiguration
```

Injecter le contexte web
```java
@Autowired
private WebApplicationContext wac;
```

Instancier l’objet MockMvc en mode context
```java
this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
```





<!-- .slide: class="slide" -->
### Test d’intégration d’un contrôleur : exécution

Simuler la requête
```java
mockMvc.perform(get("/accueil"))
```

Puis utiliser des assertions

Tous les objets du contexte existent on peut tester la requête de bout en bout





<!-- .slide: class="slide" -->
### Assertions

Contenues dans la classe : MockMvcResultMatchers
```java
request(), model(), view(), flash(), status()
forwardedUrl(…), redirectedUrl(…)
…
```

Chaque élément possède des assertions spécifiques
```java
status().isOk()
model().attributeExists("personne")
view().name("accueil")
…
```

Pour démarrer les assertions :
```java
mockMvc.perform(get("/accueil"))
    .andExpect(status().isOk()) 
    .andExpect(…)
    …;
```





<!-- .slide: data-background-image="images/tp.png" data-background-size="500px" class="tp" -->
## [TP8](https://github.com/Insee-CNIP/formation-spring-mvc#8-tests)