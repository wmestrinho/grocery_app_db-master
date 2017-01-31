package com.ironyard.com.ironyard.service;

import com.ironyard.data.IronYardUser;
import com.ironyard.service.UserService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jasonskipper on 1/26/17.
 */
public class UserServiceTest {

    @Test
    public void getAllUsers() throws Exception {
        UserService uServ = new UserService();
        List<IronYardUser> users = uServ.getAllUsers();
        assertNotNull("Users list was null", users);
        assertEquals("User list size was wrong", 1, users.size());
        assertNotNull("displayname was null", users.get(0).getDisplayname());
        assertNotNull("pass was null", users.get(0).getPassword());
        assertNotNull("username was null", users.get(0).getUsername());
    }

}