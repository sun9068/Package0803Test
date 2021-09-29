package org.fintech.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;


@Controller
@Log4j
public class ImageUploadController {
	
	
	@GetMapping("/multiFileupload")
	public void multiFileupload() {
		log.info("파일 업로드 폼 실행");
	}
	
	//파일 업로드 처리
	//MultipartFile[] :업로드 파일명이 대입된다
	@PostMapping("/multiFileuploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile,Model model) {
		
		String uploadFolder = "c:\\upload";
		
		for(MultipartFile multipartFile : uploadFile) {
			
			File saveFile = new File(uploadFolder,multipartFile.getOriginalFilename());
			
			try {
				//파일을 실제로
				multipartFile.transferTo(saveFile);
			}catch(Exception e) {
				log.error(e.getMessage());
				
			}
		}
	}
	
}
