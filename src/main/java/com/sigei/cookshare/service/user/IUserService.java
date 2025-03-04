package com.sigei.cookshare.service.user;

import com.sigei.cookshare.model.User;

public interface IUserService {
    User registerUser(User user);

    String findByUsername(String username);
}
