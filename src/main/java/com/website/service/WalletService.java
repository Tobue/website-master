package com.website.service;


import com.website.entity.Wallet;
import com.baomidou.mybatisplus.extension.service.IService;
import com.website.entity.WalletDetail;
import com.website.entity.WaylletDto;
import com.website.utils.Result;

import java.util.List;


public interface WalletService extends IService<Wallet> {

    Result queryByUserId(Wallet wallet);

    Result handWallet(WaylletDto wallet);

    List<WalletDetail> queryDetail(Wallet wallet);
}
