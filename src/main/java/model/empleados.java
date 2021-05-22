package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class empleados {
    
    private int id_empleado;
    private String nombreEmpleado;
    private String apellidosEmpleado;
    private String correoEmpleado;
    private String telefonoEmpleado;
    private Date fecha_nacimientoEmpleado;
    private int id_puesto;
    private Date fechaIngreso;
    private boolean estadoEmpleado;
    
    public empleados(){
    }

    public empleados(int id_empleado, String nombreEmpleado, String apellidosEmpleado, String correoEmpleado, String telefonoEmpleado, Date fecha_nacimientoEmpleado, int id_puesto, Date fechaIngreso, boolean estadoEmpleado) {
        this.id_empleado = id_empleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidosEmpleado = apellidosEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.telefonoEmpleado = telefonoEmpleado;
        this.fecha_nacimientoEmpleado = fecha_nacimientoEmpleado;
        this.id_puesto = id_puesto;
        this.fechaIngreso = fechaIngreso;
        this.estadoEmpleado = estadoEmpleado;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidosEmpleado() {
        return apellidosEmpleado;
    }

    public void setApellidosEmpleado(String apellidosEmpleado) {
        this.apellidosEmpleado = apellidosEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public Date getFecha_nacimientoEmpleado() {
        return fecha_nacimientoEmpleado;
    }

    public void setFecha_nacimientoEmpleado(Date fecha_nacimientoEmpleado) {
        this.fecha_nacimientoEmpleado = fecha_nacimientoEmpleado;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(boolean estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    private String nombreCompleto(){
        return this.getNombreEmpleado() + " "+ this.getApellidosEmpleado();
    }
    
    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String fecha1 = format.format(this.fecha_nacimientoEmpleado);
        String fecha2 = format.format(this.fechaIngreso);
        return "{\"Empleado\":{\n\"ID\":\""
                + id_empleado + "\",\n\"nombre\":\""
                + nombreEmpleado + "\",\n\"apellidos\":\""
                + apellidosEmpleado + "\",\n\"correo\":\""
                + correoEmpleado + "\",\n\"telefono\":\""
                + telefonoEmpleado + "\",\n\"fechaNaci\":\""
                + fecha1 + "\",\n\"idPuesto\":\""
                + id_puesto + "\",\n\"fechaIngreso\":\""
                + fecha2 + "\",\n\"estado\":\""
                + estadoEmpleado + "\"\n}\n}";

    }
    
}
