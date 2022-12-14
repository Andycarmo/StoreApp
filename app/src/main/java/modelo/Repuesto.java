package modelo;

public class Repuesto {

    private int ceco;
    private String nombre;
    private String ubicacion;

    public Repuesto(int ceco, String nombre, String ubicacion) {
        this.ceco = ceco;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public int getCeco() {
        return ceco;
    }

    public void setCeco(int ceco) {
        this.ceco = ceco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Repuesto{" +
                "ceco=" + ceco +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
