package com.myapp.teachingSharePoint.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.teachingSharePoint.model.entity.UploadedFile;
import com.myapp.teachingSharePoint.service.FileService;

@Controller
@RequestMapping("/newFile")
public class UploadNewFileController {

    private static final Logger logger = LoggerFactory.getLogger(UploadNewFileController.class); // 修正

    private final FileService fileService;

    public UploadNewFileController(FileService fileService) {
        this.fileService = fileService;
    }
	
    // newFile画面へ遷移
    @GetMapping
    public String showNewFile(Model model) {
        logger.info("Navigating to new file creation page."); // ログ出力
        List<UploadedFile> files = fileService.getAllFiles();
        model.addAttribute("files", files);
        return "newFile";
    }
}
