<!-- .slide: data-background-image="images/git-logo.png" data-background-size="800px" class="chapter" -->
## 1
### Cloner un dépôt distant

===

<!-- .slide: class="slide" -->
### Spring core
Spring core : conteneur qui implémente le *pattern* «&nbsp;inversion de contrôle&nbsp;» (IoC)

Définitions des objets (*bean*)
 - XML : `applicationContext.xml`
 - Annotations
  - Stéréotypes : `@Component`, `@Service`, `@Repository`, `@Controller`…
  - Injection : `@Autowired`, `@Resource`, `@Value`…
  - Configuration : `@Configuration`

===

<!-- .slide: class="slide" -->
### Spring core
Au démarrage de l’application, chargement du contexte
Web : *listener*
```bash
git clone git@github.com:romain-warnan/git-au-quotidien.git
cd git-au-quotidien
```

===

<!-- .slide: class="slide" -->
### Beans et injection des dépendances
En XML
```xml
<bean id="cacheManager" class="org.springframework.cache.ehcache.EhCacheCacheManager">
    <property name="cacheManager" ref="ehcache" />
</bean>
<bean id="ehcache" class="org.springframework.cache.ehcache.EhCacheManagerFactoryBean">
    <property name="configLocation" value="classpath:ehcache.xml" />
</bean>
```