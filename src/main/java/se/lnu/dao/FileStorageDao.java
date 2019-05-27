package se.lnu.dao;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageDao {
	
	public String storeFile(MultipartFile file) throws IOException;

	public Resource loadFileAsResource(String fileName);


}
