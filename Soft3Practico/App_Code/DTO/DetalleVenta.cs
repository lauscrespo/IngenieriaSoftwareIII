using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
namespace DTO
{
    /// <summary>
    /// Summary description for DetalleVenta
    /// </summary>
    public class DetalleVenta
    {
        public DetalleVenta()
        {
            //
            // TODO: Add constructor logic here
            //
        }
        public int detalleVenta_id { get; set; }
        public int venta_id { get; set; }
        public int producto_id { get; set; }
        public decimal precio { get; set; }
        public int cantidad { get; set; }
        public decimal subtotal { get; set; }
    }
}