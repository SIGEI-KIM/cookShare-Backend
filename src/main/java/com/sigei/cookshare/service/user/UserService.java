package com.sigei.cookshare.service.user;

import com.sigei.cookshare.model.User;
import com.sigei.cookshare.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user.getUsername();
        }
        return "";
    }
}
