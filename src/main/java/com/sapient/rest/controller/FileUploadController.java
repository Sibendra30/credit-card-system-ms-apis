package com.sapient.rest.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

	@PostMapping("/file-upload")
	@CrossOrigin
	public ResponseEntity<Boolean> uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			File f = new File("C://MS_Workspace/" + file.getOriginalFilename());
			OutputStream outStream = new FileOutputStream(f);
			outStream.write(file.getBytes());
			outStream.close();
		} catch (IOException e) {
			System.out.println("File upload failed");
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/file-download")
	@CrossOrigin
	public ResponseEntity<String> downloadFile(HttpServletResponse response) {
		try {
			
			Path f = Paths.get("C://MS_Workspace/abc.pdf");
			Resource resource = new UrlResource(f.toUri());
			byte arr[] = new byte[resource.getInputStream().available()];
			resource.getInputStream().read(arr);
			resource.getInputStream().close();
			String base64EncodedStr = Base64.getEncoder().encodeToString(arr);
			
			HttpHeaders header = new HttpHeaders();
			// header.set(HttpHeaders.CONTENT_TYPE, "application/pdf");
			Thread.sleep(5000l);
			response.setHeader("Content-Disposition", "attachment; filename=\"" + "response.json" + "\"");
			return new ResponseEntity<String>(base64EncodedStr, header, HttpStatus.OK);
		} catch (IOException e) {
			System.out.println("File download failed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("File download failed");
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
