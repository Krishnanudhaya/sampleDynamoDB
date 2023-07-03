package com.yadacode.dynamodbpoc.model.student;

import org.socialsignin.spring.data.dynamodb.config.EnableDynamoDBAuditing;
import org.socialsignin.spring.data.dynamodb.mapping.DynamoDBMappingContext;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
@EnableDynamoDBAuditing(auditorAwareRef = "userAuditing", dateTimeProviderRef = "dateAuditing")
//@EnableDynamoDBRepositories(basePackages = "com.yadacode.dynamodbpoc")
public class PersistenceConfiguration {

    @Bean
    public AuditorAware<String> userAuditing() {
        return () -> Optional.of("TestUser"); //get username from SecurityContext
    }

    @Bean
    public DateTimeProvider dateAuditing() {
        return CurrentDateTimeProvider.INSTANCE;
    }

    @Bean
    public DynamoDBMappingContext dynamoDBMappingContext() {
        DynamoDBMappingContext mappingContext = new DynamoDBMappingContext();

        //add your 'entities' manually 
        mappingContext.getPersistentEntity(Student.class);

        return mappingContext;
   }

    // do further configuration stuff...
}