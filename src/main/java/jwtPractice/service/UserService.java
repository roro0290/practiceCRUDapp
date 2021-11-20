package jwtPractice.service;

import jwtPractice.entity.Role;
import jwtPractice.entity.User;

import java.util.List;

//list the methods necessary
public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    //assumption is that no duplicate username is allowed
    //search for roleName in role DB first and attach it to the user
    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getAllUsers();
    /*
    Role authentication is required for this method
    in real life applications we cannot load so many (50000) users in one page
    So we will load about 30. To view more, send another request (e.g. click next page)
    app will return a page, not the list of user
     */
}
