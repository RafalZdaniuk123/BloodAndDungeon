package pl.rafal.bloodindungeon.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/templates/")
                .setCachePeriod(0);
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/resources/**")
                .setCachePeriod(0);
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/**")
                .setCachePeriod(0);
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/css/**")
                .setCachePeriod(0);
    }

}
