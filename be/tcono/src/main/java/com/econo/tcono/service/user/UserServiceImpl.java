package com.econo.tcono.service.user;

import com.econo.tcono.domain.user.domain.UserInfo;
import com.econo.tcono.service.user.feign.FeignUserInfo;

public class UserServiceImpl implements UserService {
    private FeignUserInfo feignUserInfo;

    public UserServiceImpl(FeignUserInfo feignUserInfo) {
        this.feignUserInfo = feignUserInfo;
    }

    @Override
    public UserInfo getUserByToken(String accessToken) {
        return feignUserInfo.getUserInfoByToken(accessToken);

    }

    @Override
    public UserInfo getUserById(Long id) {
        return feignUserInfo.getUserInfoById(id);
    }
}
