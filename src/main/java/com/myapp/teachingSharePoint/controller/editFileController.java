package com.myapp.teachingSharePoint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.teachingSharePoint.model.entity.UploadedFile;
import com.myapp.teachingSharePoint.service.FileService;

@Controller
@RequestMapping("/editFile")
public class EditFileController {

    private final FileService fileService;

    public EditFileController(FileService fileService) {
        this.fileService = fileService;
    }

    // 編集画面の表示
    @GetMapping("/{id}")
    public String showEditFile(@PathVariable Long id, Model model) {
        UploadedFile file = fileService.findFileById(id);  // IDに基づいてファイルを取得
        model.addAttribute("file", file);  // ファイル情報をモデルに追加
        return "editFile";  // editFile.html テンプレートを返す
    }
}
