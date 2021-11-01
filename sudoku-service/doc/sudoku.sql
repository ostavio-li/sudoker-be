create table if not exists sudoku
(
    id bigint unsigned auto_increment comment 'id'
        primary key,
    sudoku varchar(200) null
)
    comment '数独表';