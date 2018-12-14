package com.group.shop.vo;


import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PayEntity {
    private String orderName;

    private String orderNum;

    private String deviceInfo;

    private String feeType;

    private String totalFee;

    private String ip;

    private String productId;

    private String notifyUrl;

    private String tradeType;


}
