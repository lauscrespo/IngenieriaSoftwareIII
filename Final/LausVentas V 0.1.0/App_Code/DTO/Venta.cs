using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
namespace DTO
{
    public class Venta
    {
        public Venta()
        {
        }

        public int Venta_id { get; set; }
        public DateTime Fecha { get; set; }
        public int Cliente_id { get; set; }
        public decimal Total { get; set; }
    }
}

