using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using DTO;
/// <summary>
/// Summary description for ClienteBLL
/// </summary>
public class ClienteBLL
{
	public ClienteBLL()
	{
		//
		// TODO: Add constructor logic here
		//
	}

    public static void Insert(string nombre,string nit)
    {
        ClienteDSTableAdapters.ClienteTableAdapter adapter = new ClienteDSTableAdapters.ClienteTableAdapter();
        adapter.Insert(nombre,nit);
    }
    public static void Update(string nombre, string nit, int cliente_id)
    {
        ClienteDSTableAdapters.ClienteTableAdapter adapter = new ClienteDSTableAdapters.ClienteTableAdapter();
        adapter.Update(nombre,nit,cliente_id);
    }
    public static void Delete(int id)
    {
        ClienteDSTableAdapters.ClienteTableAdapter adapter = new ClienteDSTableAdapters.ClienteTableAdapter();
        adapter.Delete(id);
    }
    public static List<Cliente> SelectAll()
    {
        ClienteDSTableAdapters.ClienteTableAdapter adapter = new ClienteDSTableAdapters.ClienteTableAdapter();
        ClienteDS.ClienteDataTable table = adapter.selectAll();
        List<Cliente> listaClientes = new List<Cliente>();
        foreach (ClienteDS.ClienteRow row in table)
        {
            listaClientes.Add(RowToDto(row));
        }
        return listaClientes;
    }

    private static Cliente RowToDto(ClienteDS.ClienteRow row)
    {
        Cliente objCliente = new Cliente();
        objCliente.Cliente_id = row.cliente_id;
        objCliente.Nombre = row.nombre;
        objCliente.Nit = row.nit;
        return objCliente;
    }

    public static Cliente Select(int id)
    {
        ClienteDSTableAdapters.ClienteTableAdapter adapter = new ClienteDSTableAdapters.ClienteTableAdapter();
        ClienteDS.ClienteDataTable table = adapter.selectById(id);
        Cliente objCliente = RowToDto(table[0]);
        return objCliente;
    }
}