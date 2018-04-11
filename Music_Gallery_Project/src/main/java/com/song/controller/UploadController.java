package com.song.controller;

import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
   
	@PostMapping("file/upload")
	public String upload(@RequestParam("file") MultipartFile file , HttpServletRequest request)
	{
		
		String uploadPath = request.getServletContext().getRealPath("resources/images/");
		System.out.println(file.getOriginalFilename());
		System.out.println(uploadPath);
		try {
		Files.copy(file.getInputStream(), Paths.get(uploadPath ,file.getOriginalFilename())); 
		}catch(Exception e)
		{
			
		}
		return "fileupload";
	}
}
