package com.bookapp.bookrest.Helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileuploadHelper {

                                    //	USe Double slash for windows                                
	public final String UPLOAD_DIR="D:\\eclips\\SpringBootEx\\bookrest1\\src\\main\\resources\\static\\image";

//	public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public fileuploadHelper() throws IOException{
		
		// TODO Auto-generated constructor stub
	}

	public boolean uploadFile(MultipartFile multipartFile) {
		boolean f= false;
		System.out.println("In File Uplaod");
		try
		{
//			InputStream is=multipartFile.getInputStream();
//		    byte data[]=new byte[is.available()];
//		    is.read(data);
//		    
//		    FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
//			
//		    fos.write(data);
//		    fos.flush();
//		    fos.close();
		
			
			Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		    f=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		System.out.println("Exception in FileUpload Helper");
		}
		
		
		return f;
		
		
		
		
	}
}
