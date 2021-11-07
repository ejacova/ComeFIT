package co.edu.ecordoba263.comefit;

import java.util.Date;

public class Metas {

    private String nombreMeta;
    private Date fechaMeta;
    private String descripcionMeta;
    private int idUsuario;

    public Metas() {
    }

    public Metas(String nombreMeta, Date fechaMeta, String descripcionMeta) {
        this.nombreMeta = nombreMeta;
        this.fechaMeta = fechaMeta;
        this.descripcionMeta = descripcionMeta;
    }

    public String getNombreMeta() {
        return nombreMeta;
    }

    public void setNombreMeta(String nombreMeta) {
        this.nombreMeta = nombreMeta;
    }

    public Date getFechaMeta() {
        return fechaMeta;
    }

    public void setFechaMeta(Date fechaMeta) {
        this.fechaMeta = fechaMeta;
    }

    public String getDescripcionMeta() {
        return descripcionMeta;
    }

    public void setDescripcionMeta(String descripcionMeta) {
        this.descripcionMeta = descripcionMeta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
