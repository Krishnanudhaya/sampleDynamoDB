package com.yadacode.dynamodbpoc.model.student;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class LocalDateTimeConverter implements DynamoDBTypeConverter<String, Date> {
//    @Override
//    public String convert(final LocalDateTime time) {
//        System.out.println("hi convert");
//        return time.toString();
//    }
//
//    @Override
//    public LocalDateTime unconvert(final String stringValue) {
//
//        System.out.println("hi unconvert");
//        return LocalDateTime.parse(stringValue);
//    }

    @Override
    public String convert(Date date) {
        // Convert java.util.Date to String in a format that can be persisted in DynamoDB
        // For example, you can use ISO 8601 format
        System.out.println("hi convert");
        return date.toInstant().toString();
    }

    @Override
    public Date unconvert(String dateString) {
        // Convert the persisted String back to java.util.Date
        // Parse the String using the same format as used in the convert() method
        System.out.println("hi unconvert");
        return Date.from(Instant.parse(dateString));
    }
}