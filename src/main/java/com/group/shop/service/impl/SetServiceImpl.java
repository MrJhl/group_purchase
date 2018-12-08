package com.group.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.shop.entity.Set;
import com.group.shop.entity.SetMedia;
import com.group.shop.mapper.SetMapper;
import com.group.shop.mapper.SetMediaMapper;
import com.group.shop.service.SetService;
@Service("SetService")
public class SetServiceImpl implements SetService {

	@Autowired
	private SetMapper setMapper;
	@Autowired
	private SetMediaMapper setMediaMapper;
	
	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSet(Set record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Boolean insertSelective(Set record,List<Integer> mediaIds) {
		int snum = setMapper.insertSelective(record);
		if(snum == 1) {
			List<SetMedia> setMedias = new ArrayList<>();
			for (int mediaId : mediaIds) {
				SetMedia setMedia = new SetMedia();
				setMedia.setSetId(record.getId());
				setMedia.setMediaId(mediaId);
				setMedias.add(setMedia);
			}
			return setMediaMapper.insertOrderBatch(setMedias)>0 ?Boolean.TRUE:Boolean.FALSE;
			
		}else {
			return false;
		}
		
	}

	@Override
	public Set queryById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateSet(Set set) {
		// TODO Auto-generated method stub
		return 0;
	}

}
