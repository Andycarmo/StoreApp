package modelo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Repuesto extends RealmObject {

    @PrimaryKey
    long id;
    String ceco;
    String nombre;
    String ubicacion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCeco() {
        return ceco;
    }

    public void setCeco(String ceco) {
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
}
