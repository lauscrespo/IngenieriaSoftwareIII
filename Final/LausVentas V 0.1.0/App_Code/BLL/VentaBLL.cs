using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using DTO;
/// <summary>
/// Summary description for VentaBLL
/// </summary>
public class VentaBLL
{
	public VentaBLL()
	{
		//
		// TODO: Add constructor logic here
		//
	}

    public static void Insert(DateTime fecha, int cliente_id, decimal total)
    {
        VentaDSTableAdapters.VentaTableAdapter adapter = new VentaDSTableAdapters.VentaTableAdapter();
        adapter.Insert(fecha, cliente_id, total);
    }
    public static void Update(DateTime fecha, int cliente_id, decimal total, int Venta_id)
    {
        VentaDSTableAdapters.VentaTableAdapter adapter = new VentaDSTableAdapters.VentaTableAdapter();
        adapter.Update(fecha, cliente_id, total ,Venta_id);
    }
    public static void Delete(int id)
    {
        VentaDSTableAdapters.VentaTableAdapter adapter = new VentaDSTableAdapters.VentaTableAdapter();
        adapter.Delete(id);
    }
    public static List<Venta> SelectAll()
    {
        VentaDSTableAdapters.VentaTableAdapter adapter = new VentaDSTableAdapters.VentaTableAdapter();
        VentaDS.VentaDataTable table = adapter.selectAll();
        List<Venta> listaVentas = new List<Venta>();
        foreach (VentaDS.VentaRow row in table)
        {
            listaVentas.Add(RowToDto(row));
        }
        return listaVentas;
    }

    private static Venta RowToDto(VentaDS.VentaRow row)
    {
        Venta objVenta = new Venta();
        objVenta.Venta_id = row.venta_id;
        objVenta.Fecha = row.fecha;
        objVenta.Cliente_id = row.cliente_id;
        objVenta.Total = row.total;
        return objVenta;
    }

    public static Venta Select(int id)
    {
        VentaDSTableAdapters.VentaTableAdapter adapter = new VentaDSTableAdapters.VentaTableAdapter();
        VentaDS.VentaDataTable table = adapter.selectById(id);
        Venta objVenta = RowToDto(table[0]);
        return objVenta;
    }
}