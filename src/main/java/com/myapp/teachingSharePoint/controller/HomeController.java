package com.myapp.teachingSharePoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myapp.teachingSharePoint.bean.Resource;
import com.myapp.teachingSharePoint.service.ResourceService;

@Controller
public class HomeController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/")
    public String home(Model model) {
        List<Resource> allResources = resourceService.getAllResources();  // リソースを取得
        model.addAttribute("allResources", allResources);  // モデルに追加
        return "index";  // `src/main/resources/templates/index.html` を表示
    }
}
