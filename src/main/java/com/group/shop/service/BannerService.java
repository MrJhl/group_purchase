package com.group.shop.service;

import java.util.List;

import com.group.shop.entity.Banner;

public interface BannerService {

	/**
	 * 插入首页图片
	 * @param banner
	 * @return
	 */
	int insertBanner(Banner banner);
	
	/**
	 * 查询所有
	 * @param id
	 * @return
	 */
	List<Banner> selectAll();
	
	/**
	 * 修改Banner
	 * @param banner
	 * @return
	 */
	Boolean updateSelectiveBanner(Banner banner);
	
	/**
	 * 删除Banner
	 * @param id
	 * @return
	 */
	Boolean delete(Integer id);
}
