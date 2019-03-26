package by.justi1.controller;

import by.justi1.model.User;
import by.justi1.model.UserDto;
import by.justi1.service.UserService;
import by.justi1.util.EmailExistsException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/user")
public class RestApiController {
    private final UserService userService;

    public RestApiController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.getAll();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ResponseEntity<String> addNewUsers(
            @RequestParam String fname,
            @RequestParam String lname,
            @RequestParam String email,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam String pass
    ) {
        User user;
        try {
            user = userService.registerNewUserAccount(new UserDto(fname, lname, email, date, pass));
        } catch (EmailExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }

        return new ResponseEntity<>("We added this user\n" + user.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<String> find(
            @RequestParam String email
    ) {
        User user = userService.findByEmail(email);

        if (user == null)
            return new ResponseEntity<>("The database hasn't a user with this email\n" + "email=" + email, HttpStatus.OK);
        return new ResponseEntity<>("The database has this user\n" + user.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResponseEntity<String> delete(
            @RequestParam Long id
    ) {
        userService.deleteById(id);
        return new ResponseEntity<>("We try to delete user with this id\n" + "id =" + id, HttpStatus.OK);
    }
}
