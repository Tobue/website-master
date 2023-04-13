package com.website.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class WaylletDto extends Wallet implements Serializable {

    @ApiModelProperty(value = "操作金额")
    private BigDecimal money;

    @ApiModelProperty(value = "1-充值，2-消费，3-提现，4-退款")
    private String type;
}
