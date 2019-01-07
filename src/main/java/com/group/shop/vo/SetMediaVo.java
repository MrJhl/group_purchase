package com.group.shop.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.group.shop.entity.Set;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SetMediaVo {
    private Integer id;

    private String name;

    private String describe;

    private Float salePrice;

    private Float price;

    private Integer total;

    private Integer index;

    private Integer del;

    private Date createTime;

    private Date lastEditTime;

    private List<Integer> mediaList;
}
