create database eshop;
use eshop;

create table productos (
	id_producto int primary key auto_increment,
    nombre varchar(255) not null,
    img_producto varchar(255) not null,
    id_categoria int not null,
    precio float not null,
    stock int not null
);

DELIMITER //
create procedure selectProductos()
BEGIN
	select * from productos;
END
//

DELIMITER //
create procedure productoporID(
IN _id_producto int
)
BEGIN
	select * from productos where ip_producto=_id_producto;
END
//

insert into productos(nombre, img_producto, id_categoria, precio, stock) values('Camisa Manga Larga', 'images/home/gallery2.jpg', 2, 39.99, 10); ;
insert into productos(nombre, img_producto, id_categoria, precio, stock) values('Vestido negro', 'images/home/product3.jpg', 2, 19.99, 20);
insert into productos(nombre, img_producto, id_categoria, precio, stock) values('Sueter azul', 'images/home/product5.jpg', 2, 29.99, 20);
insert into productos(nombre, img_producto, id_categoria, precio, stock) values('Camiseta blanca', 'images/home/product6.jpg', 2, 13.99, 15);

