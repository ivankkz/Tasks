package by.justi1.repository;

import by.justi1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.email = ?1")
    List<User> findByEmail(String email);

    @Modifying
    @Query("delete from User u where u.id = ?1")
    void deleteById(Long id);
}
