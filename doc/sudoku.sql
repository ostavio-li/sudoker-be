create table sudoku
(
    id     bigint unsigned auto_increment comment 'id'
        primary key,
    sudoku varchar(200) null
)
    comment '数独表';

INSERT INTO stms.sudoku (id, sudoku) VALUES (1, '[[0,7,9,0,0,0,0,6,2],[0,0,0,0,3,0,8,0,0],[6,8,0,0,0,9,0,0,0],[5,0,0,0,9,0,0,8,3],[0,0,0,0,5,2,6,0,1],[0,0,7,0,0,6,0,0,0],[0,0,2,1,0,3,0,0,0],[1,6,0,9,0,5,2,3,4],[7,5,3,8,0,4,9,0,6]]');