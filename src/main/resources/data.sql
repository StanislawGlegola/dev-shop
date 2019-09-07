

insert INTO Category(id, category_name) values (nextval('category_seq'),'Laptopy');
insert INTO Category(id, category_name) values (nextval('category_seq'),'Telefony');

insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'Laptop Acer',1, 'laptop1',2000,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'Laptop Lenovo',1, 'laptop2',3200,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'Laptop McBook',1, 'laptop3',599,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'Laptop HP',1, 'laptop4',1200,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'Laptop Samsung',1, 'laptop5',2900,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'Laptop Lenovo',1, 'laptop6',2600,10);
insert INTO Product (id, product_name, category_id, description, price, amount) values (nextval('product_seq'), 'Laptop Acer',1, 'laptop7',4800,10);

insert INTO Role(id, role_name) values (nextval('role_seq'),'USER');
insert INTO Role(id, role_name) values (nextval('role_seq'),'ADMIN');

insert INTO User(username, password, first_name, last_name, address,role_id) values ('vanndhall' ,'vanndhall', 'Szymon', 'Mantey', 'ul.Sikorskiego 2 Dziębówko 64-990', 1);
insert INTO User(username, password, first_name, last_name, address,role_id) values ('Marry3' ,'marry3', 'Maria', 'Stachura', 'ul.Kolejowa 21 Piła 64-980', 2);
insert INTO User(username, password, first_name, last_name, address,role_id) values ('DaddyDaa' ,'daddydaa', 'Janusz', 'Łucz', 'ul.Dąbrowskiego 3 Gdańsk 67-770', 2);



commit;