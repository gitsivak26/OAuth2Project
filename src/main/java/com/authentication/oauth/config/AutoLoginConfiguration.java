package com.authentication.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AutoLoginConfiguration extends WebSecurityConfigurerAdapter {
	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web
//			.ignoring()
//			.antMatchers("/resources/**");
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.authorizeRequests(a -> a
					.antMatchers("/", "/error", "/css/**", "/js/**")
					.permitAll()
					.anyRequest()
					.authenticated())
			.logout(l -> l
					.logoutSuccessUrl("/")
					.permitAll())
			.csrf(c -> c
					.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
			.exceptionHandling(e -> e
					.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
			.oauth2Login();
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder authenticationMgr) throws Exception {
//		
//		authenticationMgr
//			.inMemoryAuthentication()
//			.withUser("Siva")
//			.password("123456")
//			.authorities("ADMIN");
//	}
	

}
