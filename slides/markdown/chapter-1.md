<!-- .slide: class="slide" -->

### Spring core
Au démarrage de l’application, chargement du contexte
Web : *listener*
```xml
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
</context-param>
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
```
Batch : de manière explicite en Java
```java
try(AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")){
    Service service1 = (Service) context.getBean("beanName");
    Service service2 = context.getBean(Service.class);
    Service service3 = context.getBean("beanName", Service.class);
}
```

------

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