using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using DTO;
/// <summary>
/// Summary description for DetalleVentaBLL
/// </summary>
public class DetalleVentaBLL
{
	public DetalleVentaBLL()
	{
		//
		// TODO: Add constructor logic here
		//
	}

    public static void Insert(int venta_id, int producto_id, decimal precio, int cantidad, decimal subtotal)
    {
        DetalleVentaDSTableAdapters.DetalleVentaTableAdapter adapter = new DetalleVentaDSTableAdapters.DetalleVentaTableAdapter();
        adapter.Insert(venta_id,producto_id,precio,subtotal, cantidad);
    }
    public static void Update(int venta_id, int producto_id, decimal precio, int cantidad, decimal subtotal, int DetalleVenta_id)
    {
        DetalleVentaDSTableAdapters.DetalleVentaTableAdapter adapter = new DetalleVentaDSTableAdapters.DetalleVentaTableAdapter();
        adapter.Update(venta_id,producto_id,precio,subtotal, cantidad,DetalleVenta_id);
    }
    public static void Delete(int id)
    {
        DetalleVentaDSTableAdapters.DetalleVentaTableAdapter adapter = new DetalleVentaDSTableAdapters.DetalleVentaTableAdapter();
        adapter.Delete(id);
    }
    public static List<DetalleVenta> SelectAll()
    {
        DetalleVentaDSTableAdapters.DetalleVentaTableAdapter adapter = new DetalleVentaDSTableAdapters.DetalleVentaTableAdapter();
        DetalleVentaDS.DetalleVentaDataTable table = adapter.selectAll();
        List<DetalleVenta> listaDetalleVentas = new List<DetalleVenta>();
        foreach (DetalleVentaDS.DetalleVentaRow row in table)
        {
            listaDetalleVentas.Add(RowToDto(row));
        }
        return listaDetalleVentas;
    }

    private static DetalleVenta RowToDto(DetalleVentaDS.DetalleVentaRow row)
    {
        DetalleVenta objDetalleVenta = new DetalleVenta();
        objDetalleVenta.detalleVenta_id = row.id_detalleVenta;
        objDetalleVenta.venta_id = row.venta_id;
        objDetalleVenta.producto_id = row.producto_id;
        objDetalleVenta.precio = row.precio;
        objDetalleVenta.cantidad = row.cantidad;
        objDetalleVenta.subtotal = row.subtotal;
        return objDetalleVenta;
    }

    public static DetalleVenta Select(int id)
    {
        DetalleVentaDSTableAdapters.DetalleVentaTableAdapter adapter = new DetalleVentaDSTableAdapters.DetalleVentaTableAdapter();
        DetalleVentaDS.DetalleVentaDataTable table = adapter.selectById(id);
        DetalleVenta objDetalleVenta = RowToDto(table[0]);
        return objDetalleVenta;
    }
    public static DetalleVenta SelectVenta(int id_venta)
    {
        DetalleVentaDSTableAdapters.DetalleVentaTableAdapter adapter = new DetalleVentaDSTableAdapters.DetalleVentaTableAdapter();
        DetalleVentaDS.DetalleVentaDataTable table = adapter.selectByIdVenta(id_venta);
        DetalleVenta objDetalleVenta = RowToDto(table[0]);
        return objDetalleVenta;
    }
}