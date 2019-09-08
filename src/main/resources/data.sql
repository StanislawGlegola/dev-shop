insert INTO Category(id, category_name) values (nextval('category_seq'),'Laptops');
insert INTO Category(id, category_name) values (nextval('category_seq'),'Phones');
insert INTO Category(id, category_name) values (nextval('category_seq'),'Monitors');
insert INTO Category(id, category_name) values (nextval('category_seq'),'Printers');

insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'Laptop Acer',1, 'laptop1',2000,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'Laptop Lenovo',1, 'laptop2',3200,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'Laptop McBook',1, 'laptop3',599,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'Laptop HP',1, 'laptop4',1200,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'Laptop Samsung',1, 'laptop5',2900,10);

insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'Telefon Acer',2, 'phone1',900,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'Telefon Huawei',2, 'phone2',1200,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'telefon iPhone',2, 'phone3',2599,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'telefon Nokia',2, 'phone4',1450,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'telefon Samsung',2, 'phone5',2940,10);

insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'monitor Asus',2, 'monitor1',700,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'mnnitor Dell',2, 'monitor2',1400,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'monitor LG',2, 'monitor3',1599,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'monitor Iiyama',2, 'monitor4',950,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'monitor Samsung',2, 'monitor5',940,10);

insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'printer Epson',2, 'printer1',300,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'printer Brother',2, 'printer2',200,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'printer HP',2, 'printer3',599,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'printer Canon',2, 'printer4',250,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'printer Samsung',2, 'printer5',240,10);


insert INTO Role(id, authority) values (nextval('role_seq'),'ADMIN');
insert INTO Role(id, authority) values (nextval('role_seq'),'USER');

insert INTO User(username, password, first_name, last_name, address,role_id) values ('admin' ,'$2a$10$IPJizmA0rxJBq9incE/PWub6B2nIDGm3z/2cIz6hAs/hgvKlQ5F9q', 'Szymon', 'Mantey', 'ul.Sikorskiego 2 Dziębówko 64-990', 1);
insert INTO User(username, password, first_name, last_name, address,role_id) values ('user' ,'$2a$10$KvxPudrieuxpEgxw3e4yPOuYK59PgfQshx3RaVUTCpbKB82DC/0RC', 'Maria', 'Stachura', 'ul.Kolejowa 21 Piła 64-980', 2);



commit;