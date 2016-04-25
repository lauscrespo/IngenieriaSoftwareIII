USE [Hospital]
GO
/****** Object:  Table [dbo].[atencion_consulta]    Script Date: 04/25/2016 17:07:43 ******/
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
/****** Object:  Table [dbo].[cita]    Script Date: 04/25/2016 17:07:43 ******/
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
	[user_id] [int] NULL,
 CONSTRAINT [PK_cita] PRIMARY KEY CLUSTERED 
(
	[cita_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  StoredProcedure [dbo].[cita_TRANSACT]    Script Date: 04/25/2016 17:07:44 ******/
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
/****** Object:  StoredProcedure [dbo].[atencion_consulta_TRANSACT]    Script Date: 04/25/2016 17:07:44 ******/
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
