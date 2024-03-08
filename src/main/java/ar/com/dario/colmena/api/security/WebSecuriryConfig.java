package ar.com.dario.colmena.api.security;


/*
@Configuration
public class WebSecuriryConfig  {
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception{
            return http
                    .csrf(csrf -> csrf.disable())
                    .authorizeRequests(requests -> requests
                                    .anyRequest().authenticated()
                    )
                    .httpBasic(withDefaults())
                    .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .build();
    }

    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        UserDetails user = User.withUsername("unnombre")
                .passwordEncoder(passwordEncoder()::encode)
                .password("unpassword")
                .roles("USER")
                .build();
        manager.createUser(user);
        return manager;
    }

    @Bean
    AuthenticationManager authManager(HttpSecurity http) throws Exception{
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
*/
