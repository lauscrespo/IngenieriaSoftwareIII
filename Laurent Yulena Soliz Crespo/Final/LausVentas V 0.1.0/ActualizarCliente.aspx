<%@ Page Language="C#" AutoEventWireup="true" CodeFile="ActualizarCliente.aspx.cs" Inherits="Actualizar" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Soft III | Actualizar Cliente</title>
    <link href="css/style.css" rel="stylesheet" />
</head>
<body>
    <form id="formUpdateCliente" runat="server">
    <div>
        <h1>Actualizar Cliente</h1>
        <asp:HiddenField runat="server" ID="hdnID" />
            <div>
                <asp:Label Text="Nombre:" runat="server"/>
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
                <asp:Button Text="Actualizar" runat="server" ID="btnActualizarCliente" OnClick="btnActualizarCliente_Click" />
            </div>
        </div>
    </form>
</body>
</html>
