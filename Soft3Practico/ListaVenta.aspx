<%@ Page Language="C#" AutoEventWireup="true" CodeFile="ListaVenta.aspx.cs" Inherits="ListaVenta" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Soft III | Venta</title>
    <link href="css/style.css" rel="stylesheet" />
    <link href="css/style_lista.css" rel="stylesheet" />
</head>
<body>
    <header class="center">
        <h1>Ingenieria de Software III</h1>
        <p>Ing. Jose Caslos Gutierrez Miranda</p>
        <nav class="menu center">
            <ul>
                <li>
                    <a href="Cliente.aspx">Cliente</a>
                </li>
                <li>
                    <a href="#">Producto
                    </a>
                </li>
                <li>
                    <a href="Venta.aspx">
                        Venta
                    </a>
                </li>
                <li>
                    <a href="ListaVenta.aspx">
                        <span>Lista Venta</span>
                    </a>
                </li>
            </ul>
        </nav>
    </header>
    <div class="center">
        <form id="form1" runat="server">
            <%--Cabecera--%>
            <div>
            <asp:Label CssClass="csscabe" ID="Label1" runat="server" Text="ID Venta:"></asp:Label>
            <asp:DropDownList CssClass="csscabe" ID="dpID" runat="server" AutoPostBack="true" DataSourceID="sqlVenta" DataTextField="venta_id" DataValueField="venta_id" Height="27px" Width="136px" OnSelectedIndexChanged="dpID_SelectedIndexChanged">
            </asp:DropDownList><br />
            <asp:SqlDataSource ID="sqlVenta" runat="server" ConnectionString="<%$ ConnectionStrings:VentasConnectionString %>" SelectCommand="sp_tblVenta_selectAll" SelectCommandType="StoredProcedure">
            </asp:SqlDataSource>
                <asp:Label CssClass="csscabe" ID="Label2" runat="server" Text="Fecha:"></asp:Label>
                &nbsp;&nbsp;
                <asp:TextBox CssClass="csscabe" ID="txtFecha" runat="server"  ></asp:TextBox>
                <br />
                <asp:Label CssClass="csscabe" ID="Label3" runat="server" Text="Cliente:"></asp:Label>
                &nbsp;<asp:TextBox CssClass="csscabe" ID="txtCliente" runat="server" ></asp:TextBox>
                <br />
                <asp:Label CssClass="csscabe" ID="Label4" runat="server" Text="Total:"></asp:Label>
                &nbsp;&nbsp;&nbsp;
                <asp:TextBox CssClass="csscabe" ID="txtTotal" runat="server" ></asp:TextBox>
                <br />
            </div>

             <%-- Detalle de Venta--%>
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" BackColor="White" BorderColor="#CCCCCC" BorderStyle="None" BorderWidth="1px" CellPadding="3" DataKeyNames="id_detalleVenta" DataSourceID="Sqldetalle">
                <Columns>
                    <asp:BoundField DataField="producto_id" HeaderText="ID Producto" SortExpression="producto_id" />
                    <asp:BoundField DataField="precio" HeaderText="Precio" SortExpression="precio" />
                    <asp:BoundField DataField="cantidad" HeaderText="Cantidad" SortExpression="cantidad" />
                    <asp:BoundField DataField="subtotal" HeaderText="Subtotal" SortExpression="subtotal" />
                </Columns>
                <FooterStyle BackColor="White" ForeColor="#000066" />
                <HeaderStyle BackColor="#CDDC39" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="White" ForeColor="#000066" HorizontalAlign="Left" />
                <RowStyle ForeColor="#000066" />
                <SelectedRowStyle BackColor="#669999" Font-Bold="True" ForeColor="White" />
                <SortedAscendingCellStyle BackColor="#F1F1F1" />
                <SortedAscendingHeaderStyle BackColor="#007DBB" />
                <SortedDescendingCellStyle BackColor="#CAC9C9" />
                <SortedDescendingHeaderStyle BackColor="#00547E" />
            </asp:GridView>
            <asp:SqlDataSource ID="Sqldetalle" runat="server" ConnectionString="<%$ ConnectionStrings:VentasConnectionString %>" SelectCommand="selectByIdVenta" SelectCommandType="StoredProcedure">
                <SelectParameters>
                    <asp:Parameter DefaultValue="1" Name="venta_id" Type="Int32" />
                </SelectParameters>
            </asp:SqlDataSource>

        </form>
    </div>
</body>
</html>
