package com.myapp.teachingSharePoint.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myapp.teachingSharePoint.Repository.ResourceRepository;
import com.myapp.teachingSharePoint.Repository.UserRepository;
import com.myapp.teachingSharePoint.bean.Resource;
import com.myapp.teachingSharePoint.bean.User;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private final UserRepository userRepository;

    @Value("${file.upload.dir}")
    private String uploadDir;  // ファイルを保存するディレクトリのパスを設定する

    public ResourceService(ResourceRepository resourceRepository, UserRepository userRepository) {
        this.resourceRepository = resourceRepository;
        this.userRepository = userRepository;
    }

    // すべてのリソースを取得
    public List<Resource> getAllResources() {
        List<Resource> resources = resourceRepository.findAll();

        for (Resource resource : resources) {
            Optional<User> userOpt = userRepository.findById(resource.getUserId());
            resource.setUserName(userOpt.map(User::getUserName).orElse("Unknown"));
        }
        return resources;
    }

    // リソースIDからリソースを取得
    public Resource findResourceById(Long id) {
        Optional<Resource> resourceOpt = resourceRepository.findById(id);
        return resourceOpt.orElse(null);  // リソースが見つからない場合はnullを返す
    }

    // ファイルのアップロード処理
    public void uploadFile(Integer userId, String title, String description, String category, MultipartFile file) {
        try {
            // ファイルを指定されたディレクトリに保存
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File destinationFile = new File(uploadDir, fileName);
            file.transferTo(destinationFile);  // 実際のファイル保存

            // 保存したファイルの情報をリソースとしてデータベースに保存
            Resource resource = new Resource();
            resource.setUserId(userId);
            resource.setTitle(title);
            resource.setDescription(description);
            resource.setCategory(category);
            resource.setImageUrl(destinationFile.getAbsolutePath()); // 保存したファイルのパスをセット

            resourceRepository.save(resource);  // リソースをデータベースに保存
        } catch (IOException e) {
            e.printStackTrace();
            // エラーハンドリング（本番環境では、適切なログを出力するなどの処理が必要）
        }
    }
    
    
}