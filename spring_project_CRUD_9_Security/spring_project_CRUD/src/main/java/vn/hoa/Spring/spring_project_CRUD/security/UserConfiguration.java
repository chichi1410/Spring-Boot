package vn.hoa.Spring.spring_project_CRUD.security;

import org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfiguration {


//    private final OrderedHiddenHttpMethodFilter hiddenHttpMethodFilter;
//
//    public UserConfiguration(OrderedHiddenHttpMethodFilter hiddenHttpMethodFilter) {
//        this.hiddenHttpMethodFilter = hiddenHttpMethodFilter;
//    }

    // tao user
    @Bean
   public InMemoryUserDetailsManager inMemoryConfiguration() {
       UserDetails hoa = User
               .withUsername("hoa")
               .password("{noop}12345")
               .roles("teacher")
               .build();
        UserDetails tuyen = User
                .withUsername("tuyen")
                .password("{noop}12345")
                .roles("manager")
                .build();
        UserDetails kieu = User
                .withUsername("kieu")
                .password("{noop}12345")
                .roles("admin")
                .build();
        return new InMemoryUserDetailsManager(hoa, tuyen , kieu);
   }

       // phan quyen
        @Bean
        public SecurityFilterChain configure(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests(
              configure -> configure
                      .requestMatchers(HttpMethod.GET , "/api/students").hasAnyRole("teacher", "manager","admin")
                      .requestMatchers(HttpMethod.GET , "/api/students/**").hasAnyRole("teacher", "manager" , "admin")
                      .requestMatchers(HttpMethod.POST , "/api/students").hasAnyRole("admin", "manager") // add student
                      .requestMatchers(HttpMethod.PUT , "/api/students").hasAnyRole("admin", "manager")  // upadate student
                      .requestMatchers(HttpMethod.DELETE , "/api/students/**").hasRole("admin") // delete student
            );

            http.httpBasic(Customizer.withDefaults());
            http.csrf(csrf->csrf.disable());
            return http.build();
        }
}
