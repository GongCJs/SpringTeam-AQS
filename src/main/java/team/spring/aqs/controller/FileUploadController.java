package team.spring.aqs.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import team.spring.aqs.exception.FileException;
import team.spring.aqs.util.Uuid;
import team.spring.aqs.vo.JsonFileInfo;

@Controller
@RequestMapping("file")
public class FileUploadController {

	@ResponseBody
	@RequestMapping("upload.do")
	public JsonFileInfo upload(MultipartFile imgFile[],String dir,HttpServletRequest request) throws SerialException, IllegalStateException, IOException{
		//获取文件保存路径 
		if(imgFile.length == 0 ) {
			throw new SerialException("请选中文件");
		}
		
		File toFile =null;
		
		//文件保存路径
		File savePath = ResourceUtils.getFile("classpath:static/upload/image/"); 
		for (MultipartFile file : imgFile) {
			
			String fileName = file.getOriginalFilename();
			if(ifFIleLeagl(fileName,dir)) {
				//将file(上传文件)保存到指定目录下
				toFile = new File(savePath,Uuid.CreateUUID()+fileName);
				file.transferTo(toFile);
			}else {
				throw new FileException("上传文件扩展名是不允许的扩展名。\n只允许" + fileType().get(dir) +"格式。");
			}
			
		}
		return new JsonFileInfo("/upload/image/"+toFile.getName());
	}
	
	
	//定义允许上传的文件扩展名
	private HashMap<String ,String>fileType(){
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
		return extMap;
	}
	
	//判断文件后最是否为图片类型的
	private boolean ifFIleLeagl(String fileName , String type) {
		HashMap<String, String> extMap = fileType();
		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		if(!Arrays.<String>asList(extMap.get(type).split(",")).contains(fileExt)){
			return false;
		}
		return true;
	}
}
