package com.yadacode.dynamodbpoc.model.student;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDTO extends BaseClass {

    private String studentId;
    private String firstName;
    private String lastName;
    private Date createdOnTime;
    private Date updatedOnTime;

}
