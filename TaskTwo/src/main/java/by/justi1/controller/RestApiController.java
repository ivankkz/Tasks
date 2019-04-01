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

@RestController
@RequestMapping("/user")
public class RestApiController {
    private final UserService userService;

    public RestApiController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<User> add(
            @RequestParam(required = false) String fname,
            @RequestParam(required = false) String lname,
            @RequestParam String email,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam String pass
    ) {
        User user;
        try {
            user = userService.registerNewUserAccount(new UserDto(fname, lname, email, date, pass));
        } catch (EmailExistsException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<User> find(
            @RequestParam String email
    ) {
        User user = userService.findByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity delete(
            @RequestParam Long id
    ) {
        userService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
