package ir.manouchehri.finalgamelectronicsproject.mapper;

import ir.manouchehri.finalgamelectronicsproject.domain.Product;
import ir.manouchehri.finalgamelectronicsproject.domain.User;
import ir.manouchehri.finalgamelectronicsproject.dto.ProductDto;
import ir.manouchehri.finalgamelectronicsproject.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

    List<UserDto> listOfUserToListOfUserDto(List<User> users);

    List<User> listOfUserDtoToListOfUser(List<UserDto> usersDto);
}
