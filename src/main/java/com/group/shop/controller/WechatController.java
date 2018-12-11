package com.group.shop.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.group.shop.common.GirlException;
import com.group.shop.common.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMaService wxMaService;

    @GetMapping("/userinfo")
    public String getUserInfo(@RequestParam("code") String code,
                              @RequestParam("state")String returnUrl){

        WxMaJscode2SessionResult sessionResult;
        try {
            sessionResult = wxMaService.jsCode2SessionInfo(code);
        }catch (WxErrorException e){
            log.error("【小程序授权】{}",e);
            throw new GirlException(ResultEnum.PAY_EXCEPTION);
        }
        String openId = sessionResult.getOpenid();

        return "redirect:" + returnUrl + "?openid=" + openId;
    }
}
