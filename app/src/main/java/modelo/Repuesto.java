package modelo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Repuesto extends RealmObject {

    @PrimaryKey
    String id;
    @Required
    private String status = TaskStatus.Open.name();
    String ceco;
    String nombre;
    String ubicacion;

    public void setStatus(TaskStatus status) { this.status = status.name(); }
    public String getStatus() { return this.status; }
    public Repuesto(String _id) { this.id = _id; }
    public Repuesto() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

     public void setStatus(String status) {
        this.status = status;
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