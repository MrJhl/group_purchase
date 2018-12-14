package com.group.shop.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.group.shop.common.GirlException;
import com.group.shop.common.ResultEnum;
import com.group.shop.config.file.FileUtils;
import com.group.shop.entity.Media;
import com.group.shop.mapper.MediaMapper;
import com.group.shop.service.MediaService;
import com.group.shop.utils.FileNameUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("MediaService")
public class MediaServiceImpl implements MediaService {

	@Value("${web.upload-path}")
	private String path;

	@Autowired
	private MediaMapper mediaMapper;

	@Override
	public List<Media> saveMedia(MultipartFile multipartFile[]) {
		List<Media> medias = new ArrayList<>();
		try {
			// 显示图片
			for (MultipartFile file : multipartFile) {
				String pathname = "";
				if (!file.isEmpty()) {
					String fileName = file.getOriginalFilename();
					// 生成新的文件名
					String diskFileName = FileNameUtils.getFileName(fileName);
//					path = new File(ResourceUtils.getURL("classpath:").getPath());
					System.out.println(path);// 如果你的图片存储路径在static下，可以参考下面的写法
					File uploadFile = new File(path);// 开发测试模式中 获取到的是/target/classes/static/images/upload/
					if (!uploadFile.exists()) {
						uploadFile.mkdirs();
					}
					String loadPath = new File(path).getAbsolutePath();
					pathname = loadPath + "/" + diskFileName;
					file.transferTo(new File(pathname));// 文件转存
					Media media = new Media();
					media.setUrl(diskFileName);
					media.setType(0);
					media.setCreateTime(new Date());
					media.setLastEditTime(new Date());
					medias.add(media);
				}
			}
			
			int num = mediaMapper.insertOrderBatch(medias);
			if (num > 0) {
				List<Integer> ids = new ArrayList<>();
				for (Media media : medias) {
//					ids.add(media.getId());
					media.setUrl(path+media.getUrl());
				}
				return medias;
			} else {
				return null;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GirlException(ResultEnum.SYS_EXCEPTION);
		}

	}

}
