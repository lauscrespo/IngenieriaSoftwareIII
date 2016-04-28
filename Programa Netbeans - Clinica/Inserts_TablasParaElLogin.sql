
--Inserts Person

INSERT INTO tbl_person (personid, nombre, apellido, direccion, telefono) VALUES
(1, 'Diego', 'Oropeza', 'calle12', 123),
(2, 'Mauricio', 'Pinto', 'calle', 123),
(5, 'David', 'Moralez', 'calle', 123),
(10, 'carlos', 'Valverde', 'Va. Santo Rumon', 125),
(12, 'Pablo', 'Peres', 'calle 10', 45222),
(15, 'pedro', 'peres', 'calle', 1255),
(45, 'Carlos', 'roca', 'ave', 12568);

--Insert Roles

INSERT INTO tbl_roles (RolId, Rol) VALUES
(2, 'Doctor'),
(3, 'Paciente');


--Insert Permisos

INSERT INTO tbl_seg_permissions (PermissionId, Mnemonic, Description) VALUES
('0', 'ver', 'ver'),
('1', 'editar', 'editar'),
('2', 'eliminar', 'eliminar'),
('3', 'añadir', 'añadir'),
('4', 'control Parcial', 'control Parcial'),
('5', 'control total', 'control total');


--Insert Users

INSERT INTO tbl_seg_user (UserId, PersonId, RolId, UserName, PasswordUser, Email, Estado) VALUES
(2, 2, 2, 'admin', '123', 'admin', '1'),
(3, 2, 2, 'mauricio', '123', 'mauricio@gmail', '1'),
(6, 5, 3, 'david', '123', 'david@gmail', '1'),
(9, 1, 3, 'diego', '123', 'diego@hotmail', '2');

--Insert PerimisosRoles

INSERT INTO tbl_seg_permissionsuserroles (PermissionId, OwnerId, OwnerType) VALUES
('0', 2, 2),
('5', 3, 2),
('0', 6, 3);


