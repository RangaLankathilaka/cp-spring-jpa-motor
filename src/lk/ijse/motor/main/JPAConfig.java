package lk.ijse.motor.main;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("file:${user.dir}/Motor - JPA/resources/application.properties")//E:\DEP\Spring motor jpa - LocalContainerEMF\Motor - JPA\resources\application.properties
public class JPAConfig {
   @Autowired
    private Environment environment;


@Bean
    public DataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(environment.getRequiredProperty("javax.persistence.jdbc.driver"));
        basicDataSource.setUrl(environment.getRequiredProperty("javax.persistence.jdbc.url"));
        basicDataSource.setUsername(environment.getRequiredProperty("javax.persistence.jdbc.user"));
        basicDataSource.setPassword(environment.getRequiredProperty("javax.persistence.jdbc.password"));

        basicDataSource.setInitialSize(environment.getRequiredProperty("hibernate.init_size",Integer.class));
        basicDataSource.setMaxTotal(environment.getRequiredProperty("hibernate.max_total",Integer.class));
        basicDataSource.setMaxIdle(environment.getRequiredProperty("hibernate.max_total",Integer.class));

        return basicDataSource;

    }


    @Bean
    public JpaVendorAdapter vendorAdapter(){
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabasePlatform(environment.getRequiredProperty("hibernate.dialect"));
        hibernateJpaVendorAdapter.setShowSql(environment.getRequiredProperty("hibernate.show_sql",boolean.class));
        hibernateJpaVendorAdapter.setGenerateDdl(environment.getRequiredProperty("hibernate.generate_ddl",boolean.class));


        return hibernateJpaVendorAdapter;
    }

@Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
    return new JpaTransactionManager(emf);
    }



@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource basicDataSource,JpaVendorAdapter vendorAdapter){

        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter());
        localContainerEntityManagerFactoryBean.setPackagesToScan("lk.ijse.motor.entity");

        return localContainerEntityManagerFactoryBean;

    }



}
