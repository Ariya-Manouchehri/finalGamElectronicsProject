package ir.manouchehri.finalgamelectronicsproject.serviceImpl;

import ir.manouchehri.finalgamelectronicsproject.domain.User;
import ir.manouchehri.finalgamelectronicsproject.dto.ProductDto;
import ir.manouchehri.finalgamelectronicsproject.dto.UserDto;
import ir.manouchehri.finalgamelectronicsproject.repository.UserRepository;
import ir.manouchehri.finalgamelectronicsproject.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Test
    void addUser() {
        User input = new User();
        input.setPassword("123456");
        input.setMobilePhone("0990026232");

        User output =  new User();

        output.setId(1L);
        output.setPassword("123456");
        output.setMobilePhone("0990026232");

        Mockito.when(userRepository.save(input)).thenReturn(output);

        Assertions.assertEquals(userRepository.save(input), output);
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