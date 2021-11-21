package br.com.fatec.sorocaba.controleProducao.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ImplementsUserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").permitAll()
		.antMatchers(HttpMethod.GET, "/ordem").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/ordem").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/ordem").hasRole("LIDER")
		.antMatchers(HttpMethod.POST, "/ordem").hasRole("LIDER")
		.anyRequest().authenticated()
		.and().formLogin()
			.loginPage("/login")
			.permitAll()
			.defaultSuccessUrl("/homeLogado",true)
		.and().logout()
			.invalidateHttpSession(true)
			.logoutSuccessUrl("/home")
			.permitAll();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/img/**", "/js/**", "/scss/**", "/vendor/**");
	}

}
