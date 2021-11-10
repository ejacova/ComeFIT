package co.edu.ecordoba263.comefit;

import java.io.Serializable;
import java.util.Date;

public class Metas implements Serializable {

    private String nombreMeta;
    private String fechaMeta;
    private int caloríasMeta;
    private String descripcionMeta;
    private int idUsuario;

    public Metas() {
    }

    public Metas(String nombreMeta, String fechaMeta, String descripcionMeta) {
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

    public String getFechaMeta() {
        return fechaMeta;
    }

    public void setFechaMeta(String fechaMeta) {
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

    public int getCaloríasMeta() {
        return caloríasMeta;
    }

    public void setCaloríasMeta(int caloríasMeta) {
        this.caloríasMeta = caloríasMeta;
    }
}
