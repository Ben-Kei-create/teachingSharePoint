package com.myapp.teachingSharePoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.teachingSharePoint.bean.Resource;
import com.myapp.teachingSharePoint.service.ResourceService;

@Controller
@RequestMapping("/editFile")
public class EditResourceController {

	@Autowired
    private final ResourceService resourceService = null;

    // 編集画面の表示
    @GetMapping("/{id}")
    public String showEditFile(@PathVariable Long id, Model model) {
        Resource resources = resourceService.findResourceById(id);  // IDに基づいてファイルを取得
        model.addAttribute("resource", resources);  // ファイル情報をモデルに追加
        return "editFile";  // editFile.html テンプレートを返す
    }
}
