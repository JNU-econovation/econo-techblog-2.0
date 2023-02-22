package com.econo.tcono.service.user.feign;

import com.econo.tcono.domain.user.domain.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "idp", url = "${idp.api.uri}")
public interface FeignUserInfo {
    @RequestMapping(method = RequestMethod.GET, path = "/api/users/token")
    UserInfo getUserInfoByToken(@RequestHeader(name = "Authorization") String accessToken);

    @RequestMapping(method = RequestMethod.GET, path = "/api/users/{userId}")
    UserInfo getUserInfoById(@PathVariable("userId") Long userId);
}
