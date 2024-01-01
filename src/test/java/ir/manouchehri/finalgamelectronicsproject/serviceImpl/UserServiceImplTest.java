package ir.manouchehri.finalgamelectronicsproject.serviceImpl;

import ir.manouchehri.finalgamelectronicsproject.dto.ProductDto;
import ir.manouchehri.finalgamelectronicsproject.dto.UserDto;
import ir.manouchehri.finalgamelectronicsproject.repository.UserRepository;
import ir.manouchehri.finalgamelectronicsproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    UserRepository userRepository;
    UserServiceImpl userService;

    @Autowired
    public UserServiceImplTest(UserRepository userRepository, UserServiceImpl userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Test
    void addUser() {
        int userSize = userRepository.findAll().size();
        UserDto userDto = new UserDto();
        userDto.setMobilePhone("09215960799");
        userDto.setPassword("Aa123456");
        userService.addUser(userDto);
        assertEquals(userRepository.findAll().size(), userSize + 1);
    }

    @Test
    void updateUser() {
        UserDto userDto = new UserDto();
        userDto.setMobilePhone("09547415254");
        userDto.setPassword("ABCDE");
        UserDto userDtoResult = userService.updateUser(1L,userDto);
        assertNotNull(userDtoResult);
    }

    @Test
    void deleteUser() {
        int sizeProduct = userRepository.findAll().size();
        userService.deleteUser(1L);
        assertEquals(userRepository.findAll().size(), sizeProduct - 1);
    }
}