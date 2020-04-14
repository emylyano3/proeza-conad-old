-- MySQL dump 10.13  Distrib 5.7.26, for Win64 (x86_64)
--
-- Host: localhost    Database: cad_proeza_dev_db
-- ------------------------------------------------------
-- Server version	5.7.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `art_articulo`
--

DROP TABLE IF EXISTS `art_articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `art_articulo` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT 'Codigo clave subrrogada unica de artículo',
  `modelo` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `descripcion` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  `fk_rubro` bigint(20) unsigned zerofill NOT NULL,
  `fk_clase` bigint(20) unsigned zerofill NOT NULL,
  `fk_tipo` bigint(20) unsigned zerofill DEFAULT NULL,
  `fk_marca` bigint(20) unsigned zerofill NOT NULL,
  `costo` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT 'Valor de compra del articulo',
  `precio` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT 'Valor de venta del articulo\r',
  `cantidad` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'Representa el stock actual del articulo',
  `habilitado` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_uk` (`id`),
  UNIQUE KEY `codigo_uk` (`codigo`),
  KEY `clase_idx` (`fk_clase`),
  KEY `rubro_idx` (`fk_rubro`),
  KEY `marca_idx` (`fk_marca`),
  KEY `tipo_idx` (`fk_tipo`),
  CONSTRAINT `articulo_clase` FOREIGN KEY (`fk_clase`) REFERENCES `art_clase` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `articulo_marca` FOREIGN KEY (`fk_marca`) REFERENCES `art_marca` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `articulo_rubro` FOREIGN KEY (`fk_rubro`) REFERENCES `art_rubro` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `articulo_tipo` FOREIGN KEY (`fk_tipo`) REFERENCES `art_tipo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4652 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `art_articulo_cliente`
--

DROP TABLE IF EXISTS `art_articulo_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `art_articulo_cliente` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `fk_articulo` bigint(20) unsigned zerofill NOT NULL,
  `fk_cliente` bigint(20) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_pk` (`id`),
  KEY `ac_articulo_idx` (`fk_articulo`),
  KEY `ac_cliente_idx` (`fk_cliente`),
  CONSTRAINT `ac_articulo` FOREIGN KEY (`fk_articulo`) REFERENCES `art_articulo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ac_cliente` FOREIGN KEY (`fk_cliente`) REFERENCES `art_cliente` (`fk_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `art_articulo_proveedor`
--

DROP TABLE IF EXISTS `art_articulo_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `art_articulo_proveedor` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `fk_articulo` bigint(20) unsigned zerofill NOT NULL,
  `fk_proveedor` bigint(20) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  KEY `proveedor_idx` (`fk_proveedor`),
  KEY `articulo_idx` (`fk_articulo`),
  CONSTRAINT `fk_articulo` FOREIGN KEY (`fk_articulo`) REFERENCES `art_articulo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_proveedor` FOREIGN KEY (`fk_proveedor`) REFERENCES `art_proveedor` (`fk_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `art_clase`
--

DROP TABLE IF EXISTS `art_clase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `art_clase` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) CHARACTER SET utf8 NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8 NOT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8 DEFAULT 'N/A',
  `fk_rubro` bigint(20) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `clase_uk` (`codigo`),
  UNIQUE KEY `clase_rubro_uk` (`fk_rubro`,`nombre`),
  KEY `nombre_idx` (`nombre`),
  KEY `rubro_idx` (`fk_rubro`),
  CONSTRAINT `clase_rubro` FOREIGN KEY (`fk_rubro`) REFERENCES `art_rubro` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `art_cliente`
--

DROP TABLE IF EXISTS `art_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `art_cliente` (
  `fk_persona` bigint(20) unsigned zerofill NOT NULL COMMENT 'FK a la tabla persona. Guarda la relacion de herencia con dicha tabla.',
  KEY `cliente_persona` (`fk_persona`),
  CONSTRAINT `cliente_persona` FOREIGN KEY (`fk_persona`) REFERENCES `cmn_persona` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Contiene los clientes de la aplicacion.\r\nGuarda una relacion';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `art_compra`
--

DROP TABLE IF EXISTS `art_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `art_compra` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'PK de la tabla',
  `codigo` varchar(20) CHARACTER SET utf8 NOT NULL,
  `fecha` date NOT NULL COMMENT 'Fecha de  compra',
  `importe` double(10,2) NOT NULL COMMENT 'Monto de compra',
  `fk_medio_pago` bigint(20) unsigned zerofill NOT NULL COMMENT 'FK a la tabla medio_pago',
  `fk_proveedor` bigint(20) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_uk` (`codigo`),
  KEY `medio_pago_idx` (`fk_medio_pago`),
  KEY `proveedor_idx` (`fk_proveedor`),
  CONSTRAINT `compra_mp` FOREIGN KEY (`fk_medio_pago`) REFERENCES `cmn_medio_pago` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `compra_proveedor` FOREIGN KEY (`fk_proveedor`) REFERENCES `art_proveedor` (`fk_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Compra de articulos';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `art_compra_articulo`
--

DROP TABLE IF EXISTS `art_compra_articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `art_compra_articulo` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `fk_articulo` bigint(20) unsigned zerofill NOT NULL,
  `fk_compra` bigint(20) unsigned zerofill NOT NULL,
  `cantidad` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `compra_idx` (`fk_compra`),
  KEY `articulo_idx` (`fk_articulo`),
  CONSTRAINT `ca_articulo` FOREIGN KEY (`fk_articulo`) REFERENCES `art_articulo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ca_compra` FOREIGN KEY (`fk_compra`) REFERENCES `art_compra` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `art_marca`
--

DROP TABLE IF EXISTS `art_marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `art_marca` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) CHARACTER SET utf8 NOT NULL,
  `nombre` varchar(45) CHARACTER SET utf8 NOT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8 DEFAULT 'N/A',
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_uk` (`codigo`),
  UNIQUE KEY `id_uk` (`id`),
  KEY `nombre_idx` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `art_proveedor`
--

DROP TABLE IF EXISTS `art_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `art_proveedor` (
  `fk_persona` bigint(20) unsigned zerofill NOT NULL COMMENT 'FK de la tabla persona. Guarda relacion de herencia.',
  KEY `proveedor_persona` (`fk_persona`),
  CONSTRAINT `proveedor_persona` FOREIGN KEY (`fk_persona`) REFERENCES `cmn_persona` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Contiene datos de los proveedores del usuario';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `art_resource`
--

DROP TABLE IF EXISTS `art_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `art_resource` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `fk_owner` bigint(20) unsigned zerofill NOT NULL,
  `media_type` varchar(50) CHARACTER SET utf8 NOT NULL,
  `f_creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `nombre` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `descripcion` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `data` longblob NOT NULL,
  `preview` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `art_rubro`
--

DROP TABLE IF EXISTS `art_rubro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `art_rubro` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) CHARACTER SET utf8 NOT NULL,
  `nombre` varchar(45) CHARACTER SET utf8 NOT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8 DEFAULT 'N/A',
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_uk` (`codigo`),
  KEY `nombre_idx` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `art_tipo`
--

DROP TABLE IF EXISTS `art_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `art_tipo` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) CHARACTER SET utf8 NOT NULL,
  `nombre` varchar(45) CHARACTER SET utf8 NOT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8 DEFAULT 'N/A',
  `fk_clase` bigint(20) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tipo_clase_uk` (`fk_clase`,`nombre`),
  UNIQUE KEY `tipo_uk` (`codigo`),
  KEY `nombre_idx` (`nombre`),
  KEY `clase_idx` (`fk_clase`),
  CONSTRAINT `tipo_clase` FOREIGN KEY (`fk_clase`) REFERENCES `art_clase` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Clasificacion dentro de clase. Indica para determinada clase';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `art_venta`
--

DROP TABLE IF EXISTS `art_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `art_venta` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'Pk de la tabla',
  `codigo` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT 'Codigo clave subrrogada unica',
  `fecha` date NOT NULL COMMENT 'Fecha de la compra',
  `importe` decimal(10,2) NOT NULL COMMENT 'Importe total de la venta',
  `fk_medio_pago` bigint(20) unsigned zerofill NOT NULL COMMENT 'FK a la tabla de medio de pagos',
  `fk_cliente` bigint(20) unsigned zerofill DEFAULT NULL,
  `fk_usuario` bigint(20) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  KEY `medio_pago_idx` (`fk_medio_pago`),
  KEY `cliente_idx` (`fk_cliente`),
  KEY `venta_usua_idx` (`fk_usuario`),
  CONSTRAINT `venta_cliente` FOREIGN KEY (`fk_cliente`) REFERENCES `art_cliente` (`fk_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `venta_mp` FOREIGN KEY (`fk_medio_pago`) REFERENCES `cmn_medio_pago` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `venta_usua` FOREIGN KEY (`fk_usuario`) REFERENCES `seg_usuario` (`fk_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `art_venta_articulo`
--

DROP TABLE IF EXISTS `art_venta_articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `art_venta_articulo` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `fk_venta` bigint(20) unsigned zerofill NOT NULL,
  `fk_articulo` bigint(20) unsigned zerofill NOT NULL,
  `cantidad` int(10) unsigned NOT NULL COMMENT 'Cantidad de articulos de un tipo en la venta',
  PRIMARY KEY (`id`),
  KEY `venta_idx` (`fk_venta`),
  KEY `articulo_idx` (`fk_articulo`),
  CONSTRAINT `va_articulo` FOREIGN KEY (`fk_articulo`) REFERENCES `art_articulo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `va_venta` FOREIGN KEY (`fk_venta`) REFERENCES `art_venta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cad_consorcio`
--

DROP TABLE IF EXISTS `cad_consorcio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cad_consorcio` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET latin1 NOT NULL,
  `descripcion` varchar(1000) CHARACTER SET latin1 DEFAULT NULL,
  `fk_direccion` bigint(20) unsigned zerofill NOT NULL,
  `email` varchar(200) CHARACTER SET latin1 NOT NULL,
  `habilitado` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_uk` (`id`),
  KEY `cons_dire_idx` (`fk_direccion`),
  CONSTRAINT `fk_cons_dire` FOREIGN KEY (`fk_direccion`) REFERENCES `cmn_direccion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cad_consorcio_consorcista`
--

DROP TABLE IF EXISTS `cad_consorcio_consorcista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cad_consorcio_consorcista` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `fk_consorcista` bigint(20) unsigned zerofill NOT NULL,
  `fk_consorcio` bigint(20) unsigned zerofill NOT NULL,
  `habilitado` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_uk` (`id`),
  KEY `fk_cc_ista_idx` (`fk_consorcista`),
  KEY `fk_cc_rcio_idx` (`fk_consorcio`),
  CONSTRAINT `fk_cc_ista` FOREIGN KEY (`fk_consorcista`) REFERENCES `cad_consorcista` (`fk_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cc_rcio` FOREIGN KEY (`fk_consorcio`) REFERENCES `cad_consorcio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Asociacion de consorcio con consorcistas';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cad_consorcista`
--

DROP TABLE IF EXISTS `cad_consorcista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cad_consorcista` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `fk_usuario` bigint(20) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fk_usuario_uk` (`fk_usuario`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_usuario_idx` (`fk_usuario`),
  CONSTRAINT `fk_cons_usua` FOREIGN KEY (`fk_usuario`) REFERENCES `seg_usuario` (`fk_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cad_cuenta`
--

DROP TABLE IF EXISTS `cad_cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cad_cuenta` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `saldo` decimal(10,3) NOT NULL DEFAULT '0.000',
  `habilitado` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cad_expensa`
--

DROP TABLE IF EXISTS `cad_expensa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cad_expensa` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `valor` decimal(10,3) NOT NULL,
  `creacion` date NOT NULL COMMENT 'Cuando fue dada de alta',
  `inicio` date NOT NULL COMMENT 'Cuando entra en vigencia',
  `fk_tipo` bigint(20) unsigned zerofill NOT NULL,
  `fk_consorcio` bigint(20) unsigned zerofill NOT NULL,
  `habilitado` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cad_expensa_tipo`
--

DROP TABLE IF EXISTS `cad_expensa_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cad_expensa_tipo` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_bin NOT NULL,
  `descripcion` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cad_expensa_uf`
--

DROP TABLE IF EXISTS `cad_expensa_uf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cad_expensa_uf` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `fk_expensa` bigint(20) unsigned zerofill NOT NULL,
  `fk_uf` bigint(20) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relacion entre las expensas particulares y las unidades funcionales';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cad_inquilino`
--

DROP TABLE IF EXISTS `cad_inquilino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cad_inquilino` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `fk_usuario` bigint(20) unsigned zerofill NOT NULL,
  `fk_cuenta` bigint(20) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `fk_usuario_UNIQUE` (`fk_usuario`),
  KEY `fk_usuario_idx` (`fk_usuario`),
  KEY `fk_inqu_cuen_idx` (`fk_cuenta`),
  CONSTRAINT `fk_inqu_cuen` FOREIGN KEY (`fk_cuenta`) REFERENCES `cad_cuenta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_inqu_usua` FOREIGN KEY (`fk_usuario`) REFERENCES `seg_usuario` (`fk_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cad_propietario`
--

DROP TABLE IF EXISTS `cad_propietario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cad_propietario` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `fk_usuario` bigint(20) unsigned zerofill NOT NULL,
  `fk_cuenta` bigint(20) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `fk_usuario_UNIQUE` (`fk_usuario`),
  KEY `fk_usuario_idx` (`fk_usuario`),
  KEY `fk_prop_cuen_idx` (`fk_cuenta`),
  CONSTRAINT `fk_prop_cuen` FOREIGN KEY (`fk_cuenta`) REFERENCES `cad_cuenta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_prop_usua` FOREIGN KEY (`fk_usuario`) REFERENCES `seg_usuario` (`fk_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cad_uf_inquilino`
--

DROP TABLE IF EXISTS `cad_uf_inquilino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cad_uf_inquilino` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `fk_inquilino` bigint(20) unsigned zerofill NOT NULL,
  `fk_uf` bigint(20) unsigned zerofill NOT NULL,
  `habilitado` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`fk_inquilino`),
  UNIQUE KEY `id_uk` (`id`),
  KEY `fk_uf_idx` (`fk_uf`),
  CONSTRAINT `fk_ufin_inqui` FOREIGN KEY (`fk_inquilino`) REFERENCES `cad_inquilino` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ufin_uf` FOREIGN KEY (`fk_uf`) REFERENCES `cad_unidad_funcional` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relacion entre inquilinos y unidades funcionales';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cad_uf_propietario`
--

DROP TABLE IF EXISTS `cad_uf_propietario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cad_uf_propietario` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `fk_propietario` bigint(20) unsigned zerofill NOT NULL,
  `fk_uf` bigint(20) unsigned zerofill NOT NULL,
  `habilitado` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_uk` (`id`),
  KEY `fk_ufpr_prop_idx` (`fk_propietario`),
  KEY `fk_ufpp_uf_idx` (`fk_uf`),
  CONSTRAINT `fk_ufpr_prop` FOREIGN KEY (`fk_propietario`) REFERENCES `cad_propietario` (`fk_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ufpr_uf` FOREIGN KEY (`fk_uf`) REFERENCES `cad_unidad_funcional` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relacion entre propietarios y unidades funcionales';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cad_uf_tipo`
--

DROP TABLE IF EXISTS `cad_uf_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cad_uf_tipo` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_bin NOT NULL,
  `descripcion` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_uk` (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tipo de unidad funcional';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cad_unidad_funcional`
--

DROP TABLE IF EXISTS `cad_unidad_funcional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cad_unidad_funcional` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) COLLATE utf8_bin NOT NULL,
  `fk_tipo` bigint(20) unsigned zerofill NOT NULL,
  `fk_consorcio` bigint(20) unsigned zerofill NOT NULL,
  `incidencia` decimal(10,0) NOT NULL,
  `habilitado` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_uk` (`id`),
  KEY `fk_uf_tuf_idx` (`fk_tipo`),
  KEY `fk_uf_cons_idx` (`fk_consorcio`),
  CONSTRAINT `fk_uf_cons` FOREIGN KEY (`fk_consorcio`) REFERENCES `cad_consorcio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_uf_tuf` FOREIGN KEY (`fk_tipo`) REFERENCES `cad_uf_tipo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Unidades funcionales que componen un consorcio';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cmn_direccion`
--

DROP TABLE IF EXISTS `cmn_direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmn_direccion` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `calle` varchar(100) COLLATE utf8_bin NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `localidad` varchar(100) COLLATE utf8_bin NOT NULL,
  `partido` varchar(100) COLLATE utf8_bin NOT NULL,
  `provincia` varchar(100) COLLATE utf8_bin NOT NULL,
  `codigo_postal` varchar(10) COLLATE utf8_bin NOT NULL,
  `piso` int(11) DEFAULT NULL,
  `departamento` varchar(5) COLLATE utf8_bin DEFAULT NULL,
  `descripcion` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_uk` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cmn_documento`
--

DROP TABLE IF EXISTS `cmn_documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmn_documento` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) COLLATE utf8_bin NOT NULL,
  `fk_tipo` bigint(20) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_uk` (`id`),
  UNIQUE KEY `cod_tipo_uk` (`codigo`,`fk_tipo`),
  KEY `fk_docu_tipo_idx` (`fk_tipo`),
  CONSTRAINT `fk_docu_tipo` FOREIGN KEY (`fk_tipo`) REFERENCES `cmn_documento_tipo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cmn_documento_tipo`
--

DROP TABLE IF EXISTS `cmn_documento_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmn_documento_tipo` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `codigo` varchar(10) COLLATE utf8_bin NOT NULL,
  `nombre` varchar(45) COLLATE utf8_bin NOT NULL,
  `descripcion` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_uk` (`id`),
  UNIQUE KEY `codigo_uk` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cmn_error`
--

DROP TABLE IF EXISTS `cmn_error`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmn_error` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `mensaje` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `excepcion` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `stack` text CHARACTER SET utf8,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_excepcion` (`excepcion`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cmn_foto`
--

DROP TABLE IF EXISTS `cmn_foto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmn_foto` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `data` longblob NOT NULL,
  `media_type` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cmn_i18n`
--

DROP TABLE IF EXISTS `cmn_i18n`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmn_i18n` (
  `id` bigint(20) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_uk` (`id`),
  KEY `id_idx` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cmn_medio_pago`
--

DROP TABLE IF EXISTS `cmn_medio_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmn_medio_pago` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'PK de la tabla',
  `codigo` varchar(10) CHARACTER SET utf8 NOT NULL COMMENT 'Codigo clave subrrogada unica',
  `nombre` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT 'Nombre del medio de pago',
  `descripcion` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_uk` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Tabla maestro con los medios de pago disponibles';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cmn_moneda`
--

DROP TABLE IF EXISTS `cmn_moneda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmn_moneda` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET utf8 NOT NULL,
  `signo` varchar(5) CHARACTER SET utf8 NOT NULL,
  `codigo` varchar(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cmn_movimiento`
--

DROP TABLE IF EXISTS `cmn_movimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmn_movimiento` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `tipo_mov` varchar(20) CHARACTER SET utf8 NOT NULL,
  `fk_entidad` bigint(20) unsigned zerofill NOT NULL,
  `tipo_entidad` varchar(20) CHARACTER SET utf8 NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valor_ant` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `valor_post` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  KEY `entidad_idx` (`fk_entidad`),
  KEY `tipo_mov` (`tipo_mov`)
) ENGINE=InnoDB AUTO_INCREMENT=659 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cmn_persona`
--

DROP TABLE IF EXISTS `cmn_persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmn_persona` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'PK de la tabla',
  `nombre` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT 'Nombre de la persona',
  `apellido` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT 'Apellido de la persona',
  `sexo` varchar(1) CHARACTER SET utf8 NOT NULL DEFAULT 'M' COMMENT 'Sexo de la persona',
  `email` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fk_foto` bigint(20) unsigned zerofill DEFAULT NULL,
  `habilitado` tinyint(1) NOT NULL DEFAULT '1',
  `fk_telefono` bigint(20) unsigned zerofill DEFAULT NULL,
  `fk_documento` bigint(20) unsigned zerofill DEFAULT NULL,
  `fk_direccion` bigint(20) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pers_foto_idx` (`fk_foto`),
  KEY `fk_pers_tele_idx` (`fk_telefono`),
  KEY `fk_pers_dire_idx` (`fk_direccion`),
  KEY `fk_pers_docu_idx` (`fk_documento`),
  CONSTRAINT `fk_pers_dire` FOREIGN KEY (`fk_direccion`) REFERENCES `cmn_direccion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pers_docu` FOREIGN KEY (`fk_documento`) REFERENCES `cmn_documento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pers_foto` FOREIGN KEY (`fk_foto`) REFERENCES `cmn_foto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pers_tele` FOREIGN KEY (`fk_telefono`) REFERENCES `cmn_telefono` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Tabla que representa persona de manera asbtracta. ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cmn_telefono`
--

DROP TABLE IF EXISTS `cmn_telefono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmn_telefono` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'PK de la tabla',
  `pref_internacional` varchar(3) CHARACTER SET utf8 NOT NULL DEFAULT '+54' COMMENT 'Prefijo internacional del numero telefonico',
  `pref_area` varchar(3) CHARACTER SET utf8 NOT NULL COMMENT 'Prefijo de area del numero telefonico',
  `numero` varchar(10) CHARACTER SET utf8 NOT NULL COMMENT 'Numero telefonico',
  `fk_tipo` bigint(20) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tele_tt_idx` (`fk_tipo`),
  CONSTRAINT `fk_tele_tt` FOREIGN KEY (`fk_tipo`) REFERENCES `cmn_telefono_tipo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Tabla que define telefono';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cmn_telefono_tipo`
--

DROP TABLE IF EXISTS `cmn_telefono_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmn_telefono_tipo` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `codigo` varchar(50) CHARACTER SET utf8 NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8 NOT NULL,
  `descripcion` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_uk` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cmn_traduccion`
--

DROP TABLE IF EXISTS `cmn_traduccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmn_traduccion` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `fk_i18n` bigint(20) unsigned zerofill NOT NULL,
  `locale` varchar(5) CHARACTER SET utf8 NOT NULL,
  `texto` varchar(200) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_i18n_locale` (`fk_i18n`,`locale`),
  KEY `idx_i18n_locale` (`fk_i18n`,`locale`),
  KEY `fk_trad_loca_idx` (`locale`),
  CONSTRAINT `fk_trad_i18n` FOREIGN KEY (`fk_i18n`) REFERENCES `cmn_i18n` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `seg_login`
--

DROP TABLE IF EXISTS `seg_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_login` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'PK de la tabla',
  `fk_usuario` bigint(20) unsigned zerofill NOT NULL COMMENT 'FK a la tabla de usuario',
  `fecha` date NOT NULL COMMENT 'La fecha del login',
  PRIMARY KEY (`id`),
  KEY `usuario_idx` (`fk_usuario`),
  CONSTRAINT `login_usuario` FOREIGN KEY (`fk_usuario`) REFERENCES `seg_usuario` (`fk_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `seg_rol`
--

DROP TABLE IF EXISTS `seg_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_rol` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo` (`codigo`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `seg_usuario`
--

DROP TABLE IF EXISTS `seg_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_usuario` (
  `fk_persona` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `alias` varchar(12) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`fk_persona`),
  UNIQUE KEY `id_uk` (`fk_persona`),
  UNIQUE KEY `alias_uk` (`alias`),
  CONSTRAINT `fk_usua_pers` FOREIGN KEY (`fk_persona`) REFERENCES `cmn_persona` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `seg_usuario_rol`
--

DROP TABLE IF EXISTS `seg_usuario_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seg_usuario_rol` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `fk_usuario` bigint(20) unsigned zerofill NOT NULL,
  `fk_rol` bigint(20) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_uk` (`id`),
  KEY `usuario_idx` (`fk_usuario`),
  KEY `rol_idx` (`fk_rol`),
  CONSTRAINT `fk_ur_rol` FOREIGN KEY (`fk_rol`) REFERENCES `seg_rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ur_usua` FOREIGN KEY (`fk_usuario`) REFERENCES `seg_usuario` (`fk_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_item`
--

DROP TABLE IF EXISTS `sys_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_item` (
  `id` bigint(20) unsigned zerofill NOT NULL COMMENT 'Pk de la tabla',
  `codigo` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT 'Clave unica de la tabla',
  `fk_i18n_texto` bigint(20) NOT NULL COMMENT 'Texto del item',
  `fk_i18n_tooltip` bigint(20) DEFAULT NULL COMMENT 'Tooltip del item de menu',
  `icono` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Ruta al icono del item',
  `link` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Enlace del item de menu',
  PRIMARY KEY (`id`),
  UNIQUE KEY `item_uk` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Contiene todos los items de los menus de la aplicacion. La a';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_item_rol`
--

DROP TABLE IF EXISTS `sys_item_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_item_rol` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'Pk de la tabla',
  `fk_item` bigint(20) unsigned zerofill NOT NULL COMMENT 'FK a la tabla de items',
  `fk_rol` bigint(20) unsigned zerofill NOT NULL COMMENT 'FK a la tabla de roles',
  PRIMARY KEY (`id`),
  KEY `ir_rol` (`fk_rol`),
  KEY `ir_item_idx` (`fk_item`),
  CONSTRAINT `ir_item` FOREIGN KEY (`fk_item`) REFERENCES `sys_item` (`id`),
  CONSTRAINT `item_rol` FOREIGN KEY (`fk_rol`) REFERENCES `seg_rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Contiene la relacion de los item de menus con los roles de a';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_item_subitem`
--

DROP TABLE IF EXISTS `sys_item_subitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_item_subitem` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `fk_item` bigint(20) unsigned zerofill NOT NULL,
  `fk_subitem` bigint(20) unsigned zerofill NOT NULL,
  `indice` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_uk` (`id`),
  KEY `item_idx` (`fk_item`),
  KEY `subitem_idx` (`fk_subitem`),
  CONSTRAINT `isi_item` FOREIGN KEY (`fk_item`) REFERENCES `sys_item` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `isi_subitem` FOREIGN KEY (`fk_subitem`) REFERENCES `sys_item` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'Pk de la tabla',
  `codigo` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT 'Clave alfanumerica unica de menu',
  `texto` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Texto del menu',
  `tooltip` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Tooltip del menu',
  `tipo` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT 'Tipo de menu. LEFT_MENU, RIGH_MENU, etc.',
  `icono` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Ruta al icono del menu',
  PRIMARY KEY (`id`),
  UNIQUE KEY `menu_uk` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Tabla con los menues de la aplicacion. Cada menu se puede as';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_menu_item`
--

DROP TABLE IF EXISTS `sys_menu_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu_item` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'PK de la tabla',
  `fk_menu` bigint(20) unsigned zerofill NOT NULL COMMENT 'FK a la tabla de menues',
  `fk_item` bigint(20) unsigned zerofill NOT NULL COMMENT 'FK a la tabla de items de menu',
  `indice` int(3) NOT NULL COMMENT 'Representa el indice del item dentro del menu. \r\nSe utiliza para el ordenamiento de los items.',
  PRIMARY KEY (`id`),
  KEY `mi_menu` (`fk_menu`),
  KEY `mi_item_idx` (`fk_item`),
  CONSTRAINT `mi_item` FOREIGN KEY (`fk_item`) REFERENCES `sys_item` (`id`),
  CONSTRAINT `mi_menu` FOREIGN KEY (`fk_menu`) REFERENCES `sys_menu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Contiene las relaciones entre los menues y los items de menu';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_pagina`
--

DROP TABLE IF EXISTS `sys_pagina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_pagina` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'Pk de la tabla',
  `grupo` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT 'Grupo al que pertenece la pagina. Indica funcionalidad de un conjunto de paginas.',
  `nombre` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT 'El nombre legible que tiene la pagina',
  `fk_i18n_titulo` bigint(20) unsigned zerofill DEFAULT NULL COMMENT 'Título de la pagina. Corresponde a una version legible por usuario del grupo al que pertenece la página',
  `fk_i18n_subtitulo` bigint(20) unsigned zerofill DEFAULT NULL COMMENT 'Subtitulo de la página. Corresponde a una versión legible por usuario del nombre de la página',
  `fk_i18n_descripcion` bigint(20) unsigned zerofill DEFAULT NULL COMMENT 'Descripcion de la pagina',
  PRIMARY KEY (`id`),
  UNIQUE KEY `grupo_nombre` (`grupo`,`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Contiene todas las paginas que componen la aplicacion.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_pagina_menu`
--

DROP TABLE IF EXISTS `sys_pagina_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_pagina_menu` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'PK de la tabla',
  `fk_pagina` bigint(20) unsigned zerofill NOT NULL COMMENT 'FK a la tabla de paginas',
  `fk_menu` bigint(20) unsigned zerofill NOT NULL COMMENT 'FK a la tabla de menues',
  PRIMARY KEY (`id`),
  KEY `pagina_idx` (`fk_pagina`),
  KEY `menu_idx` (`fk_menu`),
  CONSTRAINT `pm_menu` FOREIGN KEY (`fk_menu`) REFERENCES `sys_menu` (`id`),
  CONSTRAINT `pm_pagina` FOREIGN KEY (`fk_pagina`) REFERENCES `sys_pagina` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Asociacion entre las paginas y los menues';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_pagina_rol`
--

DROP TABLE IF EXISTS `sys_pagina_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_pagina_rol` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `fk_pagina` bigint(20) unsigned zerofill NOT NULL,
  `fk_rol` bigint(20) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pagina_idx` (`fk_pagina`),
  KEY `rol_idx` (`fk_rol`),
  CONSTRAINT `pag_rol` FOREIGN KEY (`fk_rol`) REFERENCES `seg_rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pr_pagina` FOREIGN KEY (`fk_pagina`) REFERENCES `sys_pagina` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Relaciona las paginas de la aplicacion con los roles de usua';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary table structure for view `vw_usuario_roles`
--

DROP TABLE IF EXISTS `vw_usuario_roles`;
/*!50001 DROP VIEW IF EXISTS `vw_usuario_roles`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_usuario_roles` AS SELECT 
 1 AS `nombre`,
 1 AS `apellido`,
 1 AS `alias`,
 1 AS `email`,
 1 AS `sexo`,
 1 AS `habilitado`,
 1 AS `codigo_rol`,
 1 AS `nombre_rol`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vw_usuario_roles`
--

/*!50001 DROP VIEW IF EXISTS `vw_usuario_roles`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_usuario_roles` AS select `p`.`nombre` AS `nombre`,`p`.`apellido` AS `apellido`,`u`.`alias` AS `alias`,`p`.`email` AS `email`,`p`.`sexo` AS `sexo`,`p`.`habilitado` AS `habilitado`,`r`.`codigo` AS `codigo_rol`,`r`.`nombre` AS `nombre_rol` from (((`cmn_persona` `p` join `seg_usuario` `u` on((`u`.`fk_persona` = `p`.`id`))) join `seg_usuario_rol` `ur` on((`ur`.`fk_usuario` = `u`.`fk_persona`))) join `seg_rol` `r` on((`ur`.`fk_rol` = `r`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-14 18:03:42
