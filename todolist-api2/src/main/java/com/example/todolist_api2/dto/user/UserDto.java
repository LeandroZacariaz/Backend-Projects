package com.example.todolist_api2.dto.user;

import java.util.List;

import com.example.todolist_api2.domain.enums.RoleUserEnum;
import com.example.todolist_api2.dto.todo.ToDoDetailDto;

public record UserDto(Long id_user, String name, String email, RoleUserEnum role, List<ToDoDetailDto> toDos) {

}
