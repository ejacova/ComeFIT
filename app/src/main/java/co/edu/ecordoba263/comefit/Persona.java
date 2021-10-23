package co.edu.ecordoba263.comefit;

public class Persona {
    private String nombreUsuario;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private int edad;
    private float altura;
    private float peso;
    private float metabolismo;

    public Persona() {
    }

    public Persona(String nombreUsuario, String contrasena, String nombre, String apellido, String fechaNacimiento, int edad, float altura, float peso, float metabolismo) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.metabolismo = metabolismo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getMetabolismo() {
        return metabolismo;
    }

    public void setMetabolismo(float metabolismo) {
        this.metabolismo = metabolismo;
    }
}
