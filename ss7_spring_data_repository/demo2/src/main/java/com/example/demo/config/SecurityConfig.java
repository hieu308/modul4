package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/login").permitAll() // Cho phép truy cập vào trang chủ và trang đăng nhập
                        .requestMatchers("/","/create").authenticated() // Yêu cầu đăng nhập để vào trang home
                        .anyRequest().authenticated() // Tất cả các trang còn lại yêu cầu đăng nhập
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")// Trang đăng nhập tùy chỉnh
                        .loginProcessingUrl("/login")// Cho phép tất cả truy cập trang đăng nhập
                )
                .logout((logout) -> logout
                        .permitAll() // Cho phép tất cả người dùng đăng xuất
                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder() // Tạo người dùng mặc định cho môi trường phát triển
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder() // Tạo tài khoản admin
                .username("admin")
                .password("adminpass")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin); // Sử dụng InMemory để lưu thông tin người dùng
    }
}