package com.example.springboot_mongodb_crud.Repositiory;

import com.example.springboot_mongodb_crud.Model.Expense;
import com.example.springboot_mongodb_crud.Model.expenseCat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@EnableMongoRepositories
public interface ExpenseRepo extends MongoRepository<Expense, String> {

    List<Expense> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

    List<Expense> findByCreatedAtBetweenAndExpenseCat(LocalDateTime start, LocalDateTime end, expenseCat expenseCat);


}

