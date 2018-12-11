package com.group.shop.config.wxconfig;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class WechatMaConfig {

    @Autowired
    private WechatAccountConfig accountConfig;
    @Bean
    public WxMaService wxMaService(){
        WxMaService wxMaService = new WxMaServiceImpl();
        wxMaService.setWxMaConfig(wxMaConfig());
        return wxMaService;
    }

    @Bean
    public WxMaConfig wxMaConfig(){
        WxMaConfig wxMaConfig = new WxMaInMemoryConfig();
        ((WxMaInMemoryConfig) wxMaConfig).setSecret(accountConfig.getMaAppSecret());
        ((WxMaInMemoryConfig) wxMaConfig).setAppid(accountConfig.getMaAppId());
        return wxMaConfig;
    }
}
