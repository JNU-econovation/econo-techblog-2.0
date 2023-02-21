package com.econo.tcono.service.user;

import com.econo.tcono.domain.user.domain.UserInfo;

public interface UserService {
    public UserInfo getUserByToken(String accessToken);
    public UserInfo getUserById(Long Id);
}
