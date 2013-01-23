package com.springapp.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class SpringAppTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testUserFindByName() {
        Assert.notNull(userRepository);
        System.out.println(userRepository);
        User user = new User();
        user.setName("A test user");
        userRepository.save(user);
        Assert.notNull(user.getId());
        List<User> users = userService.findByName("test");
        Assert.isTrue(users.size() > 0);
    }
}
