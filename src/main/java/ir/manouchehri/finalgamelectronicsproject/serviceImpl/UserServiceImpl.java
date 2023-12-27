package ir.manouchehri.finalgamelectronicsproject.serviceImpl;

import ir.manouchehri.finalgamelectronicsproject.domain.User;
import ir.manouchehri.finalgamelectronicsproject.dto.UserDto;
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
        User user = userRepository.save(userDtoMapper.userDtoToUser(userDto));
        return userDtoMapper.userToUserDto(user);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        Optional<User> user = userRepository.findById(id);
        user.get().setMobilePhone(userDto.getMobilePhone());
        user.get().setPassword(userDto.getPassword());
        return userDtoMapper.userToUserDto(userRepository.save(user.get()));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto getUser(Long id) {
        return userDtoMapper.userToUserDto(userRepository.getUser(id));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userDtoMapper.listOfUserToListOfUserDto(userRepository.getAllUsers());
    }
}
