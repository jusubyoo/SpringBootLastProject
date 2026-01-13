package com.sist.web.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.sist.web.security.LoginFailHandler;
import com.sist.web.security.LoginSuccessHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final LoginSuccessHandler loginSuccessHandler;
	private final LoginFailHandler loginFailHandler;
	private final DataSource dataSource;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http
			.csrf(csrt -> csrt.disable())
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/","/member/**").permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().permitAll()
			)
			.formLogin(form -> form
				.loginPage("/member/login")
				.loginProcessingUrl("/member/login_process")
				.usernameParameter("userid")
				.passwordParameter("userpwd")
				.defaultSuccessUrl("/main",false)
				.successHandler(loginSuccessHandler)
				.failureHandler(loginFailHandler)
				.permitAll()
			)
			.rememberMe(remember -> remember
				.key("my-secret-key")
				.rememberMeParameter("remember-me")
				.tokenValiditySeconds(60*60*24)
				// .userDetailsService(UserDetailsService)
			)
			.logout(logout -> logout
				.logoutUrl("/member/logout")
				.logoutSuccessUrl("/main")
				.invalidateHttpSession(true)
				.deleteCookies("remember-me","JSESSIONID")
			);
		
			return http.build();
	}
	// 인증 관리자
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder PasswordEncoder) throws Exception
	{
		AuthenticationManagerBuilder builder=http.getSharedObject(AuthenticationManagerBuilder.class);
		builder
			.userDetailsService(jdbcUserDetailsManager())
			.passwordEncoder(PasswordEncoder);
		return builder.build();
	}
	
	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager() {
		JdbcUserDetailsManager manager=new JdbcUserDetailsManager(dataSource);
		manager.setUsersByUsernameQuery("SELECT userid as username, userpwd as password, enabled "
				+ "FROM project_member_2 WHERE userid=?");
		manager.setAuthoritiesByUsernameQuery("SELECT userid as username, authority "
				+ "FROM authority_2 WHERE userid=?");
		return manager;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
