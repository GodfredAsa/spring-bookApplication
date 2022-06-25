package io.degreat.bookApplication.Service.serviceImp;

import io.degreat.bookApplication.Enumeration.Role;
import io.degreat.bookApplication.Model.User;
import io.degreat.bookApplication.Repository.UserRepository;
import io.degreat.bookApplication.Service.Iservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; //created in the main class

    @Override
    public User saveUser(User user){
//        Encrypting user password
        user.setPassword(passwordEncoder
                        .encode(user.getPassword()
                        ));
//        setting user Role -- default role
        user.setRole(Role.USER);

//        setting created Time
        user.setCreatedTime(LocalDateTime.now());
//        saving the user
       return userRepository.save(user);
    }


    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

//    change Role
    @Override
    @Transactional
    public void makeAdmin(String username){
        userRepository.updateUserRole(username, Role.ADMIN);

    }





}
