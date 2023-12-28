package ir.manouchehri.finalgamelectronicsproject.serviceImpl;

import ir.manouchehri.finalgamelectronicsproject.domain.User;
import ir.manouchehri.finalgamelectronicsproject.dto.UserDto;
import ir.manouchehri.finalgamelectronicsproject.exceptions.AddUserException;
import ir.manouchehri.finalgamelectronicsproject.exceptions.DeleteUserException;
import ir.manouchehri.finalgamelectronicsproject.exceptions.FindUserException;
import ir.manouchehri.finalgamelectronicsproject.exceptions.UpdateUserException;
import ir.manouchehri.finalgamelectronicsproject.mapper.UserDtoMapper;
import ir.manouchehri.finalgamelectronicsproject.repository.UserRepository;
import ir.manouchehri.finalgamelectronicsproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserDtoMapper userDtoMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserDtoMapper userDtoMapper) {
        this.userRepository = userRepository;
        this.userDtoMapper = userDtoMapper;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        try {
            User user = userRepository.save(userDtoMapper.userDtoToUser(userDto));
            return userDtoMapper.userToUserDto(user);
        } catch (Exception e) {
            throw new AddUserException();
        }
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        try {
            Optional<User> user = userRepository.findById(id);
            user.get().setMobilePhone(userDto.getMobilePhone());
            user.get().setPassword(userDto.getPassword());
            return userDtoMapper.userToUserDto(userRepository.save(user.get()));
        } catch (Exception e) {
            throw new UpdateUserException();
        }
    }

    @Override
    public void deleteUser(Long id) {
        try {
            User user = userRepository.getUser(id);
            if (user == null) {
                throw new DeleteUserException();
            }
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteUserException();
        }
    }

    @Override
    public UserDto getUser(Long id) {
        try {
            User user = userRepository.getUser(id);
            if (user == null) {
                throw new FindUserException();
            }
            return userDtoMapper.userToUserDto(user);
        } catch (Exception e) {
            throw new FindUserException();
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userDtoMapper.listOfUserToListOfUserDto(userRepository.getAllUsers());
    }
}
