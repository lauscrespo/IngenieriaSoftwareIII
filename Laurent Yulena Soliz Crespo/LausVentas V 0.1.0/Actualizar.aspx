<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Actualizar.aspx.cs" Inherits="Actualizar" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:HiddenField runat="server" ID="hdnID" />
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
                <asp:Button Text="Actualizar" runat="server" ID="btnActualizarCliente" OnClick="btnActualizarCliente_Click" />
            </div>
        </div>
    </form>
</body>
</html>
