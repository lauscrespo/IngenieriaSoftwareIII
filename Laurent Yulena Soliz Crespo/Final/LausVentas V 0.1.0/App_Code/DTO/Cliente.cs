using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
namespace DTO
{
    public class Cliente
    {
        public Cliente()
        {
          
        }

        public int Cliente_id { get; set; }
        public string Nombre { get; set; }
        public string Nit { get; set; }
    }
}