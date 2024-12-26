package com.todolist.todo_list_api.mappers.todo;

import com.todolist.todo_list_api.domain.ToDo;
import com.todolist.todo_list_api.dto.todo.ToDoCreateDto;
import com.todolist.todo_list_api.dto.todo.ToDoDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-26T08:33:45-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class ToDoMapperImpl implements ToDoMapper {

    @Override
    public ToDo toDoCreateDtoToToDo(ToDoCreateDto toDoCreateDto) {
        if ( toDoCreateDto == null ) {
            return null;
        }

        ToDo toDo = new ToDo();

        toDo.setDescription( toDoCreateDto.description() );
        toDo.setTitle( toDoCreateDto.title() );

        return toDo;
    }

    @Override
    public ToDoDto toDoToToDoDto(ToDo toDo) {
        if ( toDo == null ) {
            return null;
        }

        Long id_todo = null;
        String title = null;
        String description = null;

        id_todo = toDo.getId_todo();
        title = toDo.getTitle();
        description = toDo.getDescription();

        ToDoDto toDoDto = new ToDoDto( id_todo, title, description );

        return toDoDto;
    }
}
