insert INTO Product (id, productName, category_id, discription, price, amount) values (nextval('product_seq'), 'Laptop Acer',1, 'laptop1',2000,10);
insert INTO Product (id, productName, category_id, discription, price, amount) values (nextval('product_seq'), 'Laptop Lenovo',1, 'laptop2',3200,10);
insert INTO Product (id, productName, category_id, discription, price, amount) values (nextval('product_seq'), 'Laptop McBook',1, 'laptop3',599,10);
insert INTO Product (id, productName, category_id, discription, price, amount) values (nextval('product_seq'), 'Laptop HP',1, 'laptop4',1200,10);
insert INTO Product (id, productName, category_id, discription, price, amount) values (nextval('product_seq'), 'Laptop Samsung',1, 'laptop5',2900,10);
insert INTO Product (id, productName, category_id, discription, price, amount) values (nextval('product_seq'), 'Laptop Lenovo',1, 'laptop6',2600,10);
insert INTO Product (id, productName, category_id, discription, price, amount) values (nextval('product_seq'), 'Laptop Acer',1, 'laptop7',4800,10);

insert INTO Category(id, categoryName) values (nextval('product_seq'),'Laptopy');

commit;