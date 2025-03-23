package com.myapp.teachingSharePoint.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.teachingSharePoint.Repository.ResourceRepository;
import com.myapp.teachingSharePoint.Repository.UserRepository;

@RestController
@RequestMapping("/upload")
public class ResourceController {

    private final ResourceRepository resourceRepository;
    private final UserRepository userRepository;

    public ResourceController(ResourceRepository resourceRepository, UserRepository userRepository) {
        this.resourceRepository = resourceRepository;
        this.userRepository = userRepository;
    }

}
