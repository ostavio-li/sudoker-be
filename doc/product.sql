create table product
(
    id               bigint unsigned auto_increment
        primary key,
    product_name     varchar(20)                not null,
    product_desc     varchar(50)   default ''   null,
    product_type     int           default 1    not null,
    product_price    decimal(6, 2) default 0.00 not null,
    product_quantity int           default 0    null
);

INSERT INTO stms.product (id, product_name, product_desc, product_type, product_price, product_quantity) VALUES (1, '手机', 'Desc 0', 2, 100.00, 26);
INSERT INTO stms.product (id, product_name, product_desc, product_type, product_price, product_quantity) VALUES (2, '电脑', 'Desc 1', 1, 105.35, 92);
INSERT INTO stms.product (id, product_name, product_desc, product_type, product_price, product_quantity) VALUES (3, '毛巾', 'Desc 1', 1, 105.35, 10);
INSERT INTO stms.product (id, product_name, product_desc, product_type, product_price, product_quantity) VALUES (4, '平板', 'Desc 2', 1, 205.35, 10);
INSERT INTO stms.product (id, product_name, product_desc, product_type, product_price, product_quantity) VALUES (5, '电饭煲', 'dian fan bao', 2, 110.50, 26);