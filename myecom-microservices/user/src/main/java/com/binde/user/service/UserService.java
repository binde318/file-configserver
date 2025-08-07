package com.binde.user.service;



import com.binde.user.dto.UserRequest;
import com.binde.user.dto.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<UserResponse> fetchAll();

    public void addUsers(UserRequest userRequest);

    public Optional<UserResponse> fetchUser(Long id);

    public boolean updateUser(Long id, UserRequest updatedUserRequest);
}
