package com.example.aboutme._core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/webrtc/**").authenticated() // 화상 채팅 관련 URL에 대해서만 인증 강제
                        .anyRequest().permitAll()
                )
                .requiresChannel(channel -> channel
                        .requestMatchers("/webrtc/**").requiresSecure() // HTTPS 강제
                );

        return http.build();
    }
}
