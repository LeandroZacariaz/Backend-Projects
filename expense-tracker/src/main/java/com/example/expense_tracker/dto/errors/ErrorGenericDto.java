package com.example.expense_tracker.dto.errors;

import java.util.List;
import java.util.Map;

public record ErrorGenericDto(String message, List<Map<String, String>> errors) {

}
