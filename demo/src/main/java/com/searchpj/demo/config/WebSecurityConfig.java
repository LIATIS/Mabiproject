package com.searchpj.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsManager = new InMemoryUserDetailsManager();

        var user = User.withUsername("user")
                .password("{noop}password")  // "{noop}"는 암호화 없이 평문 비밀번호를 사용
                .roles("USER")
                .build();

        var admin = User.withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();

        userDetailsManager.createUser(user);
        userDetailsManager.createUser(admin);

        return userDetailsManager;
    }

    // HTTP 보안 설정
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
//        		.requestMatchers("/", "/home", "/public/**").permitAll()  // 이 경로는 로그인 없이 접근 허용
//              .requestMatchers("/admin/**").hasRole("ADMIN")  // "/admin" 경로는 ADMIN 권한 필요
//              .anyRequest().authenticated()  // 그 외 모든 요청은 인증 필요
        		.anyRequest().permitAll()  // 모든 경로에 대해 인증 없이 접근 허용
            );
//            .formLogin(form -> form
//                .loginPage("/login")  // 커스텀 로그인 페이지 설정
//                .permitAll()  // 로그인 페이지는 누구나 접근 가능
//            )
//            .logout(logout -> logout
//                .permitAll()  // 로그아웃도 누구나 접근 가능
//            );
        return http.build();
    }
}
