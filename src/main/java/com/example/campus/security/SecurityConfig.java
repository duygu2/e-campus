package com.example.campus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.campus.security.ApplicationUserPermission.*;
import static com.example.campus.security.ApplicationUserRole.*;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final PasswordEncoder passwordEncoder;

  @Autowired
  public SecurityConfig(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
      httpSecurity
              .csrf().disable()
              .authorizeRequests()
              .antMatchers( "/departments/**").hasAnyRole(ADMIN.name(), FACULTY.name(), DEPARTMENT.name())
              .antMatchers(HttpMethod.GET,"/departments/**").hasAnyAuthority(DEPARTMENT_READ.name(),FACULTY_READ.name())
              .antMatchers(HttpMethod.PUT,"/departments/**").hasAnyAuthority(DEPARTMENT_WRITE.name(),FACULTY_WRITE.name())
              .antMatchers(HttpMethod.DELETE,"/departments/**").hasAnyAuthority(DEPARTMENT_WRITE.name(),FACULTY_WRITE.name())

              //.antMatchers(HttpMethod.PUT,"/students/**").hasAnyAuthority(DEPARTMENT_READ.name(),FACULTY_READ.name(),ADMIN.name())
              //.antMatchers(HttpMethod.DELETE,"/students/**").hasAnyAuthority(DEPARTMENT_WRITE.name(),FACULTY_WRITE.name(),ADMIN.name())
              //.antMatchers(HttpMethod.GET,"/students/**").hasAnyAuthority(DEPARTMENT_READ.name(),FACULTY_READ.name(),ADMIN.name())

                         //.antMatchers(HttpMethod.POST,"/departments/**").hasAuthority(D  epartment_write))
              .anyRequest()
              .authenticated()
              .and()
              .httpBasic();


    httpSecurity.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Override
  @Bean
  protected UserDetailsService userDetailsService(){
    UserDetails student = User.builder()
            .username("duygu")
            .password(passwordEncoder.encode("123"))
           // .roles(STUDENT.name())//ROLE_STUDENT
            .authorities(STUDENT.getGrantedAuthorities())
            .build();

    UserDetails admin=  User.builder()
              .username("nisa")
              .password(passwordEncoder.encode("123"))
              //.roles(ADMIN.name())
              .authorities(ADMIN.getGrantedAuthorities())
              .build();

    UserDetails teacher=  User.builder()
            .username("teacher")
            .password(passwordEncoder.encode("123"))
            //.roles(TEACHER.name())
            .authorities(TEACHER.getGrantedAuthorities())
            .build();

    UserDetails department = User.builder()
            .username("department")
            .password(passwordEncoder.encode("123"))
            .authorities(DEPARTMENT.getGrantedAuthorities())
            .build();

    UserDetails faculty= User.builder()
            .username("faculty")
            .password(passwordEncoder.encode("123"))
            .authorities(FACULTY.getGrantedAuthorities())
            .build();

    UserDetails HR = User.builder()
            .username("HR")
            .password(passwordEncoder.encode("123"))
            .authorities(ApplicationUserRole.HR.getGrantedAuthorities())
            .build();

    UserDetails SA = User.builder()
            .username("SA")
            .password(passwordEncoder.encode("123"))
            .authorities(STUDENT_AFFAIR.getGrantedAuthorities())
            .build();


    return new InMemoryUserDetailsManager(
            student,
            admin,
            teacher,
            department,
            faculty,
            HR,
            SA
    );
  }
}
