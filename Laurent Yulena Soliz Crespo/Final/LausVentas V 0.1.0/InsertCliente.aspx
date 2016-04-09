<%@ Page Language="C#" AutoEventWireup="true" CodeFile="InsertCliente.aspx.cs" Inherits="Insert" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Soft II | Insertar Cliente</title>
    <link href="css/style.css" rel="stylesheet" />
</head>
<body>
    <form id="formInsertCliente" runat="server">
    <div>
        <h1>Insertar Cliente</h1>
            <div>
                <asp:Label Text="Nombre:" runat="server" />
            </div>
            <div>
                <asp:TextBox runat="server" ID="txtNombre" />
            </div>
            <div>
                <asp:Label Text="Nit:" runat="server" />
            </div>
            <div>
                <asp:TextBox runat="server" ID="txtNit" />
            </div>
            
            <div>
                <asp:Button Text="Insertar" runat="server" ID="btnInsertarCliente" OnClick="btnInsertarCliente_Click" />
            </div>
        </div>
    </form>
</body>
</html>
