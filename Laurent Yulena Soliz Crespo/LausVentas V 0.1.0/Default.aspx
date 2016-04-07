<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <a href="Insert.aspx">Insertar Cliente</a>
    <form id="form1" runat="server">
        <div>
            <asp:GridView runat="server" AutoGenerateColumns="False" DataSourceID="odsCliente" ID="grvCliente">
                <Columns>
                    <asp:BoundField DataField="Cliente_id" HeaderText="Cliente_id" SortExpression="Cliente_id"></asp:BoundField>
                    <asp:BoundField DataField="Nombre" HeaderText="Nombre" SortExpression="Nombre"></asp:BoundField>
                    <asp:BoundField DataField="Nit" HeaderText="Nit" SortExpression="Nit"></asp:BoundField>
                    <asp:TemplateField>
                        <ItemTemplate>
                            <a href="Actualizar.aspx?Cliente_id=<%# Eval("Cliente_id") %>" >
                                Actualizar
                            </a>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton Text="Eliminar" CommandArgument='<%# Eval("Cliente_id") %>' OnClick="btnEliminarItem_Click" ID="btnEliminarItem" runat="server" />
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>

            <asp:ObjectDataSource runat="server" ID="odsCliente" SelectMethod="SelectAll" TypeName="ClienteBLL"></asp:ObjectDataSource>
        </div>
    </form>
</body>
</html>

