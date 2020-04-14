/* Documento */
insert into cad_proeza_test_db.cmn_documento (id, fk_tipo, codigo) values (1, 1,'28941686');
insert into cad_proeza_test_db.cmn_documento (id, fk_tipo, codigo) values (2, 1,'10112355');

/* Telefono */
insert into cad_proeza_test_db.cmn_telefono (pref_internacional, pref_area, numero, fk_tipo) values ('54','011','1130114425', 1);

/* Persona */
insert into cad_proeza_test_db.cmn_persona (id, nombre, apellido, sexo, email, fk_telefono, fk_documento, habilitado) values (200, 'Emiliano','Schiano di Cola', 'M', 'emiliano.schiano@gmail.com', 1, 1, 1);
insert into cad_proeza_test_db.cmn_persona (id, nombre, apellido, sexo, email, fk_telefono, fk_documento, habilitado) values (201, 'Pepe','Argento', 'M', 'pepe.argento@gmail.com', null, 1, 1);

/* Usuario */
insert into cad_proeza_test_db.seg_usuario (fk_persona, alias, password) values (200, 'eschiano', '$2a$10$N9ba82wZVlNGgMgcO24XBeGwcE6LkEPkWvuFI8I7efa5F8VgOWXEq');
insert into cad_proeza_test_db.seg_usuario (fk_persona, alias, password) values (201, 'pargento', '$2a$10$N9ba82wZVlNGgMgcO24XBeGwcE6LkEPkWvuFI8I7efa5F8VgOWXEq');

insert into cad_proeza_test_db.cad_inquilino (id, fk_usuario) values (1, 200);

insert into cad_proeza_test_db.cad_propietario (id, fk_usuario) values (1, 200);

insert into cad_proeza_test_db.cad_consorcista (id, fk_usuario) values (1, 200);
insert into cad_proeza_test_db.cad_consorcista (id, fk_usuario) values (2, 201);

insert into cad_proeza_test_db.cmn_direccion (id, calle, numero, localidad, partido, provincia, codigo_postal, piso, departamento, descripcion) values (1, 'Sgto. Cabral', 55, 'Villa Carlos Paz', 'Punilla', 'Cordoba', 'X5152', null, null, 'Edificio Victoria Tower');

insert into cad_proeza_test_db.cad_consorcio (nombre, descripcion, fk_direccion, email, habilitado) values ('Victoria Tower', 'ND', 1, 'victoria@gmail.com', 1);

insert into cad_consorcio_consorcista (id, fk_consorcista, fk_consorcio, habilitado) values (1, 1, 1, 1);
insert into cad_consorcio_consorcista (id, fk_consorcista, fk_consorcio, habilitado) values (2, 2, 1, 0);

insert into cad_proeza_test_db.cad_uf_tipo (nombre) values ('Cochera');
insert into cad_proeza_test_db.cad_uf_tipo (nombre) values ('Departamento');

insert into cad_proeza_test_db.cad_unidad_funcional (codigo, fk_tipo, fk_consorcio, incidencia, habilitado) values ('21', 2, 1, 1.25, 1);
insert into cad_proeza_test_db.cad_unidad_funcional (codigo, fk_tipo, fk_consorcio, incidencia, habilitado) values ('22', 1, 1, 0.73, 1);
insert into cad_proeza_test_db.cad_unidad_funcional (codigo, fk_tipo, fk_consorcio, incidencia, habilitado) values ('23', 1, 1, 0.73, 1);

insert into cad_proeza_test_db.cad_uf_propietario (id, fk_propietario, fk_uf, habilitado) values (1, 1, 1, 1);

insert into cad_proeza_test_db.cad_uf_inquilino (id, fk_inquilino, fk_uf, habilitado) values (1, 1, 2, 1);
insert into cad_proeza_test_db.cad_uf_inquilino (id, fk_inquilino, fk_uf, habilitado) values (2, 1, 3, 0);