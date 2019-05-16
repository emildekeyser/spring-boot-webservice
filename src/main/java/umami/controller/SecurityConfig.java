package umami.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
            .mvcMatchers("/home", "/*/home", "/").permitAll();

        http.authorizeRequests()
            .mvcMatchers(
                "/dishes/delete*",
                "/dishes/add*",
                "/dishes/update*"
            ).hasRole("ADMIN")
            .mvcMatchers("/dishes").hasAnyRole("USER", "ADMIN")
            .anyRequest().authenticated()
//            .and().httpBasic();
            .and().formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
            .logout()
            .logoutSuccessUrl("/")
            .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication().passwordEncoder(encoder)
                .withUser("gerrit").password(encoder.encode("a")).roles("USER").and()
                .withUser("emil").password(encoder.encode("b")).roles("ADMIN");
    }
}
