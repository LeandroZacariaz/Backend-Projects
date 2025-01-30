package com.example.expense_tracker.dto.expense;

public record ExpenseDto(
    Long id_expense,
    String name,
    String description,
    Double amount
) {

}
