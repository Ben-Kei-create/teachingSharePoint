/*
 * 仮のデータとして、自身のアップロードした教材を取得するサービス
 */
package com.myapp.teachingSharePoint.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myapp.teachingSharePoint.model.entity.UploadedFile;

@Service
public class FileService {
    
    // 仮のデータ
    private static final List<UploadedFile> files = new ArrayList<>();

    static {
        files.add(new UploadedFile(1L, "数学の教科書.pdf", LocalDateTime.now().minusDays(1)));
        files.add(new UploadedFile(2L, "英語リスニング教材.mp3", LocalDateTime.now().minusDays(2)));
        files.add(new UploadedFile(3L, "理科の実験ガイド.docx", LocalDateTime.now().minusHours(3)));
    }

    public List<UploadedFile> getAllFiles() {
        return files;
    }

	public UploadedFile findFileById(int i) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public UploadedFile findFileById(Long id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
