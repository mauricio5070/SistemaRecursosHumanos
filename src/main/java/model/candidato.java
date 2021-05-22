/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Date;


/**
 *
 * @author Mauricio
 */
public class candidato {
    
    private int id_candidato;
    private String nombreCandidato;
    private String apellidosCandidato;
    private String correoCandidato;
    private String telefonoCandidato;
    private String vacante;
    private Date fecha_nacimientoCandidato;

    public candidato() {
    }

    public candidato(int id_candidato, String nombreCandidato, String apellidosCandidato, String correoCandidato, String telefonoCandidato, String vacante, Date fecha_nacimientoCandidato) {
        this.id_candidato = id_candidato;
        this.nombreCandidato = nombreCandidato;
        this.apellidosCandidato = apellidosCandidato;
        this.correoCandidato = correoCandidato;
        this.telefonoCandidato = telefonoCandidato;
        this.vacante = vacante;
        this.fecha_nacimientoCandidato = fecha_nacimientoCandidato;
    }

    public int getId_candidato() {
        return id_candidato;
    }

    public void setId_candidato(int id_candidato) {
        this.id_candidato = id_candidato;
    }

    public String getNombreCandidato() {
        return nombreCandidato;
    }

    public void setNombreCandidato(String nombreCandidato) {
        this.nombreCandidato = nombreCandidato;
    }

    public String getApellidosCandidato() {
        return apellidosCandidato;
    }

    public void setApellidosCandidato(String apellidosCandidato) {
        this.apellidosCandidato = apellidosCandidato;
    }

    public String getCorreoCandidato() {
        return correoCandidato;
    }

    public void setCorreoCandidato(String correoCandidato) {
        this.correoCandidato = correoCandidato;
    }

    public String getTelefonoCandidato() {
        return telefonoCandidato;
    }

    public void setTelefonoCandidato(String telefonoCandidato) {
        this.telefonoCandidato = telefonoCandidato;
    }

    public String getVacante() {
        return vacante;
    }

    public void setVacante(String vacante) {
        this.vacante = vacante;
    }

    public Date getFecha_nacimientoCandidato() {
        return fecha_nacimientoCandidato;
    }

    public void setFecha_nacimientoCandidato(Date fecha_nacimientoCandidato) {
        this.fecha_nacimientoCandidato = fecha_nacimientoCandidato;
    }
    
   
    
}
