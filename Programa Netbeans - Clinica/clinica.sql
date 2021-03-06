USE [master]
GO
/****** Object:  Database [clinica]    Script Date: 04/27/2016 18:21:27 ******/
CREATE DATABASE [clinica] ON  PRIMARY 
( NAME = N'clinica', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\clinica.mdf' , SIZE = 2304KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'clinica_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\clinica_log.LDF' , SIZE = 576KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [clinica] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [clinica].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [clinica] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [clinica] SET ANSI_NULLS OFF
GO
ALTER DATABASE [clinica] SET ANSI_PADDING OFF
GO
ALTER DATABASE [clinica] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [clinica] SET ARITHABORT OFF
GO
ALTER DATABASE [clinica] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [clinica] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [clinica] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [clinica] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [clinica] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [clinica] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [clinica] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [clinica] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [clinica] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [clinica] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [clinica] SET  DISABLE_BROKER
GO
ALTER DATABASE [clinica] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [clinica] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [clinica] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [clinica] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [clinica] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [clinica] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [clinica] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [clinica] SET  READ_WRITE
GO
ALTER DATABASE [clinica] SET RECOVERY SIMPLE
GO
ALTER DATABASE [clinica] SET  MULTI_USER
GO
ALTER DATABASE [clinica] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [clinica] SET DB_CHAINING OFF
GO
EXEC sys.sp_db_vardecimal_storage_format N'clinica', N'ON'
GO
USE [clinica]
GO
/****** Object:  Table [dbo].[tblPacientes]    Script Date: 04/27/2016 18:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblPacientes](
	[idPaciente] [int] IDENTITY(1,1) NOT NULL,
	[nombres] [varchar](50) NULL,
	[apellidos] [varchar](50) NULL,
	[edad] [int] NULL,
	[sexo] [varchar](50) NULL,
 CONSTRAINT [PK_tblPacientes] PRIMARY KEY CLUSTERED 
(
	[idPaciente] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_seg_permissions]    Script Date: 04/27/2016 18:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_seg_permissions](
	[PermissionId] [varchar](20) NOT NULL,
	[Mnemonic] [varchar](20) NOT NULL,
	[Description] [varchar](200) NULL,
 CONSTRAINT [PK_tbl_seg_permissions] PRIMARY KEY CLUSTERED 
(
	[PermissionId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_seg_loginhistory]    Script Date: 04/27/2016 18:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_seg_loginhistory](
	[UserId] [int] NULL,
	[FechaLog] [datetime] NOT NULL,
	[IP] [varchar](15) NOT NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_roles]    Script Date: 04/27/2016 18:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_roles](
	[RolId] [int] NOT NULL,
	[Rol] [varchar](20) NOT NULL,
 CONSTRAINT [PK_tbl_roles] PRIMARY KEY CLUSTERED 
(
	[RolId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_person]    Script Date: 04/27/2016 18:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_person](
	[personid] [int]  NOT NULL,
	[nombre] [varchar](50) NULL,
	[apellido] [varchar](50) NULL,
	[direccion] [varchar](50) NULL,
	[telefono] [int] NULL,
 CONSTRAINT [PK_tbl_person] PRIMARY KEY CLUSTERED 
(
	[personid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  StoredProcedure [dbo].[spInsertPacientes]    Script Date: 04/27/2016 18:21:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spInsertPacientes]   @nombres varchar(50),
									@apellidos varchar(50),
									@edad int,
									@sexo varchar(50)
AS
BEGIN TRY
	BEGIN TRAN 
		INSERT INTO tblPacientes(nombres,apellidos,edad,sexo)
		VALUES ( @nombres,@apellidos,@edad,@sexo) 
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH
GO
/****** Object:  UserDefinedFunction [dbo].[fnPacientesTable]    Script Date: 04/27/2016 18:21:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[fnPacientesTable] ()
RETURNS
	table
AS
RETURN
(
	SELECT *
	FROM tblPacientes
)
GO
/****** Object:  UserDefinedFunction [dbo].[fnPacientesSelectById]    Script Date: 04/27/2016 18:21:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[fnPacientesSelectById] (@idPaciente int)
RETURNS
	table
AS
RETURN
(
	SELECT idPaciente, nombres, apellidos, edad, sexo
	FROM tblPacientes
	WHERE idPaciente = @idPaciente
)
GO
/****** Object:  StoredProcedure [dbo].[spUpdatePacientes]    Script Date: 04/27/2016 18:21:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spUpdatePacientes]  @idPaciente int,
									@nombres varchar(50),
									@apellidos varchar(50),
									@edad int,
									@sexo varchar(50)
AS
BEGIN TRY
	BEGIN TRAN 
		UPDATE tblPacientes set nombres = @nombres,
								apellidos = @apellidos,
								edad = @edad,
								sexo = @sexo
		where idPaciente = @idPaciente
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH
GO
/****** Object:  Table [dbo].[tbl_seg_user]    Script Date: 04/27/2016 18:21:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_seg_user](
	[UserId] [int] NOT NULL,
	[PersonId] [int] NOT NULL,
	[RolId] [int] NOT NULL,
	[UserName] [varchar](20) NOT NULL,
	[PasswordUser] [varchar](50) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Estado] [varchar](1) NOT NULL,
 CONSTRAINT [PK_tbl_seg_user] PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_seg_permissionsuserroles]    Script Date: 04/27/2016 18:21:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_seg_permissionsuserroles](
	[PermissionId] [varchar](20) NOT NULL,
	[OwnerId] [int] NOT NULL,
	[OwnerType] [int] NOT NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  StoredProcedure [dbo].[spDeletePacientes]    Script Date: 04/27/2016 18:21:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spDeletePacientes]  @idPaciente int
AS
BEGIN TRY
	BEGIN TRAN 
		DELETE FROM tblPacientes WHERE  idPaciente = @idPaciente
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH
GO
/****** Object:  Table [dbo].[tblDoctores]    Script Date: 04/27/2016 18:21:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblDoctores](
	[idDoctor] [int] IDENTITY(1,1) NOT NULL,
	[fullName] [varchar](50) NULL,
	[especialidad] [varchar](50) NULL,
	[idUsuario] [int] NOT NULL,
 CONSTRAINT [PK_tblDoctor] PRIMARY KEY CLUSTERED 
(
	[idDoctor] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  StoredProcedure [dbo].[spInsertDoctores]    Script Date: 04/27/2016 18:21:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spInsertDoctores]   @fullname varchar(50),
									@especialidad varchar(50),
									@idUser int
AS
BEGIN TRY
	BEGIN TRAN 
		INSERT INTO tblDoctores(fullName,especialidad,idUsuario)
		VALUES ( @fullname,@especialidad,@idUser) 
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH
GO
/****** Object:  StoredProcedure [dbo].[spUpdateDoctores]    Script Date: 04/27/2016 18:21:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spUpdateDoctores]  @idDoctor int,
									@fullname varchar(50),
									@especialidad varchar(50),
									@idUser int
AS
BEGIN TRY
	BEGIN TRAN 
		UPDATE tblDoctores set fullName = @fullname,
								especialidad = @especialidad,
								idUsuario = @idUser
		where idDoctor = @idDoctor
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH
GO
/****** Object:  Table [dbo].[cita]    Script Date: 04/27/2016 18:21:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[cita](
	[cita_id] [int] IDENTITY(1,1) NOT NULL,
	[fecha_hora] [date] NULL,
	[doctor_id] [int] NULL,
	[paciente_id] [int] NULL,
	[observaciones] [char](500) NULL,
	[user_id] [int] NOT NULL,
 CONSTRAINT [PK_cita] PRIMARY KEY CLUSTERED 
(
	[cita_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  UserDefinedFunction [dbo].[fnDoctoresTable]    Script Date: 04/27/2016 18:21:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[fnDoctoresTable] ()
RETURNS
	table
AS
RETURN
(
	SELECT *
	FROM tblDoctores
)
GO
/****** Object:  UserDefinedFunction [dbo].[fnDoctoresSelectById]    Script Date: 04/27/2016 18:21:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[fnDoctoresSelectById] (@idDoctor int)
RETURNS
	table
AS
RETURN
(
	SELECT idDoctor, fullName, especialidad, idUsuario
	FROM tblDoctores
	WHERE idDoctor = @idDoctor
)
GO
/****** Object:  StoredProcedure [dbo].[spDeleteDoctores]    Script Date: 04/27/2016 18:21:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spDeleteDoctores]  @idDoctor int
AS
BEGIN TRY
	BEGIN TRAN 
		DELETE FROM tblDoctores WHERE  idDoctor = @idDoctor
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH
GO
/****** Object:  Table [dbo].[atencion_consulta]    Script Date: 04/27/2016 18:21:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[atencion_consulta](
	[atencion_id] [int] IDENTITY(1,1) NOT NULL,
	[fecha_hora] [date] NULL,
	[cita_id] [int] NULL,
	[observaciones] [char](500) NULL,
	[diagnostico] [char](500) NULL,
	[estudios] [char](500) NULL,
	[medicamentos] [char](500) NULL,
 CONSTRAINT [PK_atencion_consulta] PRIMARY KEY CLUSTERED 
(
	[atencion_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  StoredProcedure [dbo].[cita_TRANSACT]    Script Date: 04/27/2016 18:21:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[cita_TRANSACT](
@cita_id		Int,
@fecha_hora		date,
@doctor_id			int,
@paciente_id		int,
@observaciones		char(500),
@user_id			int,
@navega				char(20),
@proceso			char(20))
AS
BEGIN
	IF RTRIM(@proceso)='INSERT_'
	BEGIN
		INSERT INTO cita (fecha_hora,doctor_id,paciente_id,observaciones,user_id) VALUES(@fecha_hora,@doctor_id,
		@paciente_id,@observaciones,@user_id)
		SET @cita_id = @@IDENTITY
		SELECT *  FROM cita WHERE cita_id = @cita_id
	End
	IF RTRIM(@proceso)='MODIFY_'
	BEGIN
		UPDATE cita SET fecha_hora = @fecha_hora, doctor_id=@doctor_id,paciente_id=@paciente_id,
		observaciones=@observaciones,user_id=@user_id
		WHERE cita_id=@cita_id
	End
	IF RTRIM(@proceso)='DELETE_'
	BEGIN
		DELETE cita WHERE cita_id=@cita_id
	End
	IF RTRIM(@proceso)='QUERY_NAV'
	BEGIN
		IF RTRIM(@Navega)='BOTTON'
		BEGIN
			SELECT * FROM cita WHERE cita_id IN
			(SELECT MAX(cita_id) AS cita_id FROM cita)
		End
		ELSE
		BEGIN
			IF RTRIM(@Navega)='TOP'
			BEGIN
				-- va al primer registro
				SELECT * FROM cita WHERE cita_id IN 
				(SELECT min(cita_id) as cita_id FROM cita)
			End
			
		End
		IF RTRIM(@Navega) = 'NEXT'
				Begin
				SELECT top 1 * FROM cita WHERE cita_id > @cita_id
				order by cita_id asc
				End ELSE 
				BEGIN
					IF RTRIM(@Navega) = 'BACK'
					Begin
					SELECT top 1 * FROM cita WHERE  cita_id< @cita_id
					order by cita_id desc
					END ELSE
					BEGIN
						declare @datob int
						set @datob = cast(@Navega as integer)
						SELECT * FROM cita WHERE cita_id = @datob
					END
				END
	End
End
GO
/****** Object:  StoredProcedure [dbo].[atencion_consulta_TRANSACT]    Script Date: 04/27/2016 18:21:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[atencion_consulta_TRANSACT](
@atencion_id		Int,
@fecha_hora		date,
@cita_id			int,
@observaciones     char(500),
@diagnostico     char(500),
@estudios     char(500),
@medicamentos     char(500),
@navega				char(20),
@proceso			char(20))
AS
BEGIN
	IF RTRIM(@proceso)='INSERT_'
	BEGIN
		INSERT INTO atencion_consulta (fecha_hora,cita_id, observaciones,diagnostico, estudios, medicamentos) 
		VALUES(@fecha_hora,@cita_id,@observaciones,@diagnostico, @estudios, @medicamentos)
		SET @atencion_id = @@IDENTITY
		SELECT *  FROM atencion_consulta WHERE atencion_id = @atencion_id
	End
	IF RTRIM(@proceso)='MODIFY_'
	BEGIN
		UPDATE atencion_consulta SET fecha_hora = @fecha_hora, cita_id=@cita_id, observaciones=@observaciones,
		diagnostico=@diagnostico, estudios=@estudios, medicamentos=@medicamentos
		WHERE atencion_id=@atencion_id
	End
	IF RTRIM(@proceso)='DELETE_'
	BEGIN
		Delete atencion_consulta
		WHERE atencion_id=@atencion_id
	End
	IF RTRIM(@proceso)='QUERY_NAV'
	BEGIN
		IF RTRIM(@Navega)='BOTTON'
		BEGIN
			SELECT * FROM atencion_consulta WHERE atencion_id IN
			(SELECT MAX(atencion_id) AS atencion_id FROM atencion_consulta)
		End
		ELSE
		BEGIN
			IF RTRIM(@Navega)='TOP'
			BEGIN
				-- va al primer registro
				SELECT * FROM atencion_consulta WHERE atencion_id IN 
				(SELECT min(atencion_id) as atencion_id FROM atencion_consulta)
			End
			
		End
		IF RTRIM(@Navega) = 'NEXT'
				Begin
				SELECT top 1 * FROM atencion_consulta WHERE atencion_id > @atencion_id
				order by atencion_id asc
				End ELSE 
				BEGIN
					IF RTRIM(@Navega) = 'BACK'
					Begin
					SELECT top 1 * FROM atencion_consulta WHERE  atencion_id< @atencion_id
					order by atencion_id desc
					END ELSE
					BEGIN
						declare @datob int
						set @datob = cast(@Navega as integer)
						SELECT * FROM atencion_consulta WHERE atencion_id = @datob
					END
				END
	End
End
GO
/****** Object:  Default [DF__tbl_seg_l__UserI__656C112C]    Script Date: 04/27/2016 18:21:32 ******/
ALTER TABLE [dbo].[tbl_seg_loginhistory] ADD  DEFAULT (NULL) FOR [UserId]
GO
/****** Object:  Default [DF__tbl_perso__nombr__300424B4]    Script Date: 04/27/2016 18:21:32 ******/
ALTER TABLE [dbo].[tbl_person] ADD  CONSTRAINT [DF__tbl_perso__nombr__300424B4]  DEFAULT (NULL) FOR [nombre]
GO
/****** Object:  Default [DF__tbl_perso__apell__30F848ED]    Script Date: 04/27/2016 18:21:32 ******/
ALTER TABLE [dbo].[tbl_person] ADD  CONSTRAINT [DF__tbl_perso__apell__30F848ED]  DEFAULT (NULL) FOR [apellido]
GO
/****** Object:  Default [DF__tbl_perso__direc__31EC6D26]    Script Date: 04/27/2016 18:21:32 ******/
ALTER TABLE [dbo].[tbl_person] ADD  CONSTRAINT [DF__tbl_perso__direc__31EC6D26]  DEFAULT (NULL) FOR [direccion]
GO
/****** Object:  Default [DF__tbl_perso__telef__32E0915F]    Script Date: 04/27/2016 18:21:32 ******/
ALTER TABLE [dbo].[tbl_person] ADD  CONSTRAINT [DF__tbl_perso__telef__32E0915F]  DEFAULT (NULL) FOR [telefono]
GO
/****** Object:  Default [DF__tbl_seg_u__Perso__35BCFE0A]    Script Date: 04/27/2016 18:21:35 ******/
ALTER TABLE [dbo].[tbl_seg_user] ADD  CONSTRAINT [DF__tbl_seg_u__Perso__35BCFE0A]  DEFAULT (NULL) FOR [PersonId]
GO
/****** Object:  ForeignKey [FK_tbl_seg_user_tbl_person]    Script Date: 04/27/2016 18:21:35 ******/
ALTER TABLE [dbo].[tbl_seg_user]  WITH CHECK ADD  CONSTRAINT [FK_tbl_seg_user_tbl_person] FOREIGN KEY([PersonId])
REFERENCES [dbo].[tbl_person] ([personid])
GO
ALTER TABLE [dbo].[tbl_seg_user] CHECK CONSTRAINT [FK_tbl_seg_user_tbl_person]
GO
/****** Object:  ForeignKey [FK_tbl_seg_user_tbl_roles]    Script Date: 04/27/2016 18:21:35 ******/
ALTER TABLE [dbo].[tbl_seg_user]  WITH CHECK ADD  CONSTRAINT [FK_tbl_seg_user_tbl_roles] FOREIGN KEY([RolId])
REFERENCES [dbo].[tbl_roles] ([RolId])
GO
ALTER TABLE [dbo].[tbl_seg_user] CHECK CONSTRAINT [FK_tbl_seg_user_tbl_roles]
GO
/****** Object:  ForeignKey [FK_tbl_seg_permissionsuserroles_tbl_roles]    Script Date: 04/27/2016 18:21:35 ******/
ALTER TABLE [dbo].[tbl_seg_permissionsuserroles]  WITH CHECK ADD  CONSTRAINT [FK_tbl_seg_permissionsuserroles_tbl_roles] FOREIGN KEY([OwnerId])
REFERENCES [dbo].[tbl_roles] ([RolId])
GO
ALTER TABLE [dbo].[tbl_seg_permissionsuserroles] CHECK CONSTRAINT [FK_tbl_seg_permissionsuserroles_tbl_roles]
GO
/****** Object:  ForeignKey [FK_tbl_seg_permissionsuserroles_tbl_seg_permissions]    Script Date: 04/27/2016 18:21:35 ******/
ALTER TABLE [dbo].[tbl_seg_permissionsuserroles]  WITH CHECK ADD  CONSTRAINT [FK_tbl_seg_permissionsuserroles_tbl_seg_permissions] FOREIGN KEY([PermissionId])
REFERENCES [dbo].[tbl_seg_permissions] ([PermissionId])
GO
ALTER TABLE [dbo].[tbl_seg_permissionsuserroles] CHECK CONSTRAINT [FK_tbl_seg_permissionsuserroles_tbl_seg_permissions]
GO
/****** Object:  ForeignKey [FK_tblDoctores_tbl_seg_user]    Script Date: 04/27/2016 18:21:35 ******/
ALTER TABLE [dbo].[tblDoctores]  WITH CHECK ADD  CONSTRAINT [FK_tblDoctores_tbl_seg_user] FOREIGN KEY([idUsuario])
REFERENCES [dbo].[tbl_seg_user] ([UserId])
GO
ALTER TABLE [dbo].[tblDoctores] CHECK CONSTRAINT [FK_tblDoctores_tbl_seg_user]
GO
/****** Object:  ForeignKey [FK_cita_tbl_seg_user]    Script Date: 04/27/2016 18:21:35 ******/
ALTER TABLE [dbo].[cita]  WITH CHECK ADD  CONSTRAINT [FK_cita_tbl_seg_user] FOREIGN KEY([user_id])
REFERENCES [dbo].[tbl_seg_user] ([UserId])
GO
ALTER TABLE [dbo].[cita] CHECK CONSTRAINT [FK_cita_tbl_seg_user]
GO
/****** Object:  ForeignKey [FK_cita_tblDoctores]    Script Date: 04/27/2016 18:21:35 ******/
ALTER TABLE [dbo].[cita]  WITH CHECK ADD  CONSTRAINT [FK_cita_tblDoctores] FOREIGN KEY([doctor_id])
REFERENCES [dbo].[tblDoctores] ([idDoctor])
GO
ALTER TABLE [dbo].[cita] CHECK CONSTRAINT [FK_cita_tblDoctores]
GO
/****** Object:  ForeignKey [FK_cita_tblPacientes]    Script Date: 04/27/2016 18:21:35 ******/
ALTER TABLE [dbo].[cita]  WITH CHECK ADD  CONSTRAINT [FK_cita_tblPacientes] FOREIGN KEY([paciente_id])
REFERENCES [dbo].[tblPacientes] ([idPaciente])
GO
ALTER TABLE [dbo].[cita] CHECK CONSTRAINT [FK_cita_tblPacientes]
GO
/****** Object:  ForeignKey [FK_atencion_consulta_cita]    Script Date: 04/27/2016 18:21:35 ******/
ALTER TABLE [dbo].[atencion_consulta]  WITH CHECK ADD  CONSTRAINT [FK_atencion_consulta_cita] FOREIGN KEY([cita_id])
REFERENCES [dbo].[cita] ([cita_id])
GO
ALTER TABLE [dbo].[atencion_consulta] CHECK CONSTRAINT [FK_atencion_consulta_cita]
GO
