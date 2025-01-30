package com.example.expense_tracker.mappers.expense;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.expense_tracker.domain.Expense;
import com.example.expense_tracker.dto.expense.ExpenseCreateDto;
import com.example.expense_tracker.dto.expense.ExpenseDto;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {
    @Mapping(source = "name_category", target = "category.name")
    @Mapping(target = "date", ignore = true)
    @Mapping(target = "id_expense", ignore = true)
    @Mapping(target = "user", ignore = true)
    Expense expenseCreateDtoToExpense(ExpenseCreateDto expenseCreateDto);

    ExpenseDto expenseToExpenseDto(Expense expense);
}
