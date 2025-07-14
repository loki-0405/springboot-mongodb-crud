package com.example.springboot_mongodb_crud.Controller;

import com.example.springboot_mongodb_crud.Model.Expense;
import com.example.springboot_mongodb_crud.Model.expenseCat;
import com.example.springboot_mongodb_crud.Service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

      @Autowired
      ExpenseService expenseService;

      @PostMapping
    public ResponseEntity<?> addExpense(@RequestBody Expense expense){
          expense.setCreatedAt(LocalDateTime.now());
           expenseService.adde(expense);
        return ResponseEntity.status(201).body("Added Successfully");
    }
    @DeleteMapping
    public ResponseEntity<?> DeleteExpense(@PathVariable String id){
         expenseService.del(id);
         return ResponseEntity.status(204).body("Deleted Successfully");
    }
    @GetMapping("/all")
    public List<Expense> GetAllExpense(){
            return expenseService.getAll();
    }
    @GetMapping("/all/today")
    public int GetAllExpenseOfToday(){
          return  expenseService.getEOT();
    }
    @GetMapping("/All/thismonth")
    public int GetTotalExpenseOfMonth(){
          return  expenseService.getEOM();
    }

    @GetMapping("/all/thisyear")
    public int GetAllExpenseOfYear(){
        return expenseService.getEOY();
    }

    @PostMapping("/all/c/today")
    public int GetExpensesOfCatToday(@RequestParam expenseCat Cat){
        return expenseService.getBYCatToday(Cat);
    }
    @PostMapping("/all/c/thismonth")
    public int GetExpensesOfCatThisMonth(@RequestParam expenseCat Cat){
        return expenseService.getBYCatMonth(Cat);
    }
    @PostMapping("/all/c/thisyear")
    public int GetExpensesOfCatThisYear(@RequestParam expenseCat Cat){
        return  expenseService.getByCatYear(Cat);
    }



}
