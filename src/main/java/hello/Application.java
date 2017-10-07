package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Application.class, args);
    }

    @Bean(initMethod="start",destroyMethod="stop")
    public org.h2.tools.Server h2WebConsonleServer () throws SQLException {
        return org.h2.tools.Server.createWebServer("-web", "-webAllowOthers", "-webDaemon", "-webPort", "8082");
    }
}
