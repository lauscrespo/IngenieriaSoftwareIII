using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Insert : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void btnInsertarCliente_Click(object sender, EventArgs e)
    {
        ClienteBLL.Insert(txtNombre.Text,
            txtNit.Text
            );
        Response.Redirect("Cliente.aspx");
    }
}