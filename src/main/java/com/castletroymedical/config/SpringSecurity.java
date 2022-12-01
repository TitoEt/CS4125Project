// //package com.castletroymedical.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// //import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// //import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// //import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// //import org.springframework.security.core.userdetails.UserDetailsService;
// ////mport org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// //mport org.springframework.security.crypto.password.PasswordEncoder;
// //import org.springframework.security.web.SecurityFilterChain;
// //import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain; 

// // @Autowired
// // private UserDetailsService userDetailsService;

    @Autowired
    private UserDetailsService userDetailsService; 

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/").permitAll()
                .requestMatchers("/stripe/**").permitAll()
                .requestMatchers("/admin/**").permitAll()
                .requestMatchers("/register/**").hasRole("ADMIN")
                .requestMatchers("/hospital-procedure/**").hasRole("ADMIN");
                // .and().
                // formLogin(
                //         form -> form
                //                 .loginPage("/login")
                //                 .loginProcessingUrl("/login")
                //                 .defaultSuccessUrl("/users")
                //                 .permitAll()
                // ).logout(
                //         logout -> logout
                //                 .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                //                 .permitAll()
                // );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}