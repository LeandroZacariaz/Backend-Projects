package com.example.todolist_api2.controller.todo;


import com.example.todolist_api2.dto.todo.ToDoCreateDto;
import com.example.todolist_api2.dto.todo.ToDoDto;
import com.example.todolist_api2.mappers.todo.ToDoMapper;
import com.example.todolist_api2.service.todo.ToDoService;
import jakarta.validation.Valid;
import java.util.Map;

import lombok.AllArgsConstructor;
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

@RestController
@RequestMapping({"/api/v1/todo"})
@AllArgsConstructor
public class ToDoController {
   private ToDoService toDoService;
   private ToDoMapper toDoMapper;

   @PostMapping
   public ResponseEntity<?> createToDo(@RequestBody @Valid ToDoCreateDto toDoCreateDto) {
      ToDoDto toDoDto = this.toDoService.createToDo(toDoCreateDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(toDoDto);
   }

   @PutMapping({"/{id}"})
   public ResponseEntity<?> updateToDo(@PathVariable("id") Long id_toDo, @RequestBody @Valid ToDoCreateDto toDoCreateDto) {
      ToDoDto toDoUpdated = this.toDoService.updateToDo(id_toDo, toDoCreateDto);
      return ResponseEntity.ok().body(toDoUpdated);
   }

   @GetMapping
   public ResponseEntity<?> getAllToDos(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
      Page<ToDoDto> toDosPage = this.toDoService.getAllToDos(page, limit);
      return ResponseEntity.ok().body(Map.of("data", toDosPage.getContent(), "page", page, "limit", limit, "total", toDosPage.getTotalElements()));
   }

   @GetMapping({"/{id}"})
   public ResponseEntity<?> getToDoById(@PathVariable("id") Long id_toDo) {
      ToDoDto toDoDto = this.toDoMapper.toDoToToDoDto(this.toDoService.getToDoById(id_toDo));
      return ResponseEntity.ok().body(toDoDto);
   }

   @DeleteMapping({"/{id}"})
   public ResponseEntity<?> deleteToDo(@PathVariable("id") Long id_toDo) {
      this.toDoService.deleteToDo(id_toDo);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }

}