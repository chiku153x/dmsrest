package com.chiku.dist.dmsrest.uploadingfiles.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {



	 //* Folder location for storing files
	 //private String location = "/Users/gchinthaka/Desktop/erp";

	@Value("${dms_file_path}")
	private String location;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
