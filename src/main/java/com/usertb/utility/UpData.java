package com.usertb.utility;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

/**
 * 上传文件处理
 * @author lgs
 *
 */
public class UpData {
	
	/**
	 * 常用图片格式
	 */
	private final static String[] TYPE_PHOTO = new String[] {"bmp","jpg","png",
	"tif","gif","pcx","tga","exif","fpx","svg","psd","cdr","pcd",
			"dxf","ufo","eps","ai","raw","WMF","webp"};
	
	/**
	 * 处理上传文件名及格式
	 * @param multipartFile 上传的文件
	 * @return 返回随机文件名
	 */
	public static String upPhoto(MultipartFile multipartFile) {
		//判断文件是否为空		文件为空时true 
		boolean empty = multipartFile.isEmpty();
		if(!empty) {
								//获取上传文件名
			String filename = multipartFile.getOriginalFilename();
							//获取上传文件格式
			String type = filename.substring(filename.lastIndexOf(".")+1);
			for(int i=0;i<TYPE_PHOTO.length;i++) {
				if(TYPE_PHOTO[i].equals(type)) {
					return UUID.randomUUID().toString()+"."+type;
				}
			}
			
		}
		System.out.println("文件为空或文件格式不正确");
		return "null";
	}
	/**
	 * 文件绝对路径
	 * @param filename 文件名
	 * @return 返回File保存绝对路径
	 */
	public static File filePath(String photo_path,String filename) {
		return new File(photo_path+filename);
	}
	/**
	 * 删除旧照片
	 * @param oldfilename 
	 * @return
	 */
	public static boolean deletefilePath(String photo_path,String newfilename,String oldfilename) {
		if(!newfilename.equals(oldfilename) && !oldfilename.equals("null")) {
			return new File(photo_path+oldfilename).delete();
		}
		return false;
		
	}
	
	
}
