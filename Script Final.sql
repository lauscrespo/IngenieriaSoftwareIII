USE [Ventas]
GO
/****** Object:  Table [dbo].[tbl_venta]    Script Date: 04/09/2016 01:10:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_venta](
	[venta_id] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [date] NULL,
	[cliente_id] [int] NULL,
	[total] [decimal](18, 0) NULL,
 CONSTRAINT [PK_tbl_venta] PRIMARY KEY CLUSTERED 
(
	[venta_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_productos]    Script Date: 04/09/2016 01:10:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_productos](
	[producto_id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NULL,
	[precio] [decimal](18, 0) NULL,
 CONSTRAINT [PK_tbl_productos] PRIMARY KEY CLUSTERED 
(
	[producto_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_detalleVenta]    Script Date: 04/09/2016 01:10:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_detalleVenta](
	[venta_id] [int] NOT NULL,
	[producto_id] [int] NULL,
	[precio] [decimal](18, 0) NULL,
	[subtotal] [decimal](18, 0) NULL,
	[id_detalleVenta] [int] IDENTITY(1,1) NOT NULL,
	[cantidad] [int] NULL,
 CONSTRAINT [PK_tbl_detalleVenta] PRIMARY KEY CLUSTERED 
(
	[id_detalleVenta] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_cliente]    Script Date: 04/09/2016 01:10:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_cliente](
	[cliente_id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NULL,
	[nit] [varchar](50) NULL,
 CONSTRAINT [PK_tbl_cliente] PRIMARY KEY CLUSTERED 
(
	[cliente_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  StoredProcedure [dbo].[sp_tblVenta_selectById]    Script Date: 04/09/2016 01:10:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_tblVenta_selectById]
(
	@venta_id int
)
AS
	SET NOCOUNT ON;
SELECT venta_id, fecha, cliente_id, total
FROM     tbl_venta
WHERE  (venta_id = @venta_id)
GO
/****** Object:  StoredProcedure [dbo].[sp_tblVenta_selectAll]    Script Date: 04/09/2016 01:10:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_tblVenta_selectAll]
AS
	SET NOCOUNT ON;
SELECT venta_id, fecha, cliente_id, total
FROM     tbl_venta
GO
/****** Object:  StoredProcedure [dbo].[sp_tblVenta_insertAll]    Script Date: 04/09/2016 01:10:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_tblVenta_insertAll]
(
	@fecha date,
	@cliente_id int,
	@total decimal(18, 0)
)
AS
	SET NOCOUNT OFF;
INSERT INTO [tbl_venta] ([fecha], [cliente_id], [total]) VALUES (@fecha, @cliente_id, @total);
	
SELECT venta_id, fecha, cliente_id, total FROM tbl_venta WHERE (venta_id = SCOPE_IDENTITY())
GO
/****** Object:  StoredProcedure [dbo].[sp_tblVenta_deleteAll]    Script Date: 04/09/2016 01:10:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_tblVenta_deleteAll]
(
	@Original_venta_id int
)
AS
	SET NOCOUNT OFF;
DELETE FROM [tbl_venta] WHERE (([venta_id] = @Original_venta_id))
GO
/****** Object:  StoredProcedure [dbo].[sp_tblDetalleVenta_update]    Script Date: 04/09/2016 01:10:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_tblDetalleVenta_update]
(
	@venta_id int,
	@producto_id int,
	@precio decimal(18, 0),
	@subtotal decimal(18, 0),
	@cantidad int,
	@Original_id_detalleVenta int,
	@id_detalleVenta int
)
AS
	SET NOCOUNT OFF;
UPDATE [tbl_detalleVenta] SET [venta_id] = @venta_id, [producto_id] = @producto_id, [precio] = @precio, [subtotal] = @subtotal, [cantidad] = @cantidad WHERE (([id_detalleVenta] = @Original_id_detalleVenta));
	
SELECT venta_id, producto_id, precio, subtotal, id_detalleVenta, cantidad FROM tbl_detalleVenta WHERE (id_detalleVenta = @id_detalleVenta)
GO
/****** Object:  StoredProcedure [dbo].[sp_tblDetalleVenta_selectById]    Script Date: 04/09/2016 01:10:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_tblDetalleVenta_selectById]
(
	@id_detalleVenta int
)
AS
	SET NOCOUNT ON;
SELECT venta_id, producto_id, precio, cantidad, id_detalleVenta, subtotal
FROM     tbl_detalleVenta
WHERE  (id_detalleVenta = @id_detalleVenta)
GO
/****** Object:  StoredProcedure [dbo].[sp_tblDetalleVenta_selectAll]    Script Date: 04/09/2016 01:10:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_tblDetalleVenta_selectAll]
AS
	SET NOCOUNT ON;
SELECT venta_id, producto_id, precio, subtotal, id_detalleVenta, cantidad
FROM     tbl_detalleVenta
GO
/****** Object:  StoredProcedure [dbo].[sp_tblDetalleVenta_insert]    Script Date: 04/09/2016 01:10:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_tblDetalleVenta_insert]
(
	@venta_id int,
	@producto_id int,
	@precio decimal(18, 0),
	@subtotal decimal(18, 0),
	@cantidad int
)
AS
	SET NOCOUNT OFF;
INSERT INTO [tbl_detalleVenta] ([venta_id], [producto_id], [precio], [subtotal], [cantidad]) VALUES (@venta_id, @producto_id, @precio, @subtotal, @cantidad);
	
SELECT venta_id, producto_id, precio, subtotal, id_detalleVenta, cantidad FROM tbl_detalleVenta WHERE (id_detalleVenta = SCOPE_IDENTITY())
GO
/****** Object:  StoredProcedure [dbo].[sp_tblDetalleVenta_delete]    Script Date: 04/09/2016 01:10:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_tblDetalleVenta_delete]
(
	@Original_id_detalleVenta int
)
AS
	SET NOCOUNT OFF;
DELETE FROM [tbl_detalleVenta] WHERE (([id_detalleVenta] = @Original_id_detalleVenta))
GO
/****** Object:  StoredProcedure [dbo].[sp_tblClientes_updateAll]    Script Date: 04/09/2016 01:10:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_tblClientes_updateAll]
(
	@nombre varchar(50),
	@nit varchar(50),
	@Original_cliente_id int,
	@cliente_id int
)
AS
	SET NOCOUNT OFF;
UPDATE [tbl_cliente] SET [nombre] = @nombre, [nit] = @nit WHERE (([cliente_id] = @Original_cliente_id));
	
SELECT nombre, nit, cliente_id FROM tbl_cliente WHERE (cliente_id = @cliente_id)
GO
/****** Object:  StoredProcedure [dbo].[sp_tblClientes_selectAll]    Script Date: 04/09/2016 01:10:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_tblClientes_selectAll]
AS
	SET NOCOUNT ON;
SELECT nombre, nit, cliente_id
FROM     tbl_cliente
GO
/****** Object:  StoredProcedure [dbo].[sp_tblClientes_insertAll]    Script Date: 04/09/2016 01:10:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_tblClientes_insertAll]
(
	@nombre varchar(50),
	@nit varchar(50)
)
AS
	SET NOCOUNT OFF;
INSERT INTO [tbl_cliente] ([nombre], [nit]) VALUES (@nombre, @nit);
	
SELECT nombre, nit, cliente_id FROM tbl_cliente WHERE (cliente_id = SCOPE_IDENTITY())
GO
/****** Object:  StoredProcedure [dbo].[sp_tblClientes_deleteAll]    Script Date: 04/09/2016 01:10:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_tblClientes_deleteAll]
(
	@Original_cliente_id int
)
AS
	SET NOCOUNT OFF;
DELETE FROM [tbl_cliente] WHERE (([cliente_id] = @Original_cliente_id))
GO
/****** Object:  StoredProcedure [dbo].[sp_tblCliente_selectById]    Script Date: 04/09/2016 01:10:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_tblCliente_selectById]
(
	@cliente_id int
)
AS
	SET NOCOUNT ON;
SELECT cliente_id, nit, nombre
FROM     tbl_cliente
WHERE  (cliente_id = @cliente_id)
GO
/****** Object:  StoredProcedure [dbo].[selectByIdVenta]    Script Date: 04/09/2016 01:10:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[selectByIdVenta]
(
	@venta_id int
)
AS
	SET NOCOUNT ON;
SELECT venta_id, producto_id, precio, subtotal, id_detalleVenta, cantidad
FROM     tbl_detalleVenta
WHERE  (venta_id = @venta_id)
GO
