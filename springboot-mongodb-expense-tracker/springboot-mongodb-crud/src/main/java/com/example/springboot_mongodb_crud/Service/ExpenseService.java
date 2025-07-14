package com.example.springboot_mongodb_crud.Service;

import com.example.springboot_mongodb_crud.Model.Expense;
import com.example.springboot_mongodb_crud.Model.expenseCat;
import com.example.springboot_mongodb_crud.Repositiory.ExpenseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
     ExpenseRepo expenseRepo;

    public void adde(Expense expense) {
         expenseRepo.save(expense);
    }

    public void del(String id) {
        expenseRepo.deleteById(id);
    }

    public List<Expense> getAll() {
       return expenseRepo.findAll();
    }

    public int getEOT(){
        LocalDate today = LocalDate.now();

        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end= today.atTime(23, 59, 59);

        List<Expense> expenseList = expenseRepo.findByCreatedAtBetween(start,end);

        int sum = expenseList.stream().mapToInt(Expense::getAmount).sum();

         return sum;
    }

    public int getEOM() {
        YearMonth currentMonth = YearMonth.now();
        LocalDateTime start = currentMonth.atDay(1).atStartOfDay();
        LocalDateTime end = currentMonth.atEndOfMonth().atTime(23,59,59);

        List<Expense> expenseList = expenseRepo.findByCreatedAtBetween(start,end);

        int sum = expenseList.stream().mapToInt(Expense::getAmount).sum();
        return sum;
    }

    public int getEOY() {

          LocalDateTime start = LocalDateTime.of(LocalDateTime.now().getYear(),1,1,0,0,0);
          LocalDateTime end = LocalDateTime.of(LocalDateTime.now().getYear(),12,31,23,59,59);

          List<Expense> expenseList = expenseRepo.findByCreatedAtBetween(start,end);

        int sum = expenseList.stream().mapToInt(Expense::getAmount).sum();
        return sum;
    }

    public int getBYCatToday(expenseCat expensecat) {

        LocalDate today = LocalDate.now();

        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end= today.atTime(23, 59, 59);

        List<Expense> expenseList = expenseRepo.findByCreatedAtBetweenAndExpenseCat(start,end,expensecat);

        int sum = expenseList.stream().mapToInt(Expense::getAmount).sum();
        return sum;
    }

    public int getBYCatMonth(expenseCat expensecat) {

        YearMonth currentMonth = YearMonth.now();
        LocalDateTime start = currentMonth.atDay(1).atStartOfDay();
        LocalDateTime end = currentMonth.atEndOfMonth().atTime(23,59,59);

        List<Expense> expenseList = expenseRepo.findByCreatedAtBetweenAndExpenseCat(start,end,expensecat);

        int sum = expenseList.stream().mapToInt(Expense::getAmount).sum();
        return sum;
    }

    public int getByCatYear(expenseCat expensecat) {

        LocalDateTime start = LocalDateTime.of(LocalDateTime.now().getYear(),1,1,0,0,0);
        LocalDateTime end = LocalDateTime.of(LocalDateTime.now().getYear(),12,31,23,59,59);

        List<Expense> expenseList = expenseRepo.findByCreatedAtBetweenAndExpenseCat(start,end,expensecat);

        int sum = expenseList.stream().mapToInt(Expense::getAmount).sum();

        return sum;
    }
}
