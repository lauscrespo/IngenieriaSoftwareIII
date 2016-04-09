using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using DTO;

public partial class ListaVenta : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        try
        {
            int id = 1;
            DTO.Venta objVenta = (DTO.Venta)VentaBLL.Select(id);
            txtFecha.Text = objVenta.Fecha.Day + "-" + objVenta.Fecha.Month + "-" + objVenta.Fecha.Year;
            Cliente objCliente = ClienteBLL.Select(objVenta.Cliente_id);
            txtCliente.Text = objCliente.Nombre;
            txtTotal.Text = objVenta.Total + "";
        }
        catch { }

    }
    protected void dpID_SelectedIndexChanged(object sender, EventArgs e)
    {
        int id = Convert.ToInt32(dpID.SelectedValue);
        DTO.Venta objVenta = (DTO.Venta)VentaBLL.Select(id);
        txtFecha.Text = objVenta.Fecha.Day + "-" + objVenta.Fecha.Month + "-" + objVenta.Fecha.Year;
        Cliente objCliente = ClienteBLL.Select(objVenta.Cliente_id);
        txtCliente.Text = objCliente.Nombre;
        txtTotal.Text = objVenta.Total + "";
        Sqldetalle.SelectParameters["venta_id"].DefaultValue = id + "";
    }
}