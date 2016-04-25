/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class DatAtencion {

    static ArrayList aAtencion = new ArrayList();
    private int atencion_id;
    private Date fecha_hora;
    private int cita_id;
    private String observaciones;
    private String diagnostico;
    private String estudios;
    private String medicamentos;
    private String proceso;
    private String navega;

    public DatAtencion() {
        this.atencion_id = 0;
        this.fecha_hora = null;
        this.cita_id = 0;
        this.observaciones = "";
        this.diagnostico = "";
        this.estudios = "";
        this.medicamentos = "";
        this.proceso = "";
        this.navega = "";
    }

    public static ArrayList getaAtencion() {
        return aAtencion;
    }

    public static void setaAtencion(ArrayList aAtencion) {
        DatAtencion.aAtencion = aAtencion;
    }

    public String getNavega() {
        return navega;
    }

    public void setNavega(String navega) {
        this.navega = navega;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public int getAtencion_id() {
        return atencion_id;
    }

    public void setAtencion_id(int atencion_id) {
        this.atencion_id = atencion_id;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public int getCita_id() {
        return cita_id;
    }

    public void setCita_id(int cita_id) {
        this.cita_id = cita_id;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }
    

    // <editor-fold defaultstate="collapsed" desc="Metodos publicos de la Clase"> 
    public ArrayList GrabarNew() throws SQLException {
        proceso = "INSERT_";
        navega = "";
        inicializarPrm("atencion_consulta_TRANSACT");
        return (ArrayList) aAtencion;
    }

    public ArrayList modificar() throws SQLException {
        proceso = "MODIFY_";
        navega = "";
        inicializarPrm("atencion_consulta_TRANSACT");
        return (ArrayList) aAtencion;
    }

    public ArrayList anular() throws SQLException {
        proceso = "DELETE_";
        navega = "";
        inicializarPrm("atencion_consulta_TRANSACT");
        return (ArrayList) aAtencion;
    }

    public ArrayList consultar(String NomProc) throws SQLException {

        inicializarPrm(NomProc);

        return (ArrayList) aAtencion;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Metodos privados de la Clase">
    private void inicializarPrm(String procedimiento) throws SQLException {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Datos.Connex cn = new Connex();
        DatAtencion cAtencion = new DatAtencion();

        try {
            cn.init();
            cstmt = cn.getConnection().prepareCall(
                    "{call " + procedimiento + "(?,?,?,?,?,?,?,?,?)}",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            cstmt.setInt("atencion_id", atencion_id);
            cstmt.setDate("fecha_hora", fecha_hora);
            cstmt.setInt("cita_id", cita_id);
            cstmt.setString("observaciones", observaciones);
            cstmt.setString("diagnostico", diagnostico);
            cstmt.setString("estudios", estudios);
            cstmt.setString("medicamentos", medicamentos);
            cstmt.setString("proceso", proceso);
            cstmt.setString("navega", navega);

            cstmt.execute();

            

            rs = cstmt.getResultSet();
            if (rs.next()) {

                atencion_id = rs.getInt("atencion_id");
                cAtencion.setAtencion_id(atencion_id);

                fecha_hora = rs.getDate("fecha_hora");
                cAtencion.setFecha_hora(fecha_hora);

                cita_id = rs.getInt("cita_id");
                cAtencion.setCita_id(cita_id);
                
                observaciones=rs.getString("observaciones");
                cAtencion.setObservaciones(observaciones);
                
                diagnostico=rs.getString("diagnostico");
                cAtencion.setObservaciones(diagnostico);
                
                estudios=rs.getString("estudios");
                cAtencion.setObservaciones(estudios);
                
                medicamentos=rs.getString("medicamentos");
                cAtencion.setObservaciones(medicamentos);

                aAtencion.add(cAtencion);

            }

            cn.closeConnection();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        } finally {
        }

    }

}
