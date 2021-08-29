package com.github.shoothzj.distribute.job.impl.quartz.postgre;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * @author hezhangjian
 */
@Service
@EnableJpaRepositories(basePackages = "com.github.shoothzj.distribute.job.impl.quartz.postgre.dao")
@Configuration
public class BootService {

    @Bean
    public DataSource dataSource() {
        UnpooledDataSource unpooledDataSource = new UnpooledDataSource("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1:5432/timer", "postgres", "Password");
        return new PooledDataSource(unpooledDataSource);
    }

    @Bean(name = "entityManagerFactory")
    LocalSessionFactoryBean entityManagerFactory(@Autowired DataSource dataSource) {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan("com.github.shoothzj.distribute.job.impl.quartz.postgre.dao");
        return sessionFactoryBean;
    }

}
