package com.group.shop.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.group.shop.entity.Set;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SetMediaVo {
    private Set set;

    private List<Integer> mediaList;
}
