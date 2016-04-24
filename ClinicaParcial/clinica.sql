USE [master]
GO
/****** Object:  Database [clinica]    Script Date: 24/4/2016 07:49:37 p.m. ******/
CREATE DATABASE [clinica]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'clinica', FILENAME = N'c:\Program Files (x86)\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\clinica.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'clinica_log', FILENAME = N'c:\Program Files (x86)\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\clinica_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [clinica] SET COMPATIBILITY_LEVEL = 110
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
ALTER DATABASE [clinica] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [clinica] SET  MULTI_USER 
GO
ALTER DATABASE [clinica] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [clinica] SET DB_CHAINING OFF 
GO
ALTER DATABASE [clinica] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [clinica] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [clinica]
GO
/****** Object:  StoredProcedure [dbo].[spDeleteDoctores]    Script Date: 24/4/2016 07:49:37 p.m. ******/
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
/****** Object:  StoredProcedure [dbo].[spDeletePacientes]    Script Date: 24/4/2016 07:49:37 p.m. ******/
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
/****** Object:  StoredProcedure [dbo].[spInsertDoctores]    Script Date: 24/4/2016 07:49:37 p.m. ******/
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
/****** Object:  StoredProcedure [dbo].[spInsertPacientes]    Script Date: 24/4/2016 07:49:37 p.m. ******/
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
/****** Object:  StoredProcedure [dbo].[spUpdateDoctores]    Script Date: 24/4/2016 07:49:37 p.m. ******/
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
/****** Object:  StoredProcedure [dbo].[spUpdatePacientes]    Script Date: 24/4/2016 07:49:37 p.m. ******/
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
/****** Object:  Table [dbo].[tblDoctores]    Script Date: 24/4/2016 07:49:37 p.m. ******/
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
	[idUsuario] [int] NULL,
 CONSTRAINT [PK_tblDoctor] PRIMARY KEY CLUSTERED 
(
	[idDoctor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblPacientes]    Script Date: 24/4/2016 07:49:37 p.m. ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  UserDefinedFunction [dbo].[fnDoctoresSelectById]    Script Date: 24/4/2016 07:49:37 p.m. ******/
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
/****** Object:  UserDefinedFunction [dbo].[fnDoctoresTable]    Script Date: 24/4/2016 07:49:37 p.m. ******/
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
/****** Object:  UserDefinedFunction [dbo].[fnPacientesSelectById]    Script Date: 24/4/2016 07:49:37 p.m. ******/
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
/****** Object:  UserDefinedFunction [dbo].[fnPacientesTable]    Script Date: 24/4/2016 07:49:37 p.m. ******/
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
USE [master]
GO
ALTER DATABASE [clinica] SET  READ_WRITE 
GO
