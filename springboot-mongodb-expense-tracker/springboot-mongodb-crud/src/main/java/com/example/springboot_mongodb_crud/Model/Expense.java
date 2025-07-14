package com.example.springboot_mongodb_crud.Model;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Document("expense")
@Data
public class Expense {

    @Id
    @Generated
    private String id;
    @Field(name = "Name")
    private String ExpenseName;
    @Field(name ="Cat")
    private expenseCat expenseCat;
    @Field(name = "Amount")
    private int amount;
    @CreatedBy
    private LocalDateTime createdAt;

}
