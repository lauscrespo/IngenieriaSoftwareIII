using DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Actualizar : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            int id = Convert.ToInt32(Request.QueryString["Cliente_id"]);
           Cliente objCliente = ClienteBLL.Select(id);
            txtNombre.Text = objCliente.Nombre;
            txtNit.Text = objCliente.Nit;
            hdnID.Value = id.ToString();
        }
    }
    protected void btnActualizarCliente_Click(object sender, EventArgs e)
    {
        ClienteBLL.Update(txtNombre.Text,
            txtNit.Text,
            Convert.ToInt32(hdnID.Value)
            );
        Response.Redirect("Default.aspx");
    }
}