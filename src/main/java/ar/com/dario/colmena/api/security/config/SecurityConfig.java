package ar.com.dario.colmena.api.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        return http
                .authorizeRequests( auth -> {
                auth.regexMatchers("/").permitAll();
                auth.anyRequest().authenticated();
                })
                .formLogin(withDefaults())
                .oauth2Login(withDefaults())
                .build();
    }
    
}
