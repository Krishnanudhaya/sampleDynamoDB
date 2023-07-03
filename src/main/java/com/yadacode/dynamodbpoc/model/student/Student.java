package com.yadacode.dynamodbpoc.model.student;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@DynamoDBTable(tableName = "student2")
//@Data

public class Student  extends BaseClass{

    @DynamoDBHashKey(attributeName = "studentId")
    @DynamoDBAutoGeneratedKey
    protected String studentId;

    @DynamoDBAttribute
    private String firstName;

    @DynamoDBAttribute
    private String lastName;

//    @CreatedDate
//    @DynamoDBAttribute
//    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
//    private LocalDateTime createdOn;

//    @CreatedBy
//    @DynamoDBAttribute
//    private String createdBy;

//    @LastModifiedDate
//    @DynamoDBAttribute
//    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
//    private Date updatedOn;

//    @LastModifiedBy
//    @DynamoDBAttribute
//    private String updatedBy;

    @DynamoDBAutoGeneratedTimestamp(strategy=DynamoDBAutoGenerateStrategy.CREATE)
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    private Date createdOnTime;

    //@DynamoDBAutoGenerated(generator = DynamoDBManager.ExcludeOnCreateAutoGenerate.class)
    //@DynamoDBAutoGeneratedTimestamp(strategy=DynamoDBAutoGenerateStrategy.ALWAYS)
    @DynamoDBAutoGenerated(generator = UpdatedOnAutoGenerator.class)
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    private Date updatedOnTime;

    /*@DynamoDBAutoGenerated(generator = UpdatedOnAutoGenerator.class)
    @DynamoDBAttribute
    @AutoGenerateUpdatedOn
    public Date getUpdatedOn() {
        return updatedOn;
    }*/

    public Date getUpdatedOnTime() {
        return updatedOnTime;
    }

    public void setUpdatedOnTime(Date updatedOnTime) {
        this.updatedOnTime = updatedOnTime;
    }

    public Date getCreatedOnTime() {
        return createdOnTime;
    }

    public void setCreatedOnTime(Date createdOnTime) {
        this.createdOnTime = createdOnTime;
    }

    public Student() {
    }

    public Student(String studentId) {
   this.studentId=studentId;
    }




    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        updateFlag=false;
        if(Objects.nonNull(studentId))
        updateFlag=true;
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }*/
}