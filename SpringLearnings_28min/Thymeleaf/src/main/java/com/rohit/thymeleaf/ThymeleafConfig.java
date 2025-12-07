package com.rohit.thymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.DefaultTemplateResolver;

@Configuration
public class ThymeleafConfig {

// }  public class ThymeleafConfig {

    @Bean
    public SpringResourceTemplateResolver templateResolver() {

    	SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();

//        templateResolver.setPrefix("/WEB-INF/templates/");
    	templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");

        templateResolver.setTemplateMode(TemplateMode.HTML); // Set template mode to HTML [4, 5]
        templateResolver.setCacheable(false); // Set to true for caching templates
        return templateResolver;

    }
    
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true); // Enables Spring Expression Language (SpEL) support
        return templateEngine;
    }

}