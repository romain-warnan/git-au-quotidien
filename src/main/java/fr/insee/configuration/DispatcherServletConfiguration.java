package fr.insee.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import fr.insee.bar.converter.ClientConverter;
import fr.insee.bar.interceptor.EmployeInterceptor;
import fr.insee.bar.interceptor.TimerInterceptor;
import fr.insee.bar.resolver.EmployeResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "fr.insee.bar")
public class DispatcherServletConfiguration extends WebMvcConfigurerAdapter implements WebMvcConfigurer {

	@Autowired
	private ClientConverter clientConverter;

	@Autowired
	private EmployeResolver employeResolver;

	@Autowired
	private EmployeInterceptor employeInterceptor;

	@Autowired
	private TimerInterceptor timerInterceptor;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
			.addResourceHandler("/static/**")
			.addResourceLocations("/static/");
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(employeResolver);
	}

	@Override
	public Validator getValidator() {
		return this.validator();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry
			.addInterceptor(employeInterceptor)
			.addPathPatterns("/**")
			.excludePathPatterns("/static/**");
		registry
			.addInterceptor(timerInterceptor)
			.addPathPatterns("/**")
			.excludePathPatterns("/static/**");
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(clientConverter);
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		return bean;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver bean = new CommonsMultipartResolver();
		bean.setDefaultEncoding("utf-8");
		bean.setMaxUploadSize(1_000_000); // 1 Mo
		return bean;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource bean = new ResourceBundleMessageSource();
		bean.setBasename("message");
		bean.setDefaultEncoding("UTF-8");
		return bean;
	}

	@Bean
	public Validator validator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(this.messageSource());
		return bean;
	}
}
