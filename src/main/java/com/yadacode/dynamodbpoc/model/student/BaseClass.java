package com.yadacode.dynamodbpoc.model.student;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.Date;

@DynamoDBDocument
public class BaseClass {

    @DynamoDBIgnore
    protected static boolean updateFlag;

    @DynamoDBAttribute
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BaseClass() {
    }

    public static class UpdatedOnAutoGenerator implements DynamoDBAutoGenerator<Date> {

        public UpdatedOnAutoGenerator() {
        }
        @Override
        public DynamoDBAutoGenerateStrategy getGenerateStrategy() {
            return DynamoDBAutoGenerateStrategy.CREATE ;
        }

        @Override
        public Date generate(Date currentValue) {
            if (updateFlag) {
                System.out.println("updateFlag value::"+new Date());
                return new Date();
            }
            System.out.println("current value::"+currentValue);
            return currentValue;
        }
    }
}
