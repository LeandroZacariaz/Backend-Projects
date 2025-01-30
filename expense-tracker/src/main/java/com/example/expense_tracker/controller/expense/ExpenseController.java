package com.example.expense_tracker.controller.expense;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense_tracker.dto.expense.ExpenseCreateDto;
import com.example.expense_tracker.dto.expense.ExpenseDto;
import com.example.expense_tracker.service.expense.ExpenseService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/expense")
@AllArgsConstructor
public class ExpenseController {

    private ExpenseService expenseService;

    @PostMapping()
    public ResponseEntity<?> createExpense(@RequestBody @Valid ExpenseCreateDto expenseCreateDto){
        ExpenseDto expenseDto=expenseService.createExpense(expenseCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(expenseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable("id") Long id_expense){
        expenseService.deleteExpense(id_expense);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<?> getAllExpenses(@RequestParam(defaultValue = "1") int page,
                                            @RequestParam(defaultValue = "10") int limit,
                                            @RequestParam(required = false) String categoryName) {
    Page<ExpenseDto> expensesPage = expenseService.getAllExpenses(page, limit, categoryName);
    return ResponseEntity.ok().body(Map.of(
            "data", expensesPage.getContent(),
            "page", page,
            "limit", limit,
            "total", expensesPage.getTotalElements()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpense(@PathVariable("id") Long id_expense, 
                                            @RequestBody @Valid ExpenseCreateDto expenseCreateDto){
        ExpenseDto expenseUpdated=expenseService.updateExpense(id_expense, expenseCreateDto);
        return ResponseEntity.ok().body(expenseUpdated);
    }

    @GetMapping("/sumary")
    public ResponseEntity<?> sumaryExpenses(){
        Map<String, Object> sumary=expenseService.getExpensesSummary();
        return ResponseEntity.ok().body(sumary);
    }

    @GetMapping("/sumary/{month}")
    public ResponseEntity<?> getMonthlyExpensesSummary(@PathVariable("month") int month) {
        Map<String, Object> summary = expenseService.getMonthlyExpensesSummary(month);
        return ResponseEntity.ok().body(summary);
    }


}
