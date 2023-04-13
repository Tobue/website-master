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
@TableName("wallet")
@ApiModel(value = "Wallet", description = "")
public class Wallet implements Serializable{

    @ApiModelProperty(value = "唯一id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户ID")
    @TableField(value = "user_id")
    private Integer userId;

    @ApiModelProperty(value = "钱包余额")
    @TableField(value = "balance")
    private BigDecimal balance;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "creat_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time")
    private Date updateTime;

}
