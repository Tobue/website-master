package com.website.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.website.entity.Wallet;
import com.website.entity.WalletDetail;
import com.website.entity.WaylletDto;
import com.website.mapper.WalletDetailMapper;
import com.website.mapper.WalletMapper;
import com.website.service.WalletService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.website.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * Service实现类
 *
 * @author xiesguo
 * @date 2023-04-13
 */
@Service
public class WalletServiceImpl extends ServiceImpl<WalletMapper, Wallet> implements WalletService {

    @Autowired
    private WalletMapper walletMapper;
    @Autowired
    private WalletDetailMapper walletDetailMapper;


    @Override
    public Result queryByUserId(Wallet wallet) {
        if (wallet.getUserId() == null) {
            return Result.fail("用户ID不存在");
        }
        QueryWrapper<Wallet> wrapper = new QueryWrapper<Wallet>().eq("user_id",wallet.getUserId());
        return Result.success(walletMapper.selectOne(wrapper));
    }

    /**
     *
     * 单体架构：
     *      1.采用synchronized锁，解决并发问题
     *      2.采用spring的注解@Transactional实现事务控制
     *
     * 分布式架构：
     *      1.采用redis锁，解决并发问题
     *      2.采用阿里巴巴的seate实现分布式事务控制
     */
    @Override
    @Transactional
    public synchronized Result handWallet(WaylletDto param) {
        BigDecimal money = param.getMoney();
        Wallet wallet = this.getWallet(param);
        if(wallet == null){
            return Result.fail("钱包不存在");
        }
        //type=2消费
        if(param.getType().equals("2")){
            BigDecimal subtract = wallet.getBalance().subtract(money);
            // 返回1表示小于0，返回-1表示大于
            if (subtract.compareTo(BigDecimal.ZERO) < 0) {
                return Result.fail("金额不足,无法消费");
            }
            wallet.setBalance(subtract);
        }else if(param.getType().equals("4")){ //type = 4 为退款
            wallet.setBalance(money);
        }
        walletMapper.updateById(wallet);
        //添加明细表
        WalletDetail detail = new WalletDetail();
        detail.setWalletId(wallet.getId());
        detail.setType(param.getType());
        detail.setAmount(money);
        detail.setCreateTime(new Date());
        walletDetailMapper.insert(detail);
        return Result.success();
    }

    @Override
    public List<WalletDetail>  queryDetail(Wallet param) {
        Wallet wallet = getWallet(param);
        if(wallet != null){
            QueryWrapper<WalletDetail> wrapperDetail = new QueryWrapper<WalletDetail>().eq("wallet_id",wallet.getId());
            List<WalletDetail> walletDetails = walletDetailMapper.selectList(wrapperDetail);
            return walletDetails;
        }
        return null;
    }

    private Wallet getWallet(Wallet param) {
        QueryWrapper<Wallet> wrapper = new QueryWrapper<Wallet>().eq("user_id", param.getUserId());
        Wallet wallet = walletMapper.selectOne(wrapper);
        return wallet;
    }
}
