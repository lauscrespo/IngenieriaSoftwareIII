﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
namespace DTO
{
    /// <summary>
    /// Summary description for Venta
    /// </summary>
    public class Venta
    {
        public Venta()
        {
            //
            // TODO: Add constructor logic here
            //
        }
        public int Venta_id { get; set; }
        public DateTime Fecha { get; set; }
        public int Cliente_id { get; set; }
        public decimal Total { get; set; }
    }
}