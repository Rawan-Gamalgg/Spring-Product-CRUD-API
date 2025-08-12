/**
package com.examplewithdatabase.springrest.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // تعطيل حماية CSRF
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/public/**").permitAll()  // مسارات عامة
                .requestMatchers("/api/admin/**").hasRole("ADMIN")  // للمسؤولين فقط
                .anyRequest().authenticated()  // باقي المسارات تحتاج تسجيل دخول
            )
            .formLogin(form -> form  // واجهة تسجيل دخول بسيطة
                .loginPage("/login")
                .permitAll()
            )
            .logout(logout -> logout  // إمكانية تسجيل الخروج
                .permitAll()
            );
        
        return http.build();
    }
}
**/