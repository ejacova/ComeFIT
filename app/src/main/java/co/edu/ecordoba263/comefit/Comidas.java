package co.edu.ecordoba263.comefit;

public class Comidas {

    private String nombreComida;
    private double caloriasReceta;
    private String nombreIngrediente;
    private double caloriasIngrediente;
    private double metaDiariaL;

    public Comidas() {
    }

    public Comidas(String nombreComida, double caloriasReceta, String nombreIngrediente, double caloriasIngrediente, double metaDiariaL) {
        this.nombreComida = nombreComida;
        this.caloriasReceta = caloriasReceta;
        this.nombreIngrediente = nombreIngrediente;
        this.caloriasIngrediente = caloriasIngrediente;
        this.metaDiariaL = metaDiariaL;
    }

    public String getNombreComida() {
        return nombreComida;
    }

    public void setNombreComida(String nombreComida) {
        this.nombreComida = nombreComida;
    }

    public double getCaloriasReceta() {
        return caloriasReceta;
    }

    public void setCaloriasReceta(double caloriasReceta) {
        this.caloriasReceta = caloriasReceta;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public double getCaloriasIngrediente() {
        return caloriasIngrediente;
    }

    public void setCaloriasIngrediente(double caloriasIngrediente) {
        this.caloriasIngrediente = caloriasIngrediente;
    }

    public double getMetaDiariaL() {
        return metaDiariaL;
    }

    public void setMetaDiariaL(double metaDiariaL) {
        this.metaDiariaL = metaDiariaL;
    }
}

