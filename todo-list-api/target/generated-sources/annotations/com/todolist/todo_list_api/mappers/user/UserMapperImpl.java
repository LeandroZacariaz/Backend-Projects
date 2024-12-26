package com.todolist.todo_list_api.mappers.user;

import com.todolist.todo_list_api.domain.User;
import com.todolist.todo_list_api.domain.enums.RoleUserEnum;
import com.todolist.todo_list_api.dto.todo.ToDoDetailDto;
import com.todolist.todo_list_api.dto.user.UserDto;
import com.todolist.todo_list_api.dto.user.UserRegisterDto;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-26T08:33:45-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User UserRegisterDtoToUser(UserRegisterDto userRegisterDto) {
        if ( userRegisterDto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userRegisterDto.email() );
        user.setName( userRegisterDto.name() );
        user.setPassword( userRegisterDto.password() );

        return user;
    }

    @Override
    public UserDto UserToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        Long id_user = null;
        String name = null;
        String email = null;
        RoleUserEnum role = null;

        id_user = user.getId_user();
        name = user.getName();
        email = user.getEmail();
        role = user.getRole();

        List<ToDoDetailDto> toDos = toDosToToDoDetailDtos(user.getTodos());

        UserDto userDto = new UserDto( id_user, name, email, role, toDos );

        return userDto;
    }
}
