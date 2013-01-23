package com.springapp.data;

import java.util.List;

public interface UserService {
    List<User> findByName(String name);
}
