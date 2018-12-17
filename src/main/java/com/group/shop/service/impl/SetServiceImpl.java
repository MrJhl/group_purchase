package com.group.shop.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.shop.common.GirlException;
import com.group.shop.common.ResultEnum;
import com.group.shop.entity.Set;
import com.group.shop.entity.SetMedia;
import com.group.shop.entity.ShopSet;
import com.group.shop.mapper.SetMapper;
import com.group.shop.mapper.SetMediaMapper;
import com.group.shop.mapper.ShopSetMapper;
import com.group.shop.service.SetService;
import com.group.shop.vo.SetInfo;
import com.group.shop.vo.SetUrl;
import org.springframework.transaction.annotation.Transactional;

@Service("SetService")
@Slf4j
public class SetServiceImpl implements SetService {
	
	@Autowired
	private ShopSetMapper shopSetMapper;
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

//	@Override
//	public Boolean insertSelective(SetInfo record) {
//		   Set set = record.getSet();
//	 	   set.setTotal(0);
//	 	   set.setCreateTime(new Date());
//	 	   set.setLastEditTime(new Date());
//
//
//	 	   try {
//	 			if(setMapper.insertSelective(set) == 1 ) {
//	 				ShopSet shopSet = new ShopSet();
//	 		 	    shopSet.setShopId(record.getShopId());
//	 				shopSet.setSetId(set.getId());
//	 				if(shopSetMapper.insert(shopSet)==1) {
//	 					List<Integer> mediaIds = record.getMediaIds();
//		 				List<SetMedia> setMedias = new ArrayList<>();
//		 				for (int mediaId : mediaIds) {
//		 					SetMedia setMedia = new SetMedia();
//		 					setMedia.setSetId(set.getId());
//		 					setMedia.setMediaId(mediaId);
//		 					setMedias.add(setMedia);
//		 				}
//		 				return setMediaMapper.insertOrderBatch(setMedias)>0 ?Boolean.TRUE:Boolean.FALSE;
//	 				}else {
//	 					return Boolean.FALSE;
//	 				}
//	 			}else {
//	 				return Boolean.FALSE;
//	 			}
//		} catch (Exception e) {
//			log.error(e.getMessage());
//			throw new GirlException(ResultEnum.SYS_EXCEPTION);
//		}
//
//	}

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

	@Override
	public List<SetUrl> querySetInfoAndImgById(Integer id) {
		try {
			return setMapper.querySetInfoAndImgById(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GirlException(ResultEnum.SYS_EXCEPTION);
		}
	}

	@Override
	@Transactional
	public boolean insertSetInfo(SetInfo setInfo) {
		Set set = setInfo.getSet();
		set.setCreateTime(new Date());
		set.setLastEditTime(new Date());
		int num;
		try {
			num = setMapper.insertSelective(set);
		}catch (Exception e){
			log.error(e.getMessage());
			throw new GirlException(ResultEnum.SYS_EXCEPTION);
		}
		if(num > 0){
			SetMedia setMedia = new SetMedia();
			setMedia.setSetId(set.getId());
			for (Integer mId : setInfo.getMediaIds()) {
				setMedia.setMediaId(mId);
				int smNum;
				try {
					smNum = setMediaMapper.insertSelective(setMedia);
				}catch (Exception e){
					log.error(e.getMessage());
					throw new GirlException(ResultEnum.SYS_EXCEPTION);
				}
				if(smNum <= 0){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public List<Set> getSetList(Set set) {
		List<Set> setList;
		try {
			setList = setMapper.getSetList(set);
		}catch (Exception e){
			log.error(e.getMessage());
			throw new GirlException(ResultEnum.SYS_EXCEPTION);
		}
		return setList;
	}

}
