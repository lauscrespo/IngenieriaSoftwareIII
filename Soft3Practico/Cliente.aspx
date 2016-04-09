<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Cliente.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Soft III | Cliente</title>
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
                            <span>Cliente</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            Producto
                        </a>
                    </li>
                    <li>
                        <a href="Venta.aspx">
                            Venta
                        </a>
                    </li>
                    <li>
                        <a href="ListaVenta.aspx">
                            Lista Venta
                        </a>
                    </li>
                </ul>
            </nav>
    </header>
    <div class="center">
        <a href="InsertCliente.aspx" id="btnInsertCliente">Insertar Cliente</a>
    </div>
    <div class="center">
        <form id="form1" runat="server">
            <div>
                <asp:GridView runat="server" AutoGenerateColumns="False" DataSourceID="odsCliente" ID="grvCliente" CellPadding="4" ForeColor="#333333" GridLines="None" CssClass="tbl" Width="898px">
                    <AlternatingRowStyle BackColor="White" />
                    <Columns>
                        <asp:BoundField DataField="Cliente_id" HeaderText="ID" SortExpression="Cliente_id"></asp:BoundField>
                        <asp:BoundField DataField="Nombre" HeaderText="Nombre Completo" SortExpression="Nombre"></asp:BoundField>
                        <asp:BoundField DataField="Nit" HeaderText="NIT" SortExpression="Nit"></asp:BoundField>
                        <asp:TemplateField>
                            <ItemTemplate>
                                <a class="ud" href="ActualizarCliente.aspx?Cliente_id=<%# Eval("Cliente_id") %>" >
                                    Actualizar
                                </a>
                            </ItemTemplate>
                        </asp:TemplateField>
                        <asp:TemplateField>
                            <ItemTemplate>
                                <asp:LinkButton CssClass="ud" Text="Eliminar" CommandArgument='<%# Eval("Cliente_id") %>' OnClick="btnEliminarItem_Click" ID="btnEliminarItem" runat="server" />
                            </ItemTemplate>
                        </asp:TemplateField>
                    </Columns>
                    <EditRowStyle BackColor="#2461BF" />
                    <FooterStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
                    <HeaderStyle BackColor="#03A9F4" Font-Bold="True" ForeColor="White" />
                    <PagerStyle BackColor="#2461BF" ForeColor="White" HorizontalAlign="Center" />
                    <RowStyle BackColor="#EFF3FB" />
                    <SelectedRowStyle BackColor="#D1DDF1" Font-Bold="True" ForeColor="#333333" />
                    <SortedAscendingCellStyle BackColor="#F5F7FB" />
                    <SortedAscendingHeaderStyle BackColor="#6D95E1" />
                    <SortedDescendingCellStyle BackColor="#E9EBEF" />
                    <SortedDescendingHeaderStyle BackColor="#4870BE" />
                </asp:GridView>
                <asp:ObjectDataSource runat="server" ID="odsCliente" SelectMethod="SelectAll" TypeName="ClienteBLL"></asp:ObjectDataSource>
            </div>
        </form>
    </div>
    </body>
</html>

