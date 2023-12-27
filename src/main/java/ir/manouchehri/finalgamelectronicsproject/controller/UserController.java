package ir.manouchehri.finalgamelectronicsproject.controller;

import ir.manouchehri.finalgamelectronicsproject.dto.UserDto;
import ir.manouchehri.finalgamelectronicsproject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public UserDto addProduct(@Valid @RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @PutMapping("/updateUser/{id}")
    public UserDto updateProduct(@PathVariable Long id, @Valid @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteProduct(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/getUser")
    public UserDto getProduct(@RequestParam Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/getAllUsers")
    public List<UserDto> getProduct() {
        return userService.getAllUsers();
    }
}
