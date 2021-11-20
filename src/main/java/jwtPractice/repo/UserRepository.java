package jwtPractice.repo;

import jwtPractice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    //Spring is smart enough to know that this is a Select Statement
    User findUserByUsername(String username);
}
