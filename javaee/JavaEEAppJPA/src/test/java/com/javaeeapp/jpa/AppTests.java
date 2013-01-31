package com.javaeeapp.jpa;

import org.junit.Assert;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.List;

public class AppTests {
    @Test
    public void testUserFindByName() throws Exception {
        Context context = EJBContainer.createEJBContainer().getContext();
        UserService userService = (UserService) context.lookup("java:global/JavaEEAppJPA/UserService");

        Assert.assertNotNull(userService);
        User user = new User();
        user.setName("A test user");
        userService.save(user);
        Assert.assertNotNull(user.getId());
        List<User> users = userService.findByName("test");
        Assert.assertTrue(users.size() > 0);
    }
}
