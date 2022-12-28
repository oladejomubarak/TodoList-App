package com.example.todolistapp.services;

import com.example.todolistapp.data.models.User;
import com.example.todolistapp.data.repository.UserRepositories;
import com.example.todolistapp.dtos.request.CreateUserRequest;
import com.example.todolistapp.dtos.request.LoginRequest;
import com.example.todolistapp.dtos.request.UserUpdateRequest;
import com.example.todolistapp.dtos.response.CreateUserResponse;
import com.example.todolistapp.dtos.response.GetResponse;
import com.example.todolistapp.dtos.response.LoginResponse;
import com.example.todolistapp.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepositories userRepositories;

    private final User user = new User();
    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        validateInput(createUserRequest);
        return registerUser(createUserRequest);
    }


    private CreateUserResponse registerUser(CreateUserRequest createUserRequest) {
        if(userRepositories.findUserByEmail(createUserRequest.getEmail()).isPresent())
            throw new RuntimeException("The email already exists, try another");
        else
            user.setEmail(createUserRequest.getEmail());
        if(userRepositories.findUserByEmail(createUserRequest.getPhoneNumber()).isPresent())
            throw new RuntimeException("Phone number already exists, choose another phone number");
        else
            user.setPhoneNumber(createUserRequest.getPhoneNumber());
        user.setFirstName(createUserRequest.getFirstName());
        user.setLastName(createUserRequest.getLastName());
        user.setPassword(createUserRequest.getPassword());


        User savedUser = userRepositories.save(user);

        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setMessage("User created successfully");
        createUserResponse.setId(savedUser.getId());
        createUserResponse.setStatusCode("201");
        return createUserResponse;
    }

    private void validateInput(CreateUserRequest createUserRequest) {
        if (!UserValidator.isValidEmail(createUserRequest.getEmail())) throw new RuntimeException(
                String.format("The email %s is invalid", createUserRequest.getEmail()));
        if (!UserValidator.isValidPassword(createUserRequest.getPassword())) throw new RuntimeException(
                String.format("The password %s is invalid", createUserRequest.getPassword()));
        if (!UserValidator.isValidPhoneNumber(createUserRequest.getPhoneNumber())) throw new RuntimeException(
                String.format("The phone number %s is invalid", createUserRequest.getPhoneNumber()));
    }

    @Override
    public LoginResponse userLogin(LoginRequest loginRequest) {
        User findUser = userRepositories.findUserByEmail(loginRequest.getEmail()).orElseThrow(()->
                new RuntimeException("Email not found"));
        //findUser.setEmail(loginRequest.getEmail());
        if(loginRequest.getPassword().equals(findUser.getPassword()))
            findUser.setPassword(loginRequest.getPassword());
        else
            throw new RuntimeException("Incorrect password");
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage("Login is successful");
        return loginResponse;
    }

    @Override
    public GetResponse updateUser(UserUpdateRequest userUpdateRequest) {
        User foundUser = userRepositories.findById(userUpdateRequest.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        foundUser.setEmail(userUpdateRequest.getEmail() != null
                && !userUpdateRequest.getEmail().equals("") ? userUpdateRequest.getEmail() : foundUser.getEmail());
        foundUser.setPassword(userUpdateRequest.getPassword() != null
                && !userUpdateRequest.getPassword().equals("") ? userUpdateRequest.getPassword() : foundUser.getPassword());
        foundUser.setFirstName(userUpdateRequest.getFirstName() != null
                && !userUpdateRequest.getFirstName().equals("") ? userUpdateRequest.getFirstName() : foundUser.getFirstName());
        foundUser.setLastName(userUpdateRequest.getLastName() != null
                && !userUpdateRequest.getLastName().equals("") ? userUpdateRequest.getLastName() : foundUser.getLastName());
        foundUser.setPhoneNumber(userUpdateRequest.getPhoneNumber() != null
                && !userUpdateRequest.getPhoneNumber().equals("") ? userUpdateRequest.getPhoneNumber() : foundUser.getPhoneNumber());
        userRepositories.save(foundUser);
        return new GetResponse("User detail updated successfully");
    }
    @Override
    public GetResponse deleteUser(String id) {
        userRepositories.deleteById(id);
        return new GetResponse("User deleted successfully");
    }
}
