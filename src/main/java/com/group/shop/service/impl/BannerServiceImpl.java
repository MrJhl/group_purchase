package com.group.shop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.shop.common.GirlException;
import com.group.shop.common.ResultEnum;
import com.group.shop.entity.Banner;
import com.group.shop.mapper.BannerMapper;
import com.group.shop.service.BannerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("BannerService")
public class BannerServiceImpl implements BannerService {

	@Autowired
	private BannerMapper bannerMapper;
	
	@Override
	public int insertBanner(Banner banner) {
		int num;
		banner.setCreateTime(new Date());
		banner.setLastEditTime(new Date());
		try {
			num =bannerMapper.insert(banner);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GirlException(ResultEnum.SYS_EXCEPTION);
		}
		return num;
	}

	@Override
	public List<Banner> selectAll() {
		List<Banner> banners;
		try {
			banners =bannerMapper.selectAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GirlException(ResultEnum.SYS_EXCEPTION);
		}
		return banners;
	}

	@Override
	public Boolean updateSelectiveBanner(Banner banner) {
		int num;
		try {
			num =bannerMapper.updateByPrimaryKeySelective(banner);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GirlException(ResultEnum.SYS_EXCEPTION);
		}		
		return num == 1 ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public Boolean delete(Integer id) {
		int num;
		try {
			num =bannerMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GirlException(ResultEnum.SYS_EXCEPTION);
		}		
		return num == 1 ? Boolean.TRUE : Boolean.FALSE;
	}


}
