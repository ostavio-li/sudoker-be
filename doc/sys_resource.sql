create table sys_resource
(
    resource_method varchar(20) null,
    resource_code   varchar(20) not null
        primary key,
    resource_path   varchar(50) null
)
    comment '资源表';

INSERT INTO stms.sys_resource (resource_method, resource_code, resource_path) VALUES ('GET', 'list_sudoku', '/api/sudoku');