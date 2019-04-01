package by.justi1.service;

import by.justi1.model.User;
import by.justi1.model.UserDto;
import by.justi1.repository.UserRepository;
import by.justi1.util.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerNewUserAccount(UserDto accDto) throws EmailExistsException {
        if (emailExist(accDto.getEmail())) {
            throw new EmailExistsException("There is an account with that email address:" + accDto.getEmail());
        }
        User user = new User();
        user.setFirstname(accDto.getFirstname());
        user.setLastname(accDto.getLastname());
        user.setEmail(accDto.getEmail());
        user.setDateOfBirthday(accDto.getDateOfBirthday());
//        user.setPassword(accDto.getPassword());
        user.setPassword(passwordEncoder.encode(accDto.getPassword()));

        return userRepository.save(user);
    }

    private boolean emailExist(String email) {
        return (findByEmail(email) != null);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
