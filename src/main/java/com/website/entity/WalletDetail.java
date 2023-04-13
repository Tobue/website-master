package com.website.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@TableName("wallet_detail")
@ApiModel(value = "WalletDetail", description = "")
public class WalletDetail implements Serializable{

    @ApiModelProperty(value = "唯一id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "钱包ID")
    @TableField(value = "wallet_id")
    private Integer walletId;

    @ApiModelProperty(value = "出入账金额")
    @TableField(value = "amount")
    private BigDecimal amount;

    @ApiModelProperty(value = "1-充值，2-消费，3-提现，4-退款")
    @TableField(value = "type")
    private String type;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "creat_time")
    private Date createTime;

}
