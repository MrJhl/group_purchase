package com.group.shop.service.impl;

import com.group.shop.common.GirlException;
import com.group.shop.common.ResultEnum;
import com.group.shop.entity.Media;
import com.group.shop.entity.Set;
import com.group.shop.entity.SetMedia;
import com.group.shop.mapper.MediaMapper;
import com.group.shop.mapper.SetMapper;
import com.group.shop.mapper.SetMediaMapper;
import com.group.shop.service.SetMediaService;
import com.group.shop.vo.SetMediaVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
public class SetMediaServiceImpl implements SetMediaService {

    @Autowired
    private SetMediaMapper setMediaMapper;

    @Autowired
    private SetMapper setMapper;

    @Autowired
    private MediaMapper mediaMapper;


    @Override
    @Transactional
    public int insertSetMediaVo(SetMediaVo setMediaVo) {
        Set set = new Set();
        set = setMediaVo.getSet();
        set.setLastEditTime(new Date());
        set.setCreateTime(new Date());
        int setNum;
        try {
            setNum = setMapper.insertSelective(set);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new GirlException(ResultEnum.SYS_EXCEPTION);
        }

        if(setNum <= 0){
            return 0;
        }

        for (Integer mediaId : setMediaVo.getMediaList()) {
            SetMedia setMedia = new SetMedia();
            setMedia.setMediaId(mediaId);
            setMedia.setSetId(set.getId());
            int smNum;
            try {
                smNum = setMediaMapper.insertSelective(setMedia);
            }catch (Exception e){
                log.error(e.getMessage());
                throw new GirlException(ResultEnum.SYS_EXCEPTION);
            }
            if(smNum <= 0){
                return 0;
            }
        }
        return 1;
    }
}
