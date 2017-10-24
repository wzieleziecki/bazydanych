package pl.edu.agh.bazydanych2017;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import pl.edu.agh.bazydanych2017.dao.JdbcBazydanych2017Dao;
import pl.edu.agh.bazydanych2017.dao.JdbcDao;
import javax.sql.DataSource;

@Configuration
@PropertySource (value = { "classpath:application.properties" })
public class DatabaseConfiguration {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Primary
    @Bean
    public DataSource dataSource(){
        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName(driverClassName);
        source.setUrl(url);
        source.setUsername(username);
        source.setPassword(password);
        return source;
    }

    @Bean
    public JdbcDao jdbcBazydanych2017Dao(){
        return new JdbcBazydanych2017Dao();
    }
}
