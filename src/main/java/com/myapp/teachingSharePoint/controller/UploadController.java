package com.myapp.teachingSharePoint.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.teachingSharePoint.model.entity.UploadedFile;
import com.myapp.teachingSharePoint.service.FileService;

@Controller
@RequestMapping("/myUploadList")
public class UploadController {

    private final FileService fileService;

    public UploadController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping
    public String showMyUploadList(Model model) {
        List<UploadedFile> files = fileService.getAllFiles();
        model.addAttribute("files", files);
        return "myUploadList";  // "uploadList" -> "myUploadList"
    }
}
