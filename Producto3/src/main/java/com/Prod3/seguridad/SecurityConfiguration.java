package com.Prod3.seguridad;

import com.Prod3.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired(required = true)
    private UsuarioServicio usuarioServicio;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(usuarioServicio);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception  {
        auth.authenticationProvider(authenticationProvider());

    }

  /*  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(
                        "/registro**",
                        "/js/**",
                        "/css/**",
                        "/img/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }

 */
  String[] resources = new String[]{
          "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
  };
  @Override
  protected void configure(HttpSecurity http) throws Exception {

      http
              .authorizeRequests()
              .antMatchers(resources).permitAll()
              .antMatchers("/login*").permitAll()
              .antMatchers("/registro*").access("hasRole('ROLE_ADMIN')")
              .antMatchers("/index*").permitAll()
              .antMatchers("/clientes*").access("hasRole('ROLE_ADMIN')")
              .antMatchers("/vehiculos*").access("hasRole('ROLE_ADMIN')")
              .antMatchers("/alquileres*").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
              .anyRequest().authenticated()
              .and()
              .formLogin()
              .loginPage("/login")
              .permitAll()
              .and()
              .logout()
              .clearAuthentication(true)
              .permitAll()
              .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
              .logoutSuccessUrl("/login?logout");

  }




}
