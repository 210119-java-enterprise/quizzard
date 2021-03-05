package com.revature.quizzard.services;

import com.revature.quizzard.dtos.Principal;
import com.revature.quizzard.exceptions.*;
import com.revature.quizzard.entities.Role;
import com.revature.quizzard.entities.User;
import com.revature.quizzard.repos.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private static final Logger LOG = LogManager.getLogger(UserService.class);
    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository repo) {
        super();
        this.userRepo = repo;
    }

    @Transactional(readOnly = true)
    public User getUserById(int id) {
        if (id <= 0 ) {
            throw new InvalidRequestException();
        }
        return userRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void register(User newUser) {

        if (!isUserValid(newUser)) throw new InvalidRequestException();

        if (getUserByUsername(newUser.getUsername()) != null) {
            throw new ResourcePersistenceException("Username is already in use!");
        }

        newUser.setRole(Role.BASIC_USER);
        userRepo.save(newUser);

    }

    public List<User> getAllUsers() {

        List<User> users;

        users = (List<User>) userRepo.findAll();

        if (users.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return users;

    }

    public Set<User> getUsersByRole(Role role) {

        Set<User> users;

        if (role == null) {
            throw new InvalidRequestException();
        }

        users = userRepo.findUsersByRole(role.toString());

        if (users.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return users;

    }

    public User getUserByUsername(String username) {

        if (username == null || username.trim().equals("")) {
            throw new InvalidRequestException();
        }

        return userRepo.findUserByUsername(username).orElseThrow(ResourceNotFoundException::new);

    }

    public void confirmAccount(int userId) {

        if (userId <= 0) {
            throw new InvalidRequestException();
        }

        userRepo.confirmAccount(userId);

    }

    public SortedSet<User> sortUsers(String sortCriterion, Set<User> usersForSorting) {

        SortedSet<User> users = new TreeSet<>(usersForSorting);

        switch (sortCriterion.toLowerCase()) {
            case "username":
                users = users.stream()
                        .collect(Collectors.toCollection(() -> {
                            return new TreeSet<>(Comparator.comparing(User::getUsername, String::compareTo));
                        }));
                break;
            case "first":
                users = users.stream()
                        .collect(Collectors.toCollection(() -> {
                            return new TreeSet<>(Comparator.comparing(User::getFirstName, String::compareTo));
                        }));
                break;
            case "last":
                users = users.stream()
                        .collect(Collectors.toCollection(() -> {
                            return new TreeSet<>(Comparator.comparing(User::getLastName, String::compareTo));
                        }));
                break;
            case "role":
                users = users.stream()
                        .collect(Collectors.toCollection(() -> {
                            return new TreeSet<>(Comparator.comparing(User::getRole, Enum::compareTo));
                        }));
                break;
            default:
                throw new InvalidRequestException();

        }

        return users;

    }

    public Principal authenticate(String username, String password) {

        User authUser = userRepo.findUserByUsernameAndPassword(username, password).orElseThrow(AuthenticationException::new);

        if (authUser.accountConfirmed()) {
            return new Principal(authUser);
        } else {
            throw new AuthenticationException("Account not confirmed.");
        }

    }

    public void updateProfile(User updatedUser) {

        if (!isUserValid(updatedUser)) {
            throw new InvalidRequestException();
        }

        Optional<User> persistedUser = userRepo.findUserByUsername(updatedUser.getUsername());
        if (persistedUser.isPresent() && persistedUser.get().getId() != updatedUser.getId()) {
            throw new ResourcePersistenceException("That username is taken by someone else!");
        }

        userRepo.save(updatedUser);

    }

    public Boolean isUserValid(User user) {
        System.out.println(user);
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }

}
