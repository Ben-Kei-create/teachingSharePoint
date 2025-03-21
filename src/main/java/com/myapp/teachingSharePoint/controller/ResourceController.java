//package com.myapp.teachingSharePoint.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.myapp.teachingSharePoint.service.ResourceService;
//
//@RestController
//public class ResourceController {
//
//    private final ResourceService resourceService;
//
//    @Autowired
//    public ResourceController(ResourceService resourceService) {
//        this.resourceService = resourceService;
//    }
//
////    // 小学校の教材を取得
////    @GetMapping("/resources/elementary")
////    public List<Resource> getElementaryResources() {
////        return resourceService.getResourcesByGrade("elementary");
////    }
////
////    // 中学校の教材を取得
////    @GetMapping("/resources/middle")
////    public List<Resource> getMiddleSchoolResources() {
////        return resourceService.getResourcesByGrade("middle");
////    }
////
////    // ユーザー名で教材を検索
////    @GetMapping("/resources/search/{userName}")
////    public List<Resource> searchResourcesByUserName(@PathVariable String userName) {
////        return resourceService.searchResourcesByUserName(userName);
////    }
//
//    // すべての教材を取得
//    @GetMapping("/resources")
//    public List<Resource> getAllResources() {
//        return resourceService.getAllResources();
//    }
//}
