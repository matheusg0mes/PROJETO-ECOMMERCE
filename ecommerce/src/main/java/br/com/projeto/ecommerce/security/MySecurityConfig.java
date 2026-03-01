package br.com.projeto.ecommerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
	@Bean
	public SecurityFilterChain security(HttpSecurity http) throws Exception{
		http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
        		.requestMatchers("/swagger-ui/**").permitAll()
                .requestMatchers("/v3/api-docs/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/usuario").permitAll()
                .requestMatchers(HttpMethod.GET, "/produtos").permitAll()
                .anyRequest().authenticated()
            )
            .cors(cors -> cors.disable());
		
		http.addFilterBefore(new MySecurity(), UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
