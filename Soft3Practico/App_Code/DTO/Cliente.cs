using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
namespace DTO
{
    /// <summary>
    /// Summary description for Cliente
    /// </summary>
    public class Cliente
    {
        public Cliente()
        {
            //
            // TODO: Add constructor logic here
            //
        }
        public int Cliente_id { get; set; }
        public string Nombre { get; set; }
        public string Nit { get; set; }
    }
}