package com.group.shop.config.wxconfig;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class WechatMaConfig {

    @Autowired
    private WxPayProperties properties;

    @Bean
    public WxPayService wxPayService(){
        WxPayConfig payConfig = new WxPayConfig();
        payConfig.setAppId(StringUtils.trimToNull(properties.getAppId()));
        payConfig.setMchId(StringUtils.trimToNull(properties.getMchId()));
        payConfig.setMchKey(StringUtils.trimToNull(properties.getMchKey()));
        payConfig.setSubAppId(StringUtils.trimToNull(properties.getSubAppId()));
        payConfig.setSubMchId(StringUtils.trimToNull(properties.getSubMchId()));
        payConfig.setKeyPath(StringUtils.trimToNull(properties.getKeyPath()));

        // 可以指定是否使用沙箱环境
        payConfig.setUseSandboxEnv(false);

        WxPayService wxPayService = new WxPayServiceImpl();
        wxPayService.setConfig(payConfig);

        return wxPayService;
    }
}
