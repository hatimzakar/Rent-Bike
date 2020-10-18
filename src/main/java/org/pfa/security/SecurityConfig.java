package org.pfa.security;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//@ComponentScan(basePackages = {"com.mycompany.web","javax.sql.DataSource"})
@Configuration 
@EnableWebSecurity
public class SecurityConfig extends  WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource datasource ;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth){ }/* throws Exception {
		/*auth.jdbcAuthentication()
		.dataSource(datasource).usersByUsernameQuery("select username  as principal ,password as credentials,active from users where username = ?")
		.authoritiesByUsernameQuery("select username as principal ,role as role  from users_roles where username=?")
		.rolePrefix("ROLE_").passwordEncoder(new BCryptPasswordEncoder());
		 BCryptPasswordEncoder bcpe=new BCryptPasswordEncoder();
		
		String n=bcpe.encode("123456");
		System.out.println(n);
		
		//super.configure(auth);
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//http.formLogin();//.loginPage("/login");
		//http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
		//http.authorizeRequests().antMatchers("/").hasRole("USER");
		
		//super.configure(http);
	}
	

}
