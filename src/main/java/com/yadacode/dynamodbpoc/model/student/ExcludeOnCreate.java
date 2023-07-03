package com.yadacode.dynamodbpoc.model.student;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcludeOnCreate {
}
