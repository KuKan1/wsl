package com.wsl.wjw.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wsl.wjw.util.ImageUtils;
import com.wsl.wjw.util.UploadTools;

@Controller
@RequestMapping(value="/upload")
public class UploadSController extends UploadTools{
	
	@RequestMapping(value="/pic/preview",method=RequestMethod.POST)
    public void uploadPreviewPic(@RequestParam("file")MultipartFile file,HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("src");
	}
	
	@ResponseBody
	@RequestMapping(value="/pic",method=RequestMethod.POST)
    public String uploadPic(@RequestParam("file")MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws Exception{
        	String type = request.getParameter("type");
        	String model = request.getParameter("model");
        	String category = request.getParameter("category");
        	
        	 String picUri = super.upload(file,type, "/"+model+"/"+category+"/",request);
        	 
        	 return picUri;
//             File originalImage = new File(getSrcFilePath());
//             if("".equals(type)){
//             	File destFile = new File(getMinFilePath());
//                 if(!destFile.exists()){
//                     destFile.mkdirs();
//                 }
//                 String uploadFileName = getfName();
//                 String minFileName = null;
// 		        int index = uploadFileName.lastIndexOf(".");
// 		        if (index != -1) {
// 		        	minFileName = uploadFileName.substring(0, index) + "_min" + uploadFileName.substring(index);
// 		        } else {
// 		        	minFileName = uploadFileName+"_min.jpg";
// 		        }
//             	byte[] bytes = ImageUtils.resize(ImageIO.read(originalImage), 330, 1f, true);
//                 FileOutputStream out = new FileOutputStream(new File(getMinFilePath()+ "/" +minFileName));
//                 out.write(bytes);
//                 out.close();
//             }
            
	}
}
