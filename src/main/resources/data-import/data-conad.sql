/* Documento */
insert into cad_proeza_test_db.cmn_documento_identidad (id, fk_tipo, codigo) values (1, 1,'28941686');
insert into cad_proeza_test_db.cmn_documento_identidad (id, fk_tipo, codigo) values (2, 1,'10112355');

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
insert into cad_proeza_test_db.cad_propietario (id, fk_usuario) values (2, 201);

insert into cad_proeza_test_db.cad_consorcista (id, fk_usuario) values (1, 200);
insert into cad_proeza_test_db.cad_consorcista (id, fk_usuario) values (2, 201);

insert into cad_proeza_test_db.cmn_direccion (id, calle, numero, localidad, partido, provincia, codigo_postal, piso, departamento, descripcion) values (1, 'Sgto. Cabral', 55, 'Villa Carlos Paz', 'Punilla', 'Cordoba', 'X5152', null, null, 'Edificio Victoria Tower');

insert into cad_proeza_test_db.cad_consorcio (nombre, descripcion, fk_direccion, email, habilitado) values ('Victoria Tower', 'ND', 1, 'victoria@gmail.com', 1);

insert into cad_proeza_test_db.cad_consorcio_consorcista (id, fk_consorcista, fk_consorcio, habilitado) values (1, 1, 1, 1);
insert into cad_proeza_test_db.cad_consorcio_consorcista (id, fk_consorcista, fk_consorcio, habilitado) values (2, 2, 1, 0);

insert into cad_proeza_test_db.cad_uf_tipo (nombre) values ('Cochera');
insert into cad_proeza_test_db.cad_uf_tipo (nombre) values ('Departamento');

insert into cad_proeza_test_db.cad_unidad_funcional (codigo, fk_tipo, fk_consorcio, incidencia, habilitado) values ('21', 2, 1, 1.25, 1);
insert into cad_proeza_test_db.cad_unidad_funcional (codigo, fk_tipo, fk_consorcio, incidencia, habilitado) values ('22', 2, 1, 1.25, 1);
insert into cad_proeza_test_db.cad_unidad_funcional (codigo, fk_tipo, fk_consorcio, incidencia, habilitado) values ('23', 1, 1, 0.73, 1);
insert into cad_proeza_test_db.cad_unidad_funcional (codigo, fk_tipo, fk_consorcio, incidencia, habilitado) values ('24', 1, 1, 0.73, 1);

insert into cad_proeza_test_db.cad_uf_propietario (id, fk_propietario, fk_uf, habilitado) values (1, 1, 1, 1);
insert into cad_proeza_test_db.cad_uf_propietario (id, fk_propietario, fk_uf, habilitado) values (2, 1, 2, 1);
insert into cad_proeza_test_db.cad_uf_propietario (id, fk_propietario, fk_uf, habilitado) values (3, 2, 3, 1);
insert into cad_proeza_test_db.cad_uf_propietario (id, fk_propietario, fk_uf, habilitado) values (4, 2, 4, 1);

insert into cad_proeza_test_db.cad_uf_inquilino (id, fk_inquilino, fk_uf, habilitado) values (1, 1, 3, 1);

insert into cad_proeza_test_db.cad_cuenta (saldo, habilitado) values (150, 1);
insert into cad_proeza_test_db.cad_cuenta_movimiento (id, fk_cuenta, fecha, monto) values (1, 1, '2020-04-01', 250.000);
insert into cad_proeza_test_db.cad_cuenta_movimiento (id, fk_cuenta, fecha, monto) values (2, 1, '2015-04-15', -100.000);

insert into cad_proeza_test_db.cad_expensa_aplica (nombre, descripcion) values ('Cocheras','La expensa aplica solo a las cocheras');
insert into cad_proeza_test_db.cad_expensa_aplica (nombre, descripcion) values ('Departamentos','La expensa aplica solo a los departamentos');
insert into cad_proeza_test_db.cad_expensa_aplica (nombre, descripcion) values ('Particular','La expensa aplica a las unidades funcionales determinadas por el consorcista');
insert into cad_proeza_test_db.cad_expensa_aplica (nombre, descripcion) values ('Todos','La expensa aplica a todas las unidades funcionales');

insert into cad_proeza_test_db.cad_expensa_tipo (nombre, descripcion) values ('Mensual','Expensa de gastos fijos mensuales');
insert into cad_proeza_test_db.cad_expensa_tipo (nombre, descripcion) values ('Extraordinaria','Expensa de gastos ocasionales');
insert into cad_proeza_test_db.cad_expensa_tipo (nombre, descripcion) values ('Reserva','Expensa para recaudación de un fondo de reserva');

insert into cad_proeza_test_db.cad_expensa(id, nombre, descripcion, valor, creacion, vigencia, duracion, fk_tipo, fk_aplica, fk_consorcio, habilitado) values (1, 'Fondo reseva dptos.','Fondo reserva dptos. 2020', 3500.000, '2020-04-15', '2020-05-01', 3, 3, 2, 1, 1);
insert into cad_proeza_test_db.cad_expensa(id, nombre, descripcion, valor, creacion, vigencia, duracion, fk_tipo, fk_aplica, fk_consorcio, habilitado) values (2, 'Fondo reseva cocheras','Fondo reserva cocheras 2020', 1500.000, '2020-04-15', '2020-05-01', 3, 3, 1, 1, 1);
insert into cad_proeza_test_db.cad_expensa(id, nombre, descripcion, valor, creacion, vigencia, duracion, fk_tipo, fk_aplica, fk_consorcio, habilitado) values (3, 'Wifi','Internet de Carlos Paz Net', 900.000, '2019-10-10', '2019-11-01', 0, 1, 3, 1, 1);

insert into cad_proeza_test_db.cad_expensa_uf (id, fk_expensa, fk_uf, habilitado) values (1, 3, 1, 1);
insert into cad_proeza_test_db.cad_expensa_uf (id, fk_expensa, fk_uf, habilitado) values (2, 3, 2, 1);

insert into cad_proeza_test_db.cad_estado (id, nombre) values (1, 'Pendiente');
insert into cad_proeza_test_db.cad_estado (id, nombre) values (2, 'Aceptado');
insert into cad_proeza_test_db.cad_estado (id, nombre) values (3, 'Rechazado');

insert into cad_proeza_test_db.cad_documento (id, nombre, media_type, f_creacion, data) values (1, 'recibo pago', 'png', '2020-04-11', 'BINARY DATA');

insert into cad_proeza_test_db.cad_pago (id, monto, f_alta, f_revision, fk_estado, recibo) values (1, 4000, '2020-04-11', '2020-04-14', 1, 1);

insert into cad_proeza_test_db.cad_pago_propietario (id, fk_pago, fk_propietario) values (1, 1, 1);
