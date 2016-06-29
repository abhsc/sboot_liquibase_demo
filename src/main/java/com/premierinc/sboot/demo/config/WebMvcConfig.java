package com.premierinc.sboot.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*@Configuration
@EnableWebMvc
@ComponentScan("com.premierinc.sboot.demo")*/
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*if (!registry.hasMappingForPattern("/webjars*//**")) {
            registry.addResourceHandler("/webjars*//**").addResourceLocations(
                    "classpath:/META-INF/resources/webjars/");
        }
*/
    }
}
