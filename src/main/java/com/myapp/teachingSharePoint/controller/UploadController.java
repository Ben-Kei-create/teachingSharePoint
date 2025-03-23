package com.myapp.teachingSharePoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myapp.teachingSharePoint.bean.Resource;
import com.myapp.teachingSharePoint.service.ResourceService;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private ResourceService resourceService;

    // ファイル一覧を表示
    @GetMapping
    public String showUpload(Model model) {
        List<Resource> resources = resourceService.getAllResources();
        model.addAttribute("resources", resources);
        return "upload";  // "upload"というテンプレートに遷移   
    }
    
    // ファイル編集画面
    @GetMapping("/editResource/{id}")
    public String editFile(@PathVariable("id") Long id, Model model) {
        // idを使ってファイル情報を取得
    	Resource resource = null;
        try {
            resource = resourceService.findResourceById(id);
        } catch (Exception e) {
            e.printStackTrace(); // 例外の詳細を出力（本番環境では Logger を使用）
            model.addAttribute("error", "ファイルを取得できませんでした。");
            return "errorPage";  // エラーページに遷移
        }
        // ファイル情報をモデルに追加
        model.addAttribute("resource", resource);
        return "editResource"; 
    }
    
    // アップロード処理
    @PostMapping
    public String uploadFile(@RequestParam("userId") Integer userId,
                             @RequestParam("title") String title,
                             @RequestParam("description") String description,
                             @RequestParam("category") String category,
                             @RequestParam("file") MultipartFile file,
                             Model model) {
        try {
            // ファイル保存処理やデータベースへの保存
            resourceService.uploadFile(userId, title, description, category, file);
            model.addAttribute("success", "ファイルのアップロードに成功しました！");
            return "upload"; // アップロード成功後、再度ファイル一覧ページへ遷移
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "ファイルのアップロードに失敗しました。");
            return "errorPage"; // エラーページに遷移
        }
    }
}
