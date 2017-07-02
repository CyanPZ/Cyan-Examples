package cyan;


import cyan.dao.DepartmentsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by CPZ on 2017/6/28.
 */
@Configuration
@ComponentScan
@EnableJpaRepositories
@SpringBootApplication
public class App {
    @Autowired
    DepartmentsDAO departmentsDAO;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
