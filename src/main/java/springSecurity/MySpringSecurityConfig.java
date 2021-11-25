package springSecurity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
This class will help to create the Spring Security FILTER CHAIN
- it is called a filter chain because there are multiple stages. Each will do one
- -> () -> () -> () -> resource
@EnableWebSecurity is used to create the spring filter chain for me
(hover over it, and you'll see that it already by default contains @Configuration)
so NO NEED @Configuration to tell that it is a configuration file
 */
@EnableWebSecurity
public class MySpringSecurityConfig extends WebSecurityConfigurerAdapter {

}
