package org.task.mint.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("org.task.mint")
public class AppConfig implements WebMvcConfigurer {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String jdbcUser;

    @Value("${spring.datasource.password}")
    private String jdbcPassword;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${connection.pool.initialPoolSize}")
    private String initialPoolSize;

    @Value("${connection.pool.minPoolSize}")
    private String minPoolSize;

    @Value("${connection.pool.maxPoolSize}")
    private String maxPoolSize;

    @Value("${connection.pool.maxIdleTime}")
    private String maxIdleTime;

    @Value("${hibernate.dialect}")
    private String dialect;

    @Value("${hibernate.show_sql}")
    private String showSql;

    @Value("${hibernate.packagesToScan}")
    private String packagesToScan;

    @Autowired
    private Environment env;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public DataSource myDataSource() {
        // create connection pool
        ComboPooledDataSource myDataSource = new ComboPooledDataSource();

        // set the jdbc driver
        try {
            myDataSource.setDriverClass(driverClassName);
        } catch (PropertyVetoException exc) {
            throw new RuntimeException(exc);
        }

        // for sanity's sake, let's log url and user ... just to make sure we are reading the data
        logger.info("jdbc.url=" + dataSourceUrl);
        logger.info("jdbc.user=" + jdbcUser);

        // set database connection props
        myDataSource.setJdbcUrl(dataSourceUrl);
        myDataSource.setUser(jdbcUser);
        myDataSource.setPassword(jdbcPassword);

        // set connection pool props
        myDataSource.setInitialPoolSize(getIntProperty(initialPoolSize));
        myDataSource.setMinPoolSize(getIntProperty(minPoolSize));
        myDataSource.setMaxPoolSize(getIntProperty(maxPoolSize));
        myDataSource.setMaxIdleTime(getIntProperty(maxIdleTime));

        return myDataSource;
    }

    private Properties getHibernateProperties() {
        // set hibernate properties
        Properties props = new Properties();

        props.setProperty("hibernate.dialect", dialect);
        props.setProperty("hibernate.show_sql", showSql);

        return props;
    }


    // need a helper method
    // read environment property and convert to int
    private int getIntProperty(String propVal) {
        // now convert to int
        int intPropVal = Integer.parseInt(propVal);

        return intPropVal;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        // create session factories
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        // set the properties
        sessionFactory.setDataSource(myDataSource());
        sessionFactory.setPackagesToScan(packagesToScan);
        sessionFactory.setHibernateProperties(getHibernateProperties());

        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        // setup transaction manager based on session factory
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

}









