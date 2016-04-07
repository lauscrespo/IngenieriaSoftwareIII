USE [Ventas]
GO

/****** Object:  StoredProcedure [dbo].[sp_tblVenta_deleteAll]    Script Date: 7/4/2016 04:08:25 p.m. ******/
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


/****** Object:  StoredProcedure [dbo].[sp_tblVenta_insertAll]    Script Date: 7/4/2016 04:08:45 p.m. ******/
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

/****** Object:  StoredProcedure [dbo].[sp_tblVenta_selectAll]    Script Date: 7/4/2016 04:09:06 p.m. ******/
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


/****** Object:  StoredProcedure [dbo].[sp_tblVenta_selectById]    Script Date: 7/4/2016 04:09:29 p.m. ******/
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

/****** Object:  StoredProcedure [dbo].[sp_tblVenta_updateAll]    Script Date: 7/4/2016 04:09:54 p.m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_tblVenta_updateAll]
(
	@fecha date,
	@cliente_id int,
	@total decimal(18, 0),
	@Original_venta_id int,
	@venta_id int
)
AS
	SET NOCOUNT OFF;
UPDATE [tbl_venta] SET [fecha] = @fecha, [cliente_id] = @cliente_id, [total] = @total WHERE (([venta_id] = @Original_venta_id));
	
SELECT venta_id, fecha, cliente_id, total FROM tbl_venta WHERE (venta_id = @venta_id)
GO


