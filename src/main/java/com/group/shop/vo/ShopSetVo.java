package com.group.shop.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.group.shop.entity.Set;
import com.group.shop.entity.Shop;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ShopSetVo {
    private Shop shop;

    private Set set;

    private Date startTime;

    private Date endTime;
}
