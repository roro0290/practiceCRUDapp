package jwtPractice.service;

import jwtPractice.entity.Role;
import jwtPractice.entity.User;
import jwtPractice.repo.RoleRepository;
import jwtPractice.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database: ",user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database: ",role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {} ",roleName,username);
        User user = userRepo.findUserByUsername(username);
        Role role = roleRepo.findRoleByName(roleName);
        user.getRoles().add(role);
        /*
        Because of the transactional annotation, it will go ahead and save everything to the database
        Don't have to save user to userRepo
         */
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}",username);
        return userRepo.findUserByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
}
