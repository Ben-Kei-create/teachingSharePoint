package com.myapp.teachingSharePoint.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myapp.teachingSharePoint.Repository.ResourceRepository;
import com.myapp.teachingSharePoint.bean.Resource;
import com.myapp.teachingSharePoint.service.ResourceService;

@Controller
@RequestMapping("/newResource")
public class UploadNewFileController {

    private static final Logger logger = LoggerFactory.getLogger(UploadNewFileController.class); // 修正
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private ResourceService resourceService;
	
    @GetMapping
    public String showNewFile(Model model) {
        logger.info("Navigating to new file creation page."); // ログ出力
        return "newResource";
    }
    
    @Value("${file.upload.dir}")
    private String uploadDir;

    @PostMapping
    public String uploadResource(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("category") String category,
            @RequestParam("resource") MultipartFile file,
            @RequestParam("userId") Integer userId) {

        try {
        	if (file.isEmpty() || title.isEmpty() || category.isEmpty()) {
        	    logger.error("バリデーション失敗: 必要な項目が入力されていません。");
        	    return "uploadFailure: すべての項目を入力してください。";
        	}        	
        	
        	// ファイルを保存
            if (!file.isEmpty()) {
                String resourceName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                Path resourcePath = Paths.get(uploadDir, resourceName);
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                resourcePath = uploadPath.resolve(resourceName);
                Files.write(resourcePath, file.getBytes());


                // 教材情報をデータベースに保存
                Resource resource = new Resource();
                resource.setTitle(title);
                resource.setDescription(description);
                resource.setCategory(category);
                resource.setImageUrl("/uploads/" + resourceName);
                resource.setUserId(userId);
                resource.setCreateDatetime(Timestamp.valueOf(LocalDateTime.now()));
                resource.setUpdateDatetime(Timestamp.valueOf(LocalDateTime.now()));

                resourceRepository.save(resource);
            }
            logger.info("File received: " + file.getOriginalFilename());
            return "uploadSuccess";

        } catch (IOException e) {
            return "uploadFailure：" + e.getMessage();
        }
    }
    
}
