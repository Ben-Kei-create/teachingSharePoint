package com.myapp.teachingSharePoint.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myapp.teachingSharePoint.Repository.ResourceRepository;
import com.myapp.teachingSharePoint.Repository.UserRepository;
import com.myapp.teachingSharePoint.bean.Resource;
import com.myapp.teachingSharePoint.bean.User;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private final UserRepository userRepository;

    public ResourceService(ResourceRepository resourceRepository, UserRepository userRepository) {
        this.resourceRepository = resourceRepository;
        this.userRepository = userRepository;
    }

    public List<Resource> getAllResources() {
        List<Resource> resources = resourceRepository.findAll();

        for (Resource resource : resources) {
            User user = userRepository.findUserNameByUserId(resource.getUserId());
            if (user != null) {
                resource.setUserName(user.getUserName()); // UserオブジェクトからuserNameを取得して設定
            } else {
                resource.setUserName("Unknown"); // userが見つからない場合
            }
        }
        return resources;
    }
}