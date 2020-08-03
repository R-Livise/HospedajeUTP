/**
 * 
 */
package com.hospedaje.backend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hospedaje.backend.filter.JwtRequestFilter;
import com.hospedaje.backend.service.MyUserDetailService;


/**
 * @author rafael
 *
 */
	
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private MyUserDetailService myUserDetailsService;
	
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService).passwordEncoder(this.passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
				.authorizeRequests()
					.antMatchers("/login").permitAll()
//					.antMatchers("/swagger-ui.html").permitAll()
				.antMatchers("/**").permitAll()
//				.antMatchers(HttpMethod.GET,"/v1/plate/**").hasAnyRole("ADMIN","RECEP","CLIEN")
//				.antMatchers(HttpMethod.GET,"/v1/menu").permitAll()
//				.antMatchers("/v1/menu/**").hasAnyRole("ADMIN","CLIEN")
//				.antMatchers(HttpMethod.POST,"/v1/plate").hasAnyRole("ROLE_ADMIN")
//				.antMatchers(HttpMethod.POST, "/v1/employees").hasRole("ADMIN")
//			    .antMatchers(HttpMethod.PUT, "/v1/employees/**").hasRole("ADMIN")
//			    .antMatchers(HttpMethod.PATCH, "/v1/employees/**").hasRole("ADMIN")
				.anyRequest().authenticated()
//				.and().formLogin().loginPage("/login").permitAll()
//				.failureUrl("/login?error=true")
//				.defaultSuccessUrl("/swagger-ui.html")
				.and()
				.exceptionHandling()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")    // <---------- You need this
                .antMatchers(
                        "/**/*.{js,html,css,ico}",
                        "/i18n/**",
                        "/assets/**",
                        "/v2/api-docs/**",
                        "/webjars/**",
                        "/swagger-resources/**",
                        "/swagger-ui.html");
    }
	
	
	@Override
	@Bean(name = "authenticationManager") 
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}
