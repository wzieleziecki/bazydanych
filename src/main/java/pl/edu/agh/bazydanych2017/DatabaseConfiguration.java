package pl.edu.agh.bazydanych2017;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.agh.bazydanych2017.dao.JdbcBazydanych2017Dao;
import pl.edu.agh.bazydanych2017.dao.JdbcDao;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public JdbcDao jdbcBazydanych2017Dao(){
        return new JdbcBazydanych2017Dao();
    }
}
