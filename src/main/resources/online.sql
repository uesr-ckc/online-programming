CREATE TABLE `user`
(
    `id`       int         NOT NULL AUTO_INCREMENT,
    `username` varchar(32)          DEFAULT NULL,
    `password` varchar(32) NOT NULL,
    `usertype` int         NOT NULL DEFAULT '2' COMMENT '1 :管理员 2：普通用户',
    `filepath` varchar(10)          DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY (`userid`,`username`,`password`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
