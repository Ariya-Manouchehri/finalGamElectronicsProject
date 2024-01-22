package ir.manouchehri.finalgamelectronicsproject.repository;

import ir.manouchehri.finalgamelectronicsproject.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    User user;

    @BeforeEach
    void setup() {
        user = new User();
        user.setId(1L);
        user.setMobilePhone("09215960799");
        user.setPassword("Ariya123456");
    }

    @Test
    void getUser() {
        //given
        userRepository.save(user);

        //when
        User expect = userRepository.getUser(user.getId());

        //then
        Assertions.assertEquals(user, expect);
    }

    @Test
    void getNotUser() {
        //given
        //userRepository.save(user);

        //when
        User expect = userRepository.getUser(user.getId());

        //then
        Assertions.assertNotEquals(user, expect);
    }

    @Test
    void getAllUsers() {
        //given
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        userRepository.saveAll(users);

        //when
        List<User> expect = userRepository.getAllUsers();

        //then
        Assertions.assertNotNull(expect);
        Assertions.assertArrayEquals(users.toArray(), expect.toArray());
    }

    @Test
    void getNotAllUsers() {
        //given
        ArrayList<User> users = new ArrayList<>();
        userRepository.saveAll(users);

        //when
        List<User> expect = userRepository.getAllUsers();

        //then
        Assertions.assertArrayEquals(users.toArray(), expect.toArray());
    }
}