package com.dreamscapetravel.config;

import com.dreamscapetravel.services.PackageService;
import com.dreamscapetravel.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartUp implements CommandLineRunner {
    private final UserService userService;
    private final PackageService packageService;
    @Override
    public void run(String... args) throws Exception {
        packageService.initData();
    }
}