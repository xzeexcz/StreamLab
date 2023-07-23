package kz.bitlab.streamlab.services;

import kz.bitlab.streamlab.dto.UserDTO;
import kz.bitlab.streamlab.entities.impls.Permission;
import kz.bitlab.streamlab.entities.impls.User;
import kz.bitlab.streamlab.mapper.UserMapper;
import kz.bitlab.streamlab.respository.PermissionsRepository;
import kz.bitlab.streamlab.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;


public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PermissionsRepository permissionsRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user !=null) {
            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getUsername())
                    .password(user.getPassword())
                    .authorities(user.getAuthorities())
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .disabled(false)
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
    }

    public User addUser(String email, String password, String firstName, String lastName) {
        if (email == null ||  firstName == null || lastName == null) {
            return null;
        } else {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            User checkUser = userRepository.findByEmail(user.getEmail());
            if(checkUser == null) {
                Permission permission = new Permission();
                permission.setRole("ROLE_USER");
                List<Permission> permissions = new ArrayList<>();
                permissions.add(permission);
                user.setPermissions(permissions);
                permissionsRepository.save(permission);
                return userRepository.save(user);
            } else {
                return null;
            }
        }
    }

    public ResponseEntity<String > updatePassword(String newPassword, String oldPassword, String email) {
        User currentUser = getCurrentSessionUser(email);
        if(passwordEncoder.matches(oldPassword, currentUser.getPassword())) {
            currentUser.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(currentUser);
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.ok("fail");
        }
    }
    public User getCurrentSessionUser(String email) {
        User user = userRepository.findByEmail(email);
        if(user!=null) {
            return user;
        } else {
            return null;
        }
    }

    public List<UserDTO> getAllUsers() {
        return userMapper.toUsersDtoList(userRepository.findAll());
    }

    public UserDTO oneUser(String email) {
        User user = userRepository.findByEmail(email);
        if(user!=null) {
            return userMapper.toUserDto(user);
        } else {
            return null;
        }
    }

    public ResponseEntity<String> updateUser(String email, List<String> roles) {
        User user = userRepository.findByEmail(email);
        if(user!=null) {
            List<Permission> permissions = new ArrayList<>();
            for(String role : roles) {
                Permission permission = new Permission();
                permission.setRole(role);
                permissionsRepository.save(permission);
                permissions.add(permission);
            }
            user.getPermissions().clear();
            user.getPermissions().addAll(permissions);
            userRepository.save(user);
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.ok("Fail!");
        }
    }
    public ResponseEntity<String> checkUser(String email) {
        User user = userRepository.findByEmail(email);
        if(user!=null) {
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.ok("null");
        }
    }

    public ResponseEntity<String> deleteUser(String email) {
        User user = userRepository.findByEmail(email);

        if(user!=null) {
            userRepository.delete(user);
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.ok("Fail");
        }
    }
}
