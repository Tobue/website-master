package com.website.mapper;

import com.website.entity.Wallet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface WalletMapper extends BaseMapper<Wallet> {

}
