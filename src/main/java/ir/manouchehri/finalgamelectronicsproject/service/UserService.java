package ir.manouchehri.finalgamelectronicsproject.service;

import ir.manouchehri.finalgamelectronicsproject.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto);

    UserDto updateUser(Long id, UserDto UserDto);

    void deleteUser(Long id);

    UserDto getUser(Long id);

    List<UserDto> getAllUsers();
}
