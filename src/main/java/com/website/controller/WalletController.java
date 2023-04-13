package com.website.controller;
import com.website.entity.Wallet;
import com.website.entity.WaylletDto;
import com.website.service.WalletService;
import com.website.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller
 *
 * @author xiesguo
 * @date 2023-04-13
 */
@RestController
@RequestMapping("/wallet")
@Api(tags = "钱包")
@Slf4j
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("queryByUserId")
    @ApiOperation("查询用户钱包余额")
    public Result queryByUserId(@RequestBody Wallet wallet) {
        return walletService.queryByUserId(wallet);
    }

    /**
     * type=2消费
     * @param wallet
     * @return
     */
    @PostMapping("consume")
    @ApiOperation("用户消费100元的接口")
    public Result consume(WaylletDto wallet) {
        return walletService.handWallet(wallet);
    }

    /**
     * type=4 退款
     * @param wallet
     * @return
     */
    @PostMapping("refund")
    @ApiOperation("用户退款20元接口")
    public Result<Wallet> refund(WaylletDto wallet) {
        return walletService.handWallet(wallet);
    }

    @PostMapping("queryDetail")
    @ApiOperation("查询用户钱包金额变动明细的接口")
    public Result queryDetail(Wallet wallet) {
        return Result.success(walletService.queryDetail(wallet));
    }


}
