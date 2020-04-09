/* Seguridad */

    /* Personas */
    insert into cad_proeza_test_db.cmn_persona (id, nombre, apellido, sexo, email, fk_foto) values (100, 'user_admin','user_admin', 'M', 'user_admin@proeza.com.ar', null);
    insert into cad_proeza_test_db.cmn_persona (id, nombre, apellido, sexo, email, fk_foto) values (101, 'prod_admin','prod_admin', 'M', 'prod_admin@proeza.com.ar', null);
    insert into cad_proeza_test_db.cmn_persona (id, nombre, apellido, sexo, email, fk_foto) values (102, 'prod_viewer','prod_viewer', 'M', 'prod_viewer@proeza.com.ar', null);
    insert into cad_proeza_test_db.cmn_persona (id, nombre, apellido, sexo, email, fk_foto) values (103, 'prod_stat','prod_stat', 'M', 'prod_stat@proeza.com.ar', null);
    insert into cad_proeza_test_db.cmn_persona (id, nombre, apellido, sexo, email, fk_foto) values (104, 'admin','admin', 'M', 'admin@proeza.com.ar', null);
    
	/* Usuarios */
	insert into cad_proeza_test_db.seg_usuario (fk_persona, alias, password) values (100, 'user_admin', '$2a$10$oTBcDbxPZlyEhjK4/Q8.o.PCiqc.LwOg5IgF7e4VWAzkDMlVr0cvW');
	insert into cad_proeza_test_db.seg_usuario (fk_persona, alias, password) values (101, 'prod_admin', '$2a$10$gstdn6.1OVcOmjSxx36kJuHoH9seRgbSNYQjVTNavTBVGGxcrT6VC');
	insert into cad_proeza_test_db.seg_usuario (fk_persona, alias, password) values (102, 'prod_viewer', '$2a$10$WwVnE7OeUpe1a892TJrbEOUEzTFKWiHLIM0w9WNKyxZmyGM8vmwk2');
	insert into cad_proeza_test_db.seg_usuario (fk_persona, alias, password) values (103, 'prod_stat', '$2a$10$LGpaazPGhg3U8cqTEb5bq.65GKpqYlEoRG7xEBEtnJ0ZiNN5CFz/S');
	insert into cad_proeza_test_db.seg_usuario (fk_persona, alias, password) values (104, 'admin', '$2a$10$N9ba82wZVlNGgMgcO24XBeGwcE6LkEPkWvuFI8I7efa5F8VgOWXEq');
	
	/* Roles */
	/* Venta */
	insert into cad_proeza_test_db.seg_rol (id, codigo, nombre, descripcion) values (51,'ROLE_VENTA_ADMIN','Ventas Administrador','');
	insert into cad_proeza_test_db.seg_rol (id, codigo, nombre, descripcion) values (52,'ROLE_VENTA_ESTAD','Ventas Estadista','');
	/* Compra */
	insert into cad_proeza_test_db.seg_rol (id, codigo, nombre, descripcion) values (11,'ROLE_COMPR_ADMIN','Compras Administrador','');
	insert into cad_proeza_test_db.seg_rol (id, codigo, nombre, descripcion) values (12,'ROLE_COMPR_ESTAD','Compras Estadista','');
	/* Producto */
	insert into cad_proeza_test_db.seg_rol (id, codigo, nombre, descripcion) values (31,'ROLE_PRODU_ADMIN','Productos Administrador','');
	insert into cad_proeza_test_db.seg_rol (id, codigo, nombre, descripcion) values (32,'ROLE_PRODU_CATAL','Productos Catálogo','');
	insert into cad_proeza_test_db.seg_rol (id, codigo, nombre, descripcion) values (33,'ROLE_PRODU_ESTAD','Productos Estadista','');
	/* Usuario */
	insert into cad_proeza_test_db.seg_rol (id, codigo, nombre, descripcion) values (41,'ROLE_USUAR_ADMIN','Usuarios Administrador','');
	insert into cad_proeza_test_db.seg_rol (id, codigo, nombre, descripcion) values (42,'ROLE_USUAR_ESTAD','Usuarios Estadista','');
	insert into cad_proeza_test_db.seg_rol (id, codigo, nombre, descripcion) values (43,'ROLE_USUAR_LISTA','Usuarios Listado','');

	/* Asociacion de Usuarios y roles */
	/* user_admin */
	insert into cad_proeza_test_db.seg_usuario_rol (fk_usuario, fk_rol) values (100, 41);
	insert into cad_proeza_test_db.seg_usuario_rol (fk_usuario, fk_rol) values (100, 42);
	insert into cad_proeza_test_db.seg_usuario_rol (fk_usuario, fk_rol) values (100, 43);
	
	/* prod_admin */
	insert into cad_proeza_test_db.seg_usuario_rol (fk_usuario, fk_rol) values (101, 31);
	
	/* prod_stat */
	insert into cad_proeza_test_db.seg_usuario_rol (fk_usuario, fk_rol) values (102, 32);
	
	/* prod_viewer */
	insert into cad_proeza_test_db.seg_usuario_rol (fk_usuario, fk_rol) values (103, 33);
	
	/* admin */
	insert into cad_proeza_test_db.seg_usuario_rol (fk_usuario, fk_rol) values (104, 41);
	insert into cad_proeza_test_db.seg_usuario_rol (fk_usuario, fk_rol) values (104, 42);
	insert into cad_proeza_test_db.seg_usuario_rol (fk_usuario, fk_rol) values (104, 43);
	insert into cad_proeza_test_db.seg_usuario_rol (fk_usuario, fk_rol) values (104, 31);
	insert into cad_proeza_test_db.seg_usuario_rol (fk_usuario, fk_rol) values (104, 32);
	insert into cad_proeza_test_db.seg_usuario_rol (fk_usuario, fk_rol) values (104, 33);
	insert into cad_proeza_test_db.seg_usuario_rol (fk_usuario, fk_rol) values (104, 12);
	insert into cad_proeza_test_db.seg_usuario_rol (fk_usuario, fk_rol) values (104, 12);
	insert into cad_proeza_test_db.seg_usuario_rol (fk_usuario, fk_rol) values (104, 51);
	insert into cad_proeza_test_db.seg_usuario_rol (fk_usuario, fk_rol) values (104, 52);
	
/* Seguridad */
