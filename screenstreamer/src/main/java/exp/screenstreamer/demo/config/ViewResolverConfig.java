package exp.screenstreamer.demo.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@EnableWebMvc
@Configuration
public class ViewResolverConfig  implements WebMvcConfigurer{
	
	  @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/**")
	        .addResourceLocations("classpath:/");
	    }
	  
	  @Bean
		public BeanNameViewResolver beanNameViewResolver(){
		    return new BeanNameViewResolver();
		}
	  
	  @Bean
		public View sample() {
		    return new JstlView("/static/view/index.jsp");
		}
	  
	  @Bean
	  public InternalResourceViewResolver jspViewResolver() {
	      InternalResourceViewResolver resolver= new InternalResourceViewResolver();
	      //resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
	      resolver.setPrefix("/WEB-INF/");
	      resolver.setSuffix(".jsp");
	      return resolver;
	  } 

}
