package com.group.shop.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.shop.entity.Media;
import com.group.shop.mapper.MediaMapper;
import com.group.shop.service.MediaService;

@Service("MediaService")
public class MediaServiceImpl implements MediaService{

	@Autowired
	private MediaMapper mediaMapper;
	
	@Override
	public List<Integer> insertOrderBatch(List<String> record) {
		List<Media> medias = new ArrayList<>();
		for (String url : record) {
			Media media = new Media();
			media.setUrl(url);
			media.setType(0);
			media.setCreateTime(new Date());
			media.setLastEditTime(new Date());
			medias.add(media);
		}
		int num= mediaMapper.insertOrderBatch(medias);
		if (num>0) {
			List<Integer> ids = new ArrayList<>();
			for (Media media : medias) {
				ids.add(media.getId());
			}
			return ids;
		}else {
			return null;
		}
	}

}
