package com.group.shop.controller;

import com.group.shop.common.Result;
import com.group.shop.entity.Media;
import com.group.shop.service.MediaService;
import com.group.shop.utils.AddrHandler;
import com.group.shop.utils.FileNameUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/file")
@Slf4j
public class FileController {

    @Autowired
    private MediaService mediaService;

    /**
     * 单个文件上传
     * @param file
     * @return
     */
    @PostMapping(value = "/upload")
    public Result<String> upload(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return Result.errorMsg("文件为空");
            }
            // 获取文件名
            String fileName = FileNameUtils.getFileName(file.getOriginalFilename());
            log.info("上传的文件名为：" + fileName);
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            log.info("文件的后缀名为：" + suffixName);

            // 设置文件存储路径
            String filePath = AddrHandler.getImgBasePath();
            String path = filePath + fileName;

            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            return Result.success(path);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.errorMsg("上传失败");
    }

    /**
     * 上传图片，写入数据库
     * @param file
     * @return
     */
    @PostMapping(value = "/setupload")
    public Result<Object> uploadSetMedia(MultipartFile file){
        try {
            if (file.isEmpty()) {
                return Result.errorMsg("文件为空");
            }
            // 获取文件名
            String fileName = FileNameUtils.getFileName(file.getOriginalFilename());
            log.info("上传的文件名为：" + fileName);
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            log.info("文件的后缀名为：" + suffixName);

            // 设置文件存储路径
            String filePath = AddrHandler.getImgBasePath();
            String path = filePath + fileName;

            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            Media media = new Media();
            media.setUrl(path);
            Media m = mediaService.insertMedia(media);
            if(m == null){
                return Result.errorMsg("上传图片失败！");
            }
            return Result.success(m);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.errorMsg("上传失败");
    }

    /**
     * 多文件上传
     * @param files
     * @return
     */
    @PostMapping(value = "/list")
    public Result<Object> handleFileUpload(MultipartFile files[]) {
        MultipartFile file = null;
        List<String> stringList = new ArrayList<>();
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.length; ++i) {
            file = files[i];
            String filePath = AddrHandler.getImgBasePath();
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    String fullPath = filePath + FileNameUtils.getFileName(file.getOriginalFilename());
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(fullPath)));//设置文件路径及名字
                    stream.write(bytes);// 写入
                    stringList.add(fullPath);
                } catch (Exception e) {
                    stream = null;
                    log.error( "第 " + i + " 个文件上传失败  ==> "
                            + e.getMessage());
                }finally {
                    try {
                        stream.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            } else {
                return Result.errorMsg("第 " + i + " 个文件上传失败因为文件为空") ;
            }
        }
        return Result.success(stringList);
    }

    /**
     * 文件下载相关代码
     * @param fileName
     * @param request
     * @param response
     * @return
     */
    @GetMapping(value = "/download")
    public String downloadFile(@RequestParam(value = "fileName",required = true)String fileName,
            HttpServletRequest request, HttpServletResponse response) {
        if (fileName != null) {
            //设置文件路径
            String realPath = AddrHandler.getImgBasePath();
            File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * 移除文件
     * @param fileName
     * @return
     */
    @DeleteMapping(value = "/remove",produces = {"application/json;charset=UTF-8"})
    public Result<Boolean> removeFile(@RequestParam(value = "fileName",required = true)String fileName){
        File file = new File(fileName);
        if(file.exists() && file.isFile()){
            if(file.delete()){
                return Result.success(true);
            }else{
                return Result.errorMsg("删除图片失败！");
            }
        }else{
            return Result.errorMsg("不存在改图片！");
        }
    }
}
