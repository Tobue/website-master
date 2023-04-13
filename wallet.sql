CREATE TABLE wallet (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    user_id int(11) NOT NULL COMMENT '用户ID',
    balance decimal(10, 2) DEFAULT '0.00' COMMENT '钱包余额',
    creat_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE = InnoDB CHARSET = utf8mb4 COMMENT '用户钱包表';


CREATE TABLE wallet_detail (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    wallet_id int(11) NOT NULL COMMENT '钱包ID',
    amount decimal(10, 2) DEFAULT '0.00' COMMENT '出入账金额',
    type vachar(2) DEFAULT '0.00' COMMENT '1-充值，2-消费，3-提现，4-退款',
    creat_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE = InnoDB CHARSET = utf8mb4 COMMENT '用户钱包明细表';


