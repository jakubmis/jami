package com.jami;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

/**
 * Created by Mis on 2017-07-11.
 */
@Configuration
@EnableAutoConfiguration
public class AppConfig {

//    @Bean
//    public JtaTransactionManager transactionManager(){
//        return new JtaTransactionManager();
//    }
}
