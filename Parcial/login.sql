-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-04-2016 a las 16:21:27
-- Versión del servidor: 5.6.20
-- Versión de PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `prosistemas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_person`
--

CREATE TABLE IF NOT EXISTS `tbl_person` (
  `personid` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `direccion` varchar(30) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tbl_person`
--

INSERT INTO `tbl_person` (`personid`, `nombre`, `apellido`, `direccion`, `telefono`) VALUES
(1, 'Diego', 'Oropeza', 'calle12', 123),
(2, 'Mauricio', 'Pinto', 'calle', 123),
(5, 'David', 'Moralez', 'calle', 123),
(10, 'carlos', 'Valverde', 'Va. Santo Rumon', 125),
(12, 'Pablo', 'Peres', 'calle 10', 45222),
(15, 'pedro', 'peres', 'calle', 1255),
(45, 'Carlos', 'roca', 'ave', 12568);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_roles`
--

CREATE TABLE IF NOT EXISTS `tbl_roles` (
`RolId` int(11) NOT NULL,
  `Rol` varchar(20) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `tbl_roles`
--

INSERT INTO `tbl_roles` (`RolId`, `Rol`) VALUES
(2, 'Doctor'),
(3, 'Paciente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_seg_loginhistory`
--

CREATE TABLE IF NOT EXISTS `tbl_seg_loginhistory` (
  `UserId` int(11) DEFAULT NULL,
  `FechaLog` datetime NOT NULL,
  `IP` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tbl_seg_loginhistory`
--

INSERT INTO `tbl_seg_loginhistory` (`UserId`, `FechaLog`, `IP`) VALUES
(2, '2016-04-23 09:36:56', '10.4.39.203'),
(2, '2016-04-23 09:39:53', '10.4.39.203'),
(2, '2016-04-23 09:41:47', '10.4.39.203'),
(2, '2016-04-23 09:59:01', '10.4.39.203'),
(2, '2016-04-23 10:02:51', '10.4.39.203'),
(3, '2016-04-23 10:05:09', '10.4.39.203'),
(3, '2016-04-23 10:05:36', '10.4.39.203'),
(2, '2016-04-23 10:07:28', '10.4.39.203'),
(6, '2016-04-23 10:07:55', '10.4.39.203'),
(6, '2016-04-23 10:09:11', '10.4.39.203'),
(6, '2016-04-23 10:16:15', '10.4.39.203'),
(2, '2016-04-23 10:16:36', '10.4.39.203'),
(2, '2016-04-26 10:03:48', '10.4.39.203'),
(6, '2016-04-26 10:04:38', '10.4.39.203'),
(2, '2016-04-26 10:07:21', '10.4.39.203'),
(2, '2016-04-26 10:20:29', '10.4.39.203');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_seg_permissions`
--

CREATE TABLE IF NOT EXISTS `tbl_seg_permissions` (
  `PermissionId` varchar(20) NOT NULL,
  `Mnemonic` varchar(20) NOT NULL,
  `Description` varchar(200) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_seg_permissions`
--

INSERT INTO `tbl_seg_permissions` (`PermissionId`, `Mnemonic`, `Description`) VALUES
('0', 'ver', 'ver'),
('1', 'editar', 'editar'),
('2', 'eliminar', 'eliminar'),
('3', 'añadir', 'añadir'),
('4', 'control Parcial', 'control Parcial'),
('5', 'control total', 'control total');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_seg_permissionsuserroles`
--

CREATE TABLE IF NOT EXISTS `tbl_seg_permissionsuserroles` (
  `PermissionId` varchar(20) NOT NULL,
  `OwnerId` int(11) NOT NULL,
  `OwnerType` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_seg_permissionsuserroles`
--

INSERT INTO `tbl_seg_permissionsuserroles` (`PermissionId`, `OwnerId`, `OwnerType`) VALUES
('0', 2, 2),
('5', 3, 2),
('0', 6, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_seg_user`
--

CREATE TABLE IF NOT EXISTS `tbl_seg_user` (
  `UserId` int(11) NOT NULL,
  `PersonId` int(11) DEFAULT NULL,
  `RolId` int(11) NOT NULL,
  `UserName` varchar(20) NOT NULL,
  `PasswordUser` varchar(50) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Estado` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_seg_user`
--

INSERT INTO `tbl_seg_user` (`UserId`, `PersonId`, `RolId`, `UserName`, `PasswordUser`, `Email`, `Estado`) VALUES
(2, 2, 2, 'admin', '123', 'admin', '1'),
(3, 2, 2, 'mauricio', '123', 'mauricio@gmail', '1'),
(6, 5, 3, 'david', '123', 'david@gmail', '1'),
(9, 1, 3, 'diego', '123', 'diego@hotmail', '2');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_person`
--
ALTER TABLE `tbl_person`
 ADD PRIMARY KEY (`personid`);

--
-- Indices de la tabla `tbl_roles`
--
ALTER TABLE `tbl_roles`
 ADD PRIMARY KEY (`RolId`), ADD UNIQUE KEY `Rol` (`Rol`);

--
-- Indices de la tabla `tbl_seg_loginhistory`
--
ALTER TABLE `tbl_seg_loginhistory`
 ADD KEY `UserId` (`UserId`);

--
-- Indices de la tabla `tbl_seg_permissions`
--
ALTER TABLE `tbl_seg_permissions`
 ADD PRIMARY KEY (`PermissionId`);

--
-- Indices de la tabla `tbl_seg_permissionsuserroles`
--
ALTER TABLE `tbl_seg_permissionsuserroles`
 ADD KEY `tbl_seg_permissionsuserroles_ibfk_1` (`PermissionId`), ADD KEY `tbl_seg_permissionsuserroles_ibfk_2` (`OwnerId`), ADD KEY `tbl_seg_permissionsuserroles_ibfk_3` (`OwnerType`);

--
-- Indices de la tabla `tbl_seg_user`
--
ALTER TABLE `tbl_seg_user`
 ADD PRIMARY KEY (`UserId`), ADD KEY `tbl_seg_user_ibfk_1` (`RolId`), ADD KEY `FK_tbl_seg_user` (`PersonId`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_roles`
--
ALTER TABLE `tbl_roles`
MODIFY `RolId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_seg_loginhistory`
--
ALTER TABLE `tbl_seg_loginhistory`
ADD CONSTRAINT `tbl_seg_loginhistory_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `tbl_seg_user` (`UserId`);

--
-- Filtros para la tabla `tbl_seg_permissionsuserroles`
--
ALTER TABLE `tbl_seg_permissionsuserroles`
ADD CONSTRAINT `tbl_seg_permissionsuserroles_ibfk_1` FOREIGN KEY (`PermissionId`) REFERENCES `tbl_seg_permissions` (`PermissionId`),
ADD CONSTRAINT `tbl_seg_permissionsuserroles_ibfk_2` FOREIGN KEY (`OwnerId`) REFERENCES `tbl_seg_user` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `tbl_seg_permissionsuserroles_ibfk_3` FOREIGN KEY (`OwnerType`) REFERENCES `tbl_roles` (`RolId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_seg_user`
--
ALTER TABLE `tbl_seg_user`
ADD CONSTRAINT `FK_tbl_seg_user` FOREIGN KEY (`PersonId`) REFERENCES `tbl_person` (`personid`),
ADD CONSTRAINT `tbl_seg_user_ibfk_1` FOREIGN KEY (`RolId`) REFERENCES `tbl_roles` (`RolId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
