package ir.manouchehri.finalgamelectronicsproject.testController;

import ir.manouchehri.finalgamelectronicsproject.controller.UserController;
import ir.manouchehri.finalgamelectronicsproject.domain.User;
import ir.manouchehri.finalgamelectronicsproject.dto.UserDto;
import ir.manouchehri.finalgamelectronicsproject.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @MockBean
    private UserService userService;

    //@Autowired
    //private MockMvc mockMvc;

    private User user;

    private UserDto userDto;

    @BeforeEach
    void setUp() throws Exception {
        user = new User();
        user.setMobilePhone("09215960799");
        user.setPassword("123456");

        userDto = new UserDto();
        userDto.setMobilePhone("09215960799");
        userDto.setPassword("123456");
    }

    @Test
    void AddUserSuccesFully() throws Exception {
//        Mockito.when(userService.addUser(userDto)).thenReturn(userDto);
//        mockMvc.perform(post("/user/addUser")
//                .contentType(MediaType.APPLICATION_JSON)
//                        .content());
//                .andExpect(status().is2xxSuccessful());
    }

}
