/* CREACION DE DB Y TABLAS*/ 
CREATE DATABASE muebleria_proyecto_final;
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'Admin.123';
GRANT ALL PRIVILEGES ON muebleria_proyecto_final .* TO 'admin'@'localhost';

USE muebleria_proyecto_final;

CREATE TABLE tipo_usuario(
id_tipo_usuario  INT PRIMARY KEY NOT NULL,
nombre VARCHAR(45) NOT NULL	
);	


CREATE TABLE usuario(
nombre_usuario VARCHAR(45) PRIMARY KEY NOT NULL,
contra VARCHAR(45) NOT NULL,
tipo_usuario INT, 
CONSTRAINT fk_tipoU FOREIGN KEY(tipo_usuario) REFERENCES tipo_usuario(id_tipo_usuario)
);

CREATE TABLE pieza(
tipo_pieza VARCHAR(30)  NOT NULL,
costo DECIMAL(7,2) NOT NULL,
cantidad INT ,
PRIMARY KEY(tipo_pieza,costo)
);

CREATE TABLE mueble(
nombre_mueble VARCHAR(45) PRIMARY KEY NOT NULL,
precio DECIMAL(7,2)
);


CREATE TABLE ensamble_pieza(
cantidad INT,
nombre_mueble VARCHAR(45) NOT NULL,
tipo_pieza VARCHAR(30) NOT NULL,
PRIMARY KEY(nombre_mueble,tipo_pieza),
CONSTRAINT nombre_mueble_fk FOREIGN KEY (nombre_mueble) REFERENCES mueble(nombre_mueble),
FOREIGN KEY (tipo_pieza) REFERENCES pieza(tipo_pieza)
);

CREATE TABLE cliente(
nit VARCHAR(12) PRIMARY KEY,
nombre VARCHAR(100),
direccion VARCHAR(45),
municipio VARCHAR(45),
departamento VARCHAR(45)
);


DROP TABLE estado_mueble_ensamblado;
CREATE TABLE estado_mueble_ensamblado(
id_estado_mueble_ensamblado INT PRIMARY KEY,
nombre_estado VARCHAR(45) 
);


CREATE TABLE mueble_ensamblado(
id_mueble_ensamblado VARCHAR(25) PRIMARY KEY NOT NULL,
fecha_ensamble DATE NOT NULL,
usuario_nombre VARCHAR(45),
id_estado_mueble INT,
nombre_mueble VARCHAR(45),
costo_fabricacion DECIMAL(7,2),
CONSTRAINT usuario_nombre_fk FOREIGN KEY (usuario_nombre) REFERENCES usuario(nombre_usuario),
CONSTRAINT nombre_mueblefk FOREIGN KEY (nombre_mueble) REFERENCES mueble(nombre_mueble),
CONSTRAINT id_estado_mueble_fk FOREIGN KEY (id_estado_mueble) REFERENCES estado_mueble_ensamblado(id_estado_mueble_ensamblado)
);




CREATE TABLE factura(
id_factura INT PRIMARY KEY AUTO_INCREMENT,
fecha_compra DATE, 
cliente_nit VARCHAR(12),
id_mueble_ensamblado VARCHAR(15),
costo_fabricacion DECIMAL,
usuario_venta VARCHAR(45),
CONSTRAINT cliente_fk FOREIGN KEY (cliente_nit) REFERENCES cliente(nit),
CONSTRAINT mueble_ensambladofk FOREIGN KEY (id_mueble_ensamblado) REFERENCES mueble_ensamblado(id_mueble_ensamblado), 
CONSTRAINT vendedor_fk FOREIGN KEY (usuario_venta) REFERENCES usuario(nombre_usuario) 
);



CREATE TABLE pieza_usada(
tipo_pieza  VARCHAR(30),
costo DECIMAL(7,2),
cantidad INT,
id_mueble_ensamblado VARCHAR(15),
PRIMARY KEY(tipo_pieza,costo),
CONSTRAINT idmueble_ensamblado_fk FOREIGN KEY (id_mueble_ensamblado) REFERENCES mueble_ensamblado(id_mueble_ensamblado) 
);



CREATE TABLE devolucion(
id_devolucion INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
costo_perdida DECIMAL(7,2),
fecha_devolucion DATE,
id_factura INT,
CONSTRAINT id_factura_fk FOREIGN KEY (id_factura) REFERENCES factura(id_factura)
);


/*DATOS CONSTANTES*/
INSERT INTO tipo_usuario VALUES('1','Administrador');
INSERT INTO tipo_usuario VALUES('2','Vendedor');
INSERT INTO tipo_usuario VALUES('3','Fabricador');
INSERT INTO tipo_usuario VALUES('4','Cancelado');
INSERT INTO estado_mueble_ensamblado VALUES('1','Disponible');
INSERT INTO estado_mueble_ensamblado VALUES('2','Vendido');
INSERT INTO usuario VALUES('admin','Admin.123','1');
