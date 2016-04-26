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
public class DatCita {

    static ArrayList aCita = new ArrayList();
    private int cita_id;
    private Date fecha_hora;
    private int doctor_id;
    private int paciente_id;
    private String observaciones;
    private int user_id;
    private String proceso;
    private String navega;

    public DatCita() {
        this.cita_id = 0;
        this.fecha_hora = null;
        this.doctor_id = 0;
        this.paciente_id = 0;
        this.observaciones = "";
        this.user_id = 0;
        this.proceso = "";
        this.navega = "";
    }

    public static ArrayList getaCita() {
        return aCita;
    }

    public static void setaCita(ArrayList aCita) {
        DatCita.aCita = aCita;
    }

    public int getCita_id() {
        return cita_id;
    }

    public void setCita_id(int cita_id) {
        this.cita_id = cita_id;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(int paciente_id) {
        this.paciente_id = paciente_id;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getNavega() {
        return navega;
    }

    public void setNavega(String navega) {
        this.navega = navega;
    }

    // <editor-fold defaultstate="collapsed" desc="Metodos publicos de la Clase"> 
    public ArrayList GrabarNew() throws SQLException {
        proceso = "INSERT_";
        navega = "";
        inicializarPrm("cita_TRANSACT");
        return (ArrayList) aCita;
    }

    public ArrayList modificar() throws SQLException {
        proceso = "MODIFY_";
        navega = "";
        inicializarPrm("cita_TRANSACT");
        return (ArrayList) aCita;
    }

    public ArrayList anular() throws SQLException {
        proceso = "DELETE_";
        navega = "";
        inicializarPrm("cita_TRANSACT");
        return (ArrayList) aCita;
    }

    public ArrayList consultar(String NomProc) throws SQLException {

        inicializarPrm(NomProc);

        return (ArrayList) aCita;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Metodos privados de la Clase">
    private void inicializarPrm(String procedimiento) throws SQLException {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Datos.Connex cn = new Connex();
        DatCita cAtencion = new DatCita();

        try {
            cn.init();
            cstmt = cn.getConnection().prepareCall(
                    "{call " + procedimiento + "(?,?,?,?,?,?,?,?)}",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            cstmt.setInt("cita_id", cita_id);
            cstmt.setDate("fecha_hora", fecha_hora);
            cstmt.setInt("doctor_id", doctor_id);
            cstmt.setInt("paciente_id", paciente_id);
            cstmt.setString("observaciones", observaciones);
            cstmt.setInt("user_id", user_id);
            cstmt.setString("proceso", proceso);
            cstmt.setString("navega", navega);

            cstmt.execute();

            rs = cstmt.getResultSet();
            if (rs.next()) {

                cita_id = rs.getInt("cita_id");
                cAtencion.setCita_id(cita_id);

                fecha_hora = rs.getDate("fecha_hora");
                cAtencion.setFecha_hora(fecha_hora);

                doctor_id = rs.getInt("doctor_id");
                cAtencion.setCita_id(doctor_id);

                paciente_id = rs.getInt("paciente_id");
                cAtencion.setPaciente_id(paciente_id);

                observaciones = rs.getString("observaciones");
                cAtencion.setObservaciones(observaciones);

                user_id = rs.getInt("user_id");
                cAtencion.setUser_id(user_id);

                aCita.add(cAtencion);

            }

            cn.closeConnection();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        } finally {
        }

    }

}
