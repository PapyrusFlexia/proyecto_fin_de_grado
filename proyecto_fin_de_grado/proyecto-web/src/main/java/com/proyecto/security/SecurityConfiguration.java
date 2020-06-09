package com.proyecto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
		//.passwordEncoder(passwordEncoder()) para contraseñas encriptadas
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		 http.csrf().disable()
		 /*.authorizeRequests()
		 		.antMatchers("/rest/**")
		 		.authenticated()
		 		.and().httpBasic()
		 		.authenticationEntryPoint(getBasicAuthEntryPoint())
		 		
		 .and()*/
		 .authorizeRequests()
         	.antMatchers("/css/**").permitAll()
         	.antMatchers("/js/**").permitAll()
         	.antMatchers("/images/**").permitAll()
         	.antMatchers("/assets/**").permitAll()
         	.antMatchers("/login*").permitAll()
         	.antMatchers("/register*").permitAll()
         	.antMatchers("/CaptchaServlet*").permitAll()
         
		 .and().authorizeRequests()
         .anyRequest().authenticated()
         .and()
		 	.authorizeRequests()
		 	.antMatchers("/update").access("hasAuthority('ROLE_USER')")
         .and()
         .formLogin()
         	 .loginPage("/login").permitAll() 
             .usernameParameter("mail")
             .passwordParameter("pass")
             .defaultSuccessUrl("/", true)
             .permitAll()
         .and()
             .logout()
             .logoutUrl("/logout")
             .invalidateHttpSession(true)
             .logoutSuccessUrl("/")
             .deleteCookies("JSESSIONID");
	}

	/*@Bean
	public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
		return new CustomBasicAuthenticationEntryPoint();
	}*/

	/* To allow Pre-flight [OPTIONS] request from browser */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.debug(true).ignoring().antMatchers("/images").and().ignoring().antMatchers("/css").and().ignoring()
				.antMatchers("/js");
	}

	/*@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}*/
/*
	@Configuration
	@Order(2)
	public static class LoginFormSecurityConfig extends WebSecurityConfigurerAdapter {
		@Autowired
		private PasswordEncoder passwordEncoder;
		@Autowired
		public void configureInMemoryAuthentication(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("admin@123#"))
					.roles("ADMIN");
		}
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable().antMatcher("/**").authorizeRequests().antMatchers("/resources/**").permitAll()
					.antMatchers("/**").hasRole("ADMIN").and().formLogin();
			http.sessionManagement().maximumSessions(1).expiredUrl("/login?expired=true");
		}
	}*/

}