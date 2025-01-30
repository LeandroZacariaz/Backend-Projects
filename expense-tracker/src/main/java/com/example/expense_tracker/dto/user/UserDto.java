package com.example.expense_tracker.dto.user;

import java.util.List;

import com.example.expense_tracker.domain.enums.RoleEnumUser;
import com.example.expense_tracker.dto.expense.ExpenseDto;

public record UserDto(
    Long id_user,
    String name,
    String email,
    RoleEnumUser role,
    List<ExpenseDto> expenses
) {

}
