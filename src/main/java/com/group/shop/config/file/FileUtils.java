package com.group.shop.config.file;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.group.shop.common.GirlException;
import com.group.shop.common.ResultEnum;
import com.group.shop.service.impl.AdminServiceImpl;
import com.group.shop.utils.FileNameUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 文件上传工具包
 */
public class FileUtils {

    private final static Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);


    /**
     *
     * @param file 文件
     * @param path 文件存放路径
     * @param fileName 源文件名
     * @return
     */
//    public static boolean upload(MultipartFile file, String path, String fileName){
//
//
//        // 生成新的文件名
//        String realPath = path + "/" + FileNameUtils.getFileName(fileName);
//
//        //使用原文件名
//        //String realPath = path + "/" + fileName;
//
//        File dest = new File(realPath);
//
//        //判断文件父目录是否存在
//        if(!dest.getParentFile().exists()){
//            dest.getParentFile().mkdirs();
//        }
//
//        try {
//            //保存文件
//            file.transferTo(dest);
//            return true;
//        } catch (IllegalStateException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//
//    }

    public static String saveImg(MultipartFile file, String path) {
    	String pathname = "";
    	if (!file.isEmpty()) {
    		String fileName = file.getOriginalFilename();
    		//生成新的文件名
            String diskFileName  = FileNameUtils.getFileName(fileName);
//    		File path;
			try {
//				path = new File(ResourceUtils.getURL("classpath:").getPath());
				System.out.println(path);//如果你的图片存储路径在static下，可以参考下面的写法
	            File uploadFile = new File(path);//开发测试模式中 获取到的是/target/classes/static/images/upload/
	            if (!uploadFile.exists()){
	                uploadFile.mkdirs();
	            }
	            String loadPath = new File(path).getAbsolutePath();
	            pathname = loadPath+ "/" + diskFileName;
	            file.transferTo(new File(pathname));//文件转存
	            return diskFileName;
			} catch (IOException e) {
				log.error(e.getMessage());
	            throw new GirlException(ResultEnum.SYS_EXCEPTION);
			}
    		
            
    	}
    	
    	return null;
    }
    

}
