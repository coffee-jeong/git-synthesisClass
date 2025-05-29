package com.example.synthesisClass.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.synthesisClass.mapper.SignMapper;

@Service
public class SignService {
	@Autowired SignMapper signMapper;
	
	@Transactional
	public void adminSign(int docNo, String userId, String fileName) {
	    signMapper.insertSignature(docNo, userId, fileName, fileName); // signapp 테이블 INSERT
	    signMapper.updateAdminSigned(docNo); // document.admin_signed = 'Y'
	    completeIfBothSigned(docNo);
	}

	public void ownerSign(int docNo, String userId, String fileName) {
	    signMapper.insertSignature(docNo, userId, fileName, fileName); // signapp 테이블 INSERT
	    signMapper.updateOwnerSigned(docNo); // document.owner_signed = 'Y'
	    completeIfBothSigned(docNo);
	}

	public boolean isAdminSigned(int docNo) {
	    String status = signMapper.getAdminSignStatus(docNo);
	    return "Y".equals(status); // NPE 방지 포함
	}

	public void completeIfBothSigned(int docNo) {
	    if (signMapper.isBothSigned(docNo)) {
	        signMapper.updateStatusToCompleted(docNo); // document.status = '완결'
	    }
	}

	public String saveSignatureImage(String signatureData, int docNo, String role) {
	    // 서명 이미지가 저장될 경로
	    String uploadDir = "src/main/resources/static/uploads/";
	    
	    // 디렉토리 없으면 생성
	    File dir = new File(uploadDir);
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }

	    // 고유한 파일명 생성 (docNo_role_UUID.png)
	    String fileName = "doc_" + docNo + "_" + role + "_" + UUID.randomUUID() + ".png";
	    String filePath = uploadDir + fileName;

	    try {
	        // Data URL prefix 제거
	        String base64Image = signatureData.replace("data:image/png;base64,", "");

	        // Base64 디코딩
	        byte[] imageBytes = Base64.getDecoder().decode(base64Image);

	        // 파일로 저장
	        try (FileOutputStream fos = new FileOutputStream(filePath)) {
	            fos.write(imageBytes);
	        }

	        return fileName; // DB에는 파일명만 저장
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}

}
