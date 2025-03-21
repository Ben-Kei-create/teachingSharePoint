package com.myapp.teachingSharePoint.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.teachingSharePoint.model.entity.UploadedFile;
import com.myapp.teachingSharePoint.service.FileService;

@Controller
@RequestMapping("/upload")
public class UploadController {

    private final FileService fileService;

    public UploadController(FileService fileService) {
        this.fileService = fileService;
    }

    // ファイル一覧を表示
    @GetMapping
    public String showUpload(Model model) {
        List<UploadedFile> files = fileService.getAllFiles();
        model.addAttribute("files", files);
        return "upload";  // "upload"というテンプレートに遷移
    }
    
    // ファイル編集画面
    @GetMapping("/editFile/{id}")
    public String editFile(@PathVariable("id") Long id, Model model) {
        // idを使ってファイル情報を取得
        UploadedFile file = null;
		try {
			file = fileService.findFileById(id);
		} catch (Exception e) {
			    model.addAttribute("error", "ファイルを取得できませんでした。");
			    return "errorPage";  // エラーページに遷移
			}

        
        if (file == null) {
            // ファイルが見つからない場合、ファイル一覧ページにリダイレクト
            return "redirect:/upload";
        }
        
        // ファイル情報をモデルに追加
        model.addAttribute("file", file);
        return "editFile";  // "editFile"というテンプレートに遷移
    }
    

    
}
