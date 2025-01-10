package com.example.todolist_api2.service.todo;

import com.example.todolist_api2.domain.ToDo;
import com.example.todolist_api2.domain.User;
import com.example.todolist_api2.dto.todo.ToDoCreateDto;
import com.example.todolist_api2.dto.todo.ToDoDto;
import com.example.todolist_api2.exceptions.ResourceNotFoundException;
import com.example.todolist_api2.mappers.todo.ToDoMapper;
import com.example.todolist_api2.repository.ToDoRepository;
import com.example.todolist_api2.service.auth.AuthService;
import com.example.todolist_api2.service.user.UserService;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class ToDoServiceImpl implements ToDoService {
   private ToDoMapper toDoMapper;
   private ToDoRepository toDoRepository;
   private UserService userService;
   private AuthService authService;

   public ToDoDto createToDo(ToDoCreateDto toDoCreateDto) {
      ToDo toDoCreated = this.toDoMapper.toDoCreateDtoToToDo(toDoCreateDto);
      User userLogged = this.userService.getLoggingInUser();
      toDoCreated.setUser(userLogged);
      return this.toDoMapper.toDoToToDoDto((ToDo)this.toDoRepository.save(toDoCreated));
   }

   public Page<ToDoDto> getAllToDos(int page, int limit) {
      String currentUserEmail = this.authService.getCurrentUserEmail();
      Pageable pageable = PageRequest.of(page - 1, limit);
      return this.toDoRepository.findByUser_Email(currentUserEmail, pageable).map((t) -> {
         return this.toDoMapper.toDoToToDoDto(t);
      });
   }

   public ToDo getToDoById(Long id_toDo) {
      return (ToDo)this.toDoRepository.findById(id_toDo).orElseThrow(() -> {
         return new ResourceNotFoundException("ToDo not found.");
      });
   }

   public void deleteToDo(Long id_toDo) {
      ToDo toDoDelete = this.getToDoById(id_toDo);
      String currentUserEmail = this.authService.getCurrentUserEmail();
      if (toDoDelete.getUser().getEmail().equals(currentUserEmail)) {
         this.toDoRepository.deleteById(id_toDo);
      } else {
         throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Forbidden");
      }
   }

   public ToDoDto updateToDo(Long id_toDo, ToDoCreateDto toDoCreateDto) {
      ToDo toDoUpdate = this.getToDoById(id_toDo);
      String currentUserEmail = this.authService.getCurrentUserEmail();
      if (!toDoUpdate.getUser().getEmail().equals(currentUserEmail)) {
         throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Forbidden");
      } else {
         toDoUpdate.setTitle(toDoCreateDto.title());
         toDoUpdate.setDescription(toDoCreateDto.description());
         return this.toDoMapper.toDoToToDoDto((ToDo)this.toDoRepository.save(toDoUpdate));
      }
   }

}
