create table sys_user
(
    id       bigint auto_increment
        primary key,
    username varchar(20) not null,
    password varchar(20) not null
)
    comment '用户表';

INSERT INTO stms.sys_user (id, username, password) VALUES (1, 'carlos', '9903');