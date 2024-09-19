package org.daersh.githubchat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().authenticated()  // 모든 요청에 대해 인증 필요
                )
                .oauth2Login(oauth2Login ->
                        oauth2Login
                                .loginPage("/oauth2/authorization/github")  // GitHub 로그인 페이지로 이동
                                .defaultSuccessUrl("/welcome", true) // 로그인 후 리다이렉트 경로
                )
                .logout(logout -> logout.logoutSuccessUrl("/"));  // 로그아웃 후 리다이렉트될 URL

        return http.build();
    }
}
