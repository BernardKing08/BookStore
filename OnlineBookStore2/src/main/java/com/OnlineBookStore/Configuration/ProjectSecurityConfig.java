package com.OnlineBookStore.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain sfc(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf
            		.ignoringRequestMatchers("/addToCart")
            		.ignoringRequestMatchers("/removeItem")
            		.ignoringRequestMatchers("/closeMsg/**")
            		.ignoringRequestMatchers("/register")
            )
            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/addToCart").authenticated()
	                .requestMatchers("/signin").permitAll()
	                .requestMatchers("/removeItem").authenticated()
	                .requestMatchers("/dashboard").authenticated()
	                .requestMatchers("/book-details/**").permitAll()
	                .requestMatchers("/getAllBooks").authenticated()
	                .requestMatchers("/books").permitAll()
	                .requestMatchers("/login").permitAll()
	                .requestMatchers("/register").permitAll()
	                .requestMatchers("/logout").permitAll()
	                .requestMatchers("/saveMsg").permitAll()
	                .requestMatchers("/displayMessages").authenticated()
	                .requestMatchers("/contact").permitAll()
	                .requestMatchers("/assets/**").permitAll()
	                .requestMatchers("/history").authenticated()
	                .requestMatchers("/cart").authenticated()
	                .requestMatchers("/order").authenticated()
	                .requestMatchers("/closeMsg/**").authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/books", true)
                .failureUrl("/login?error=true")
                .permitAll()
            )
            //this would not work since the login controller is being controlled in the controller class
            .logout(logoutConfigurer -> logoutConfigurer
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .permitAll()
                .deleteCookies("JSESSIONID")
                .permitAll()
            )
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
