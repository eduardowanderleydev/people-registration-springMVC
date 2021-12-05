package br.com.eduardowanderley.personregistration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableConfigurationProperties
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {

    private static final String ROLE_ADMIN = "ADMIN";

    @Autowired
    private UserDetailServiceImp detailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()// disable default configurations
                .authorizeRequests().antMatchers(HttpMethod.GET, "/*").permitAll() // any user can access index page
                .antMatchers(HttpMethod.POST, "/h2-console").hasAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.POST, "/person/save").hasAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, "/person/delete/*").hasAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.POST, "/phones/save/*").hasAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, "/phones/delete/*").hasAuthority(ROLE_ADMIN)
                .anyRequest().authenticated().and().formLogin().permitAll() // allow any user to submit login form
                .loginPage("/login")
                .defaultSuccessUrl("/person/register")
                .failureUrl("/login/?error=true")
                .and()
                .logout().logoutSuccessUrl("/login")// maps logout URL and invalidates authenticated user
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override // create user authentication using database or in memory
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detailService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
