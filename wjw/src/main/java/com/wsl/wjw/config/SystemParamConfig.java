package com.wsl.wjw.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="system")
public class SystemParamConfig {

	/**
	 * 图片存储路径
	 */
	private String uploadPicDir;

	public String getUploadPicDir() {
		return uploadPicDir;
	}

	public void setUploadPicDir(String uploadPicDir) {
		this.uploadPicDir = uploadPicDir;
	}

}
