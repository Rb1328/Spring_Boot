package com.bookapp.bookrest.controllerbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookapp.bookrest.Helper.fileuploadHelper;

@RestController
public class FileController {
	
	@Autowired
	private fileuploadHelper fileuploadhelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		
		System.out.println(file.getContentType());
		
		System.out.println(file.getSize());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		
		try {
			
			
		if(file.isEmpty()) {
			
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Must Select File");
			
		}
		if(!file.getContentType().equals("image/jpeg")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("image/jpeg");

			
		}
		
//		File Upload Code
		boolean f=fileuploadhelper.uploadFile(file);
		if(f) {
			System.out.println("File Uploded OKK");
//			return ResponseEntity.ok("File Uploded");
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("File control Main catch");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Somethong Went Wrong");
	}

}
