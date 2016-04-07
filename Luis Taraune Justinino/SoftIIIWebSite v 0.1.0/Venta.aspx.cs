using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using DTO;

public partial class Venta : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        Calendar1.Visible = false;
        if (!IsPostBack)
        {
            try
            {
                int id = Convert.ToInt32(Request.QueryString["Cliente_id"]);
                Cliente objCliente = ClienteBLL.Select(id);
                txtnombreCliente.Text = objCliente.Nombre;
                txtIdCliente.Text = Convert.ToString(objCliente.Cliente_id);
            }
            catch
            {

            }
        }
    }

    protected void btnInsertarVenta_Click(object sender, EventArgs e)
    {
        try
        {
            VentaBLL.Insert(Convert.ToDateTime(txtFecha.Text),
                        Convert.ToInt32(txtIdCliente.Text),
                        Convert.ToDecimal(txtTotal.Text)
                        );
            Response.Redirect("Venta.aspx");
        }
        catch
        {

        }
        
    }
    protected void Calendar1_SelectionChanged(object sender, EventArgs e)
    {
        txtFecha.Text = Calendar1.SelectedDate.ToString("yyyy/MM/dd");
        Calendar1.Visible = false;
    }
    protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
    {
        Calendar1.Visible = true;
    }
}