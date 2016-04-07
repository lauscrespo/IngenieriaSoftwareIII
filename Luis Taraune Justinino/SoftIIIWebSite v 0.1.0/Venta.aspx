<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Venta.aspx.cs" Inherits="Venta" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Soft III | Venta</title>
    <link href="css/style.css" rel="stylesheet" />
</head>
<body>
    <header class="center">
        <h1>Ingenieria de Software III</h1>
        <p>Ing. Jose Caslos Gutierrez Miranda</p>
        <nav class="menu center">
                <ul>
                    <li>
                        <a href="Cliente.aspx">
                            Cliente
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            Producto
                        </a>
                    </li>
                    <li>
                        <a href="Venta.aspx">
                            <span>Venta</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            Lista Venta
                        </a>
                    </li>
                </ul>
            </nav>
    </header>
    <div class="center">
        <form id="form1" runat="server">
            <div>
                <a class="ud" id="btnSelectCliente" href="SelectCliente.aspx" >
                    Seleccionar Cliente
                </a>
            </div>
            <div>
                <p>Nombre del Cliente:</p>
            </div>
            <div>
                <asp:TextBox runat="server" ID="txtnombreCliente" Height="16px" Enabled="False" />
            </div>
            <div>
                <p>ID:</p>
            </div>
            <div>
                <asp:TextBox runat="server" ID="txtIdCliente" Height="16px" Enabled="False" />
            </div>
            <div>
                <p>Fecha:</p>
            </div>
            <div>
                <asp:TextBox runat="server" ID="txtFecha" Height="16px" Enabled="False" />
                <asp:ImageButton ID="ImageButton1" runat="server" Height="20px" ImageUrl="~/Images/icon.ico" OnClick="ImageButton1_Click" Width="20px" />
                <asp:Calendar ID="Calendar1" runat="server" OnSelectionChanged="Calendar1_SelectionChanged" BackColor="White" BorderColor="White" BorderWidth="1px" Font-Names="Verdana" Font-Size="9pt" ForeColor="Black" Height="190px" NextPrevFormat="FullMonth" Width="350px">
                    <DayHeaderStyle Font-Bold="True" Font-Size="8pt" />
                    <NextPrevStyle Font-Bold="True" Font-Size="8pt" ForeColor="#333333" VerticalAlign="Bottom" />
                    <OtherMonthDayStyle ForeColor="#999999" />
                    <SelectedDayStyle BackColor="#CDDC39" ForeColor="White" />
                    <TitleStyle BackColor="White" BorderColor="Black" BorderWidth="4px" Font-Bold="True" Font-Size="12pt" ForeColor="#03A9F4" />
                    <TodayDayStyle BackColor="#CCCCCC" />
                </asp:Calendar>
            </div>
            <div>
                <p>Total</p>
            </div>
            <div>
                <asp:TextBox runat="server" ID="txtTotal" Height="16px" />
            </div>
            <div>
                <asp:Button Text="Registrar Venta" runat="server" ID="btnInsertVenta" OnClick="btnInsertarVenta_Click" />
            </div>
            </form>
        </div>
</body>
</html>
