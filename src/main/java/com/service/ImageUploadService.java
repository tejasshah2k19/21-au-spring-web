package com.service;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageUploadService {

	public void uploadData(MultipartFile file, String path) {
		try {
			File dir = new File(path);
			if(!dir.exists()) {
				dir.mkdir();
			}
			
			String fileName = file.getOriginalFilename();
			File f = new File(dir, fileName);// images / 3.jpg
			f.createNewFile();// blank file
			byte allBytes[] = file.getBytes();

			FileUtils.writeByteArrayToFile(f, allBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
