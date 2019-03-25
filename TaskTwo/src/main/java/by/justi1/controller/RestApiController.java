package by.justi1.controller;

import by.justi1.model.User;
import by.justi1.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class RestApiController {
    private final UserRepository userRepository;

    public RestApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ResponseEntity<String> addNewUsers(
            @RequestParam String fname,
            @RequestParam String lname,
            @RequestParam String email
    ) {
        User user = new User();
        user.setEmail(email);
        user.setFirstname(fname);
        user.setLastname(lname);

        userRepository.save(user);

        return new ResponseEntity<>("We added this user\n" + user.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<String> find(
            @RequestParam String email
    ) {
        List<User> users = userRepository.findByEmail(email);

        if (users.isEmpty())
            return new ResponseEntity<>("The database hasn't a user with this email\n" + "email=" + email, HttpStatus.OK);
        return new ResponseEntity<>("The database has these users\n" + users.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResponseEntity<String> delete(
            @RequestParam Long id
    ) {
        userRepository.deleteById(id);
        return new ResponseEntity<>("We try to delete user with this id\n" + "id =" + id, HttpStatus.OK);
    }
}
