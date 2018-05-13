package com.wsl.wjw.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.wsl.wjw.config.SystemParamConfig;

@Component
public class UploadTools {

	Logger logger = LoggerFactory.getLogger(UploadTools.class);
	
	@Autowired
	private SystemParamConfig systemParamConfig;
	
	
	/**
     * @Description: 文件上传 
     * @param file
     * @param destDir 模块
     * @param request
     * @throws Exception
     * @return void
     */
    public String upload(MultipartFile file,String fileType, String destDir,HttpServletRequest request) throws Exception {
    	
        try {
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
                int length = getAllowSuffix().indexOf(suffix);
                if(length == -1){
                    throw new Exception("请上传允许格式的文件");
                }
                if(file.getSize() > getAllowSize()){
                    throw new Exception("您上传的文件大小已经超出范围");
                }
                String uploadPicDir = systemParamConfig.getUploadPicDir();
                if(StringUtils.isEmpty(uploadPicDir)){
                	uploadPicDir = request.getSession().getServletContext().getRealPath("/");
                }
                File destFile = new File(uploadPicDir+destDir);
                if(!destFile.exists()){
                    destFile.mkdirs();
                }
                String fileNameNew = getFileNameNew()+"."+suffix;
                File f = new File(destFile.getAbsoluteFile()+"/"+fileNameNew);
                file.transferTo(f);
                if(f.createNewFile()){
                	logger.info(destDir+fileNameNew+" 已存在");
                }
                fileName = destDir+fileNameNew;
                fName = destDir+fileNameNew;
        } catch (Exception e) {
            throw e;
        }
        return fName;
    }
    
    private String allowSuffix = "jpg,png,gif,jpeg,txt,cdr,jcd,3dm";//允许文件格式
    private long allowSize = 5L;//允许文件大小
    private String fileName;//文件名(包含完整路径)
    private String[] fileNames;
    private String model;//文件上传模块
    private String fName;//文件名(包含扩展名)
    private String[] fNames;
    private String srcFilePath;
    
    private String minFilePath;//缩略图存放路径
    private String minFileName;//缩略图名称
    
    public String getAllowSuffix() {
        return allowSuffix;
    }
 
    public void setAllowSuffix(String allowSuffix) {
        this.allowSuffix = allowSuffix;
    }
 
    public long getAllowSize() {
        return allowSize*1024*1024;
    }
 
    public void setAllowSize(long allowSize) {
        this.allowSize = allowSize;
    }
 
    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
 
    public String[] getFileNames() {
        return fileNames;
    }
 
    public void setFileNames(String[] fileNames) {
        this.fileNames = fileNames;
    }
    public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	//上传文件目录
	public String getStaticDir() {
		return "";
	}

    public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String[] getfNames() {
		return fNames;
	}

	public void setfNames(String[] fNames) {
		this.fNames = fNames;
	}

	public String getMinFilePath() {
		return minFilePath;
	}

	public void setMinFilePath(String minFilePath) {
		this.minFilePath = minFilePath;
	}

	public String getSrcFilePath() {
		return srcFilePath;
	}

	public void setSrcFilePath(String srcFilePath) {
		this.srcFilePath = srcFilePath;
	}

	public String getMinFileName() {
		return minFileName;
	}

	public void setMinFileName(String minFileName) {
		this.minFileName = minFileName;
	}
	
	/**
     * @Description: 重新命名文件
     * @param @return
     * @return String
     */
    private String getFileNameNew(){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Random random = new Random();
    	String randomCode = "";
    	for ( int i = 0; i < 6; i++ )
    	{
    		randomCode += Integer.toString(random.nextInt(36), 36);
    	}
        return fmt.format(new Date()) + randomCode;
    }

}
