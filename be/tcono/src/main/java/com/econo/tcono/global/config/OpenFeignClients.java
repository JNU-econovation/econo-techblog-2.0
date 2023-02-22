package com.econo.tcono.global.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.econo.tcono")
public class OpenFeignClients {
}
